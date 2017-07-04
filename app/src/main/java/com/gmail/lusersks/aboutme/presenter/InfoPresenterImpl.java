package com.gmail.lusersks.aboutme.presenter;

import com.gmail.lusersks.aboutme.model.InfoModel;
import com.gmail.lusersks.aboutme.view.InfoView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

public class InfoPresenterImpl extends MvpBasePresenter<InfoView> implements InfoPresenter {

    private final InfoModel model;

    public InfoPresenterImpl(InfoModel model) {
        this.model = model;
    }

    @Override
    public void loadInformation() {
        getView().showLoading(false);
        if (isViewAttached()) {
            getView().setData(model.retrieveInfo());
            getView().showContent();
        }
    }
}
