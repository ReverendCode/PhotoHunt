package com.vaporware.photohunt;

import android.os.AsyncTask;

/**
 * Created by ReverendCode on 7/21/15.
 */
public class FetchSiteTask extends AsyncTask {


    @Override
    protected Object doInBackground(Object[] params) {

        /**
         * This is where I will connect to the internet, and grab the actual data
         * almost certainly, this will happen though the use of Android Endpoints, since that
         * seems to be exactly the kind of problem it is supposed to solve.
         * so, endpoints sends me a JSON string, which I decode, and parse for the location of
         * the images to download. then we insert into the local database the new (local path)
         * of the images, along with the other DB information that is wanted
         * */
        return null;
    }
}
