package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**��¼������һ�����崰�ڿ�*/

public class LoginFrame extends JFrame {
	private static final long serialVersionUID=46347673438L;
	public LoginFrame(){
		init();
	}
	/**��ʼ����������Ͳ���*/
	private void init(){
		this.setTitle("��¼ϵͳ");
		JPanel contentPane=createContentPane();
		this.setContentPane(contentPane);
		setLocationRelativeTo(null);
		setSize(270,188);
	}
	private JPanel createContentPane(){
		JPanel p=new JPanel(new  BorderLayout());
		p.setBorder(new EmptyBorder(8,8,8,8));//�հױ߿�
		p.add(BorderLayout.NORTH,new JLabel("��¼����ϵͳ",JLabel.CENTER));
		p.add(BorderLayout.CENTER,createCenterPane());
		p.add(BorderLayout.SOUTH,createBtnPane());
		return p;
	}
	
	private JPanel createCenterPane(){
		JPanel p=new JPanel(new BorderLayout());
		p.add(BorderLayout.NORTH,createIdPwdPane());
		p.setBorder(new EmptyBorder(8,0,8,0));
		message=new JLabel("",JLabel.CENTER);
		p.add(BorderLayout.CENTER,message);
		return p;
	}
	private JPanel createBtnPane(){
		JPanel p=new JPanel(new FlowLayout());
		JButton login=new JButton("Login");
		JButton cancel=new JButton("cancel");
		
		getRootPane().setDefaultButton(login);
		
		p.add(login);
		p.add(cancel);
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.login();
			}
		});
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.exit(LoginFrame.this);
				//LoginFrame.this�ǵ�ǰLoginFrame �����ʵ��
				//���ǵ�¼���ڶ��������
			}
		});
		
		return p;
	}
	/**�򵥹�����������װ�ĸ��Ӷ���Ĵ������̣�����һ������ʵ��*/
	private JPanel createIdPwdPane(){
		JPanel p=new JPanel(new GridLayout(2,1,0,6));
		p.add(createIdPane());
		p.add(createPwdPane());
		return p;
	}
	private JPanel createIdPane(){
		JPanel p=new JPanel(new BorderLayout());
		p.add(BorderLayout.WEST,new JLabel("���"));
		p.setBorder(new EmptyBorder(0,3,0,3));
		JTextField idField=new JTextField();
		p.add(BorderLayout.CENTER,idField);
		//��ʵ������idField���õ�����ؼ���
		this.idField=idField;
		return p;
	}
	private JPanel createPwdPane(){
		JPanel p=new JPanel(new BorderLayout());
		p.add(BorderLayout.WEST,new JLabel("����"));
		p.setBorder(new EmptyBorder(0,3,0,3));
		JPasswordField pwdField=new JPasswordField();
		pwdField.enableInputMethods(true);
		p.add(BorderLayout.CENTER,pwdField);
		this.pwdField=pwdField;
		return p;
	}
	
	private ClientContext clientContext;
	public void setClientContext(ClientContext clientContext){
		this.clientContext=clientContext;
	}
	private JTextField idField;
	private JPasswordField pwdField;
	private JLabel message;
	
	
	
	public int getUserId(){
		return Integer.parseInt(idField.getText());
	}
	public String getPassword(){
		char[]pwd=pwdField.getPassword();
		return new String(pwd);
	}
	public void showMessage(String message){
		this.message.setText(message);
	}
}
