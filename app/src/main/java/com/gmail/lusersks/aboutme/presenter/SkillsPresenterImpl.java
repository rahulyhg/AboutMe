package com.gmail.lusersks.aboutme.presenter;

import android.util.Log;

import com.gmail.lusersks.aboutme.model.SkillsModel;
import com.gmail.lusersks.aboutme.view.SkillsView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

public class SkillsPresenterImpl extends MvpBasePresenter<SkillsView> implements SkillsPresenter {

    private final SkillsModel model;

    public SkillsPresenterImpl(SkillsModel model) {
        this.model = model;
    }

    @Override
    public void loadSkills() {
        Log.d("APP", "presenter.loadSkills");
        getView().showLoading(false);
        if (isViewAttached()) {
            getView().setData(model.retrieveInfo());
            getView().showContent();
        }
    }
}
