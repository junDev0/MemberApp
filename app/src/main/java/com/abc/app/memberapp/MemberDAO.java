package com.abc.app.memberapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hb2020 on 2016-07-27.
 */
public class MemberDAO extends SQLiteOpenHelper{


    public MemberDAO(Context context) {
        super(context,"",null,1);
    }


    public boolean insert(MemberBean bean){
        String sql = "insert into member_bean(id,pw,name,regDate,gender,ssn,age,email,phone,profile_img) values(?,?,?,?,?,?,?,?,?,?)";
        boolean result = false;
        return result;
    }
    public int infoUpdate(MemberBean bean){
        String sql = "update member_bean set pw = '"+bean.getPw()+"', email = '"+bean.getEmail()
                + "' where id ='"+bean.getId()+"'";
        return 0;

    }
    public int infoDelete(MemberBean bean){
        String sql = "delete from member_bean where id = '"+bean.getId()+"' and pw='"+bean.getPw()+"'";
        return 0;

    }



    //list
    public List<MemberBean> list(){
        String sql = "select * from member_bean";
        List <MemberBean> list = new ArrayList<MemberBean>();

        return list;
    }
    // findByPK
    public MemberBean findById(String id){
        String sql = "select * from member_bean where id ='"+id+"'";
        MemberBean bean = null;
        return bean;
    }
    public void addMajorAndSubjects(){
        String sql = "insert into grade()";
    }
    //findByNotPK
    public List<MemberBean> findByName(String name){
        String sql = "select * from member_bean where name ='"+name+"'";
        List <MemberBean> list = new ArrayList<MemberBean>();
        return list;
    }
    //count
    public int count(){
        String sql = "select count(*) as count from member_bean";
        int count = 0;
        return count;
    }
    public int genCount(String gender){
        String sql = "select count(*) as count from member_bean where gender = ?";
        int count = 0;
        return count;
    }
    public boolean login(MemberBean param) {
        boolean loginOk= false;
        if(param.getId()!=null&& param.getPw()!=null&&this.existId(param.getId())==true){
            MemberBean member = this.findById(param.getId());
            if(member.getPw().equals(param.getPw())){
                loginOk = true;
            }
        }

        return loginOk;
    }
    public boolean existId(String id){
        boolean existOK = false;
        int result=0;
        String sql = "select count(*) as count from member_bean where id = ?";
        return existOK;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
