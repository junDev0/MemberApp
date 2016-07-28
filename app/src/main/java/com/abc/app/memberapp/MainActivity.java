package com.abc.app.memberapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText et_id,et_pw;
    Button bt_login,bt_join,bt_img;
    MemberService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        service = new MemberServiceImpl(this.getApplication());
        init();
    }

    public void init(){
        et_id = (EditText)findViewById(R.id.et_id);
        et_pw= (EditText)findViewById(R.id.et_pw);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_join = (Button)findViewById(R.id.bt_join);
        bt_img = (Button)findViewById(R.id.bt_img);

        bt_login.setOnClickListener(this);
        bt_join.setOnClickListener(this);
        bt_img.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:
                String id = et_id.getText().toString();
                String pw = et_pw.getText().toString();
                if(id.equals("")||pw.equals("")){
                    Toast.makeText(MainActivity.this, "아이디와 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "아이디:" + id + "\n비밀번호:" + pw, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this,HomeActivity.class));
                }
                break;
            case R.id.bt_join:
                startActivity(new Intent(MainActivity.this,JoinActivity.class));
                break;
            case R.id.bt_img:
                startActivity(new Intent(MainActivity.this,ImageActivity.class));
                break;

        }

    }
}
