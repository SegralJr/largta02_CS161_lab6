package largta02_CS161_lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ColorExchange extends JFrame implements ActionListener {
	
	/*
	 * Taylor Large
	 * CS161
	 * Spring 2018
	 * Lab 5
	 */
	
	JPanel west, east, center, middle;
	JButton button;
	JTextField text;
	JLabel label;
	JPanel south;
	JPanel randoPane;
	JPanel coordPane;
	JButton randoButton;
	JLabel coordLabel;
	Font font = new Font("Dialog", Font.BOLD, 24);
	int count = 0;
	
	public ColorExchange(int length) {
		super(">>>>> WINDOW of COLOR EXCHANGE <<<<<");
		text = new JTextField(length);
		setSize(800,450);
		setLocation(25, 15);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		openWindow();
		setVisible(true);
	}
	
	public void openWindow() {

		west = new JPanel();
		west.setBackground(Color.GREEN);
		
		east = new JPanel();
		east.setBackground(Color.YELLOW);
		
		center = new JPanel();
		center.setBackground(Color.LIGHT_GRAY);
		
		middle = new JPanel();
		middle.setBackground(Color.DARK_GRAY);
		
		button = new JButton("Swap colors!");
		button.setBackground(Color.RED);
		
		text.setBackground(Color.PINK);
		
		label = new JLabel("Middle panel!");
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
		
		//Lab 6 Stuffs
		
		south = new JPanel();
		randoPane = new JPanel();
		coordPane = new JPanel();
		
		add(south, BorderLayout.SOUTH);
		
		south.setLayout(new GridLayout(1,2));
		
		coordPane.setBackground(Color.MAGENTA);
		
		randoButton = new JButton("Random color");
		randoButton.setBackground(Color.CYAN);
		randoPane.add(randoButton);
		
		String coordText = "RGB coordinates: ";
		coordLabel = new JLabel(coordText);
		coordLabel.setBackground(Color.WHITE);
		coordLabel.setOpaque(true);
		coordPane.add(coordLabel);
		
		south.add(randoPane);
		south.add(coordPane);

		button.addActionListener(this);
		randoButton.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent event) {
		if("Swap colors!".equals(event.getActionCommand())) {
			Color westColor = west.getBackground();
			Color eastColor = east.getBackground();
			west.setBackground(eastColor);
			east.setBackground(westColor);
			
			count++;
			text.setText(Integer.toString(count));
		}
		else if ("Random color".equals(event.getActionCommand())){
			int R = randomInt(0, 255), G = randomInt(0, 255), B = randomInt(0, 255);
			Color randomColor = new Color(R,G,B);
			coordPane.setBackground(randomColor);
			coordLabel.setText("RGB coordinates: R: " + R + " G: " + G + " B: " + B);\
			//coordLabel.setFont(font);
		}
		else {
			JOptionPane.showMessageDialog(null, "How did you even do this");
		}
			
	}
	
	public static int randomInt(int min, int max) {
		Random random = new Random();
		int randomReturn = random.nextInt((max - min) + 1) + min;
		return randomReturn;
	}
	
}
