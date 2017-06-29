package com.itplus.demolistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private  List<CountryInfo> listCountry = new ArrayList<CountryInfo>();
    private ListView listView;
    public CountryAdapter apdater;

    private Button btnAddView;
    private TextView tvName;

    private final int DOI_CHAU_LUC = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createInput();
        initView();

    }

    private void createInput() {
        CountryInfo countryInfo1 = new CountryInfo("Viet Nam","1");
        CountryInfo countryInfo2 = new CountryInfo("Lao","2");
        CountryInfo countryInfo3 = new CountryInfo("Campuchia","3");
        listCountry.add(countryInfo1);
        listCountry.add(countryInfo2);
        listCountry.add(countryInfo3);

    }

    private void initView() {

        btnAddView = (Button)  findViewById(R.id.btnAddView);
        tvName = (TextView)  findViewById(R.id.tvName);

        //Khai bao ListView
        listView = (ListView) findViewById(R.id.listView);

        //Khoi tao Adapter
        apdater = new CountryAdapter(MainActivity.this,listCountry);

        // Set adapter cho listview
        listView.setAdapter(apdater);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //CountryInfo countryInfo = (CountryInfo) apdater.getItem(position); //Cach 1: Lay theo adapter
                CountryInfo countryInfo = listCountry.get(position);
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                //Cach 1: Truyen du lieu theo key - param
//                String strNameCountry = countryInfo.getCountryName();
//                String strPosition = countryInfo.getCountryPosition();
//                intent.putExtra("NAME", strNameCountry);
//                intent.putExtra("POSITION",strPosition);

                //Cach 2:
                Bundle bundle = new Bundle();
                bundle.putSerializable("OBJECT_COUNTRY",countryInfo);
                intent.putExtras(bundle);


                startActivity(intent);
            }
        });



        btnAddView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChangeActivity.class);
                startActivityForResult(intent,DOI_CHAU_LUC);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==DOI_CHAU_LUC){
            String strName = data.getStringExtra("NAME");
            tvName.setText(strName);
        }
    }
}
