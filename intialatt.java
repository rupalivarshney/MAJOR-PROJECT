package code1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import code1.attendance;
import code1.curses;

public class intialatt {

	private JFrame frame;
	public  JLabel teacher;
	public  JLabel student;
	public JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					intialatt window = new intialatt();
					//attendance a=new attendance();
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
	public intialatt() {
		initialize();
	}

	public void  run()
	{
				try {
				intialatt window = new intialatt();
				//attendance a=new attendance();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (comboBox.getSelectedItem().equals("TEACHER"))
				{
					
					curses c=new curses();
					c.run();
										
					
				}
				else if(comboBox.getSelectedItem().equals("STUDENT"))
				{
				
				}
			}});
		btnLogin.setBounds(335, 262, 97, 25);
		frame.getContentPane().add(btnLogin);
		
		 teacher = new JLabel("TEACHER");
		teacher.setBounds(151, 232, 120, 53);
		frame.getContentPane().add(teacher);
		
		student = new JLabel("STUDENT");
		student.setBounds(151, 298, 144, 60);
		frame.getContentPane().add(student);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"TEACHER", "STUDENT"}));
		comboBox.setMaximumRowCount(2);
		comboBox.setBounds(243, 263, 80, 22);
		frame.getContentPane().add(comboBox);
	}
}
