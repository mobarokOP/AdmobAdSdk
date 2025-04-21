
# AdmobAdSdk - A Ad Loader Libreary For Loading Admob Ads
### Overview of AdmobAdSdk library
* You can use App Open Ad
* Banner Ad
* Interstitial Ad
* In Built GDPR

## About me

Hello! I’m Mobarok Hossain, a passionate and experienced Android developer from Tabakpur, Ulipur, Kurigram, Bangladesh. With over 3 years of hands-on experience in Android development, I’ve had the privilege of completing more than 200 projects, working across various types of apps—ranging from educational tools to lifestyle utilities. I specialize in building Android applications using Java, and I’m highly skilled in integrating Firebase for powerful backend solutions.

You can connect with me on:

- [Facebook](https://facebook.com/mobarokOP)
- [Whatsapp](https://wa.me/8801408874276)
- [GitHub](https://github.com/mobarokOP)
- [Twitter](https://twitter.com/mobarokOP)
- [YouTube](https://www.youtube.com/@mobarokOP)
- [LinkedIn](https://www.linkedin.com/in/mobarokOP)

## Using AdmobAdSdk Library in your Android application

Add this in your `settings.gradle`:
```groovy
maven { url 'https://jitpack.io' }
```

If you are using `settings.gradle.kts`, add the following:
```kotlin
maven { setUrl("https://jitpack.io") }
```

Add this into your `strings.xml` file:
```xml
 <!--Warning don't change any resources name.-->

   <string name="BANNER_ID">ca-app-pub-3940256099942544/9214589741</string> <!--Required for BannerAd-->
    <string name="INTERSTITIAL_AD">ca-app-pub-3940256099942544/1033173712</string <!--Required for InterstitialAd-->
    <string name="APP_OPEN_ID">ca-app-pub-3940256099942544/9257395921</string> <!--Required for AppOpenAd-->
    <string name="APP_ID">ca-app-pub-3940256099942544~3347511713</string> <!--Required App ID-->
```
Do not forget to add internet permission in `Manifest.xml` if already not present
```xml
<uses-permission android:name="android.permission.INTERNET" />
```

**Add Admob Metadata Tag into** `Manifest.xml`:

```xml
    <meta-data
            android:name="com.google.android.gms.ads.APPLICATION_ID"
            android:value="@string/APP_ID" />
```
**Like below image:**

![image](https://github.com/user-attachments/assets/8092261d-9f1b-412e-9802-8f14e3460ec8)


**Also Add This into your** `Manifest.xml` **if your'e using AppOpenAd:**
```xml
android:name="com.android_admob.MyApplication"
```
**Like below image:**

![image](https://github.com/user-attachments/assets/9015fb6a-25dd-4c56-898e-48533a98546e)


Version:
[![](https://jitpack.io/v/mobarokOP/AdmobAdSdk.svg)](https://jitpack.io/#mobarokOP/AdmobAdSdk)

Add this in your `build.gradle`
```groovy
implementation 'com.github.mobarokOP:AdmobAdSdk:1.0.0'
```

If you are using `build.gradle.kts`, add the following:
```kotlin
implementation("com.github.mobarokOP:AdmobAdSdk:1.0.0")
```

