package com.gmail.lusersks.aboutme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BlogActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        (findViewById(R.id.tab_about)).setOnClickListener(this);
        (findViewById(R.id.tab_projects)).setOnClickListener(this);
        (findViewById(R.id.tab_home)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent newActivity;
        switch (v.getId()) {
            case R.id.tab_about:
                newActivity = new Intent(this, AboutActivity.class);
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
