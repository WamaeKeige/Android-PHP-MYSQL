package com.awake.mysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class MainActivity extends AppCompatActivity {
EditText id, name, amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = (EditText) findViewById(R.id.id);
        name = (EditText) findViewById(R.id.name);
        amount = (EditText) findViewById(R.id.amount);
    }
    public void send(View v){
        AsyncHttpClient  c= new AsyncHttpClient();
        //prepare parameter(param) for posting using 'c'
        RequestParams params = new RequestParams();
        //its a must that the keys in green are the same as those in PHP
        params.add("id", id.getText().toString());
        params.add("name", name.getText().toString());
        params.add("amount", amount.getText().toString());
        c.post("your url goes here",params, new AsyncHttpResponseHandler()
        {
            //checks for errors and success
            @Override
            public void onSuccess(String content) {
                Toast.makeText(MainActivity.this, "Completed Successfully!!", Toast.LENGTH_SHORT).show();

            }
        }

        );
    }


    public void Records(View view) {
        //gets to view records
        Intent xx = new Intent(this, SearchActivity.class);
        startActivity(xx);

    }
}
