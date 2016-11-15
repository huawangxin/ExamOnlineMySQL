
package com.tarena.elts.ui;

import com.tarena.elts.dao.Impl.ExamServiceDaoImpl;



public class Main {
	public static void main(String[] args) {
		LoginFrame loginFrame=new LoginFrame();
		MenuFrame menuFrame=new MenuFrame();
		ExamFrame examFrame=new ExamFrame();
		WelcomeWindow welcomeWindow=new WelcomeWindow();
		ClientContext clientContext=new  ClientContext();
//		ExamService examService=new ExamService(){
//			public User login(int id,String pwd)throws IdOrPwdException{
//				if(id==1&&pwd.equals("1234")){
//					return new User("Robin",1,"1234");
//				}
//				throw new IdOrPwdException("登录错误");
//			}
//		};
		ExamServiceDaoImpl examService=new ExamServiceDaoImpl();
//		Config config=new Config("client.properties");
//		EntityContext entityContext=new EntityContext(config);
//		
		//examService.setEntityContext(entityContext);
		
		clientContext.setExamService(examService);
		clientContext.setLoginFrame(loginFrame);
		clientContext.setMenuFrame(menuFrame);
		clientContext.setExamFrame(examFrame);
		clientContext.setWelcomeWindow(welcomeWindow);
		
		loginFrame.setClientContext(clientContext);
		menuFrame.setClientContext(clientContext);
		examFrame.setClientContext(clientContext);
		clientContext.show();
	}

}
