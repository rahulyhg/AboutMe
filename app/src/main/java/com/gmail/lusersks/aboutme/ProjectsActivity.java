package com.gmail.lusersks.aboutme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ProjectsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        (findViewById(R.id.tab_skills)).setOnClickListener(this);
        (findViewById(R.id.tab_home)).setOnClickListener(this);
        (findViewById(R.id.tab_contacts)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switchActivity(v.getId());
    }

    public void goToGithub(View view) {
        TextView textView = (TextView) findViewById(R.id.go_to_github);
        textView.setText("romasks");
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
