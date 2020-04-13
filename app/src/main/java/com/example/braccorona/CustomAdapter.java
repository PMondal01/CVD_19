package com.example.braccorona;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<UserInfo> {

    private Activity context;
    private List<UserInfo> userInfoList;


    public CustomAdapter(Activity  context, List<UserInfo>userInfoList) {
        super(context, R.layout.sample_layout,userInfoList);
        this.context=context;
        this.userInfoList=userInfoList;

    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position,View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.sample_layout,null,true);

        //retrive

        UserInfo userInfo=userInfoList.get(position);

        TextView textView_pin=view.findViewById(R.id.sample_pin);
        TextView textView_mobile=view.findViewById(R.id.sample_mobile);
        TextView textView_address=view.findViewById(R.id.sample_address);

        textView_pin.setText("Pin: "+userInfo.getPin());
        textView_mobile.setText("Mobile:: "+userInfo.getMobile());
        textView_address.setText("Address: "+userInfo.getAddress());


        return view;



    }
}
