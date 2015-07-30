package com.vaporware.photohunt;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.vaporware.photohunt.SiteContract.SiteEntry;

import java.util.Vector;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_main, container, false);
        final String SQL_TITLE_THUMB_QUERY = "SELECT " +
                SiteEntry._ID + ", " +
                SiteEntry.COLUMN_NAME_THUMB + ", " +
                SiteEntry.COLUMN_NAME_TITLE + " FROM " +
                SiteEntry.TABLE_NAME + " LIMIT 5";


        Vector tempArray = new Vector<>();
        Vector tempNum = new Vector<>();
        Vector tempId = new Vector<>();
        /**
         * This is probably where I want to:
         * 1. create db
         * 2. use a dbHelper to construct the tables
         * 3. insert dummy data
         * Once that is done, I can finish setting up the views with more certainty
         * */

        SiteDBHelper mDBHelper = new SiteDBHelper(getActivity());
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        mDBHelper.onUpgrade(db,2,2);
        ContentValues values = new ContentValues();
        values.put(SiteEntry.COLUMN_NAME_THUMB,"Thumb");
        values.put(SiteEntry.COLUMN_NAME_TITLE,"title");
        values.put(SiteEntry.COLUMN_NAME_IMAGE,"Image");
        values.put(SiteEntry.COLUMN_NAME_LAT,123);
        values.put(SiteEntry.COLUMN_NAME_LONG,321);
        values.put(SiteEntry.COLUMN_NAME_RATING, 0);
        db.insert(SiteEntry.TABLE_NAME, null, values);

        Cursor cursor = db.rawQuery(SQL_TITLE_THUMB_QUERY,null);

        if (cursor != null) {
            if (cursor.moveToFirst() ) {

                do {
                    String tempTitle = cursor.getString(
                            cursor.getColumnIndex(SiteEntry.COLUMN_NAME_TITLE)
                    );
                    String tempThumb = cursor.getString(
                            cursor.getColumnIndex(SiteEntry.COLUMN_NAME_THUMB));
                    String id = cursor.getString(
                            cursor.getColumnIndex(SiteEntry._ID));
                    tempId.add(id);
                    tempArray.add(tempTitle);
                    tempNum.add(tempThumb);
                }while (cursor.moveToNext() );
            }
        }

        final CustomList adapter = new CustomList(getActivity(),tempId,tempArray,tempNum);
        ListView list = (ListView) rootView.findViewById(R.id.mainList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),SiteDetail.class);
                startActivity(intent);


            }
        });

        return rootView;
    }
}
