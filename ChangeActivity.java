package com.itplus.demolistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChangeActivity extends AppCompatActivity {

    private EditText edName;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_activity);

        edName =(EditText) findViewById(R.id.edName);
        btnSave =(Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = edName.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("NAME",strName);
                setResult(20, intent);
                finish();
            }
        });

    }
}
