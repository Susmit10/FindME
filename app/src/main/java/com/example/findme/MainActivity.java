package com.example.findme;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    TextView Latitude, Longitude;
    Button button;
//    DatabaseReference dref;
//    String status1 = "0", status2 = "0";
//    Double latitude = 0.0,longitude = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Latitude = findViewById(R.id.lat);
        Longitude = findViewById(R.id.lon);
        button = findViewById(R.id.button);



        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference dref = firebaseDatabase.getReference("Latitude");
        dref.setValue(1);

//        dref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                status1 = snapshot.child("Latitude").getValue(String.class);
//                status2 = snapshot.child("Longitude").getValue(String.class);
//                latitude = Double.parseDouble(status1);
//                longitude = Double.parseDouble(status2);
//
//                Latitude.setText(status1);
//                Longitude.setText(status2);
//
//                Toast.makeText(MainActivity.this, "Firebase connection successfully done", Toast.LENGTH_LONG).show();
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference dref = firebaseDatabase.getReference("Latitude");
                dref.setValue(1);
                Toast.makeText(MainActivity.this, "Firebase connection successfully done", Toast.LENGTH_LONG).show();
                openMap();
            }
        });

    }

    private void openMap() {

        Intent intent = new Intent(this, Map.class);
        startActivity(intent);

    }

}