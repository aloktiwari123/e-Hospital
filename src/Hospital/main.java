package Hospital;
import javax.swing.*;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.*;
public class main implements ActionListener {
	JButton b1,b2,b3,b4,b5,b6,b7;
	JFrame frame;
	main()
	{
		frame=new JFrame("Welcome to e-Hospital");
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/welcome.jpg"));
		 Image i2 = i1.getImage().getScaledInstance(600, 280, Image.SCALE_DEFAULT); // resize our image size.
		 ImageIcon i3 = new ImageIcon(i2);  // convert image into imageicon
		 JLabel l =  new JLabel(i3); // set imageicon on label
			l.setBounds(80,30,600,250);
			frame.add(l); // finally, add label on welcome frame.
		 JLabel l1=new JLabel("Hospital Management System");  
		    l1.setBounds(140,00, 500,200);
		    l1.setForeground(Color.BLUE);
		    l1.setFont (l1.getFont ().deriveFont (32.0f));
		 JLabel l2=new JLabel("Welcome !!");  
		    l2.setBounds(300,100, 300,200);
		    l2.setFont (l1.getFont ().deriveFont (20.0f));
		   final JTextField tf=new JTextField();  
	       tf.setBounds(200,300, 150,20);  
		    b1=new JButton("Doctor");  
		    b1.setBackground(Color.DARK_GRAY);
			b1.setForeground(Color.WHITE);
		    b1.setBounds(100,300,110,60);  
		  
		    b2=new JButton("Patient");  
		    b2.setBackground(Color.DARK_GRAY);
			b2.setForeground(Color.WHITE);
		    b2.setBounds(300,300,110,60);  
		   
		    b3=new JButton("Medicines");  
		    b3.setBackground(Color.DARK_GRAY);
			b3.setForeground(Color.WHITE);
		    b3.setBounds(500,300,110,60);  
		   
		    b4=new JButton("Laboratories");  
		    b4.setBackground(Color.DARK_GRAY);
			b4.setForeground(Color.WHITE);
		    b4.setBounds(100,400,110,60);  
		   
		    b5=new JButton("Facilities");  
		    b5.setBackground(Color.DARK_GRAY);
			b5.setForeground(Color.WHITE);
		    b5.setBounds(300,400,110,60);  
		 
		    b6=new JButton("Staff");  
		    b6.setBackground(Color.DARK_GRAY);
			b6.setForeground(Color.WHITE);
		    b6.setBounds(500,400,110,60);
		    
		    b7=new JButton("Get your Health Insurance");  
		    b7.setBackground(Color.DARK_GRAY);
			b7.setForeground(Color.WHITE);
		    b7.setBounds(260,500,200,30);
		    
		    b1.addActionListener(this);
		    b2.addActionListener(this);
		    b3.addActionListener(this);
		    b4.addActionListener(this);
		    b5.addActionListener(this);
		    b6.addActionListener(this);
		    b7.addActionListener(this);
		   
		 
		    frame.add(b1);frame.add(b2);frame.add(b3);frame.add(b4);frame.add(b5);frame.add(b6);frame.add(b7);
		    frame.add(l2);
		    frame.setSize(800,600);
		    frame.add(l1);
		    frame.setLayout(null);  
		    frame.setVisible(true);
		    //frame.setLocation(380,230);
		    Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		      int width = 740;
		      int height = 600;
		      frame.setBounds(center.x - width / 2, center.y - height / 2, width, height);
		    //frame.getContentPane().setBackground(Color.lightGray);
		    frame.getContentPane().setBackground(Color.WHITE);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()== b1)
		{
			//System.out.println(" Button b1 Clicked");
			new doctors(); 
			frame.setVisible(false);
		}
		else if(e.getSource()==b2)
		{
			//System.out.println(" Button b2 Clicked");
			new patient();
			frame.setVisible(false);
		}
		else if(e.getSource()==b3)
		{
			//System.out.println(" Button b3  Clicked");
			new medicine();
			frame.setVisible(false);
		}
		else if(e.getSource()==b4)
		{
			//System.out.println(" Button b4 Clicked");
			new laboratory();
			frame.setVisible(false);
		}
		else if(e.getSource()==b5)
		{
			//System.out.println(" Button b5 Clicked");
			new facilites();
			frame.setVisible(false);
		}
		else if(e.getSource()==b6)
		{
			//System.out.println(" Button b6 Clicked");
			new staff();
			frame.setVisible(false);
		}
		else
		{
			new add_insurance();
			frame.setVisible(false);
		}
	}
	public static void main(String args[])
	{
		new main();
	}

}
