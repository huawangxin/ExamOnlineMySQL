package com.tarena.elts.dao;

import java.util.List;

import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;

/**
 * ����ϵͳ��DAO���������д������ݿ��ķ���
 * */
public interface ExamServiceDao {
	abstract public User check(String name, String password);
}

