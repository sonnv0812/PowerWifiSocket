package com.example.smarthome.Modal;

public class Device {
    private int status;
    private String nameDevice;

    public Device() {
    }

    public Device(int status, String nameDevice) {
        this.status = status;
        this.nameDevice = nameDevice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNameDevice() {
        return nameDevice;
    }

    public void setNameDevice(String nameDevice) {
        this.nameDevice = nameDevice;
    }

    @Override
    public String toString() {
        return "Device{" +
                "status=" + status +
                ", nameDevice='" + nameDevice + '\'' +
                '}';
    }
}
