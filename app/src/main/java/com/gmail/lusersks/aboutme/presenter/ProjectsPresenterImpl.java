package com.gmail.lusersks.aboutme.presenter;

import com.gmail.lusersks.aboutme.model.ProjectsModel;
import com.gmail.lusersks.aboutme.model.entity.Project;
import com.gmail.lusersks.aboutme.view.ProjectsView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class ProjectsPresenterImpl extends MvpBasePresenter<ProjectsView> implements ProjectsPresenter {
    private final ProjectsModel model;
    private Subscription subscription;

    public ProjectsPresenterImpl(ProjectsModel model) {
        this.model = model;
    }

    @Override
    public void detachView(boolean retainInstance) {
        if (!retainInstance && subscription != null && subscription.isUnsubscribed()) {
            subscription.unsubscribe();
            subscription = null;
        }
        super.detachView(retainInstance);
    }

    @Override
    public void loadProjects() {
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
