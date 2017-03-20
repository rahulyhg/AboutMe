package com.gmail.lusersks.aboutme;

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

        Utilities.initTabs(this);
    }

    @Override
    public void onClick(View v) {
        Utilities.someAction(v.getId(), this);
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
        Utilities.someAction(item.getItemId(), this);
        return super.onOptionsItemSelected(item);
    }
}
