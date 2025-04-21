
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
    <string name="INTERSTITIAL_AD">ca-app-pub-3940256099942544/1033173712</string> <!-- Required for InterstitialAd-->
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


## Initialize Admob Ad Into Activity by Default:


**Also Add** `InitializeAdmob` **into your** `MainActivity.java`:

```java
public class SampleActivity extends InitializeAdmob {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

    }
}
```
**Like below image:**

![image](https://github.com/user-attachments/assets/ed2cc67b-e5fd-466b-bd52-0234962ebd1e)


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


## Banner Ad Implementation

Add this in your `activity_main.xml`:

```xml
    <LinearLayout
        android:layout_marginTop="@dimen/_3sdp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/adLayout"
        android:orientation="vertical"
        android:layout_alignParentBottom="true"
        />
```

Add this in your `MainAcivity.java` oncreate:

```java
     AdNetwork.loadBanner(this, R.id.adLayout); //For Simple Fixed Banner
     AdNetwork.loadBannerAd(this, R.id.adLayout); //For Adaptive Collapsable Banner
```

## Interstitial Ad Implementation


Add this in your `MainAcivity.java` oncreate:

```java

      AdNetwork.showAd(MainActivity.this); //Without Ad Callback

      //With Ad Show Complete Listenter
      AdNetwork.showAd(MainActivity.this, new AdNetwork.OnDismiss() {
                    @Override
                    public void onDismiss() {
                        // Ad Show Complete
                        startActivity(new Intent(MainActivityv.this, PhotoActivity.class));
                    }
                });
```

## App Open Ad Implementation

**Add this** `Manifest.xml` **if your'e using AppOpenAd:**
```xml
android:name="com.android_admob.MyApplication"
```
**Like below image:**

![image](https://github.com/user-attachments/assets/9015fb6a-25dd-4c56-898e-48533a98546e)


**If you want to use AppOpenAd into your** `SplashActivity.java`:

```java
 new Handler().postDelayed(() -> {
            Application application = getApplication();
            ((MyApplication) application)
                    .showAdIfAvailable(
                            SplashActivity.this,
                            () -> {
                                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                                finish();
                            });
        }, 5000); //it will start yout app after 5 second
```




