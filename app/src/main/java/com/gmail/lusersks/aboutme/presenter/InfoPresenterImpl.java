package com.gmail.lusersks.aboutme.presenter;

import android.util.Log;

import com.gmail.lusersks.aboutme.model.InfoModel;
import com.gmail.lusersks.aboutme.view.InfoView;

import java.util.List;

public class InfoPresenterImpl implements InfoPresenter {

    private final InfoModel model;
    private final InfoView view;

    public InfoPresenterImpl(InfoModel model, InfoView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void loadInformation() {
        Log.d("APP", "presenter.loadInformation()");
        view.setData(model.retrieveInfo());
    }
}
