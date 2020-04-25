package com.example.braccorona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserinfoActivity extends AppCompatActivity implements OnMapReadyCallback {

    private Button button;
    private EditText editText_pin,editText_mobile,editText_address;
    DatabaseReference databaseReference;
    MyPreferences myPreferences;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE=101;
    Location currentLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);
        databaseReference= FirebaseDatabase.getInstance().getReference("user_responses");
        myPreferences=MyPreferences.getPreferences(this);

        button=findViewById(R.id.angry_btn);
        editText_pin=findViewById(R.id.editpin);
        editText_mobile=findViewById(R.id.editmobile);
        editText_address=findViewById(R.id.editaddress);
        fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(this);

        //getCurrentlocation
            if ( ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_COARSE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {

                ActivityCompat.requestPermissions( this, new String[] {  android.Manifest.permission.ACCESS_COARSE_LOCATION  },
                        REQUEST_CODE);
            }
            Task<Location> task=fusedLocationProviderClient.getLastLocation();
            task.addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if(location!=null){
                        currentLocation=location;
                    }
                }
            });
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saveData();
                int age=myPreferences.getAge();
                int second=myPreferences.getSecond();
                int third=myPreferences.getThird();
                int four=myPreferences.getFourth();
                int fifth=myPreferences.getFifth();
                int six=myPreferences.getSixth();
                int seven=myPreferences.getSeven();
                int total=second+third+four+fifth+six+seven;
                //all questions
                //age
                int age_value=0;
                if(age<55){
                    age_value=0;
                }else {
                    age_value=1;
                }
                //symptom
                int q2q3_value=0;
                if (second==0 && third==0) {
                        q2q3_value=0;
                } else if (second==0 && third==1) {
                        q2q3_value=2;
                } else if (second==1 && third==0){
                        q2q3_value=2;
                }else {
                        q2q3_value=2;
                }
                //Epidomik
                int q4q5_value=0;
                if (four==0 && fifth==0) {
                    q4q5_value=0;
                } else if (four==0 && fifth==1) {
                    q4q5_value=1;
                } else if (four==1 && fifth==0){
                    q4q5_value=2;
                }else {
                    q4q5_value=2;
                }
                //history
                int history_value=0;
                if(six==0){
                    history_value=0;
                }else {
                    history_value=1;
                }
                int medical_worker;
                if(seven==0){
                    medical_worker=0;
                }else {
                    medical_worker=1;
                }
                if(total>=4)
                {
                    Intent intent = new Intent(UserinfoActivity.this, SickActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(UserinfoActivity.this, HealthyActivity.class);
                    startActivity(intent);
                }

            }

            private void saveData() {

                String pin=editText_pin.getText().toString().trim();
                String mobile=editText_mobile.getText().toString().trim();
                String address=editText_address.getText().toString().trim();

                myPreferences.setPin(pin);
                myPreferences.setMobile(mobile);
                myPreferences.setAddress(address);
                editText_pin.setText("");
                editText_mobile.setText("");
                editText_address.setText("");

                int age=myPreferences.getAge();
                int second=myPreferences.getSecond();
                int third=myPreferences.getThird();
                int four=myPreferences.getFourth();
                int fifth=myPreferences.getFifth();
                int six=myPreferences.getSixth();
                int seven=myPreferences.getSeven();
              //  int eight=myPreferences.getEight();
                String pin_no=myPreferences.getPin();
                String mob=myPreferences.getMobile();
                String add=myPreferences.getAddress();
                //location pass
                Double latitude= currentLocation.getLatitude();
                float float_latitude = latitude.floatValue();
                Double longitude=  currentLocation.getLongitude();
                float float_longitude = longitude.floatValue();
                myPreferences.setlatitude(float_latitude);
                Float param_latitude= myPreferences.getlatitude();
                myPreferences.setlongitude(float_longitude);
                Float param_longitude=myPreferences.getlongitude();

                Location mylocation=currentLocation;
                String string_location=mylocation.toString();
                myPreferences.setlocation(string_location);
                String location=myPreferences.getlocation();
                //firebase
                String key=databaseReference.push().getKey();
                MyPreferences myPreferences=new MyPreferences(age,second,third,four,fifth,six,seven,pin_no,mob,add,param_latitude,param_longitude,location);
                assert key != null;
                databaseReference.child(key).setValue(myPreferences);
                }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED);
                break;
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng latLng=new LatLng(currentLocation.getLatitude(),currentLocation.getLongitude());
        MarkerOptions markerOptions=new MarkerOptions().position(latLng)
                .title("Current Location");

        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,5));
        googleMap.addMarker(markerOptions);
    }
}

