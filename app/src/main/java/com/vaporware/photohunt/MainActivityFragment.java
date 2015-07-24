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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.vaporware.photohunt.SiteContract.SiteEntry;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public ArrayAdapter<String> mListAdapter;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_main, container, false);
        final String SQL_QUERY = "SELECT " + SiteEntry.COLUMN_NAME_CLUE + " FROM " + SiteEntry.TABLE_NAME;
        Integer[] tempNum = {
                0,
                1,
                2
        };

        String[] tempArray = {
                "words",
                "are",
                "hard"
        };

        /**
         * This is probably where I want to:
         * 1. create db
         * 2. use a dbHelper to construct the tables
         * 3. insert dummy data
         * Once that is done, I can finish setting up the views with more certainty
         * */

        SiteDBHelper mDBHelper = new SiteDBHelper(getActivity());
        SQLiteDatabase db = mDBHelper.getWritableDatabase();

        for (int i = 0; i < 3; i++) {
            ContentValues values = new ContentValues();
            values.put(SiteEntry.COLUMN_NAME_CLUE,tempArray[i]);
            values.put(SiteEntry.COLUMN_NAME_IMAGE,tempNum[i]);
            db.insert(SiteEntry.TABLE_NAME,
                    null,
                    values);
        }

        Cursor cursor = db.rawQuery(SQL_QUERY, null);


        final CustomList adapter = new CustomList(getActivity(),tempArray,tempNum);
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
