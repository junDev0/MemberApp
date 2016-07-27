package com.abc.app.memberapp;

import java.util.List;

/**
 * Created by hb2020 on 2016-07-27.
 */
public class MemberServiceImpl implements MemberService{
    private MemberBean st = new MemberBean();
    private MemberDAO dao = MemberDAO.getInstance(); //싱글톤 패턴
    private MemberBean session;
    private static MemberServiceImpl instance = new MemberServiceImpl();

    public static MemberServiceImpl getInstance() {
        return instance;
    }

    private MemberServiceImpl() {
        session = new MemberBean();
    }

    @Override
    public String regist(MemberBean bean) {
        String msg = "fail";
        MemberBean temp = this.findById(bean.getId());
        if(temp == null){
            boolean result = dao.insert(bean);
            if(result == true){
                msg = "succ";
            }else{
                msg = "fail";
            }
        }else{
            msg = "fail";
        }
        return msg;
    }

    @Override
    public List<MemberBean> list() {

        return dao.list();
    }

    @Override
    public String update(MemberBean bean) {
        String result = "";
        if(dao.infoUpdate(bean) == 1){
            session = this.findById(bean.getId());
            result = "내정보 수정이 완료되었습니다.";
        }
        System.out.println(result);
        return result;
    }

    @Override
    public String delete(MemberBean bean) {
        String result = "";
        if(dao.infoDelete(bean) == 1){
            result = "계정 삭제가 완료되었습니다.";
        }
        return result;
    }
	/*		String sql = "create table member_bean("
	+ "id varchar(20),"
	+ "pw varchar(20),"
	+ "name varchar(20),"
	+ "regDate varchar(20),"
	+ "gender varchar(20),"
	+ "ssn varchar(20),"
	+ "age int"
	+ ")";
	String dropSql = "drop table member_bean";
	String sqlSelect = "select * from member_bean";
	 */

    @Override
    public int count() {
        // TODO Auto-generated method stub
        return dao.count();
    }

    @Override
    public MemberBean findById(String id) {
        MemberBean result = new MemberBean();
        if(dao.findById(id)!=null){
            result = dao.findById(id);
        }
        return result;
    }

    @Override
    public List<MemberBean> findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public MemberBean login(MemberBean bean) {
        MemberBean mb = new MemberBean();
        if (dao.login(bean)) {
            session = dao.findById(bean.getId());
            mb = dao.findById(bean.getId());
        }else{
            mb.setId("fail");
        }
        return mb;

    }
    @Override
    public MemberBean findBy() {
        if(session != null){
            System.out.println(this.findById(session.getId()).toString());
            return this.findById(session.getId());
        }
        return null;
    }

    @Override
    public int findByGen(String gender) {
        return dao.genCount(gender);
    }

    @Override
    public String logout() {
        String result = "";
        if(session!=null){
            session = null;
            result = "로그아웃 완료";
        }
        return result;
    }

}
