package com.hg.uxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hg.uxdemo.ui.activity.UnUseUxActivity;
import com.hg.uxdemo.ui.activity.UseUxActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onUseUxClick(View view) {
        startActivity(new Intent(this, UseUxActivity.class));
    }

    public void onUnUseUxClick(View view) {
        startActivity(new Intent(this, UnUseUxActivity.class));
    }

}