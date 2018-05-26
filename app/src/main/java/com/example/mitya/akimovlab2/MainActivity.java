package com.example.mitya.akimovlab2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup group1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        group1 = (RadioGroup) findViewById(R.id.radioGroup1);
        RadioButton rButton;

        rButton = new RadioButton(this);
        rButton.setText("Так");
        group1.addView(rButton);
        group1.check(rButton.getId());
        rButton = new RadioButton(this);
        rButton.setText("Ні");
        group1.addView(rButton);

        Button button = findViewById(R.id.button);

        View.OnClickListener v = new View.OnClickListener(){
            public void onClick(View v) {
                int selectedId1 = group1.getCheckedRadioButtonId();
                RadioButton radioButton1 = (RadioButton) findViewById(selectedId1);
                EditText mEdit = (EditText)findViewById(R.id.editText);
                Context context = getApplicationContext();
                CharSequence text = mEdit.getText() + " - " + radioButton1.getText();
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        };

        button.setOnClickListener(v);
    }

    private void loadFragment(Fragment fragment) {

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }
}