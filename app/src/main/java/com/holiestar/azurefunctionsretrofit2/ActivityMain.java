package com.holiestar.azurefunctionsretrofit2;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.holiestar.http.loader.LoaderSaveData;

public class ActivityMain extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private Context context;
    private Button btnSend;

    private LoaderSaveData loaderSaveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initUI();
        initAction();
    }

    private void init() {
        this.loaderSaveData=new LoaderSaveData(context);
    }

    private void initUI() {
        this.btnSend = (Button) findViewById(R.id.btnSend);
    }

    private void initAction() {
        this.btnSend.setOnClickListener(view -> loaderSaveData.load("suki", "xxx@xx.xx.xx"));
        this.loaderSaveData.setOnSimpleLoadedListener(() -> Log.i(TAG, "load successful"));
        this.loaderSaveData.setOnFailedListener((errorCode, errorMessage) -> Log.i(TAG, String.format("load failed\nerrorCode:%d\terrorMessage%s",errorCode,errorMessage)));
    }
}
