package code1;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import code1.attendance;
public class student1 {

	private JFrame frame;
	 public JComboBox comboBox;
	 private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student1 window = new student1();
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
	public student1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F", "G"}));
		comboBox.setBounds(151, 231, 301, 22);
		frame.getContentPane().add(comboBox);
		
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(138, 82, 375, 10);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(138, 154, 375, 10);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("STUDENT_LIST");
		lblNewLabel.setBounds(272, 116, 163, 16);
		frame.getContentPane().add(lblNewLabel);
		attendance a= new attendance();
		
		JButton btnNewButton = new JButton("CLICK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (comboBox.getSelectedItem().equals("A"))
				{
					System.out.println(a.array[1][1]);
					System.out.println(a.array[2][1]);
					System.out.println(a.array[3][1]);
					System.out.println(a.array[4][1]);
					//System.out.println(a.array[1][1]);
					//System.out.println(a.array[1][1]);
					//System.out.println(a.array[1][1]);
			    }
				if (comboBox.getSelectedItem().equals("B"))
				{
				
			    }
				if (comboBox.getSelectedItem().equals("C"))
				{
				
			    }
				if (comboBox.getSelectedItem().equals("D"))
				{
				
			    }
				
				if (comboBox.getSelectedItem().equals("E"))
				{
				
			    }
				
				if (comboBox.getSelectedItem().equals("F"))
				{
				
			    }
				if (comboBox.getSelectedItem().equals("G"))
				{
				
			    }
				
				
				
			}});
		btnNewButton.setBounds(473, 230, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(302, 386, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ATTENDANCE_STATUS");
		lblNewLabel_1.setBounds(51, 386, 225, 21);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
