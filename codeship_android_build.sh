cd /tmp
pwd

wget http://dl.google.com/android/android-sdk_r24.1.2-linux.tgz
tar zxvf android-sdk_r24.1.2-linux.tgz
rm android-sdk_r24.1.2-linux.tgz

export ANDROID_HOME="/tmp/android-sdk-linux"
export PATH="$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools:$PATH"

( sleep 1 && while [ 1 ]; do sleep 1; echo y; done ) | android update sdk --no-ui --all --filter tools,platform-tools,build-tools-21.1.2
#( sleep 1 && while [ 1 ]; do sleep 1; echo y; done ) | android update sdk --no-ui --all --filter android-22,sys-img-armeabi-v7a-android-22,addon-google_apis-google-22
#( sleep 1 && while [ 1 ]; do sleep 1; echo y; done ) | android update sdk --no-ui --all --filter android-8,sysimg-8,addon-google_apis-google-8

cd -

touch local.properties
echo "sdk.dir=$ANDROID_HOME" >> local.properties

./gradlew assembleDebug

./gradlew testDebug