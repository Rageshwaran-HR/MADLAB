package com.example.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class MyDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "MyDB";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "users";
    public static final String COL_NAME = "name";

    public MyDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + COL_NAME + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertName(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String getAllNames() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        StringBuilder builder = new StringBuilder();

        while (cursor.moveToNext()) {
            builder.append(cursor.getString(0)).append("\n");
        }

        cursor.close();
        db.close();
        return builder.toString();
    }
}
