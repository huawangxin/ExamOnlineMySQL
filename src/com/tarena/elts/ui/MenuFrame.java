package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tarena.elts.entity.User;

public class MenuFrame extends JFrame {
private static final long serialVersionUID=467341387434L;
	public  MenuFrame(){
		init();
	}
	private void init(){
		setTitle("在线测评");
		setSize(600,400);
		setContentPane(createContentPane());
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
			   clientContext.exit(MenuFrame.this);
			}
		});
		
	}
	private JPanel createContentPane(){
		JPanel pane=new JPanel(new BorderLayout());
		ImageIcon icon=new ImageIcon(this.getClass().getResource("title.png"));
		pane.add(BorderLayout.NORTH,new JLabel(icon));
		pane.add(BorderLayout.CENTER,createMenuePane());
		pane.add(BorderLayout.SOUTH,new JLabel("版权所有，盗版必杀！",Label.RIGHT));
		return pane;
	}
	private JPanel createMenuePane(){
		JPanel pane=new JPanel(new BorderLayout());
	     info=new JLabel("******你好",JLabel.CENTER);
		pane.add(BorderLayout.NORTH,info);
		pane.add(BorderLayout.CENTER,createBtnPane());
		return pane;
	}
	private JPanel createBtnPane(){
		JPanel pane=new JPanel(new FlowLayout());
		JButton start=createImgBtn("exam.png","开始");
		JButton result=createImgBtn("result.png","分数");
		JButton  rule=createImgBtn("message.png","考试规则");
		JButton  exit=createImgBtn("exit.png","离开");
		pane.add(start);
		pane.add(result);
		pane.add(rule);
		pane.add(exit);
		
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.start();
			}

			
		});
		result.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				clientContext.result();
			}
		});
		
		rule.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.rule();
			}
		});
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.exit(MenuFrame.this);
			}
		});
		
		getRootPane().setDefaultButton(start);
		
		return pane;
	}
	private JButton createImgBtn(String img,String txt){
		ImageIcon ico=new ImageIcon(this.getClass().getResource(img));
		JButton button=new JButton(txt,ico);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setHorizontalTextPosition(JButton.CENTER);
		return button;
	}
	private JLabel info;
	public void updateView(User user){
		info.setText(user+"同学您好!");
	}
	private ClientContext clientContext;
	public void setClientContext(ClientContext clientContext){
		this.clientContext=clientContext;
	}
//	public static void main(String[]args){
//		MenuFrame xx=new MenuFrame();
//		xx.init();
//		xx.setVisible(true);
//	}
}
