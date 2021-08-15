package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import javax.net.ssl.SSLEngineResult;

public class MainActivity extends AppCompatActivity {

    Switch Light1;
    Switch Light2;
    Switch Light3;
    Switch Light4;
    Switch Light5;
    TextView Temperature;
    TextView Humidity;
    DatabaseReference myref;
    String Temp;
    String Hum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Light1 = (Switch) findViewById(R.id.Light1);
        Light2 = (Switch) findViewById(R.id.Light2);
        Light3 = (Switch) findViewById(R.id.Light3);
        Light4 = (Switch) findViewById(R.id.Light4);
        Light5 = (Switch) findViewById(R.id.Light5);

        Temperature = (TextView) findViewById(R.id.Temperature);
        Humidity = (TextView) findViewById(R.id.Humidity);

        myref = FirebaseDatabase.getInstance().getReference();
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot dataSnapshot) {
                Temp = dataSnapshot.child("Iot/Temp").getValue().toString();
                Temperature.setText(Temp);
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError databaseError) {
                //Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot dataSnapshot) {
                Hum = dataSnapshot.child("Iot/Humidity").getValue().toString();
                Humidity.setText(Hum+"%");
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError databaseError) {
                //Log.w(TAG, "Failed to read value.", error.toException());
            }
        });





        Light1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b1) {
                        if(b1){
                            // Write a message to the database
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference myRef = database.getReference("Iot/Data1");
                            myRef.setValue(true);

                        } else {
                            // Write a message to the database
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference myRef = database.getReference("Iot/Data1");
                            myRef.setValue(false);

                        }
            }
        });

        Light2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b2) {
                if(b2){
                    // Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("Iot/Data2");
                    myRef.setValue(true);

                } else {
                    // Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("Iot/Data2");
                    myRef.setValue(false);

                }
            }
        });

        Light3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b3) {
                if(b3){
                    // Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("Iot/Data3");
                    myRef.setValue(true);

                } else {
                    // Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("Iot/Data3");
                    myRef.setValue(false);

                }
            }
        });

        Light4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b4) {
                if(b4){
                    // Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("Iot/Data4");
                    myRef.setValue(true);

                } else {
                    // Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("Iot/Data4");
                    myRef.setValue(false);

                }
            }
        });


        Light5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b5) {
                if(b5){
                    // Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("Iot/Data5");
                    myRef.setValue(true);

                } else {
                    // Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("Iot/Data5");
                    myRef.setValue(false);

                }
            }
        });
    }
}