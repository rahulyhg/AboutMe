package com.gmail.lusersks.aboutme;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Utilities {

    public static void someAction(int id, Context activity) {
        Class activityClass;
        String toast_text;
        switch (id) {
            case R.id.tab_skills:
                activityClass = SkillsActivity.class;
                toast_text = "Go to skills";
                break;
            case R.id.tab_projects:
                activityClass = ProjectsActivity.class;
                toast_text = "Go to projects";
                break;
            case R.id.tab_contacts:
                activityClass = ContactsActivity.class;
                toast_text = "Go to contacts";
                break;
            default:
                activityClass = MainActivity.class;
                toast_text = "Go to home";
        }
        Toast.makeText(activity, toast_text, Toast.LENGTH_SHORT).show();
        activity.startActivity(new Intent(activity, activityClass));
    }
}
