package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;

public class ExamFrame extends JFrame{
	private static final long serialVersionUID=3493439476749687L;
	private Option[]options=new Option[4];
	public ExamFrame(){
		init();
	}
	
	private void init(){
		setTitle("在线测评");
		setContentPane(createContentPane());
		setSize(600,380);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				//clientContext.send();
			}
		});
	}
	private JPanel createContentPane(){
		JPanel pane=new JPanel(new BorderLayout());
		pane.add(BorderLayout.NORTH,new JLabel(new ImageIcon(ExamFrame.class.getResource("exam_title.png"))));
		pane.add(BorderLayout.CENTER,createCenterPane());
		pane.add(BorderLayout.SOUTH,createToolsPane());
		return pane;
	}
	private JPanel createCenterPane(){
		JPanel pane=new JPanel(new BorderLayout());
		pane.setBorder(new EmptyBorder(6,6,6,6));
		
		JLabel examInfo=new JLabel("````` ",JLabel.CENTER);
		this.info=examInfo;
		pane.add(BorderLayout.NORTH,info);
		pane.add(BorderLayout.CENTER,createQuestionPane());
		pane.add(BorderLayout.SOUTH,createOptionsPane());
		return pane;
	}
	private JScrollPane createQuestionPane(){
		JScrollPane pane=new JScrollPane();
		pane.setBorder(new TitledBorder("题目"));
	   
		questionArea=new JTextArea();
		//this.questionArea=questionArea;
		questionArea.setText("问题\nA\nB.");
		questionArea.setLineWrap(true);
		questionArea.setEditable(false);
		pane.getViewport().add(questionArea);
		return pane;
	}
	private JPanel createOptionsPane(){
		JPanel pane=new JPanel();
		Option a=new Option(0,"A");
		Option b=new Option(1,"B");
		Option c=new Option(2,"C");
		Option d=new Option(3,"D");
		options[0]=a;
		options[1]=b;
		options[2]=c;
		options[3]=d;
		pane.add(a);
		pane.add(b);
		pane.add(c);
		pane.add(d);
		return pane;
	}
	
	private JPanel createToolsPane(){
		JPanel pane=new JPanel(new BorderLayout());
		pane.setBorder(new EmptyBorder(0,10,0,10));
	    questionCount=new JLabel("题目：20题的1题");
	    timer=new JLabel("剩余时间222秒");
		
		
		pane.add(BorderLayout.WEST,questionCount);
		pane.add(BorderLayout.EAST,timer);
		pane.add(BorderLayout.CENTER,createBtnPane());
		return pane;
	}
	private JPanel createBtnPane(){
		JPanel pane=new JPanel(new FlowLayout());
		 prev=new JButton("上一题");
		 next=new JButton("下一题");
		 send=new JButton("交卷");
		pane.add(prev);
		pane.add(next);
		pane.add(send);
		
		prev.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.prev();
			}
		});
		next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
//				System.out.println(" examFrame currentQuestion index:"+clientContext.getCurrentQuestion().getQuestionIndex());
				clientContext.next();
				
			}
		});
		
		send.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.send();
			}
		});
		return pane;
	}
	class Option extends JCheckBox{
		//序列化版本号
		private static final long serialVersionUID=5569918347028393191L;
		int value;
		public Option(int val,String txt){
			super(txt);
			this.value=val;
		}
	}
	
	private JButton prev;
	private JButton next;
	private JButton send;
	private JLabel info;
	private JLabel questionCount;
	private JTextArea questionArea;
	public void updateView(ExamInfo examInfo,QuestionInfo questionInfo){
		info.setText(examInfo.toString());
		questionCount.setText("题目"+examInfo.getQuestionCount()+"的"+(questionInfo.getQuestionIndex()+1)+"题");
		updateOptions(questionInfo.getUserAnswers());
		
		questionArea.setText(questionInfo.toString());
		
		updateQuestionCount(examInfo.getQuestionCount(), questionInfo.getQuestionIndex());
		
		updateButtons(examInfo.getQuestionCount(),questionInfo.getQuestionIndex());
		
	}
	
	
	private void updateButtons(String questionCount2, int questionIndex) {
		// TODO Auto-generated method stub
		
	}

	private void updateQuestionCount(String questionCount2, int questionIndex) {
		// TODO Auto-generated method stub
		
	}

	private void updateButtons(int questionCount, int questionIndex) {
		prev.setEnabled(questionIndex!=0);
		next.setEnabled((questionCount-1)!=questionIndex);
		
	}

	private void updateQuestionCount(int questionCount, int questionIndex) {
		String str="题目:"+questionCount+" 的"+(questionIndex+1)+"题";
		this.questionCount.setText(str);
	}

	private void updateOptions(List<Integer>userAnswers){
		for(Option o:options){
			o.setSelected(false);
			if(userAnswers.contains(o.value)){
				o.setSelected(true);
			}
		}
	}
	public List<Integer>getUserAnswers(){
		List<Integer>ans=new ArrayList<Integer>();
		for(Option o:options){
			if(o.isSelected()){
				ans.add(o.value);
			}
		}
		return ans;
	}
	private ClientContext clientContext;
	public void setClientContext(ClientContext clientContext){
		this.clientContext=clientContext;
	}
	JLabel timer;
	public void showTime(long h,long m,long s){
		String t=h+":"+m+":"+s;
		if(h==0 && m<5){
			timer.setForeground(Color.red);
		}
		timer.setText(t);
	}
}
