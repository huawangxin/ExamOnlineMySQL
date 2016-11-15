package com.tarena.elts.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import util.DBUtils;

import com.tarena.elts.dao.ExamServiceDao;
import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;

/**
 * ExamServiceDao�ӿڵľ���ʵ����
 * */

public class ExamServiceDaoImpl implements ExamServiceDao{

	static Connection conn;
	public ExamServiceDaoImpl(){
		try {
			conn=DBUtils.getConnection();
			System.out.println("���ݿ�������");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static ResultSet executeQuery(String sql) {
		
		ResultSet rs = null ;
		try{
			
		if(conn == null){
			conn = DBUtils.getConnection() ;
		}
			Statement state = conn.createStatement() ;
			 rs =state.executeQuery(sql) ;
		}catch (Exception e) {
			e.printStackTrace() ;
		}
		return rs;
	}
	private static int executeUpdate(String sql) {
		int flag=-1;
		try{
			
			if(conn == null){
				conn = DBUtils.getConnection() ;
			
			}
				Statement state = conn.createStatement() ;
				
				 flag =state.executeUpdate(sql) ;
				//executeUpdate���µ�����
				return flag ;
			
			}catch (Exception e) {
				e.printStackTrace() ;
				return -1;
			}
	}
	public static void close() {
		DBUtils.closeConnection() ;
		conn = null ;
	}
	public User check(String name, String password) {
		try{
			User op = new User() ;
		String sql = "SELECT * FROM exam_user_wangxin " +
				"WHERE name ='"+name+"'" +
				" AND password ='"+password+"'";
		
		int i = ExamServiceDaoImpl.executeUpdate(sql) ;
		if(i>0){
			System.out.println("��ȷ");
			op.setName(name) ;
			op.setPassword(password) ;
			return op ;
		}else {
			System.out.println(i);
			System.out.println("����");
			
			return op ;
		}
		}finally{
			ExamServiceDaoImpl.close() ;
		}
	}
	
	
}
