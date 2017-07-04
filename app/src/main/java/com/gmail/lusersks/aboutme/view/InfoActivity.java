package com.gmail.lusersks.aboutme.view;

import android.support.annotation.NonNull;
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
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState;

import java.util.List;

public class InfoActivity extends MvpLceViewStateActivity<TextView, List<String>, InfoView, InfoPresenter>
        implements InfoView, View.OnClickListener {

    private TextView tvPersonName;
    private TextView tvJobRole;
    private TextView tvNonJobRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        tvPersonName = (TextView) findViewById(R.id.contentView);
        tvJobRole = (TextView) findViewById(R.id.job_role);
        tvNonJobRole = (TextView) findViewById(R.id.non_job_role);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("APP", "Something wrong");
    }

    @NonNull
    @Override
    public InfoPresenter createPresenter() {
        return new InfoPresenterImpl(new InfoModelImpl());
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

    @Override
    public void setData(List<String> data) {
        tvPersonName.setText(data.get(0));
        tvJobRole.setText(data.get(1));
        tvNonJobRole.setText(data.get(2));
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        getPresenter().loadInformation();
    }

    @NonNull
    @Override
    public LceViewState<List<String>, InfoView> createViewState() {
        return new RetainingLceViewState<>();
    }

    @Override
    public List<String> getData() {
        return null;
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return null;
    }
}
