package com.example.whjth.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private String Name;
    private String Gender;
    private String Personality;
    private String Major;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner s1 = (Spinner) findViewById(R.id.spinner);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String[] major = getResources().getStringArray(R.array.major);
                Major = major[pos];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id){
                switch (id) {
                    case R.id.male:
                        Gender = "男";
                        break;
                    case R.id.female:
                        Gender = "女";
                        break;
                }
            }
        });

        Button submit = (Button) findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                EditText editText = (EditText) findViewById(R.id.name);
                Name = editText.getText().toString();
                Personality = "";

                CheckBox c1 = (CheckBox) findViewById(R.id.c1);
                CheckBox c2 = (CheckBox) findViewById(R.id.c2);
                CheckBox c3 = (CheckBox) findViewById(R.id.c3);
                CheckBox c4 = (CheckBox) findViewById(R.id.c4);

                if(c1.isChecked()){
                    Personality+= c1.getText().toString()+" ";
                }
                if(c2.isChecked()){
                    Personality+=c2.getText().toString()+" ";
                }
                if(c3.isChecked()){
                    Personality+=c3.getText().toString()+" ";
                }
                if(c4.isChecked()){
                    Personality+=c4.getText().toString()+" ";
                }
                Intent intent = new Intent(MainActivity.this, Information.class);
                intent.putExtra("Name", Name);
                intent.putExtra("Gender", Gender);
                intent.putExtra("Personality", Personality);
                intent.putExtra("Major", Major);
                startActivity(intent);
            }
        });

    }

}
