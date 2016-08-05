package com.web.webcaller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.web.webrequestcaller.WebRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebRequest webRequest = new WebRequest("http://jsonplaceholder.typicode.com/posts/1",WebRequest.REQUEST_GET,WebRequest.STRING){
            @Override
            public void onWebResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Log.d(TAG,jsonObject.getInt("userId")+"");
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onWebErrorResponse(String error) {
                Log.d(TAG,"error : " + error);
            }
        };

        webRequest.addParams("param-name","param-value");

        webRequest.addHeaderParams("param-name","param-value");

        webRequest.execute();
    }
}
