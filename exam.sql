DROP TABLE IF EXISTS exam_user_wangxin;
CREATE TABLE exam_user_wangxin(
  id int(12) NOT NULL auto_increment,
  name varchar(50) default NULL,
  passwd varchar(50) NOT NULL,
  phone varchar(15) NOT NULL,
  email varchar(50) NOT NULL,
  score int,
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
select * from exam_user_wangxin
INSERT INTO exam_user_wangxin VALUES (1000,'宁丽娟','1234','13810381038','ninglj@tarena.com.cn',0);
INSERT INTO exam_user_wangxin VALUES (1001,'刘苍松','1234','13810381038','liucs@tarena.com.cn',0);
INSERT INTO exam_user_wangxin VALUES (1002,'张三','1234','13810381038','zhangsan@tarena.com.cn',0);
INSERT INTO exam_user_wangxin VALUES (1003,'李四','1234','13810381038','lisi@tarena.com.cn',0);
INSERT INTO exam_user_wangxin VALUES (1004,'王五','1234','13810381038','wangwu@tarena.com.cn',0);
INSERT INTO exam_user_wangxin VALUES (1005,'赵六','1234','13810381038','zhaoliu@tarena.com.cn',0);

DROP TABLE IF EXISTS exam_question_wangxin;
CREATE TABLE exam_question_wangxin(
  id int(12) NOT NULL auto_increment,
  title text NOT NULL,
  optionA varchar(50),
  optionB varchar(50),
  optionC varchar(50),
  optionD varchar(50),
  answer varchar(50),
  score int,
  level int,
  type int,
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;