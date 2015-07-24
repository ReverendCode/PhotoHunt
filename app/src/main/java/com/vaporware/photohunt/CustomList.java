package com.vaporware.photohunt;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * This is copyPasta from the internet.
 * Mostly because I couldn't see any way to improve it,
 * it is a pretty simple piece of code
 *
 */
public class CustomList extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] text;
    private final Integer[] imageId;

    public CustomList(Activity context, String[] text, Integer[] imageId) {
        super(context, R.layout.list_item_site, text);
        this.context = context;
        this.text = text;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        //the parent class calls this iteratively over the listview
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_item_site, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.list_item_site_textview);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.list_item_site_imageview);
        txtTitle.setText(text[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
