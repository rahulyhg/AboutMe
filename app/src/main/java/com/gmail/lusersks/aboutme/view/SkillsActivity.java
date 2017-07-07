package com.gmail.lusersks.aboutme.view;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gmail.lusersks.aboutme.R;
import com.gmail.lusersks.aboutme.model.Skill;
import com.gmail.lusersks.aboutme.model.SkillsModelImpl;
import com.gmail.lusersks.aboutme.presenter.SkillsPresenter;
import com.gmail.lusersks.aboutme.presenter.SkillsPresenterImpl;
import com.gmail.lusersks.aboutme.presenter.Utilities;
import com.gmail.lusersks.aboutme.view.dialog.AddNewDialog;
import com.gmail.lusersks.aboutme.view.dialog.DeleteDialog;
import com.gmail.lusersks.aboutme.view.dialog.DialogSkillsActionListener;
import com.gmail.lusersks.aboutme.view.dialog.EditDialog;
import com.gmail.lusersks.aboutme.model.SkillsData;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState;

import java.util.List;

public class SkillsActivity extends MvpLceViewStateActivity<RecyclerView, List<Skill>, SkillsView, SkillsPresenter>
        implements SkillsView, DialogSkillsActionListener {

    private static final String UNKNOWN_ERROR_MESSAGE = "Unknown error";
    private DialogFragment addNewSkillDialog;
    private DialogFragment deleteSkillDialog;
    private DialogFragment editSkillDialog;
    private RecyclerView recyclerView;
    private SkillsAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setContentView(R.layout.activity_skills);

        initUI();

        initRecyclerView();
    }

    private void initUI() {
        addNewSkillDialog = new AddNewDialog();
        deleteSkillDialog = new DeleteDialog();
        editSkillDialog = new EditDialog();
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.contentView);
        recyclerAdapter = new SkillsAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);
    }

    @NonNull
    @Override
    public SkillsPresenter createPresenter() {
        return new SkillsPresenterImpl(new SkillsModelImpl());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.add_new_skill:
                Toast.makeText(this, "Add new skill", Toast.LENGTH_SHORT).show();
                addNewSkillDialog.show(getFragmentManager(), "addNewSkillDialog");
                return true;

            case R.id.edit_skill:
                Toast.makeText(this, "Edit skill", Toast.LENGTH_SHORT).show();
                editSkillDialog.show(getFragmentManager(), "editSkillDialog");
                return true;

            case R.id.delete_skill:
                Toast.makeText(this, "Delete skill", Toast.LENGTH_SHORT).show();
                deleteSkillDialog.show(getFragmentManager(), "deleteSkillDialog");
                return true;

            default:
                return super.onContextItemSelected(item);
        }
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
    public void onDialogPositiveClick(DialogFragment dialog) {

        if (dialog instanceof AddNewDialog) {
            Dialog dialogView = dialog.getDialog();

            EditText etSkill = (EditText) dialogView.findViewById(R.id.etSkill);
            EditText etYears = (EditText) dialogView.findViewById(R.id.etYears);
            EditText etLevel = (EditText) dialogView.findViewById(R.id.etLevel);

            String skill = etSkill.getText().toString();
            String years = etYears.getText().toString();
            String level = etLevel.getText().toString();

            SkillsData.addItem(this, skill, years, level);

        } else if (dialog instanceof DeleteDialog) {

            Dialog dialogView = dialog.getDialog();
            // TODO: delete Item

            //SkillsData.deleteItem(this, skill);

        } else if (dialog instanceof EditDialog) {
            Toast.makeText(this, "Edit skill", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setData(List<Skill> data) {
        Log.d("APP", "view.setData");
        recyclerAdapter.setData(data);
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        Log.d("APP", "view.loadData");
        getPresenter().loadSkills();
    }

    @NonNull
    @Override
    public LceViewState<List<Skill>, SkillsView> createViewState() {
        return new RetainingLceViewState<>();
    }

    @Override
    public List<Skill> getData() {
        return recyclerAdapter.getData();
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        String errorMessage = e.getMessage();
        return errorMessage == null ? UNKNOWN_ERROR_MESSAGE : errorMessage;
    }
}
