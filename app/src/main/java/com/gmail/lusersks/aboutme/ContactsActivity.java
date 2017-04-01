package com.gmail.lusersks.aboutme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ContactsActivity extends AppCompatActivity implements View.OnClickListener {

    private void initUI() {
        (findViewById(R.id.tab_skills)).setOnClickListener(this);
        (findViewById(R.id.tab_projects)).setOnClickListener(this);
        (findViewById(R.id.tab_home)).setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        initUI();
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

    public void goToSocialMedia(View view) {
        Uri uri = null;
        switch (view.getId()) {
            case R.id.social_tw:
                uri = Uri.parse("https://twitter.com/romasks");
                break;
            case R.id.social_gh:
                uri = Uri.parse("https://github.com/romasks");
                break;
            case R.id.social_fb:
                uri = Uri.parse("https://facebook.com/romasks");
                break;
            case R.id.social_in:
                uri = Uri.parse("https://linkedin.com/romasks");
                break;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void sendSMS(View view) {
        String message = "My CV\n"
                + "Raman Skaskevich\n"
                + "Software Developer and Tester";

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(intent);
    }
}
