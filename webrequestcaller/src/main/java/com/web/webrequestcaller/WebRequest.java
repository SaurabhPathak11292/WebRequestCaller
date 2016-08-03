package com.web.webrequestcaller;

import android.widget.Switch;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pratik on 3/8/16.
 */
public class WebRequest {

    public static final int STRING  = 0;
    public static final int JSON_OBJECT  = 1;
    public static final int JSON_ARRAY  = 2;

    public static final int REQUEST_GET  = Request.Method.GET;
    public static final int REQUEST_POST  = Request.Method.POST;
    public static final int REQUEST_PUT  = Request.Method.PUT;
    public static final int REQUEST_DELETE  = Request.Method.DELETE;



    private int responseType;
    private String url;
    private int requestType;

    private Map<String,String> header;
    private Map<String,String> params;

    public void onResponse(String reponse) {

    }

    public void onErrorResponse(String reponse) {

    }

    public WebRequest() {
        header = new HashMap<String,String>();
        params = new HashMap<String,String>();
    }

    public WebRequest(String url,int requestType,int responseType) {
        super();
        this.url = url;
        this.requestType = requestType;
        this.responseType = responseType;

    }

    public void addHeaderParams(Map<String,String> paramHeader) {
        header.putAll(paramHeader);
    }

    public void addHeaderParams(String paramName , String value) {
        header.put(paramName, value);
    }

    public void addParams(Map<String,String> paramList) {
        params.putAll(paramList);
    }

    public void addParams(String paramName , String value) {
        params.put(paramName, value);
    }


    public void execute() {
        switch (responseType) {
            case STRING:
                    callStringRequest();
                break;
            case JSON_OBJECT:
                    callJSONObjectRequest();
                break;
            case JSON_ARRAY:
                    callJSONArrayRequest();
                break;
        }
    }

    private void callStringRequest() {
        String  reqest_tag = "string_req";
        StringRequest strReq = new StringRequest(requestType,
                url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                WebRequest.this.onResponse(response.toString());
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                WebRequest.this.onErrorResponse(error.getMessage());
            }
        });

        BaseApplication.getInstance().addToRequestQueue(strReq, reqest_tag);
    }

    private void callJSONObjectRequest() {
        String request_tag = "json_obj_req";
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(requestType,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        WebRequest.this.onResponse(response.toString());
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                WebRequest.this.onErrorResponse(error.getMessage());
            }
        });
        BaseApplication.getInstance().addToRequestQueue(jsonObjReq, request_tag);
    }

    private void callJSONArrayRequest() {
        String request_tag = "json_array_req";
        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        WebRequest.this.onResponse(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                WebRequest.this.onErrorResponse(error.getMessage());
            }
        });
        BaseApplication.getInstance().addToRequestQueue(req,request_tag);
    }
}
