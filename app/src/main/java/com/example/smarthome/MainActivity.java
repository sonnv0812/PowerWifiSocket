package com.example.smarthome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.smarthome.adapter.DeviceStatusAdapter;
import com.example.smarthome.model.Device;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main_Activity";
    public static final String LIST_DEVICE = "device";
    public static final String ID_USER = "123111";
    FirebaseDatabase database;
    DatabaseReference myRef;
    DeviceStatusAdapter deviceStatusAdapter;
    RecyclerView recyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager manager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference(LIST_DEVICE).child(ID_USER);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Device> listDevice = new ArrayList<>();
                for(DataSnapshot deviceSnapshot:dataSnapshot.getChildren()){
                    Device device = deviceSnapshot.getValue(Device.class);
                    listDevice.add(device);
                }
                Log.d(TAG, "onDataChange: " + listDevice.size());
                deviceStatusAdapter = new DeviceStatusAdapter(listDevice);
                recyclerView.setAdapter(deviceStatusAdapter);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}
