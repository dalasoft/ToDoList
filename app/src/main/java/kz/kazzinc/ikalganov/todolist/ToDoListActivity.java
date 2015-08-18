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

    private ArrayAdapter<String> aa;
    private ArrayList<String> todoItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        FragmentManager fm = getFragmentManager();
        ToDoListFragment todoListFragment = (ToDoListFragment)fm.findFragmentById(R.id.TodoListFragment);

        todoItems = new ArrayList<>();

        aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todoItems);

        todoListFragment.setListAdapter(aa);
    }

    public void onNewItemAdded(String newItem) {
        todoItems.add(newItem);
        aa.notifyDataSetChanged();
    }
}
