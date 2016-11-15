package com.tarena.elts.ui;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.tarena.elts.dao.ExamServiceDao;
import com.tarena.elts.dao.Impl.ExamServiceDaoImpl;
import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;

/** 客户界面控制器: 客户端上下文环境  */
public class ClientContext {

  //private LoginFrame loginFrame = new LoginFrame();
  private LoginFrame loginFrame;
  /** 依赖注入(IOC) 这里注入的是loginFrame是实例 */
  public void setLoginFrame(LoginFrame loginFrame) {
    this.loginFrame = loginFrame;
  }
  private ExamServiceDao examService;
  public void setExamService(ExamServiceDao examService) {
    this.examService = examService;
  }
  private MenuFrame menuFrame;
  public void setMenuFrame(MenuFrame menuFrame) {
    //System.out.println("setMenuFrame()" + menuFrame); 
    this.menuFrame = menuFrame;
  }
  private ExamFrame examFrame;
  public void setExamFrame(ExamFrame examFrame) {
    this.examFrame = examFrame;
  }
  
  private WelcomeWindow welcomeWindow;
  public void setWelcomeWindow(WelcomeWindow welcomeWindow){
	  this.welcomeWindow=welcomeWindow;
  }
  /**
   * 显示软件的开始界面,  先显示登录界面
   * show()方法的运行, 必须依赖于 loginFrame变量引用
   * 具体的界面对象, 这个界面对象必须依赖方法setLoginFrame()
   * 注入, 注入这个界面对象实例!
   **/
  public void show(){
	  welcomeWindow.setVisible(true);
	  final Timer timer=new Timer();
	  timer.schedule(new TimerTask(){
		  public void run(){
			  welcomeWindow.setVisible(false);
			  loginFrame.setVisible(true);
			  timer.cancel();
		  }
	  },2000);
  }
  /**
   * 此方法被 login按钮调用!
   * 登录系统, 控制逻辑
   *  1 从登录界面获得用户的ID和pwd
   *  2 调用业务模型的login方法完成登录功能
   *  3 根据登录的结果, 如果成功就 更新菜单界面,显示用户信息
   *     关闭登录界面, 打开菜单界面
   *  4 如果登录失败就在登录界面上显示失败消息
   */
  
  
  public void login(){
    //用户登录
	  String user=loginFrame.getName();
	  String password=loginFrame.getPassword();
	  welcomeWindow.setVisible(false);
	  menuFrame.setVisible(true);
	  
  }
  /**
   * 退出系统 控制逻辑
   * @param source 代表从哪一个界面退出. 是一个窗口的引用
   */
  public void exit(JFrame source){
    //退出系统
  }

  public void start(){
    //开始考试，生成考卷  
  }
  
  public void next(){
      //取得当前的题号
      //保存当前考题的用户答案到业务层
      //取得下一题目
      //更新考试界面, 显示下一题目
  }
  public void prev(){
      //取得当前的题号
      //保存当前考题的用户答案到业务层
      //取得下一题目
      //更新考试界面, 显示上一题目
  }
  public void send() {
	  //交卷
  }
  public void result() {
	  //计算考试分数，显示结果
  }
  public void gameOver(){
	 //考试结束
  }
  private void startTimer(){
	 //开始计时
  }
  public void rule() {
	JOptionPane.showMessageDialog(menuFrame, "考试时间1分钟，共20道题目，交卷后不能重新考试");
	
  }
}

















