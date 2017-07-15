package com.gmail.lusersks.aboutme.model;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

public class InfoModelImpl implements InfoModel {
    @Override
    public Observable<List<String>> retrieveInfo() {
        List<String> list = new ArrayList<>();
        list.add("RAMAN SKASKEVICH");
        list.add("SOFTWARE DEVELOPER and TESTER");
        list.add("RUBY and JAVA AMATEUR");
        return Observable.from(list).buffer(3);
    }
}
