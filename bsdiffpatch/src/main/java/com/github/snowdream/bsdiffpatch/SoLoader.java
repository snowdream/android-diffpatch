package com.github.snowdream.bsdiffpatch;

import android.content.Context;
import android.util.Log;

import com.getkeepsafe.relinker.ReLinker;
import com.getkeepsafe.relinker.ReLinkerInstance;

/**
 * Use Relinker with default configuration
 * see: https://github.com/KeepSafe/ReLinker
 * see: https://medium.com/keepsafe-engineering/relinker-v1-2-is-here-b8f1799e22fe
 *
 * Created by yanghui.yangh on 2016-07-06.
 */
public final class SoLoader {
    private static final String TAG = SoLoader.class.getSimpleName();

    public static void loadLibrary(Context context, String library) {
        loadLibrary(context, library, (String)null, (ReLinker.LoadListener)null);
    }

    public static void loadLibrary(Context context, String library, String version) {
        loadLibrary(context, library, version, (ReLinker.LoadListener)null);
    }

    public static void loadLibrary(Context context, String library, ReLinker.LoadListener listener) {
        loadLibrary(context, library, (String)null, listener);
    }

    public static void loadLibrary(Context context, String library, String version, ReLinker.LoadListener listener) {
        (getDefaultReLinkerInstance()).loadLibrary(context, library, version, listener);
    }

    private static ReLinkerInstance getDefaultReLinkerInstance(){
        return ReLinker.recursively().log(new ReLinker.Logger() {
            @Override
            public void log(String s) {
                Log.i(TAG,s);
            }
        });
    }
}
