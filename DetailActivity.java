package com.itplus.demolistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private TextView tvName, tvPosition;
    private String strName ="";
    private String strPosition ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_listview);
//        getDataFromIntent1();
        getDataFromIntent2();
        initView();
    }


    //Cach nhan du lieu 1
    private void getDataFromIntent1() {
        strName = getIntent().getStringExtra("NAME");
        strPosition = getIntent().getStringExtra("POSITION");
    }

    //Cach nhan du lieu 2
    private void getDataFromIntent2(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        CountryInfo mCountryInfo = (CountryInfo)  bundle.getSerializable("OBJECT_COUNTRY");

        strName= mCountryInfo.getCountryName();
        strPosition= mCountryInfo.getCountryPosition();
    }

    private void initView() {
        //Khai bao ListView
        tvName = (TextView) findViewById(R.id.tvName);
        tvPosition = (TextView) findViewById(R.id.tvPosition);


        tvName.setText(strName);
        tvPosition.setText(strPosition);
    }

}
