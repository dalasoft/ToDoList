package kz.kazzinc.ikalganov.todolist;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ToDoListActivity extends AppCompatActivity implements NewItemFragment.OnNewItemAddedListener {

    private ArrayAdapter<ToDoItem> aa;
    private ArrayList<ToDoItem> todoItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        FragmentManager fm = getFragmentManager();
        ToDoListFragment todoListFragment = (ToDoListFragment)fm.findFragmentById(R.id.TodoListFragment);

        todoItems = new ArrayList<>();

        int resID = R.layout.totolist_item;
        aa = new ArrayAdapter<>(this, resID, todoItems);

        todoListFragment.setListAdapter(aa);
    }

    public void onNewItemAdded(String newItem) {
        ToDoItem newToDoItem = new ToDoItem(newItem);
        todoItems.add(0, newToDoItem);
        aa.notifyDataSetChanged();
    }
}
