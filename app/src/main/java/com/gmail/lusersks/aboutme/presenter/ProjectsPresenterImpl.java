package com.gmail.lusersks.aboutme.presenter;

import com.gmail.lusersks.aboutme.model.ProjectsModel;
import com.gmail.lusersks.aboutme.view.ProjectsView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

public class ProjectsPresenterImpl extends MvpBasePresenter<ProjectsView> implements ProjectsPresenter {
    private final ProjectsModel model;

    public ProjectsPresenterImpl(ProjectsModel model) {
        this.model = model;
    }

    @Override
    public void loadProjects() {
        getView().showLoading(false);
        if (isViewAttached()) {
            getView().setData(model.retrieveInfo());
            getView().showContent();
        }
    }
}
