package com.example.admobapplicationidissue;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    //views
    private AdView mAdView;

    //vars
    private AdRequest mAdRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        //If you will use com.example.guidetemplate applicationId like in this project, your banners will not be shown
        initAd();
    }

    private void initAd() {
        MobileAds.initialize(this, initializationStatus -> {
        });

        initBanner();

    }

    private void initBanner() {
        mAdRequest = new AdRequest.Builder().build();
        mAdView.loadAd(mAdRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);

            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();

            }
        });
    }

    private void initViews() {
        mAdView = findViewById(R.id.adView);
    }
}