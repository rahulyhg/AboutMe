package com.gmail.lusersks.aboutme;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.gmail.lusersks.aboutme.skills.AddNewDialog;
import com.gmail.lusersks.aboutme.skills.DeleteDialog;
import com.gmail.lusersks.aboutme.skills.DialogSkillsActionListener;
import com.gmail.lusersks.aboutme.skills.EditDialog;
import com.gmail.lusersks.aboutme.skills.SkillsData;

public class SkillsActivity extends AppCompatActivity
        implements View.OnClickListener, DialogSkillsActionListener {

    private DialogFragment addNewSkillDialog;
    private DialogFragment deleteSkillDialog;
    private DialogFragment editSkillDialog;

    private void initUI() {
        (findViewById(R.id.tab_home)).setOnClickListener(this);
        (findViewById(R.id.tab_projects)).setOnClickListener(this);
        (findViewById(R.id.tab_contacts)).setOnClickListener(this);

        addNewSkillDialog = new AddNewDialog();
        deleteSkillDialog = new DeleteDialog();
        editSkillDialog = new EditDialog();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);

        initUI();

        ListAdapter mAdapter = new SimpleAdapter(this,
                SkillsData.getItems(this),
                R.layout.activity_listview,
                new String[]{SkillsData.FIELD_SKILL, SkillsData.FIELD_YEARS, SkillsData.FIELD_LEVEL},
                new int[]{R.id.tvSkill, R.id.tvYears, R.id.tvLevel});
        ListView mList = (ListView) findViewById(R.id.list_skills);
        mList.setAdapter(mAdapter);

        registerForContextMenu(mList);
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
}
