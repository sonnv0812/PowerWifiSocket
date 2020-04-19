package com.example.smarthome.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smarthome.Modal.Device;
import com.example.smarthome.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DeviceStatusAdapter extends RecyclerView.Adapter<DeviceStatusAdapter.DeviceStatusHolder> {
    List<Device> deviceList = new ArrayList<>();

    public DeviceStatusAdapter(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    @NonNull
    @Override
    public DeviceStatusHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_button,parent,false);
        return new DeviceStatusHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceStatusHolder holder, int position) {
        holder.setData(deviceList.get(position));
    }

    @Override
    public int getItemCount() {
        return deviceList.size();
    }

    public class DeviceStatusHolder extends RecyclerView.ViewHolder{
        public TextView tvDevice;
        public ImageView ivStatus;
        public DeviceStatusHolder(View itemView) {
            super(itemView);
            tvDevice =itemView.findViewById(R.id.tvDevice);
            ivStatus =itemView.findViewById(R.id.ivStatus);
        }
        public void setData(final Device data){
            tvDevice.setText(data.getNameDevice());
            chooseImage(data.getStatus());
            ivStatus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    data.setStatus(1-data.getStatus());
                    chooseImage(data.getStatus());
                }
            });


        }
        private void chooseImage(int choose){
            if(choose == 0 ) Picasso.get().load(R.drawable.turn_on).into(ivStatus);
            else Picasso.get().load(R.drawable.turn_off).into(ivStatus);
        }
    }
}
