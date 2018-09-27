package com.example.bilalal_shahwany.proguardtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import io.split.android.client.SplitClient;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.SplitFactory;
import io.split.android.client.SplitFactoryBuilder;
import io.split.android.client.api.Key;

public class MainActivity extends AppCompatActivity {
    SplitClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//API Key
        String apikey = "there-was-our-api-key-here";

// Build SDK configuration by default
        SplitClientConfig config = SplitClientConfig.builder()
                .build();

// Create a new user key to be evaluated
        String matchingKey = "there-was-a-user-uuid-here";
        String bucketingKey = null;
        Key k = new Key(matchingKey, bucketingKey);

        try {
// Create factory
            SplitFactory splitFactory = SplitFactoryBuilder.build(apikey, k, config, getApplicationContext());

// Get Split Client instance
            client = splitFactory.client();
            String result = client.getTreatment("chat_quick_replies");
            Log.i("Split", result);
        } catch (Exception e) {
        }

    }

    public void callSplit(View view) {
        String result = client.getTreatment("chat_quick_replies");
        Log.i("Split", result);
    }
}
