package com.example.smarthome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.smarthome.Adapter.DeviceStatusAdapter;
import com.example.smarthome.Modal.Device;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Device>  deviceList = new ArrayList<>();
    DeviceStatusAdapter deviceStatusAdapter;
    RecyclerView recyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =findViewById(R.id.recyclerView);
        Device device1 = new Device(1,"DEV1");
        Device device2 = new Device(1,"DEV2");
        Device device3 = new Device(1,"DEV3");
        deviceList.add(device1);
        deviceList.add(device2);
        Log.d("test", "onCreate: "+deviceList.toString());
        deviceStatusAdapter = new DeviceStatusAdapter(deviceList);
        recyclerView.setAdapter(deviceStatusAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
//        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(gridLayoutManager);

    }
}
