package com.example.slaby.android_2;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static public boolean isAfterChange = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartClick(View view) {

        if (!isAfterChange) {
            // Do something in response to button
            TextView helloText = (TextView) findViewById(R.id.helloText);
            EditText input = (EditText) findViewById(R.id.editText);

            String finalText = (String) getResources().getText(R.string.Hello);
            if (input.getText().length() > 0) {
                finalText += " " + input.getText();
            } else {
                finalText += " " + getResources().getText(R.string.Stranger);
            }

            helloText.setText(finalText);
            input.setFreezesText(true);
            input.setEnabled(false);

            isAfterChange = true;
            Button btn = (Button) findViewById(R.id.button);
            btn.setText(getResources().getText(R.string.change_color_button));
        } else {
            TextView helloText = (TextView) findViewById(R.id.helloText);

            if (helloText.getCurrentTextColor() == ContextCompat.getColor(this, R.color.GREEN)) {
                helloText.setTextColor(ContextCompat.getColor(this, R.color.RED));
            } else if (helloText.getCurrentTextColor() == ContextCompat.getColor(this, R.color.RED)) {
                helloText.setTextColor(ContextCompat.getColor(this, R.color.BLUE));
            } else {
                helloText.setTextColor(ContextCompat.getColor(this, R.color.GREEN));
            }
        }

    }
}
