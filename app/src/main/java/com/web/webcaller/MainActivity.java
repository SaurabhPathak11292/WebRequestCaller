package com.web.webcaller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.web.webrequestcaller.WebRequest;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebRequest webRequest = new WebRequest("http://jsonplaceholder.typicode.com/posts",WebRequest.REQUEST_GET,WebRequest.JSON_OBJECT){
            @Override
            public void onResponse(String response) {
                Log.d(TAG,response);
            }

            @Override
            public void onErrorResponse(String reponse) {
                Log.d(TAG,"error : " + reponse);
            }
        };

        webRequest.execute();
    }
}
