package Hospital;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class add_insurance implements ActionListener {
	JFrame frame;
	JLabel l1, l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5,t6;
	JButton b1,b2,home,b3;
	JRadioButton r1,r2,r3;
	int plan1=10000;
	int plan2=20000;
	int plan3=30000;
	
	public add_insurance()
	{
		frame = new JFrame("Add Insurance");
		frame.setBackground(Color.WHITE);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(380,230);
		frame.setBackground(Color.lightGray);
		
		
		l1 = new JLabel("Patient ID");
		l1.setBounds(100,290,150,30);
		l1.setFont(new Font("serif",Font.BOLD,20));
		frame.add(l1);
		
		l2 = new JLabel("Patient Name");
		l2.setBounds(100,340,150,30);
		l2.setFont(new Font("serif",Font.BOLD,20));
		frame.add(l2);
		
		
		
		l3 = new JLabel("Insurance Plans");
		l3.setBounds(100,390,150,30);
		l3.setFont(new Font("serif",Font.BOLD,20));
		frame.add(l3);
		
		
		l4 = new JLabel("Cost");
		l4.setBounds(100,490,150,30);
		l4.setFont(new Font("serif",Font.BOLD,20));
		frame.add(l4);
		
		l5 = new JLabel("Payment");
		l5.setBounds(230,520,150,40);
		l5.setFont(new Font("serif",Font.BOLD,30));
		frame.add(l5);
		
		l6 = new JLabel("Amount Paid");
		l6.setBounds(100,570,150,40);
		l6.setFont(new Font("serif",Font.BOLD,20));
		frame.add(l6);
		
		t6 = new JTextField();
		t6.setBounds(300,570,200,30);
		frame.add(t6);
		
		t1 = new JTextField();
		t1.setBounds(300,290,200,30);
		frame.add(t1);
		
		t2 = new JTextField();
		t2.setBounds(300,340,200,30);
		frame.add(t2);
		
		r1=new JRadioButton("1 Year Plan");
		r1.setBounds(300,390,200,30);
		r1.setFont(new Font("serif",Font.BOLD,18));
		frame.add(r1);
		r1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	t4.setText(Integer.toString(plan1));
	            t4.setEditable(false);

	        }
	    });

		
		r2=new JRadioButton("2 Year Plan");
		r2.setBounds(300,420,200,30);
		r2.setFont(new Font("serif",Font.BOLD,18));
		frame.add(r2);
		r2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	t4.setText(Integer.toString(plan2));
	            t4.setEditable(false);
	        }
	    });

		
		r3=new JRadioButton("3 Year Plan");
		r3.setBounds(300,450,200,30);
		r3.setFont(new Font("serif",Font.BOLD,18));
		frame.add(r3);
		r3.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	t4.setText(Integer.toString(plan3));
	            t4.setEditable(false);
	        }
	    });

		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(r1);
		buttonGroup.add(r2);
		buttonGroup.add(r3);
		
		
		
		t4 = new JTextField();
		t4.setBounds(300,490,200,30);
		frame.add(t4);
		
		
		
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/insurance.jpeg"));
		Image i2 = i1.getImage().getScaledInstance(540,250, Image.SCALE_DEFAULT); // resize our image size.
		ImageIcon i3 = new ImageIcon(i2);  // convert image into imageicon
		l6 =  new JLabel(i3); // set imageicon on label
		l6.setBounds(20,20,540,250);
		frame.add(l6); // finally, add label on welcome frame.
		
		
		
		b1 = new JButton("Pay");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(230,610,120,30);
		b1.setFont(new Font("serif",Font.BOLD,15));
		b1.addActionListener(this);  // perform action on button click.
		frame.add(b1);
		
		b2 = new JButton("Print");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(80,660,120,30);
		b2.setFont(new Font("serif",Font.BOLD,15));
		b2.addActionListener(this);  // perform action on button click.
		frame.add(b1);
		frame.add(b2);
		home= new JButton("Home");
		home.setBackground(Color.BLACK);
		home.setForeground(Color.WHITE);
		home.setBounds(230,660,100,30);
		home.setFont(new Font("serif",Font.BOLD,15));
		home.addActionListener(this);  // perform action on button click.
		frame.add(home);
		b3 = new JButton("Insurance List");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(380,660,150,30);
		b3.setFont(new Font("serif",Font.BOLD,15));
		b3.addActionListener(this);  // perform action on button click.
		frame.add(b3);
		
		frame.getContentPane().setBackground(Color.WHITE);
		
		frame.setVisible(true);
		
		
		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
	      int width = 600;
	      int height = 750;
	      frame.setBounds(center.x - width / 2, center.y - height / 2, width, height);
	   
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==home)
		{
			new main();
			frame.setVisible(false);
		}
		
		if(e.getSource()==b1)
		{
			String s1=t1.getText();
			String s2=t2.getText();
			
			
			if(r1.isSelected())
			{
				if(Integer.parseInt(t6.getText().toString())==plan1)
				{
				try{
	                conn cc = new conn();
	                String q = "insert into insurance values('"+s1+"','"+s2+"','1 Year Plan','"+plan1+"')";
	                cc.st.executeUpdate(q);
	                JOptionPane.showMessageDialog(null,"Insurance Plan successfully added");
	                //frame.setVisible(false); // close current frame.
	                 // open details page
	            }catch(Exception ee){
	                System.out.println("The error is:"+ee);
	                new add_insurance();
	            }
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Payment Failed");
				}
			}
			else if(r2.isSelected())
			{
				if(Integer.parseInt(t6.getText().toString())==plan2)
				{
				try{
	                conn cc = new conn();
	                String q = "insert into insurance values('"+s1+"','"+s2+"','2 Year Plan','"+plan2+"')";
	                cc.st.executeUpdate(q);
	                JOptionPane.showMessageDialog(null,"Insurance Plan successfully added");
	                //frame.setVisible(false); // close current frame.
	                 // open details page
	            }catch(Exception ee){
	                System.out.println("The error is:"+ee);
	                
	            }
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Payment Failed");
				}
				
			}
			else if(r3.isSelected())
			{
				if(Integer.parseInt(t6.getText().toString())==plan3)
				{
				try{
	                conn cc = new conn();
	                String q = "insert into insurance values('"+s1+"','"+s2+"','3 Year Plan','"+plan3+"')";
	                cc.st.executeUpdate(q);
	                JOptionPane.showMessageDialog(null,"Insurance Plan successfully added");
	                //frame.setVisible(false); // close current frame.
	                 // open details page
	            }catch(Exception ee){
	                System.out.println("The error is:"+ee);
	                
	            }
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Payment Failed");
				}
			}
			else {
				JOptionPane.showMessageDialog(null,"Select one of the Plans");
				new add_insurance();
			}
			
		}
		
		if(e.getSource()==b2)
		{
			try
			{
				PrinterJob pjob = PrinterJob.getPrinterJob();
				PageFormat preformat = pjob.defaultPage();
				preformat.setOrientation(PageFormat.LANDSCAPE);
				PageFormat postformat = pjob.pageDialog(preformat);
				if (preformat != postformat) {
				  pjob.setPrintable(new Printer(frame), postformat);
				  if (pjob.printDialog()) {
				    pjob.print();
				  }
				}
			}
			catch(Exception ex)
			{
				
			}
		}
		
		if(e.getSource()==b3)
		{
			new show_insurance().setVisible(true);
			frame.setVisible(false);
		}
	
	}

	public static void main(String args[]) {
		new add_insurance();
	}

}
