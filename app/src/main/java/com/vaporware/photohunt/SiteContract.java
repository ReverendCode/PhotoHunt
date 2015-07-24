package com.vaporware.photohunt;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by ReverendCode on 7/21/15.
 */
public final class SiteContract {


    public static final String CONTENT_AUTHORITY = "com.vaporware.photohunt.app";


    //here is the basic front part of every URI
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    //where can we look? should only be at 'sites' I think??
    public static final String PATH_SITE = "site";

    //empty constructor to prevent instantiation of the superClass
    public SiteContract() {}

    //now we define our contract parameters

    public static abstract class SiteEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_SITE).build();


        public static final String TABLE_NAME = "site";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_CLUE = "clue";
        public static final String COLUMN_NAME_THUMB = "thumbLoc";
        public static final String COLUMN_NAME_IMAGE = "imageLoc";
        public static final String COLUMN_NAME_LAT = "latitude";
        public static final String COLUMN_NAME_LONG = "longitude";
        public static final String COLUMN_NAME_RATING = "rating";




    }

}
