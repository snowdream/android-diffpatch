/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.snowdream.diffpatchdemo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Environment;
import android.widget.TextView;
import android.os.Bundle;

import com.github.snowdream.bsdiffpatch.BSDiffPatch;
import com.github.snowdream.diffpath.IDiffPatch;


public class MainActivity extends Activity
{
    private static final String SD_PATH = Environment.getExternalStorageDirectory().getPath();


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        /* Create a TextView and set its content.
         * the text is retrieved by calling a native
         * function.
         */
        TextView  tv = new TextView(this);
        tv.setText("test" );
        setContentView(tv);

        new UpdateTask().execute();
    }


    private class UpdateTask extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... params) {
            IDiffPatch diffPatch = new BSDiffPatch();
//            diffPatch.diff()

            String SD_PATH = Environment.getExternalStorageDirectory().getPath();

            return null;
        }
    }




}
