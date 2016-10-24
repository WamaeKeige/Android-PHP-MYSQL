package com.awake.mysql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class SearchActivity extends AppCompatActivity {
TextView results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        results=(TextView) findViewById (R.id.results);

        AsyncHttpClient c = new AsyncHttpClient();
        results.setText("Please Wait....Loading");
        RequestParams params = new RequestParams();
        c.post("your url goes here",params, new AsyncHttpResponseHandler(){

            @Override
            public void onSuccess(String content) {
               //the data is stored in  content string as contnt updates the the please wait message
                results.setText(content);

            }
        });
    }
}
