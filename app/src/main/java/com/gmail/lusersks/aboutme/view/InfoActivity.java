package com.gmail.lusersks.aboutme.view;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gmail.lusersks.aboutme.R;
import com.gmail.lusersks.aboutme.model.InfoModelImpl;
import com.gmail.lusersks.aboutme.model.api.GithubService;
import com.gmail.lusersks.aboutme.model.entity.GithubUser;
import com.gmail.lusersks.aboutme.model.image.ImageLoader;
import com.gmail.lusersks.aboutme.model.image.PicassoImageLoader;
import com.gmail.lusersks.aboutme.presenter.InfoPresenter;
import com.gmail.lusersks.aboutme.presenter.InfoPresenterImpl;
import com.gmail.lusersks.aboutme.presenter.Utilities;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class InfoActivity extends MvpLceViewStateActivity<LinearLayout, GithubUser, InfoView, InfoPresenter>
        implements InfoView {

    private static final String UNKNOWN_ERROR_MESSAGE = "Unknown error";
    public static final String USER = "romasks";

//    private RecyclerView recyclerView;
//    private InfoAdapter recyclerAdapter;

    @BindView(R.id.avatar)
    ImageView avatar;

    @BindView(R.id.username)
    TextView username;

    @BindView(R.id.userbio)
    TextView userbio;
    private ImageLoader<ImageView> imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);
//        initRecyclerView();
        imageLoader = new PicassoImageLoader(Picasso.with(this));
    }

    /*private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.contentView);
        recyclerAdapter = new InfoAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);
    }*/

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("APP", "Something wrong");
    }

    @NonNull
    @Override
    public InfoPresenter createPresenter() {
        GithubService api = new Retrofit.Builder().baseUrl("https://api.github.com/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService.class);
        return new InfoPresenterImpl(new InfoModelImpl(USER, api));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Utilities.someAction(item.getItemId(), this);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setData(GithubUser data) {
//        recyclerAdapter.setData(data);
        runOnUiThread(() -> {
            imageLoader.downloadInfio(data.getAvatar(), avatar);
            username.setText(data.getName());
            userbio.setText(data.getBio());
        });
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        getPresenter().loadInformation();
    }

    @NonNull
    @Override
    public LceViewState<GithubUser, InfoView> createViewState() {
        return new RetainingLceViewState<>();
    }

    @Override
    public GithubUser getData() {
//        return recyclerAdapter.getData();
        return new GithubUser();
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        String errorMessage = e.getMessage();
        return errorMessage == null ? UNKNOWN_ERROR_MESSAGE : errorMessage;
    }
}
