package com.gmail.lusersks.aboutme.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.gmail.lusersks.aboutme.R;
import com.gmail.lusersks.aboutme.model.Project;
import com.gmail.lusersks.aboutme.model.ProjectsModelImpl;
import com.gmail.lusersks.aboutme.presenter.ProjectsPresenter;
import com.gmail.lusersks.aboutme.presenter.ProjectsPresenterImpl;
import com.gmail.lusersks.aboutme.presenter.Utilities;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState;

import java.util.List;

public class ProjectsActivity extends MvpLceViewStateActivity<RecyclerView, List<Project>, ProjectsView, ProjectsPresenter>
        implements ProjectsView {

    private static final String UNKNOWN_ERROR_MESSAGE = "Unknown error";
    private RecyclerView recyclerView;
    private ProjectsAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setContentView(R.layout.activity_projects);

        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.contentView);
        recyclerAdapter = new ProjectsAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);
    }

    @NonNull
    @Override
    public ProjectsPresenter createPresenter() {
        return new ProjectsPresenterImpl(new ProjectsModelImpl());
    }

    public void goToGithub(View view) {
//        TextView textView = (TextView) findViewById(R.id.go_to_github);
//        textView.setText("romasks");
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

    @NonNull
    @Override
    public LceViewState<List<Project>, ProjectsView> createViewState() {
        return new RetainingLceViewState<>();
    }

    @Override
    public List<Project> getData() {
        return recyclerAdapter.getData();
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        String errorMessage = e.getMessage();
        return errorMessage == null ? UNKNOWN_ERROR_MESSAGE : errorMessage;
    }

    @Override
    public void setData(List<Project> data) {
        recyclerAdapter.setData(data);
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        getPresenter().loadProjects();
    }
}
