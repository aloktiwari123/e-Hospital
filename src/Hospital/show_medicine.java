/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

/**
 *
 * @author alokt
 */
public class show_medicine extends javax.swing.JFrame {

    /**
     * Creates new form show
     */
    public show_medicine() {
        initComponents();
        upDateDB();
        this.setLocationRelativeTo(null);
    }
    
    int q,i,deleteItem;
	String id;
    
    public void upDateDB()
    {
    	try {
    		conn cc=new conn();
    		String query1="SELECT * FROM medicine";
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
    				columnData.add(rs.getString("medicine_name"));
    				columnData.add(rs.getString("brand"));
    				columnData.add(rs.getString("mfd_date"));
    				columnData.add(rs.getString("expiry_date"));
    				columnData.add(rs.getString("price"));
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
    	jtxt_medname.setText("");
		jtxt_brand.setText("");
		jtxt_mfd.setText("");
		jtxt_exp.setText("");
		jtxt_price.setText("");
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
        jtxt_medname = new javax.swing.JTextField();
        jtxt_brand = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxt_mfd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxt_exp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtxt_price = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jbtn_update = new javax.swing.JButton();
        jbtn_reset = new javax.swing.JButton();
        jbtn_add = new javax.swing.JButton();
        jbtn_exit = new javax.swing.JButton();
        jbtn_delete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTable1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		DefaultTableModel RecordTable=(DefaultTableModel)jTable1.getModel();
        		int Selectedrow=jTable1.getSelectedRow();
        		
        		jtxt_medname.setText(RecordTable.getValueAt(Selectedrow,0).toString());
        		jtxt_brand.setText(RecordTable.getValueAt(Selectedrow,1).toString());
        		jtxt_mfd.setText(RecordTable.getValueAt(Selectedrow,2).toString());
        		jtxt_exp.setText(RecordTable.getValueAt(Selectedrow,3).toString());
        		jtxt_price.setText(RecordTable.getValueAt(Selectedrow,4).toString());
        	}
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 143, 203), 8));
        jPanel1.setPreferredSize(new java.awt.Dimension(1430, 800));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 143, 203), 8));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Medicine Name");

        jtxt_medname.setFont(new java.awt.Font("Tahoma", 1, 24));
        

        jtxt_brand.setFont(new java.awt.Font("Tahoma", 1, 24));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Brand");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Mfd Date");

        jtxt_mfd.setFont(new java.awt.Font("Tahoma", 1, 24));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Expiry Date");

        jtxt_exp.setFont(new java.awt.Font("Tahoma", 1, 24));
       

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Price");

        jtxt_price.setFont(new java.awt.Font("Tahoma", 1, 24));

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

			private void jbtn_resetActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				txtblank();
				
			}
        });
        PreparedStatement pst;
        jbtn_add.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbtn_add.setText("Add");
        jbtn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_addActionPerformed(evt);
            }

			
        });

        jbtn_exit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbtn_exit.setText("Exit");
        jbtn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_exitActionPerformed(evt);
            }

			private void jbtn_exitActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				JFrame frame = new JFrame("Exit");
		    	if(JOptionPane.showConfirmDialog(frame,"Confirm you want to exit","Medicine Info",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
		    	{
		    		
		    		new medicine();
		    		show_medicine.this.setVisible(false);
		    		
		    	}
				
			}
        });

        jbtn_delete.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbtn_delete.setText("Delete");
        jbtn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_deleteActionPerformed(evt);
            }

			
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbtn_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtn_add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtn_update)
                .addGap(18, 18, 18)
                .addComponent(jbtn_reset)
                .addGap(18, 18, 18)
                .addComponent(jbtn_delete)
                .addGap(18, 18, 18)
                .addComponent(jbtn_exit)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxt_brand, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxt_mfd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxt_exp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxt_price, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxt_medname, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(123, 123, 123)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxt_medname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxt_brand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxt_mfd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxt_exp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxt_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        jLabel1.setText("Medicine Info");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(482, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(448, 448, 448))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable1.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        	},
        	new String[] {
        		"Medicine Name", "Brand", "Mfd Date", "Expiry Date", "Price"
        	}
        ));
        jTable1.setRowHeight(20);
        jTable1.setSelectionBackground(new java.awt.Color(20, 159, 91));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5Layout.setHorizontalGroup(
        	jPanel5Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel5Layout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 1173, GroupLayout.PREFERRED_SIZE)
        			.addGap(128))
        );
        jPanel5Layout.setVerticalGroup(
        	jPanel5Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel5Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanel5.setLayout(jPanel5Layout);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(30)
        					.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(76)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(jPanel5, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
        						.addComponent(jPanel2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        			.addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
        			.addGap(30))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    PreparedStatement pst;
    private void jbtn_addActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		try {
			conn cc=new conn();
    		//String query1="SELECT * FROM doctor";
    		//ResultSet rs=cc.st.executeQuery(query1);
    		pst=cc.c.prepareStatement("insert into medicine(medicine_name,brand,mfd_date,expiry_date,price)value(?,?,?,?,?)");
    		
    		pst.setString(1,jtxt_medname.getText());
    		pst.setString(2,jtxt_brand.getText());
    		pst.setString(3,jtxt_mfd.getText());
    		pst.setString(4,jtxt_exp.getText());
    		pst.setString(5,jtxt_price.getText());
    		
    		pst.executeUpdate();
    		JOptionPane.showMessageDialog(this,"Record Added");
    		upDateDB();
    		txtblank();
    		
		}
		 
		
		catch (SQLException ex)
		{
			java.util.logging.Logger.getLogger(show_doc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		
	}
    
    private void jbtn_deleteActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		DefaultTableModel RecordTable=(DefaultTableModel)jTable1.getModel();
		int Selectedrow=jTable1.getSelectedRow();
		
		try
		{
			id=RecordTable.getValueAt(Selectedrow,0).toString();
			deleteItem=JOptionPane.showConfirmDialog(this,"Confirm if you want to delete the record","Warning",JOptionPane.YES_NO_OPTION);
			
			if(deleteItem==JOptionPane.YES_OPTION)
			{
				conn cc=new conn();
				pst=cc.c.prepareStatement("delete from medicine where medicine_name=?");
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
    
    private void jbtn_updateActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		try {
    		conn cc=new conn();
    		pst=cc.c.prepareStatement("update medicine set medicine_name=?,brand=?,mfd_date=?,expiry_date=?,price=? where medicine_name=?");
    		DefaultTableModel RecordTable=(DefaultTableModel)jTable1.getModel();
    		int Selectedrow=jTable1.getSelectedRow();
    		id=RecordTable.getValueAt(Selectedrow,0).toString();
    		
    		pst.setString(1,jtxt_medname.getText());
    		pst.setString(2,jtxt_brand.getText());
    		pst.setString(3,jtxt_mfd.getText());
    		pst.setString(4,jtxt_exp.getText());
    		pst.setString(5,jtxt_price.getText());
    		pst.setString(6,id);
    		
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
            java.util.logging.Logger.getLogger(show_medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(show_medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(show_medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(show_medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new show_medicine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jbtn_update;
    private javax.swing.JButton jbtn_reset;
    private javax.swing.JButton jbtn_add;
    private javax.swing.JButton jbtn_exit;
    private javax.swing.JButton jbtn_delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jtxt_medname;
    private javax.swing.JTextField jtxt_brand;
    private javax.swing.JTextField jtxt_mfd;
    private javax.swing.JTextField jtxt_exp;
    private javax.swing.JTextField jtxt_price;
    // End of variables declaration                   
}
