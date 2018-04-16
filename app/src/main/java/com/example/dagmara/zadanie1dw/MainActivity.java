package com.example.dagmara.zadanie1dw;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.BoringLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText textField;
    private TextView textView;
    private Switch switchField;
    private RadioGroup radioGroup;
    private boolean isUppercase = false;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textField = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.text_view);
        switchField = (Switch) findViewById(R.id.switch1);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);

        text = textField.getText().toString();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);

                switch(checkedId) {
                    case R.id.radioButtonRed:
                        textView.setTextColor(getResources().getColor(R.color.red));
                        break;

                    case R.id.radioButtonGreen:
                        textView.setTextColor(getResources().getColor(R.color.green));
                        break;

                    case R.id.radioButtonYellow:
                        textView.setTextColor(getResources().getColor(R.color.yellow));
                        break;
                    case R.id.radioButtonBlue:
                        textView.setTextColor(getResources().getColor(R.color.blue));
                }


            }
        });

        textField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                text = textField.getText().toString();
                updateText();
            }
        });

        switchField.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isUppercase = isChecked;
                updateText();
            }
        });
    }

    private void updateText() {
        textView.setText((isUppercase) ? text.toUpperCase() : text);
    }
}
