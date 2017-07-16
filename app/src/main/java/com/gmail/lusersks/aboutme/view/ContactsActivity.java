package com.gmail.lusersks.aboutme.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.gmail.lusersks.aboutme.R;
import com.gmail.lusersks.aboutme.presenter.Utilities;

public class ContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        setTitle("Contacts");
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
                uri = Uri.parse("https://www.linkedin.com/in/raman-skaskevich");
                break;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void sendSMS(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:+48511404949"));
        intent.putExtra("sms_body", "Hire me");
        startActivity(intent);
    }

    public void sendEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:lusersks@gmail.com"));
        intent.putExtra("subject", "hire me");
        intent.putExtra("body", "...");
        startActivity(intent);
    }
}
