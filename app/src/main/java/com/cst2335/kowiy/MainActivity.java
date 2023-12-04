package com.cst2335.kowiy;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);

        // Click listener for "Click Here" Button
        Button clickHereButton = findViewById(R.id.button);
        clickHereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Show a Toast message
                Toast.makeText(MainActivity.this, getResources().getString(R.string.toast_message), Toast.LENGTH_LONG).show();
            }
        });

        // Checked change listener for Switch
        Switch switchButton = findViewById(R.id.switch);
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                // Show a Snackbar with the current switch state
                String switchState = isChecked ? "on" : "off";
                Snackbar.make(compoundButton, "The switch is now " + switchState, Snackbar.LENGTH_LONG)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                // Undo action: Set the switch back to its original state
                                switchButton.setChecked(!isChecked);
                            }
                        })
                        .show();
            }
        });
    }
