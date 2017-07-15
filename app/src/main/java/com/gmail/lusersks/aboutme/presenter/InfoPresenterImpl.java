package com.gmail.lusersks.aboutme.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.gmail.lusersks.aboutme.model.InfoModel;
import com.gmail.lusersks.aboutme.view.InfoView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class InfoPresenterImpl extends MvpBasePresenter<InfoView> implements InfoPresenter {

    @NonNull
    private final InfoModel model;

    @Nullable
    private Subscription subscription;

    public InfoPresenterImpl(@NonNull InfoModel model) {
        this.model = model;
    }

    @Override
    public void loadInformation() {
        getView().showLoading(false);
        subscription = model.retrieveInfo().observeOn(AndroidSchedulers.mainThread()).subscribe(data -> {
            if (isViewAttached()) {
                getView().setData(data);
                getView().showContent();
            }
        }, throwable -> {
            if (isViewAttached()) {
                getView().showError(throwable, false);
            }
        });
    }
}
