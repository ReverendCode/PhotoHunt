package com.vaporware.photohunt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


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

        CustomList adapter = new CustomList(getActivity(),tempArray,tempNum);
        ListView list = (ListView) rootView.findViewById(R.id.mainList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"You touched something",Toast.LENGTH_SHORT).show();

            }
        });

        return rootView;
    }
}
