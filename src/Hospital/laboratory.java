package Hospital;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
public class laboratory implements ActionListener {
	
	JFrame frame;
	JLabel l1,l2,l3;
	JButton b1,b2,home;
	
	laboratory(){
		frame = new JFrame("LABORATORY");
		frame.setBackground(Color.WHITE);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(380,230);
		String months[] = {

	            "Jan",
	            "Feb",
	            "Mar",
	            "Apr",

	            "May",
	            "Jun",
	            "Jul",
	            "Aug",

	            "Sep",
	            "Oct",
	            "Nov",
	            "Dec"
	        };
		Calendar calendar = Calendar.getInstance();
		String date="Date: " + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR);
		String time="Time: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
		
		JLabel lid = new JLabel("LABORATORY SECTION"); // blinking label
		lid.setBounds(60,40,1140,100);
		lid.setFont(new Font("Serif",Font.PLAIN,40));
		frame.add(lid);
		
		
		l1 = new JLabel(date);
		l1.setBounds(40,20,200,30);
		l1.setFont(new Font("serif",Font.PLAIN,20));
		frame.add(l1);
		
		
		l2 = new JLabel(time);
		l2.setBounds(400,20,200,30);
		l2.setFont(new Font("serif",Font.PLAIN,20));
		frame.add(l2);
		
		b1 = new JButton("Add New Entry");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(40,140,200,50);
		b1.setFont(new Font("serif",Font.BOLD,15));
		b1.addActionListener(this);  // perform action on button click.
		frame.add(b1);
		
		b2 = new JButton("Existing Laboratory List");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(300,140,200,50);
		b2.setFont(new Font("serif",Font.BOLD,15));
		b2.addActionListener(this);  // perform action on button click.
		frame.add(b2);
		
		home= new JButton("Home");
		home.setBackground(Color.BLACK);
		home.setForeground(Color.WHITE);
		home.setBounds(220,500,100,30);
		home.setFont(new Font("serif",Font.BOLD,15));
		home.addActionListener(this);  // perform action on button click.
		frame.add(home);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/welcome.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600,250, Image.SCALE_DEFAULT); // resize our image size.
		ImageIcon i3 = new ImageIcon(i2);  // convert image into imageicon
		JLabel l3 =  new JLabel(i3); // set imageicon on label
		l3.setBounds(20,200,600,250);
		frame.add(l3); // finally, add label on welcome frame.
		
		
		
		frame.setLayout(null);  
	    frame.setVisible(true);
	    
	    Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
	      int width = 600;
	      int height = 600;
	      frame.setBounds(center.x - width / 2, center.y - height / 2, width, height);
	    //frame.getContentPane().setBackground(Color.lightGray);
	    frame.getContentPane().setBackground(Color.WHITE);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
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
			new add_laboratory();
			frame.setVisible(false);
		}
		if(e.getSource()==b2)
		{
			new show_laboratory().setVisible(true);
			frame.setVisible(false);
		}
		
	}
	
	public static void main(String args[])
	{
		new laboratory();
	}

}
