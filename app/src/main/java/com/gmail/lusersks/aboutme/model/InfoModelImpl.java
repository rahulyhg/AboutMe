package com.gmail.lusersks.aboutme.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class InfoModelImpl implements InfoModel {
    @Override
    public List<String> retrieveInfo() {
        List<String> list = new ArrayList<>();
        list.add("RAMAN SKASKEVICH");
        list.add("SOFTWARE DEVELOPER and TESTER");
        list.add("RUBY and JAVA AMATEUR");
        return list;
    }
}
