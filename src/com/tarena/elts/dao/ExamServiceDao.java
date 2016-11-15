package com.tarena.elts.dao;

import java.util.List;

import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;

/**
 * 考试系统的DAO，包含所有处理数据库表的方法
 * */
public interface ExamServiceDao {
	abstract public User check(String name, String password);
}

