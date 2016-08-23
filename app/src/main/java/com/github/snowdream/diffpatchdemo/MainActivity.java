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
import android.util.TimingLogger;
import android.widget.TextView;
import android.os.Bundle;

import com.github.snowdream.bsdiffpatch.BSDiffPatch;
import com.github.snowdream.diffpatch.IDiffPatch;
import com.github.snowdream.hdiffpatch.HDiffPatch;

import java.io.File;


public class MainActivity extends Activity
{


    private static final String TAG = "SnowdreamFramework";

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

            String SD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
            String AMAP_OLD_PATH = SD_PATH+"/Amap_Android_V7.3.0.2036_GuanWang.apk";
            String AMAP_NEW_PATH = SD_PATH+"/Amap_Android_V7.7.4.2128_GuanWang.apk";
            String AMAP_BSDIFF_PATCH_PATH = SD_PATH+"/Amap_Android_Bsdiffpatch_patch";
            String AMAP_BSDIFF_PATCH_GEN_PATH = SD_PATH+"/Amap_Android_V7.7.4.2128_GuanWang_Bsdiff.apk";
            String AMAP_HDIFF_PATCH_PATH = SD_PATH+"/Amap_Android_hdiffpatch_patch";
            String AMAP_HDIFF_PATCH_GEN_PATH = SD_PATH+"/Amap_Android_V7.7.4.2128_GuanWang_hdiff.apk";

            TimingLogger timings = new TimingLogger(TAG, "UpdateTask");

            File old_apk = new File(AMAP_OLD_PATH);
            if (!old_apk.exists()) {
                Util.CopyAssets(getApplicationContext(), "Amap_Android_V7.3.0.2036_GuanWang.apk", AMAP_OLD_PATH);
                timings.addSplit("CopyAssets Amap_Android_V7.3.0.2036_GuanWang.apk ");
            }

            File new_apk = new File(AMAP_NEW_PATH);
            if (!new_apk.exists()) {
                Util.CopyAssets(getApplicationContext(), "Amap_Android_V7.7.4.2128_GuanWang.apk", AMAP_NEW_PATH);
                timings.addSplit("CopyAssets Amap_Android_V7.7.4.2128_GuanWang.apk ");
            }


            //BSDiffPatch
            IDiffPatch bsDiffPatch = new BSDiffPatch();
            bsDiffPatch.init(getApplicationContext());

            if(!new File(AMAP_BSDIFF_PATCH_PATH).exists()) {
                bsDiffPatch.diff(AMAP_OLD_PATH, AMAP_NEW_PATH, AMAP_BSDIFF_PATCH_PATH);
                timings.addSplit("bsDiffPatch.diff");
            }

            if(!new File(AMAP_BSDIFF_PATCH_GEN_PATH).exists()) {
                bsDiffPatch.patch(AMAP_OLD_PATH, AMAP_BSDIFF_PATCH_PATH, AMAP_BSDIFF_PATCH_GEN_PATH);
                timings.addSplit("bsDiffPatch.patch");
            }


            //HDiffPatch
            IDiffPatch  hDiffPatch= new HDiffPatch();
            hDiffPatch.init(getApplicationContext());

            if(!new File(AMAP_HDIFF_PATCH_PATH).exists()) {
                hDiffPatch.diff(AMAP_OLD_PATH, AMAP_NEW_PATH, AMAP_HDIFF_PATCH_PATH);
                timings.addSplit("hDiffPatch.diff");
            }

            if(!new File(AMAP_HDIFF_PATCH_GEN_PATH).exists()) {
                hDiffPatch.patch(AMAP_OLD_PATH, AMAP_HDIFF_PATCH_PATH, AMAP_HDIFF_PATCH_GEN_PATH);
                timings.addSplit("hDiffPatch.patch");
            }

            timings.dumpToLog();

            return null;
        }
    }




}
