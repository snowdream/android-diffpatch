package com.github.snowdream.diffpatch;

import android.content.Context;

/**
 * Created by yanghui.yangh on 2016-07-11.
 */
public interface IDiffPatch {
    public static final int SUCCESS = 0;
    public static final int ERROR = 1;


    /**
     * Load so with Relinker
     *
     * @param context
     */
    public void init(Context context);

    /**
     * diff between the old file and the new file,then output into the diff file.
     *
     * @param oldFilePath
     * @param newFilePath
     * @param diffFilePath
     * @return
     */
    public int diff(String oldFilePath, String newFilePath, String diffFilePath);


    /**
     * patch to the old file with the diff file, then create the new file.
     *
     * @param oldFilePath
     * @param diffFilePath
     * @param newFilePath
     * @return
     */
    public int patch(String oldFilePath, String diffFilePath, String newFilePath);
}
