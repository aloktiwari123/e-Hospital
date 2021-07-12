package Hospital;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Thread;

class welcome implements ActionListener {
	
	JFrame frame;
	JButton b;
	JButton b1;
	
	
	welcome(){
	
		frame = new JFrame("e-Hospital");
		frame.setBackground(Color.red);
		frame.setLayout(null); // absolute layout used
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/welcome.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1050, 650, Image.SCALE_DEFAULT); // resize our image size.
		ImageIcon i3 = new ImageIcon(i2);  // convert image into imageicon
		
		JLabel l1 =  new JLabel(i3); // set imageicon on label
		l1.setBounds(30,140,1165,430);
		frame.add(l1); // finally, add label on welcome frame.
		
		b = new JButton("Click Here To Continue");
		b.setBackground(Color.DARK_GRAY);
		b.setForeground(Color.WHITE);
		b.setBounds(550,600,180,30);
		b.addActionListener(this);  // perform action on button click.
		
		
		JLabel id = new JLabel();
		id.setBounds(0,0,1050,650); // keep length as image length.
		id.setLayout(null);
		
		
		JLabel lid = new JLabel("e HOSPITAL SERVICE"); // blinking label
		lid.setBounds(300,30,1140,100);
		lid.setFont(new Font("Serif",Font.PLAIN,63));
		id.add(lid);
		
		
		frame.add(id);
		frame.add(b);
		frame.getContentPane().setBackground(Color.WHITE); // set frame background color
		
		frame.setVisible(true);
		frame.setSize(1260,700);
		//frame.setLocation(50,50);
		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
	      int width = 1260;
	      int height = 700;
	      frame.setBounds(center.x - width / 2, center.y - height / 2, width, height);// setting on window location 
		/*
		// For blinking text on frame
		while(true) {
			lid.setVisible(false);
			try {
				Thread.sleep(500);
			}catch(Exception ex1){}
			
				lid.setVisible(true);
				try {
					Thread.sleep(500);
				}catch(Exception ex2) {}
				
		}
		*/
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
			
		
			 if(ae.getSource()==b)
			 {
				 frame.setVisible(false);
				 new login(); // open login page on button click
			 }
			 
	}
	
	public static void main(String [] args) {
		new welcome();
	}
	
}
