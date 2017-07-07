package com.gmail.lusersks.aboutme.presenter;

import com.gmail.lusersks.aboutme.view.SkillsView;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

public interface SkillsPresenter extends MvpPresenter<SkillsView> {
    void loadSkills();
}
