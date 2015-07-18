package com.vaporware.photohunt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public ArrayAdapter<String> mListAdapter;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_main, container, false);

        String[] tempArray = {
                "words",
                "are",
                "hard"
        };
        List<String> sitesInArea = new ArrayList<String>(Arrays.asList(tempArray));

        mListAdapter = new ArrayAdapter<>(
                getActivity(),
                R.layout.list_item_site,
                R.id.list_item_site_textview,
                sitesInArea
        );
        ListView listview = (ListView) rootView.findViewById(R.id.mainList);
        listview.setAdapter(mListAdapter);
        //TODO: add setOnItemClickListener

        return rootView;
    }
}
