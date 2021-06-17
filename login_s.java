package code1;
//import package login_system;
import java.awt.EventQueue;
import code1.intialatt;
//import package mysql;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class login_s {

	private JFrame frame;
	private JTextField username;
	private JTextField password;
	private JButton btnNewButton;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_s window = new login_s();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login_s() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel loginform = new JLabel("LOGIN ");
		loginform.setBounds(286, 99, 171, 16);
		frame.getContentPane().add(loginform);
		
		JLabel lblusername = new JLabel("USERNAME");
		lblusername.setBounds(132, 181, 79, 16);
		frame.getContentPane().add(lblusername);
		
		JLabel lblpassword = new JLabel("PASSWORD");
		lblpassword.setBounds(132, 250, 109, 19);
		frame.getContentPane().add(lblpassword);
		
		username = new JTextField();
		username.setBounds(314, 178, 116, 22);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(314, 248, 116, 22);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		separator = new JSeparator();
		separator.setBounds(12, 195, 1, 2);
		frame.getContentPane().add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(12, 195, 1, 2);
		frame.getContentPane().add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(104, 140, 486, 2);
		frame.getContentPane().add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(104, 294, 486, 9);
		frame.getContentPane().add(separator_3);
		
		JLabel usertype = new JLabel("USERTYPE");
		usertype.setBounds(185, 371, 126, 16);
		frame.getContentPane().add(usertype);
		
		JComboBox combo = new JComboBox();
		combo.setToolTipText("");
		combo.setModel(new DefaultComboBoxModel(new String[] {"teacher", "student", "user", "admin"}));
		combo.setMaximumRowCount(4);
		combo.setBounds(358, 368, 148, 22);
		frame.getContentPane().add(combo);
		
		btnNewButton = new JButton("login");
		btnNewButton.setBounds(259, 421, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("ATTENDANCE APPLICATION");
		lblNewLabel.setBounds(173, 32, 345, 16);
		frame.getContentPane().add(lblNewLabel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con=null;
				PreparedStatement pst=null;
				ResultSet rs=null;
				
				try {
					String query="SELECT * FROM `multiuser` WHERE username=? and password=? and usertype=?";
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/multiuser","root","");
					
					//System.out.println("ASDSA");
					//pst.setString(1, username.getText());
					//pst.setString(2, password.getText());
					//JComboBox combo;
					String type = String.valueOf(combo.getSelectedItem());
					//pst.setString(3, type);
					
					String u1 = username.getText();
					String p = password.getText();
					String q = "SELECT * from multiuser where username='".concat(u1).concat("' and password='").concat(p).concat("' and usertype='").concat(type).concat("'");
					pst=con.prepareStatement(q);
					
					rs=pst.executeQuery();
					int size = 0;
					if(rs != null) {
						rs.last();
						size = rs.getRow();
					}
					System.out.println(size);
					if(size > 0)
					{
						JOptionPane.showMessageDialog(combo, this,"USER AND PASSWORD MATCHED AND YOU ARE  LOGGED IN"+type, 0);
						intialatt i=new intialatt();
						i.run();
						
					}
					else {
						JOptionPane.showMessageDialog(combo, this,"NOPE", 0);
					}
					if(combo.getSelectedIndex()==0)
					{
					admin a=new admin();
					//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					//a.frame.setVisible(true);
					a.setVisible(true);
					this.setVisible(false);
			        }
					
				else if(combo.getSelectedIndex()==1)
				{
				user u=new user();
				//a.setVisible(true)
				u.setVisible(true);
				this.setVisible(false);
				}
				}
				catch(Exception ex)
				{
					System.out.println("OOPS");	
					JOptionPane.showMessageDialog(lblpassword, this,ex.getMessage(), 0);
				}
				
				
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
	
	}
}
