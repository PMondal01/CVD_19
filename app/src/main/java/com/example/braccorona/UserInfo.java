package com.example.braccorona;

public class UserInfo {

    private String pin,mobile,address;

    public UserInfo(String pin, String mobile, String address) {
        this.pin = pin;
        this.mobile = mobile;
        this.address = address;
    }

    public UserInfo(String pin) {

    }


    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
