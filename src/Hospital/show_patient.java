/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

/**
 *
 * @author alokt
 */
public class show_patient extends javax.swing.JFrame {

    /**
     * Creates new form show
     */
    public show_patient() {
        initComponents();
        upDateDB();
        this.setLocationRelativeTo(null);
    }
    
    int q,i,deleteItem;
	String id;
	PreparedStatement pst;
	DefaultTableModel RecordTable;
	int Selectedrow;
	JFrame frame;
	JLabel l1, l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5,t6;
	JButton b1,b2,home;
    
    public void upDateDB()
    {
    	try {
    		conn cc=new conn();
    		String query1="SELECT * FROM patient";
    		ResultSet rs=cc.st.executeQuery(query1);
    		ResultSetMetaData stData= (ResultSetMetaData) rs.getMetaData();
    		q=stData.getColumnCount();
    		
    		DefaultTableModel RecordTable=(DefaultTableModel)jTable1.getModel();
    		RecordTable.setRowCount(0);
    		
    		while(rs.next())
    		{
    			Vector columnData=new Vector();
    			
    			for (i=1;i<=q;i++)
    			{
    				columnData.add(rs.getString("patient_id"));
    				columnData.add(rs.getString("patient_name"));
    				columnData.add(rs.getString("age"));
    				columnData.add(rs.getString("doctor_assigned"));
    				columnData.add(rs.getString("ward_assigned"));
    				columnData.add(rs.getString("bill"));
    				columnData.add(rs.getString("status"));
    			}
    			RecordTable.addRow(columnData);
    		}
    	
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		JOptionPane.showMessageDialog(null,e);
		}
    		
    }
    public void txtblank()
    {
    	jtxt_pid.setText("");
		jtxt_name.setText("");
		jtxt_age.setText("");
		jtxt_doctor.setText("");
		jtxt_ward.setText("");
		jtxt_bill.setText("");
		jtxt_status.setText("");
    }
    
    public void payframe(DefaultTableModel RecordTable)
    {
    	
    	int Selectedrow=jTable1.getSelectedRow();
    	frame = new JFrame("Payment");
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
		
		
		
		l2 = new JLabel("Bill");
		l2.setBounds(100,390,150,30);
		l2.setFont(new Font("serif",Font.BOLD,20));
		frame.add(l2);
		
		l5=new JLabel("Payment");
		l5.setBounds(220,420,150,50);
		l5.setFont(new Font("serif",Font.BOLD,40));
		frame.add(l5);
		
		l3 = new JLabel("Amount Paid");
		l3.setBounds(100,480,150,30);
		l3.setFont(new Font("serif",Font.BOLD,20));
		frame.add(l3);
		
		l4 = new JLabel("Status");
		l4.setBounds(100,560,150,30);
		l4.setFont(new Font("serif",Font.BOLD,20));
		frame.add(l4);
		
		
		t1 = new JTextField();
		t1.setBounds(300,290,200,30);
		frame.add(t1);
		
		t2 = new JTextField();
		t2.setBounds(300,340,200,30);
		frame.add(t2);
		
		t3 = new JTextField();
		t3.setBounds(300,390,200,30);
		frame.add(t3);
		
		t4 = new JTextField();
		t4.setBounds(300,480,200,30);
		frame.add(t4);
		
		t5 = new JTextField();
		t5.setBounds(300,560,200,30);
		frame.add(t5);
		
		
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/pay.jpg"));
		Image i2 = i1.getImage().getScaledInstance(540,250, Image.SCALE_DEFAULT); // resize our image size.
		ImageIcon i3 = new ImageIcon(i2);  // convert image into imageicon
		l6 =  new JLabel(i3); // set imageicon on label
		l6.setBounds(20,20,540,250);
		frame.add(l6); // finally, add label on welcome frame.
		
		
		
		b1 = new JButton("Pay");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(230,520,120,30);
		b1.setFont(new Font("serif",Font.BOLD,15));
		b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payActionPerformed(evt);
            }

			

			
        });  // perform action on button click.
		frame.add(b1);
		
		b2 = new JButton("Print Bill");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(170,600,120,30);
		b2.setFont(new Font("serif",Font.BOLD,15));
		b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }

			

			
        });  // perform action on button click.
		frame.add(b1);
		frame.add(b2);
		home= new JButton("Back");
		home.setBackground(Color.BLACK);
		home.setForeground(Color.WHITE);
		home.setBounds(320,600,100,30);
		home.setFont(new Font("serif",Font.BOLD,15));
		home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }

			private void backActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				
			}

			
        }); // perform action on button click.
		frame.add(home);
		
		
		frame.getContentPane().setBackground(Color.WHITE);
		
		frame.setVisible(true);
		t1.setEditable(false);
		t2.setEditable(false);
		t3.setEditable(false);
		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
	      int width = 600;
	      int height = 700;
	      frame.setBounds(center.x - width / 2, center.y - height / 2, width, height);
	      
	      
    }

    protected void printActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
    	
			// TODO Auto-generated method stub
			
			
			try
			{
				//JFrame yourComponent = new JFrame();
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
			catch(Exception e)
			{
				
			}
			
		
		
	}
	protected void payActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
    	int bill=Integer.parseInt(t3.getText().toString());
		String amount=t4.getText().toString();
		if(t4.getText ().trim ().equals (""))
		{
			JOptionPane.showMessageDialog(frame,"Enter the amount first");
		}
		else
		{
			int am=Integer.parseInt(amount);
			if(bill==am)
			{
				t5.setText("Paid");
				JOptionPane.showMessageDialog(frame,"Amount paid Successfull");
				jtxt_status.setText("Paid");
				status_update(t1.getText());
			}
			else
			{
				t5.setText("Unpaid");
				JOptionPane.showMessageDialog(frame,"Payment failed");
			}
		}
	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtxt_pid = new javax.swing.JTextField();
        jtxt_age = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxt_doctor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxt_ward = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jbtn_update = new javax.swing.JButton();
        jbtn_reset = new javax.swing.JButton();
        jbtn_add = new javax.swing.JButton();
        jbtn_pay = new javax.swing.JButton();
        jbtn_delete = new javax.swing.JButton();
        jbtn_exit = new javax.swing.JButton();
        jtxt_name = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxt_bill = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtxt_status = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 143, 203), 8));
        jPanel1.setPreferredSize(new java.awt.Dimension(1430, 800));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 143, 203), 8));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Patient ID");

        jtxt_pid.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        

        jtxt_age.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Age");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Doctor Assigned");

        jtxt_doctor.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Ward Assigned");

        jtxt_ward.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 143, 203), 8));

        jbtn_update.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbtn_update.setText("Update");
        jbtn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_updateActionPerformed(evt);
            }
        });

        jbtn_reset.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbtn_reset.setText("Reset");
        jbtn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_resetActionPerformed(evt);
            }
        });

        jbtn_add.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbtn_add.setText("Add");
        jbtn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_addActionPerformed(evt);
            }
        });

        jbtn_pay.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbtn_pay.setText("Pay");
        jbtn_pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_payActionPerformed(evt);
            }
        });

        jbtn_delete.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbtn_delete.setText("Delete");
        jbtn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_deleteActionPerformed(evt);
            }
        });

        jbtn_exit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbtn_exit.setText("Exit");
        jbtn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbtn_pay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_exit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtn_add)
                .addGap(18, 18, 18)
                .addComponent(jbtn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jbtn_reset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtn_delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtn_pay)
                .addGap(18, 18, 18)
                .addComponent(jbtn_exit)
                .addContainerGap())
        );

        jtxt_name.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Patient Name");

        jtxt_bill.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Bill");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("Payment Status");

        jtxt_status.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxt_status, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxt_bill, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxt_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxt_age, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxt_pid, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxt_ward, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(121, 121, 121)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jtxt_pid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jtxt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jtxt_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jtxt_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jtxt_ward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jtxt_bill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jtxt_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        jLabel1.setText("Patient Info");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(510, 510, 510))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Patient ID", "Patient Name", "Age", "Doctor Assigned", "Ward Assigned", "Bill", "Payment Status"
            }
        ));
        jTable1.setRowHeight(20);
        jTable1.setSelectionBackground(new java.awt.Color(20, 159, 91));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

                                        

    private void jbtn_addActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    	try {
			conn cc=new conn();
    		//String query1="SELECT * FROM doctor";
    		//ResultSet rs=cc.st.executeQuery(query1);
    		pst=cc.c.prepareStatement("insert into patient(patient_id,patient_name,age,doctor_assigned,ward_assigned,bill,status)value(?,?,?,?,?,?,?)");
    		
    		pst.setString(1,jtxt_pid.getText());
    		pst.setString(2,jtxt_name.getText());
    		pst.setString(3,jtxt_age.getText());
    		pst.setString(4,jtxt_doctor.getText());
    		pst.setString(5,jtxt_ward.getText());
    		pst.setString(6,jtxt_bill.getText());
    		pst.setString(7,"Unpaid");
    		
    		pst.executeUpdate();
    		JOptionPane.showMessageDialog(this,"Record Added");
    		upDateDB();
    		txtblank();
    		
		}
		 
		
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this,e);
		}
    }                                        

    private void status_update(String id)
    {
    	try {
    		conn cc=new conn();
    		pst=cc.c.prepareStatement("update patient set patient_id=?,patient_name=?,age=?,doctor_assigned=?,ward_assigned=?,bill=?,status=? where patient_id=?");
    		DefaultTableModel RecordTable=(DefaultTableModel)jTable1.getModel();
    		int Selectedrow=jTable1.getSelectedRow();
    		
    		pst.setString(1,jtxt_pid.getText());
    		pst.setString(2,jtxt_name.getText());
    		pst.setString(3,jtxt_age.getText());
    		pst.setString(4,jtxt_doctor.getText());
    		pst.setString(5,jtxt_ward.getText());
    		pst.setString(6,jtxt_bill.getText());
    		pst.setString(7,jtxt_status.getText());
    		pst.setString(8,id);
    		
    		
    		pst.executeUpdate();
    		
    		//JOptionPane.showMessageDialog(this, "Record Updated");
    		upDateDB();
    		//txtblank();
    		
    	
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		JOptionPane.showMessageDialog(null,e);
		}
    }
    private void jbtn_updateActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    	try {
    		conn cc=new conn();
    		pst=cc.c.prepareStatement("update patient set patient_id=?,patient_name=?,age=?,doctor_assigned=?,ward_assigned=?,bill=? where patient_id=?");
    		DefaultTableModel RecordTable=(DefaultTableModel)jTable1.getModel();
    		int Selectedrow=jTable1.getSelectedRow();
    		id=RecordTable.getValueAt(Selectedrow,0).toString();
    		
    		pst.setString(1,jtxt_pid.getText());
    		pst.setString(2,jtxt_name.getText());
    		pst.setString(3,jtxt_age.getText());
    		pst.setString(4,jtxt_doctor.getText());
    		pst.setString(5,jtxt_ward.getText());
    		pst.setString(6,jtxt_bill.getText());
    		pst.setString(7,id);
    		
    		
    		pst.executeUpdate();
    		
    		JOptionPane.showMessageDialog(this, "Record Updated");
    		upDateDB();
    		txtblank();
    		
    	
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		JOptionPane.showMessageDialog(null,e);
		}
    }                                           

    private void jbtn_payActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    	DefaultTableModel RecordTable=(DefaultTableModel)jTable1.getModel();
		int Selectedrow=jTable1.getSelectedRow();
    	
    	if(Selectedrow==-1)
    	{
    		JOptionPane.showMessageDialog(this,"Please Select the patient first");
    	}
    	else
    	{
    		payframe(RecordTable);
    		t1.setText(RecordTable.getValueAt(Selectedrow,0).toString());
    		t2.setText(RecordTable.getValueAt(Selectedrow,1).toString());
    		t3.setText(RecordTable.getValueAt(Selectedrow,5).toString());
    	}
    }                                                                                
                                        

    private void jbtn_exitActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    	// TODO Auto-generated method stub
		JFrame frame = new JFrame("Exit");
    	if(JOptionPane.showConfirmDialog(frame,"Confirm you want to exit","Doctor Info",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
    	{
    		
    		new patient();
    		show_patient.this.setVisible(false);
    		
    	}
    }                                         
                                          

    private void jbtn_resetActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    	txtblank();
    }                                          

    private void jbtn_deleteActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    	DefaultTableModel RecordTable=(DefaultTableModel)jTable1.getModel();
		int Selectedrow=jTable1.getSelectedRow();
		
		try
		{
			id=RecordTable.getValueAt(Selectedrow,0).toString();
			deleteItem=JOptionPane.showConfirmDialog(this,"Confirm if you want to delete the record","Warning",JOptionPane.YES_NO_OPTION);
			
			if(deleteItem==JOptionPane.YES_OPTION)
			{
				conn cc=new conn();
				pst=cc.c.prepareStatement("delete from patient where patient_id=?");
			    pst.setString(1,id);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(this,"Record Updated");
				upDateDB();
				txtblank();
				
				
				
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
    }                                           

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
    	DefaultTableModel RecordTable=(DefaultTableModel)jTable1.getModel();
		int Selectedrow=jTable1.getSelectedRow();
		
		jtxt_pid.setText(RecordTable.getValueAt(Selectedrow,0).toString());
		jtxt_name.setText(RecordTable.getValueAt(Selectedrow,1).toString());
		jtxt_age.setText(RecordTable.getValueAt(Selectedrow,2).toString());
		jtxt_doctor.setText(RecordTable.getValueAt(Selectedrow,3).toString());
		jtxt_ward.setText(RecordTable.getValueAt(Selectedrow,4).toString());
		jtxt_bill.setText(RecordTable.getValueAt(Selectedrow,5).toString());
		jtxt_status.setText(RecordTable.getValueAt(Selectedrow,6).toString());
		jtxt_status.setEditable(false);
    }                                    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(show_patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(show_patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(show_patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(show_patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new show_patient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtn_add;
    private javax.swing.JButton jbtn_delete;
    private javax.swing.JButton jbtn_exit;
    private javax.swing.JButton jbtn_pay;
    private javax.swing.JButton jbtn_reset;
    private javax.swing.JButton jbtn_update;
    private javax.swing.JTextField jtxt_age;
    private javax.swing.JTextField jtxt_bill;
    private javax.swing.JTextField jtxt_doctor;
    private javax.swing.JTextField jtxt_name;
    private javax.swing.JTextField jtxt_pid;
    private javax.swing.JTextField jtxt_status;
    private javax.swing.JTextField jtxt_ward;
    // End of variables declaration                   
}
