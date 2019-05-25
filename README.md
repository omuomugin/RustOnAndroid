## What is this
Sample Project of Android Library including binary build with Rust.

## Features
- Using Rust binary with JNI
- Execute side effect in Library module

## How to build
1. Download NDK
follow https://mozilla.github.io/firefox-browser-architecture/experiments/2017-09-21-rust-on-android.html

add path to `NDK_HOME`

```
export NDK_HOME=$ANDROID_HOME/ndk-bundle
```

make directory named `NDK` to RustLibrary/RustSample/

```
${NDK_HOME}/build/tools/make_standalone_toolchain.py --api 26 --arch arm64 --install-dir NDK/arm64
${NDK_HOME}/build/tools/make_standalone_toolchain.py --api 26 --arch arm --install-dir NDK/arm
${NDK_HOME}/build/tools/make_standalone_toolchain.py --api 26 --arch x86 --install-dir NDK/x86
```

2. modify cargo-config.toml to your project path
In order for cargo to see our new SDK’s we need to copy this config file to our .cargo directory like this after modifying it

```
cp cargo-config.toml ~/.cargo/config
```

3. add target images to build for android

```
rustup target add aarch64-linux-android armv7-linux-androideabi i686-linux-android
```

4. modify RustLibrary/RustSample/build.sh
after modifying it just run 

```
sh build.sh
```

5. run Android App
You can see, add button and text.
Addition logic is in rust and side effect of saving to Shared Preference is in the library module.
