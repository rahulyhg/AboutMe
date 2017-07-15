package com.gmail.lusersks.aboutme.model.image;


import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoImageLoader implements ImageLoader<ImageView> {

    @NonNull
    private final Picasso picasso;

    public PicassoImageLoader(@NonNull Picasso picasso) {
        this.picasso = picasso;
    }

    @Override
    public void downloadInfio(@NonNull String url, @NonNull ImageView placeHolder) {
        picasso.load(url).into(placeHolder);
    }
}
