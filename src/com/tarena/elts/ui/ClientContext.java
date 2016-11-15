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

/** �ͻ����������: �ͻ��������Ļ���  */
public class ClientContext {

  //private LoginFrame loginFrame = new LoginFrame();
  private LoginFrame loginFrame;
  /** ����ע��(IOC) ����ע�����loginFrame��ʵ�� */
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
   * ��ʾ����Ŀ�ʼ����,  ����ʾ��¼����
   * show()����������, ���������� loginFrame��������
   * ����Ľ������, ���������������������setLoginFrame()
   * ע��, ע������������ʵ��!
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
   * �˷����� login��ť����!
   * ��¼ϵͳ, �����߼�
   *  1 �ӵ�¼�������û���ID��pwd
   *  2 ����ҵ��ģ�͵�login������ɵ�¼����
   *  3 ���ݵ�¼�Ľ��, ����ɹ��� ���²˵�����,��ʾ�û���Ϣ
   *     �رյ�¼����, �򿪲˵�����
   *  4 �����¼ʧ�ܾ��ڵ�¼��������ʾʧ����Ϣ
   */
  
  
  public void login(){
    //�û���¼
	  String user=loginFrame.getName();
	  String password=loginFrame.getPassword();
	  welcomeWindow.setVisible(false);
	  menuFrame.setVisible(true);
	  
  }
  /**
   * �˳�ϵͳ �����߼�
   * @param source �������һ�������˳�. ��һ�����ڵ�����
   */
  public void exit(JFrame source){
    //�˳�ϵͳ
  }

  public void start(){
    //��ʼ���ԣ����ɿ���  
  }
  
  public void next(){
      //ȡ�õ�ǰ�����
      //���浱ǰ������û��𰸵�ҵ���
      //ȡ����һ��Ŀ
      //���¿��Խ���, ��ʾ��һ��Ŀ
  }
  public void prev(){
      //ȡ�õ�ǰ�����
      //���浱ǰ������û��𰸵�ҵ���
      //ȡ����һ��Ŀ
      //���¿��Խ���, ��ʾ��һ��Ŀ
  }
  public void send() {
	  //����
  }
  public void result() {
	  //���㿼�Է�������ʾ���
  }
  public void gameOver(){
	 //���Խ���
  }
  private void startTimer(){
	 //��ʼ��ʱ
  }
  public void rule() {
	JOptionPane.showMessageDialog(menuFrame, "����ʱ��1���ӣ���20����Ŀ������������¿���");
	
  }
}

















