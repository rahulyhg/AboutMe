package com.gmail.lusersks.aboutme.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.gmail.lusersks.aboutme.model.SkillsData;


public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "skillsDB";
    public static final String TABLE_SKILLS = "skills";
    public static final String KEY_ID = "_id";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_SKILLS + " (" + KEY_ID + " integer primary key, "
                + SkillsData.FIELD_SKILL + " text, " + SkillsData.FIELD_YEARS + " integer, "
                + SkillsData.FIELD_LEVEL + " integer" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exist " + TABLE_SKILLS);

        onCreate(db);
    }
}
