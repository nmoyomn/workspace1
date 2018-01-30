package view;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import com.product.ProductBiz;
import com.user.UserBiz;

public class View implements ActionListener{
	Frame frame;
	Panel p1, p2, p3, p4;
	Button b1, b2, b3, b4;
	CheckboxGroup radiobt;
	Checkbox ck1, ck2;
	TextField tf1;
	Label label;
	List alist;
	ArrayList<com.vo.UserVO> list;
	ArrayList<com.vo.ProductVO> prolist;

	public View() {
		frame = new Frame();
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();
		b1 = new Button("조회");
		b2 = new Button("삭제");
		b3 = new Button("입력");
		b4 = new Button("수정");
		radiobt = new CheckboxGroup();
		ck1 = new Checkbox("User", true, radiobt);
		ck2 = new Checkbox("Product", false, radiobt);
		tf1 = new TextField(10);
		label = new Label("Result : ");
		alist = new List();
		list = new ArrayList<>();

	}

	public void makeUi() {
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose(); // Frame 닫기 이벤트
			}
		});
		
		b1.addActionListener(this);
		
		frame.setSize(600, 400);
		frame.setBackground(Color.PINK);
		frame.setTitle("New Window");

		p1.setBackground(new Color(70, 150, 20));
		p1.setLayout(new GridLayout(1, 5));
		
		p1.add(ck1);
		p1.add(ck2);
		
		tf1.setPreferredSize(new Dimension(10, 3));
		p1.add(tf1);
		p1.add(p3);
		p1.add(p4);
		p3.setBackground(new Color(200, 10, 30));
		p4.setBackground(new Color(150, 250, 70));
		p3.add(b1);
		p3.add(b2);
		// p1.setLayout(new BorderLayout());

		p2.setBackground(Color.gray);
		p2.add(label);
		// ---------------------------

		
		// ---------------------------
		frame.add(p1, "North");
		frame.add(p2, "South");
		frame.add(alist, "Center");
		frame.setLocation(500, 400);
		frame.setVisible(true);
		
	}
	//userAll
	private void getdata() {
		list.clear();
		alist.removeAll();
		UserBiz biz = new UserBiz();
		try {
			list = biz.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(com.vo.UserVO u:list) {
			//alist.add(u.getId()+" "+u.getPwd()+" "+u.getName());
			alist.add(u.getId()+" "+u.getName());
		}
	}
	//productAll
	private void pgetdata() {
		list.clear();
		alist.removeAll();
		ProductBiz biz = new ProductBiz();
		try {
			prolist = biz.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(com.vo.ProductVO u:prolist) {
			//alist.add(u.getId()+" "+u.getPwd()+" "+u.getName());
			alist.add(u.getId()+" "+u.getName());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			if(radiobt.getSelectedCheckbox().getLabel().equals("User")) {
				getdata();
			}else {
				pgetdata();
			}
		}else if(e.getSource() == b2) {
			
		}
		
	}

}
