# MOE_SAM — Android APK project

This project wraps the MOE_SAM app (`app/src/main/assets/index.html`) in an Android WebView.
The app works fully offline and blocks external links.

## Build the APK (Android Studio)
1. Install Android Studio (includes the Android SDK and JDK 17).
2. File > Open > select this `MOE_SAM_android` folder. Let Gradle sync finish.
3. Build > Build Bundle(s) / APK(s) > Build APK(s).
4. The APK is at `app/build/outputs/apk/debug/app-debug.apk`.
5. For a release APK: Build > Generate Signed App Bundle / APK.

Install on a phone: copy the APK to the phone and open it (allow installs from this source).

## Updating the app
Replace `app/src/main/assets/index.html` with a new export of the HTML and rebuild.
