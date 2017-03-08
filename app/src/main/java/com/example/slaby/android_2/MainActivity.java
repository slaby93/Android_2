package com.example.slaby.android_2;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartClick(View view) {
        // Do something in response to button
        TextView helloText = (TextView) findViewById(R.id.helloText);
        EditText input = (EditText) findViewById(R.id.editText);

        String finalText = (String) getResources().getText(R.string.Hello);
        if (input.getText().length() > 0) {
            finalText += input.getText();
        } else {
            finalText += " " + (String) getResources().getText(R.string.Stranger);
        }

        helloText.setText(finalText);
        input.setFreezesText(true);
        input.setEnabled(false);
        findViewById(R.id.button).setVisibility(View.INVISIBLE);
        findViewById(R.id.changeColorButton).setVisibility(View.VISIBLE);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onChangeColorClick(View view) {
        TextView helloText = (TextView) findViewById(R.id.helloText);

        if (helloText.getCurrentTextColor() == getResources().getColor(R.color.GREEN, getTheme())) {
            helloText.setTextColor(getResources().getColor(R.color.RED, getTheme()));

        } else if (helloText.getCurrentTextColor() == getResources().getColor(R.color.RED, getTheme())) {
            helloText.setTextColor(getResources().getColor(R.color.BLUE, getTheme()));

        } else {
            helloText.setTextColor(getResources().getColor(R.color.GREEN, getTheme()));

        }
    }
}
