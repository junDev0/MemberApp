package com.abc.app.memberapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class JoinActivity extends Activity implements View.OnClickListener {

    EditText et_id,et_pw,et_name,et_ssn,et_email,et_phone;
    Button bt_reset,bt_join;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
    }

    public void init(){
        et_id = (EditText)findViewById(R.id.et_id);
        et_pw = (EditText)findViewById(R.id.et_pw);
        et_name = (EditText)findViewById(R.id.et_name);
        et_ssn = (EditText)findViewById(R.id.et_ssn);
        et_email = (EditText)findViewById(R.id.et_email);
        et_phone = (EditText)findViewById(R.id.et_phone);

        bt_join = (Button)findViewById(R.id.bt_join);
        bt_reset = (Button)findViewById(R.id.bt_reset);

        bt_join.setOnClickListener(this);
        bt_reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_join:
                break;
            case R.id.bt_reset:
                startActivity(new Intent(JoinActivity.this,MainActivity.class));
                break;
        }
    }
}
