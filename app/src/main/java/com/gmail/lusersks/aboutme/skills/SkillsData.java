package com.gmail.lusersks.aboutme.skills;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.gmail.lusersks.aboutme.R;
import com.gmail.lusersks.aboutme.SkillsActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkillsData {

    public static final String FIELD_SKILL = "skill";
    public static final String FIELD_YEARS = "years";
    public static final String FIELD_LEVEL = "level";

    private static String[] skill = {"Android", "Java", "Ruby on Rails", "JavaScript", "HTML", "CSS"};
    private static String[] years = {"1", "1", "1", "1", "2", "2"};
    private static String[] level = {"1", "2", "2", "2", "3", "2"};

    public static List<Map<String, String>> getItems(SkillsActivity activity) {

        DBHelper dbHelper = new DBHelper(activity);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        Cursor cursor = database.query(DBHelper.TABLE_SKILLS, null, null, null, null, null, null);
        if (!cursor.moveToFirst()) initDB(database);

        List<Map<String, String>> items = new ArrayList<>();
        fillListOfItems(cursor, items);

        cursor.close();

        return items;
    }

    private static void fillListOfItems(Cursor cursor, List<Map<String, String>> items) {

        int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
        int skillIndex = cursor.getColumnIndex(FIELD_SKILL);
        int yearsIndex = cursor.getColumnIndex(FIELD_YEARS);
        int levelIndex = cursor.getColumnIndex(FIELD_LEVEL);
        do {
            Map<String, String> map = new HashMap<>(2);

            Log.d("mLog", "ID = " + cursor.getInt(idIndex)
                    + ", skill = " + cursor.getString(skillIndex)
                    + ", years = " + cursor.getString(yearsIndex)
                    + ", level = " + cursor.getString(levelIndex));

            map.put(FIELD_SKILL, cursor.getString(skillIndex));
            map.put(FIELD_YEARS, cursor.getString(yearsIndex));
            map.put(FIELD_LEVEL, cursor.getString(levelIndex));

            items.add(map);
        } while (cursor.moveToNext());
    }

    private static void initDB(SQLiteDatabase database) {

        final int NUMBER_OF_SKILLS = 6;
        ContentValues contentValues = new ContentValues();

        database.delete(DBHelper.TABLE_SKILLS, null, null);

        for (int i = 0; i < NUMBER_OF_SKILLS; i++) {
            contentValues.put(FIELD_SKILL, skill[i]);
            contentValues.put(FIELD_YEARS, Integer.parseInt(years[i]));
            contentValues.put(FIELD_LEVEL, Integer.parseInt(level[i]));

            /*Log.d("mLog", "ID = ?"
                    + ", skill = " + contentValues.get(FIELD_SKILL)
                    + ", years = " + contentValues.get(FIELD_YEARS)
                    + ", level = " + contentValues.get(FIELD_LEVEL));*/

            database.insert(DBHelper.TABLE_SKILLS, null, contentValues);
        }
    }

    public static void addItem(SkillsActivity activity, String skill, String years, String level) {

        DBHelper dbHelper = new DBHelper(activity);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(FIELD_SKILL, skill);
        contentValues.put(FIELD_YEARS, Integer.parseInt(years));
        contentValues.put(FIELD_LEVEL, Integer.parseInt(level));

        database.insert(DBHelper.TABLE_SKILLS, null, contentValues);
    }

    public static void deleteItem(SkillsActivity activity, String skill) {

        DBHelper dbHelper = new DBHelper(activity);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        database.delete(DBHelper.TABLE_SKILLS, FIELD_SKILL + " == " + skill, null);
    }

    public static void modifyItem(String item) {
        // TODO: edit item
    }

    public static void clearItems() {
        // TODO; clear items
    }
}
