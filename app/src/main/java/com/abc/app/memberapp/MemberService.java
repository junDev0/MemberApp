package com.abc.app.memberapp;

import java.util.List;

/**
 * Created by hb2020 on 2016-07-27.
 */
public interface MemberService {
    public String regist(MemberBean bean);
    public MemberBean findBy();
    public List<MemberBean> list();
    public String update(MemberBean bean); //pw만 수정가능
    public String delete(MemberBean bean);
    public int count();
    public MemberBean findById(String id);
    public List<MemberBean> findByName(String name);
    public int findByGen(String gender);
    public MemberBean login(MemberBean bean);
    public String logout();
}
