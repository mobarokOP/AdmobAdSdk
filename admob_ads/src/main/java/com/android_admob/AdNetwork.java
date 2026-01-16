package com.android_admob;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.io.Serializable;

public class AdNetwork implements Serializable {



    public static void setForChild(boolean isChild){
        if (isChild){
            RequestConfiguration configuration = new RequestConfiguration.Builder()
                    .setTagForChildDirectedTreatment(RequestConfiguration.TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE)
                    .setMaxAdContentRating(RequestConfiguration.MAX_AD_CONTENT_RATING_G)
                    .build();
            MobileAds.setRequestConfiguration(configuration);
        }
    }

    public static void showAd(Context context, OnDismiss onDismiss) {
        // Show the ad if it's ready. Otherwise restart the game.
        if (interstitialAd != null) {
            interstitialAd.show((Activity) context);
            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent();
                    onDismiss.onDismiss();
                    interstitialAd = null;
                }
            });
        } else {
            onDismiss.onDismiss();
            loadInterstitial(context);
        }
    }



    public static void showAd(Context context) {
        // Show the ad if it's ready. Otherwise restart the game.
        if (interstitialAd != null) {
            interstitialAd.show((Activity) context);
            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent();
                    //onDismiss.onDismiss();
                    interstitialAd = null;
                }
            });
        } else {
            //onDismiss.onDismiss();
            loadInterstitial(context);
        }
    }




    public interface OnDismiss{
        void onDismiss();
    }


    private static boolean adIsLoading;

    private static InterstitialAd interstitialAd;


    public static void loadInterstitial(Context context) {
        // Request a new ad if one isn't already loaded.
        if (adIsLoading || interstitialAd != null) {
            return;
        }
        adIsLoading = true;
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(
                context,
                context.getResources().getString(R.string.INTERSTITIAL_AD),
                adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        interstitialAd = interAd;
                        adIsLoading = false;
                        Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i(TAG, loadAdError.getMessage());
                        interstitialAd = null;
                        adIsLoading = false;

                        String error =
                                String.format(
                                        java.util.Locale.US,
                                        "domain: %s, code: %d, message: %s",
                                        loadAdError.getDomain(),
                                        loadAdError.getCode(),
                                        loadAdError.getMessage());
                        //Toast.makeText(MyActivity.this, "onAdFailedToLoad() with error: " + error, Toast.LENGTH_SHORT).show();
                    }
                });
    }


    private static AdView adView;



    public static void loadBanner(Activity activity, int adLayout){
        LinearLayout adContainer = activity.findViewById(adLayout);
        adView = new AdView(activity);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(activity.getResources().getString(R.string.BANNER_ID));
        adContainer.addView(adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }

    public static void loadBannerAd(Activity activity, int adLayout) {
        LinearLayout adContainer = activity.findViewById(adLayout);
        adView = new AdView(activity);
        adView.setAdSize(AdSize.SMART_BANNER);
        adView.setAdUnitId(activity.getResources().getString(R.string.BANNER_ID));
        adContainer.addView(adView);
        // Create an extra parameter that aligns the bottom of the expanded ad to
        // the bottom of the bannerView.
        Bundle extras = new Bundle();
        extras.putString("collapsible", "bottom");

        AdRequest adRequest = new AdRequest.Builder()
                .addNetworkExtrasBundle(AdMobAdapter.class, extras)
                .build();

        adView.loadAd(adRequest);
    }

    public static void destroyBanner(){
        if (adView != null) {
            adView.destroy();
        }
    }

    public static void pauseBanner(){
        if (adView != null) {
            adView.pause();
        }
    }

    public static void resumeBanner(){
        if (adView != null) {
            adView.resume();
        }
    }



}
