package com.vaporware.photohunt;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.vaporware.photohunt.SiteContract.SiteEntry;

/**
 * Created by ReverendCode on 7/21/15.
 */
public class SiteDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;

    static final String DATABASE_NAME = "sites.db";

    public SiteDBHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_SITES_TABLE = "CREATE TABLE IF NOT EXISTS " + SiteEntry.TABLE_NAME + " (" +
                SiteEntry._ID + " INTEGER PRIMARY KEY," +
                SiteEntry.COLUMN_NAME_TITLE + " TEXT, " +
                SiteEntry.COLUMN_NAME_CLUE + " TEXT, " +
                SiteEntry.COLUMN_NAME_THUMB + " TEXT, " +
                SiteEntry.COLUMN_NAME_IMAGE + " TEXT, " +
                SiteEntry.COLUMN_NAME_LAT + " REAL, " +
                SiteEntry.COLUMN_NAME_LONG + " REAL, " +
                SiteEntry.COLUMN_NAME_RATING + " INTEGER);";
        db.execSQL(SQL_CREATE_SITES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //just a local cache, so we can dump local data with relative impunity
            //is that a royal 'we' or am I talking to the computer now?
                //I get it, comments are notes for future me, so it is past me talking.

        db.execSQL("DROP TABLE IF EXISTS " + SiteEntry.TABLE_NAME);
        onCreate(db);

    }
}
