package com.gmail.lusersks.aboutme.skills;


import android.app.Activity;
import android.app.DialogFragment;

public class SkillsActionsDialog extends DialogFragment {
    DialogSkillsActionListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (DialogSkillsActionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement DialogSkillsActionListener");
        }
    }
}
