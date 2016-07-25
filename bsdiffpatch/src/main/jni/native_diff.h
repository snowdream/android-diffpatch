//
// Created by yanghui.yangh on 2016-07-11.
//

#ifndef ANDROID_DIFFPATCH_NATIVE_DIFF_H
#define ANDROID_DIFFPATCH_NATIVE_DIFF_H

#include <jni.h>

#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT jint JNICALL bsdiff(JNIEnv *env, jobject thiz, jstring oldFilePath, jstring newFilePath,
                                jstring diffFilePath);

#ifdef __cplusplus
}
#endif
#endif //ANDROID_DIFFPATCH_NATIVE_DIFF_H
