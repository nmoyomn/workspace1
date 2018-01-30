package view;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class firstFrame {

	Frame frame;
	Panel panel;
	Button button, b1;
	Label label;
	TextField tf1;

	public firstFrame() {
		frame = new Frame();
		panel = new Panel();
		button = new Button("로그인");
		label = new Label("ID : ");
		tf1 = new TextField();
	}

	public void makeUi() {
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose(); // Frame 닫기 이벤트
			}
		});
		
		
		frame.setSize(600, 400);
		frame.setBackground(Color.PINK);
		frame.setTitle("New Window");
		frame.setVisible(true);
	}
	
	

}
