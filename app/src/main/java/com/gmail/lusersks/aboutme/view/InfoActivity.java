package com.gmail.lusersks.aboutme.view;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.gmail.lusersks.aboutme.R;
import com.gmail.lusersks.aboutme.model.InfoModelImpl;
import com.gmail.lusersks.aboutme.presenter.InfoPresenter;
import com.gmail.lusersks.aboutme.presenter.InfoPresenterImpl;
import com.gmail.lusersks.aboutme.presenter.Utilities;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState;

import java.util.List;

public class InfoActivity extends MvpLceViewStateActivity<RecyclerView, List<String>, InfoView, InfoPresenter>
        implements InfoView {

    private static final String UNKNOWN_ERROR_MESSAGE = "Unknown error";
    private RecyclerView recyclerView;
    private InfoAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setContentView(R.layout.activity_info);
        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.contentView);
        recyclerAdapter = new InfoAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);
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
        recyclerAdapter.setData(data);
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
        return recyclerAdapter.getData();
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        String errorMessage = e.getMessage();
        return errorMessage == null ? UNKNOWN_ERROR_MESSAGE : errorMessage;
    }
}
