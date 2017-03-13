package com.gmail.lusersks.aboutme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SkillsActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] skills = {"Android", "Java", "Ruby on Rails", "JavaScript", "HTML", "CSS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);

        (findViewById(R.id.tab_home)).setOnClickListener(this);
        (findViewById(R.id.tab_projects)).setOnClickListener(this);
        (findViewById(R.id.tab_blog)).setOnClickListener(this);

        ArrayAdapter mAdapter = new ArrayAdapter<>(this, R.layout.activity_listview, skills);
        ListView mList = (ListView) findViewById(R.id.list_skills);
        mList.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
        Intent newActivity;
        switch (v.getId()) {
            case R.id.tab_skills:
                newActivity = new Intent(this, SkillsActivity.class);
                break;
            case R.id.tab_projects:
                newActivity = new Intent(this, ProjectsActivity.class);
                break;
            case R.id.tab_blog:
                newActivity = new Intent(this, BlogActivity.class);
                break;
            default:
                newActivity = new Intent(this, MainActivity.class);
        }
        startActivity(newActivity);
    }
}
