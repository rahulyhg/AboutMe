package com.gmail.lusersks.aboutme.presenter;

import com.gmail.lusersks.aboutme.view.InfoView;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

public interface InfoPresenter extends MvpPresenter<InfoView> {
    void loadInformation();
}
