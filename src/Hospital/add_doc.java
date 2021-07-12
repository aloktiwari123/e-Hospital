package Hospital;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class add_doc implements ActionListener {

	JFrame frame;
	JLabel l1, l2,l3,l4,l5,l6;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,home;
	
	add_doc()
	{
		frame = new JFrame("Add Doctor");
		frame.setBackground(Color.WHITE);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(380,230);
		frame.setBackground(Color.lightGray);
		
		
		l1 = new JLabel("Doctor ID");
		l1.setBounds(100,190,150,30);
		l1.setFont(new Font("serif",Font.BOLD,20));
		frame.add(l1);
		
		
		l2 = new JLabel("Name");
		l2.setBounds(100,240,150,30);
		l2.setFont(new Font("serif",Font.BOLD,20));
		frame.add(l2);
		
		l3 = new JLabel("Qualification");
		l3.setBounds(100,290,150,30);
		l3.setFont(new Font("serif",Font.BOLD,20));
		frame.add(l3);
		
		l4 = new JLabel("Specialization");
		l4.setBounds(100,340,150,30);
		l4.setFont(new Font("serif",Font.BOLD,20));
		frame.add(l4);
		
		l5 = new JLabel("Wards Assigned");
		l5.setBounds(100,390,150,30);
		l5.setFont(new Font("serif",Font.BOLD,20));
		frame.add(l5);
		
		t1 = new JTextField();
		t1.setBounds(300,190,200,30);
		frame.add(t1);
		
		t2 = new JTextField();
		t2.setBounds(300,240,200,30);
		frame.add(t2);
		
		t3 = new JTextField();
		t3.setBounds(300,290,200,30);
		frame.add(t3);
		
		t4 = new JTextField();
		t4.setBounds(300,340,200,30);
		frame.add(t4);
		
		t5 = new JTextField();
		t5.setBounds(300,390,200,30);
		frame.add(t5);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/log.png"));
		Image i2 = i1.getImage().getScaledInstance(150,150, Image.SCALE_DEFAULT); // resize our image size.
		ImageIcon i3 = new ImageIcon(i2);  // convert image into imageicon
		l6 =  new JLabel(i3); // set imageicon on label
		l6.setBounds(220,20,150,150);
		frame.add(l6); // finally, add label on welcome frame.
		
		
		
		b1 = new JButton("Save");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(100,460,120,30);
		b1.setFont(new Font("serif",Font.BOLD,15));
		b1.addActionListener(this);  // perform action on button click.
		frame.add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(250,460,120,30);
		b2.setFont(new Font("serif",Font.BOLD,15));
		b2.addActionListener(this);  // perform action on button click.
		frame.add(b1);
		frame.add(b2);
		home= new JButton("Home");
		home.setBackground(Color.BLACK);
		home.setForeground(Color.WHITE);
		home.setBounds(400,460,100,30);
		home.setFont(new Font("serif",Font.BOLD,15));
		home.addActionListener(this);  // perform action on button click.
		frame.add(home);
		
		
		frame.getContentPane().setBackground(Color.WHITE);
		
		frame.setVisible(true);
		
		
		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
	      int width = 600;
	      int height = 600;
	      frame.setBounds(center.x - width / 2, center.y - height / 2, width, height);
	      
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==home)
		{
			new doctors();
			frame.setVisible(false);
		}
		String s1=t1.getText();
		String s2=t2.getText();
		String s3=t3.getText();
		String s4=t4.getText();
		String s5=t5.getText();
		if(e.getSource()==b1)
		{
			try{
                conn cc = new conn();
                String q = "insert into doctor values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')";
                cc.st.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                frame.setVisible(false); // close current frame.
                new add_doc(); // open details page
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
		}
		
	}

	public static void main(String args[]) {
		new add_doc();
	}
}
