package Hospital;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class add_staff implements ActionListener {
	JFrame frame;
	JLabel l1, l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5,t6;
	JButton b1,b2,home;
	JRadioButton r1,r2,r3;
	
	public add_staff()
	{
		frame = new JFrame("Add Staff");
		frame.setBackground(Color.WHITE);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(380,230);
		frame.setBackground(Color.lightGray);
		
		
		l1 = new JLabel("Employee ID");
		l1.setBounds(100,290,150,30);
		l1.setFont(new Font("serif",Font.BOLD,20));
		frame.add(l1);
		
		l2 = new JLabel("Employee Name");
		l2.setBounds(100,340,150,30);
		l2.setFont(new Font("serif",Font.BOLD,20));
		frame.add(l2);
		
		
		
		l3 = new JLabel("Staff Type");
		l3.setBounds(100,390,150,30);
		l3.setFont(new Font("serif",Font.BOLD,20));
		frame.add(l3);
		
		
		l4 = new JLabel("Ward Assigned");
		l4.setBounds(100,490,150,30);
		l4.setFont(new Font("serif",Font.BOLD,20));
		frame.add(l4);
		
		l5 = new JLabel("Shift");
		l5.setBounds(100,540,150,30);
		l5.setFont(new Font("serif",Font.BOLD,20));
		frame.add(l5);
		
		
		t1 = new JTextField();
		t1.setBounds(300,290,200,30);
		frame.add(t1);
		
		t2 = new JTextField();
		t2.setBounds(300,340,200,30);
		frame.add(t2);
		
		r1=new JRadioButton("Nurses");
		r1.setBounds(300,390,200,30);
		r1.setFont(new Font("serif",Font.BOLD,18));
		frame.add(r1);
		
		r2=new JRadioButton("Workers");
		r2.setBounds(300,420,200,30);
		r2.setFont(new Font("serif",Font.BOLD,18));
		frame.add(r2);
		
		r3=new JRadioButton("Security");
		r3.setBounds(300,450,200,30);
		r3.setFont(new Font("serif",Font.BOLD,18));
		frame.add(r3);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(r1);
		buttonGroup.add(r2);
		buttonGroup.add(r3);
		
		
		
		t4 = new JTextField();
		t4.setBounds(300,490,200,30);
		frame.add(t4);
		
		t5 = new JTextField();
		t5.setBounds(300,540,200,30);
		frame.add(t5);
		
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/staff.jpg"));
		Image i2 = i1.getImage().getScaledInstance(540,250, Image.SCALE_DEFAULT); // resize our image size.
		ImageIcon i3 = new ImageIcon(i2);  // convert image into imageicon
		l6 =  new JLabel(i3); // set imageicon on label
		l6.setBounds(20,20,540,250);
		frame.add(l6); // finally, add label on welcome frame.
		
		
		
		b1 = new JButton("Save");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(100,590,120,30);
		b1.setFont(new Font("serif",Font.BOLD,15));
		b1.addActionListener(this);  // perform action on button click.
		frame.add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(250,590,120,30);
		b2.setFont(new Font("serif",Font.BOLD,15));
		b2.addActionListener(this);  // perform action on button click.
		frame.add(b1);
		frame.add(b2);
		home= new JButton("Home");
		home.setBackground(Color.BLACK);
		home.setForeground(Color.WHITE);
		home.setBounds(400,590,100,30);
		home.setFont(new Font("serif",Font.BOLD,15));
		home.addActionListener(this);  // perform action on button click.
		frame.add(home);
		
		
		frame.getContentPane().setBackground(Color.WHITE);
		
		frame.setVisible(true);
		
		
		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
	      int width = 600;
	      int height = 700;
	      frame.setBounds(center.x - width / 2, center.y - height / 2, width, height);
	      
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==home)
		{
			new staff();
			frame.setVisible(false);
		}
		
		if(e.getSource()==b1)
		{
			String s1=t1.getText();
			String s2=t2.getText();
			String s3=t4.getText();
			String s4=t5.getText();
			if(r1.isSelected())
			{
				try{
	                conn cc = new conn();
	                String q = "insert into staff values('"+s1+"','"+s2+"','Nurses','"+s3+"','"+s4+"')";
	                cc.st.executeUpdate(q);
	                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
	                frame.setVisible(false); // close current frame.
	                new add_staff(); // open details page
	            }catch(Exception ee){
	                System.out.println("The error is:"+ee);
	                new add_staff();
	            }
			}
			else if(r2.isSelected())
			{
				try{
	                conn cc = new conn();
	                String q = "insert into staff values('"+s1+"','"+s2+"','Workers','"+s3+"','"+s4+"')";
	                cc.st.executeUpdate(q);
	                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
	                frame.setVisible(false); // close current frame.
	                new add_staff(); // open details page
	            }catch(Exception ee){
	                System.out.println("The error is:"+ee);
	                new add_staff();
	            }
				
			}
			else if(r3.isSelected())
			{
				try{
	                conn cc = new conn();
	                String q = "insert into staff values('"+s1+"','"+s2+"','Security','"+s3+"','"+s4+"')";
	                cc.st.executeUpdate(q);
	                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
	                frame.setVisible(false); // close current frame.
	                new add_staff(); // open details page
	            }catch(Exception ee){
	                System.out.println("The error is:"+ee);
	                new add_staff();
	            }
			}
			else {
				JOptionPane.showMessageDialog(null,"Select one of the Staff Category");
				new add_staff();
			}
			
		}
	
	}

	public static void main(String args[]) {
		new add_staff();
	}

}
