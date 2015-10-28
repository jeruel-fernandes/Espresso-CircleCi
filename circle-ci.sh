function pushHacks(){
   HACKED="$ANDROID_HOME/hacks-applied"

   if [ ! -e $HACKED ]; then
       adb install -r circleci/android_emulator_hacks-release.apk &&
       adb shell pm grant no.finn.android_emulator_hacks android.permission.SET_ANIMATION_SCALE &&
       touch $HACKED
   fi

   adb shell am start -n no.finn.android_emulator_hacks/no.finn.android_emulator_hacks.HackActivity
}