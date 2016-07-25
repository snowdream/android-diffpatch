//
// Created by yanghui.yangh on 2016-07-06.
//
#include <jni.h>
#include <assert.h>
#include <stdint.h>
#include "native_diff.h"
#include "native_patch.h"

#define JNIREG_CLASS "com/github/snowdream/bsdiffpatch/BSDiffPatch"//指定要注册的类

/**
* Table of methods associated with a single class.
*/
static JNINativeMethod gMethods[] = {
        {"bsdiff", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I", (void *) bsdiff},
        {"bspatch", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I", (void *) bspatch}
};

/*
* Register several native methods for one class.
*/
static int registerNativeMethods(JNIEnv* env, const char* className,
                                 JNINativeMethod* gMethods, int numMethods)
{
    jclass clazz;
    clazz = (*env)->FindClass(env, className);
    if (clazz == NULL) {
        return JNI_FALSE;
    }
    if ((*env)->RegisterNatives(env, clazz, gMethods, numMethods) < 0) {
        return JNI_FALSE;
    }

    return JNI_TRUE;
}


/*
* Register native methods for all classes we know about.
*/
static int registerNatives(JNIEnv* env)
{
    if (!registerNativeMethods(env, JNIREG_CLASS, gMethods,
                               sizeof(gMethods) / sizeof(gMethods[0])))
        return JNI_FALSE;

    return JNI_TRUE;
}

/*
* Set some test stuff up.
*
* Returns the JNI version on success, -1 on failure.
*/
JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved)
{
    JNIEnv* env = NULL;
    jint result = -1;

    if ((*vm)->GetEnv(vm, (void**) &env, JNI_VERSION_1_4) != JNI_OK) {
        return -1;
    }
    assert(env != NULL);

    if (!registerNatives(env)) {//注册
        return -1;
    }
    /* success -- return valid version number */
    result = JNI_VERSION_1_4;

    return result;
}