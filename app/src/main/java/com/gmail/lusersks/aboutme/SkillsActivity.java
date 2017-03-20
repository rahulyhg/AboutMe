package com.gmail.lusersks.aboutme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class SkillsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);

        Utilities.initTabs(this);

        //ArrayAdapter mAdapter = new ArrayAdapter<>(this, R.layout.activity_listview, skills);
        ListAdapter mAdapter = new SimpleAdapter(this,
                SkillsData.getItems(),
                R.layout.activity_listview,
                new String[]{SkillsData.FIELD_SKILL, SkillsData.FIELD_EXPERIENCE, SkillsData.FIELD_LEVEL},
                new int[]{R.id.skill, R.id.experience, R.id.level});
        ListView mList = (ListView) findViewById(R.id.list_skills);
        mList.setAdapter(mAdapter);

        // Create context menu
        registerForContextMenu(mList);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.add_new_skill:
                Toast.makeText(this, "Add new skill", Toast.LENGTH_LONG).show();
                return true;
            case R.id.edit_skill:
                Toast.makeText(this, "Edit skill", Toast.LENGTH_LONG).show();
                return true;
            case R.id.delete_skill:
                Toast.makeText(this, "Delete skill", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        Utilities.someAction(v.getId(), this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Utilities.someAction(item.getItemId(), this);
        return super.onOptionsItemSelected(item);
    }
}
