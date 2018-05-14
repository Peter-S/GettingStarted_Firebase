package com.example.lmnop.gettingstarted;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView textViewDisplay;
    Button buttonDougnut, buttonNugot;
    Firebase firebaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        textViewDisplay = (TextView)  findViewById(R.id.textView);
        buttonDougnut = (Button) findViewById(R.id.button_donut);
        buttonNugot = (Button) findViewById(R.id.button_nogut);

        firebaseReference = new Firebase("https://gettingstarted-fc134.firebaseio.com/");
        firebaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                textViewDisplay.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
}
