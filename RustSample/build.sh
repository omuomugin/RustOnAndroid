cargo build --target aarch64-linux-android --release
cargo build --target armv7-linux-androideabi --release
cargo build --target i686-linux-android --release

cp ./target/aarch64-linux-android/release/librust_logic.so ../RunningRustOnAndroid/rustclient/jniLibs/arm64/librust_logic.so
cp ./target/armv7-linux-androideabi/release/librust_logic.so ../RunningRustOnAndroid/rustclient/jniLibs/armeabi/librust_logic.so
cp ./target/i686-linux-android/release/librust_logic.so ../RunningRustOnAndroid/rustclient/jniLibs/x86/librust_logic.so