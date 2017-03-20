package com.gmail.lusersks.aboutme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

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
    }

    @Override
    public void onClick(View v) {
        Utilities.goToAnotherActivity(v.getId(), this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Utilities.goToAnotherActivity(item.getItemId(), this);
        return super.onOptionsItemSelected(item);
    }
}
