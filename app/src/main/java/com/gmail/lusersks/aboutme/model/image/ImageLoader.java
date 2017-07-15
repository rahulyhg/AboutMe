package com.gmail.lusersks.aboutme.model.image;


import android.support.annotation.NonNull;

public interface ImageLoader<T> {

    void downloadInfio(@NonNull String url, @NonNull T placeHolder);

}
