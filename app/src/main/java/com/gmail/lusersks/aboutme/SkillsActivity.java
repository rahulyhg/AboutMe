package com.gmail.lusersks.aboutme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkillsActivity extends AppCompatActivity implements View.OnClickListener {

    private static String[] skills = {"Android", "Java", "Ruby on Rails", "JavaScript", "HTML", "CSS"};
    private static String[] experience_year = {"0.5", "1", "1", "1", "2", "2"};
    private static String[] level_1to5 = {"1", "2", "2", "2", "3", "2"};

    private static List<Map<String, String>> getItems() {
        final List<Map<String, String>> items = new ArrayList<>();
        for (int i = 0; i < skills.length; i++) {
            final Map<String, String> map = new HashMap<>(2);
            map.put(FIELD_SKILL, skills[i]);
            map.put(FIELD_EXPERIENCE, experience_year[i]);
            map.put(FIELD_LEVEL, level_1to5[i]);
            items.add(map);
        }
        return items;
    }

    public static final String FIELD_SKILL = "skills";
    public static final String FIELD_EXPERIENCE = "experience";
    public static final String FIELD_LEVEL = "level";

    private static final String TAG = "AboutMe";
    private ListView mList = null;
    private ListAdapter mAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);

        (findViewById(R.id.tab_home)).setOnClickListener(this);
        (findViewById(R.id.tab_projects)).setOnClickListener(this);
        (findViewById(R.id.tab_contacts)).setOnClickListener(this);

        //ArrayAdapter mAdapter = new ArrayAdapter<>(this, R.layout.activity_listview, skills);
        mAdapter = new SimpleAdapter(this,
                getItems(),
                R.layout.activity_listview,
                new String[]{FIELD_SKILL, FIELD_EXPERIENCE, FIELD_LEVEL},
                new int[]{R.id.skill, R.id.experience, R.id.level});
        mList = (ListView) findViewById(R.id.list_skills);
        mList.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
        switchActivity(v.getId());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switchActivity(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void switchActivity(int id) {
        Intent newActivity;
        switch (id) {
            case R.id.tab_skills:
                newActivity = new Intent(this, SkillsActivity.class);
                break;
            case R.id.tab_projects:
                newActivity = new Intent(this, ProjectsActivity.class);
                break;
            case R.id.tab_contacts:
                newActivity = new Intent(this, ContactsActivity.class);
                break;
            default:
                newActivity = new Intent(this, MainActivity.class);
        }
        startActivity(newActivity);
    }
}
