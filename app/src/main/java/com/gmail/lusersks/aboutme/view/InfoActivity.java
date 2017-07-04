package com.gmail.lusersks.aboutme.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.gmail.lusersks.aboutme.R;
import com.gmail.lusersks.aboutme.model.InfoModel;
import com.gmail.lusersks.aboutme.model.InfoModelImpl;
import com.gmail.lusersks.aboutme.presenter.InfoPresenter;
import com.gmail.lusersks.aboutme.presenter.InfoPresenterImpl;
import com.gmail.lusersks.aboutme.presenter.Utilities;

import java.util.List;

public class InfoActivity extends AppCompatActivity
        implements InfoView, View.OnClickListener {

    private TextView tvPersonName;
    private TextView tvJobRole;
    private TextView tvNonJobRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        InfoModel model = new InfoModelImpl();
        InfoPresenter presenter = new InfoPresenterImpl(model, this);
        presenter.loadInformation();
    }

    private void initUI() {
        tvPersonName = (TextView) findViewById(R.id.person_name);
        tvJobRole = (TextView) findViewById(R.id.job_role);
        tvNonJobRole = (TextView) findViewById(R.id.non_job_role);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("APP", "Something wrong");
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

    public void setData(List<String> data) {
        Log.d("APP", "view.setData()");
        Log.d("APP", String.valueOf(data.size()));
        for (int i = 0; i < data.size(); i++) {
            Log.d("APP", data.get(i));
        }
        tvPersonName.setText(data.get(0));
        tvJobRole.setText(data.get(1));
        tvNonJobRole.setText(data.get(2));
    }
}
