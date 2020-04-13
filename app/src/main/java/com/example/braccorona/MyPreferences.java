package com.example.braccorona;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreferences {

    private static MyPreferences myPreferences;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    MyPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences("user_Response", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    public MyPreferences(int age, int s, int t, int four, int fifth, int six, int sev, int eight, String pin_no, String mob, String add) {
    }

    public static MyPreferences getPreferences(Context context) {
        if (myPreferences == null) myPreferences = new MyPreferences(context);
        return myPreferences;
    }

    public void setAge(int age){
        editor.putInt("AGE", age);
        editor.apply();
    }

    public int getAge(){
        return sharedPreferences.getInt("AGE", -1); //if user's age not found then it'll return -1
    }

    public void setSecond(int second_ans){
        editor.putInt("second_ans", second_ans);
        editor.apply();
    }

    public int getSecond(){
        return sharedPreferences.getInt("second_ans", -1); //if user's age not found then it'll return -1
    }

    public void setThird(int third_ans){
        editor.putInt("third_ans", third_ans);
        editor.apply();
    }

    public int getThird(){
        return sharedPreferences.getInt("third_ans", -1); //if user's age not found then it'll return -1
    }
    public void setFourth(int fourth_ans){
        editor.putInt("fourth_ans", fourth_ans);
        editor.apply();
    }

    public int getFourth(){
        return sharedPreferences.getInt("fourth_ans", -1); //if user's age not found then it'll return -1
    }
    public void setFifth(int fifth_ans){
        editor.putInt("fifth_ans", fifth_ans);
        editor.apply();
    }

    public int getFifth(){
        return sharedPreferences.getInt("fifth_ans", -1); //if user's age not found then it'll return -1
    }
    public void setSixth(int sixth_ans){
        editor.putInt("sixth_ans", sixth_ans);
        editor.apply();
    }

    public int getSixth(){
        return sharedPreferences.getInt("sixth_ans", -1); //if user's age not found then it'll return -1
    }
    public void setSeven(int seventh_ans){
        editor.putInt("seventh_ans", seventh_ans);
        editor.apply();
    }

    public int getSeven(){
        return sharedPreferences.getInt("seventh_ans", -1); //if user's age not found then it'll return -1
    }

    public int getEight(){
        return sharedPreferences.getInt("eighth_ans", -1); //if user's age not found then it'll return -1
    }
    public void setEight(int eighth_ans){
        editor.putInt("eighth_ans", eighth_ans);
        editor.apply();
    }

    public String getPin(){
        return sharedPreferences.getString("pin", null); //if user's age not found then it'll return -1
    }
    public void setPin(String pin){
        editor.putString("pin",pin);
        editor.apply();
    }

    public String getMobile(){
        return sharedPreferences.getString("mobile", null); //if user's age not found then it'll return -1
    }
    public void setMobile(String mobile){
        editor.putString("mobile",mobile);
        editor.apply();
    }

    public String getAddress(){
        return sharedPreferences.getString("address", null); //if user's age not found then it'll return -1
    }
    public void setAddress(String address){
        editor.putString("address",address);
        editor.apply();
    }






}




