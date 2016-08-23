# android-diffpatch

diffpatch with android

## Getting Started
### BsDiffPatch
website： [http://www.daemonology.net/bsdiff/](http://www.daemonology.net/bsdiff/) 

1. write in the build.gradle as follows:
```
sourceSets {
    main {
        jniLibs.srcDirs = ['libs']
    }
}
```
1. copy `app/libs/armeabi-v7a/libbsdiffpatch.so` to your project.
1. copy `app/src/main/java/com/github/snowdream/bsdiffpatch` and `app/src/main/java/com/github/snowdream/diffpath` to your project, with the exact package and filename.


### HDiffPatch
website：[https://github.com/sisong/HDiffPatch](https://github.com/sisong/HDiffPatch)

1. write in the build.gradle as follows:
```
sourceSets {
    main {
        jniLibs.srcDirs = ['libs']
    }
}
```
1. copy `app/libs/armeabi-v7a/libhdiffpatch.so` to your project.
1. copy `app/src/main/java/com/github/snowdream/hdiffpatch` and `app/src/main/java/com/github/snowdream/diffpath` to your project, with the exact package and filename.


## Usage
### BsDiffPatch
```
IDiffPatch bsDiffPatch = new BSDiffPatch();
bsDiffPatch.init(getApplicationContext()); 
//diff
bsDiffPatch.diff(oldFilePath, newFilePath, diffFilePath);
//patch
bsDiffPatch.patch(oldFilePath, diffFilePath, gennewFilePath);
```

### HDiffPatch
```
IDiffPatch hDiffPatch = new HDiffPatch();
hDiffPatch.init(getApplicationContext()); 
//diff
hDiffPatch.diff(oldFilePath, newFilePath, diffFilePath);
//patch
hDiffPatch.patch(oldFilePath, diffFilePath, gennewFilePath);
```


## License
```
Copyright (C) 2016 snowdream <yanghui1986527@gmail.com>

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
