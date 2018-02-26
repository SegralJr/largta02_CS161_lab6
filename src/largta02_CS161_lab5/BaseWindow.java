package largta02_CS161_lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BaseWindow extends JFrame {
	
	/*
	 * Taylor Large
	 * CS161
	 * Spring 2018
	 * Lab 5
	 */
	
	private JPanel west, east, center, middle;
	private JButton button;
	private JTextField text;
	private JLabel label;
	
	public BaseWindow(int length) {
		super(">>>>> BASE WINDOW with COLORED COMPONENTS <<<<<");
		text = new JTextField(length);
		setSize(800,450);
		setLocation(25, 15);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		openWindow();
		setVisible(true);
	}
	
	public void openWindow() {
		
		Font font = new Font("Dialog", Font.BOLD, 98);

		JPanel west = new JPanel();
		west.setBackground(Color.GREEN);
		
		JPanel east = new JPanel();
		east.setBackground(Color.YELLOW);
		
		JPanel center = new JPanel();
		center.setBackground(Color.LIGHT_GRAY);
		
		JPanel middle = new JPanel();
		middle.setBackground(Color.DARK_GRAY);
		
		JButton button = new JButton("button!");
		button.setBackground(Color.RED);
		
		text.setBackground(Color.PINK);
		
		JLabel label = new JLabel("Middle panel!");
		label.setForeground(Color.CYAN);
		
		add(west, BorderLayout.WEST);
		add(east, BorderLayout.EAST);
		
		center.setLayout(new GridLayout(5,1));
		center.add(new JLabel());
		center.add(new JLabel());
		center.add(middle);
		
		west.add(button);
		middle.add(label);
		east.add(text);
		
		add(center, BorderLayout.CENTER);
	}
	
}
