package code1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import code1.attendance;
import code1.Capabilities;
import code1.Capture;
import code1.CaptureThread;
import code1.Enrollment; 
import code1.Identification;
import code1.ImagePanel;
import code1.First;
import code1.Selection;
import code1.UareUSampleJava;
import code1.MessageBox;
import code1.Verification;
//import code1.curses;
public class curses {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					curses window = new curses();
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
	public void run()
	{
		try {
			curses window = new curses();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public curses() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		attendance a=new attendance();
	//	Verification v=new Verification();
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(32, 78, 340, -2);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(57, 157, 820, 10);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(57, 118, 820, 10);
		frame.getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(57, 211, 820, 10);
		frame.getContentPane().add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(57, 252, 820, 10);
		frame.getContentPane().add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLACK);
		panel_5.setBounds(57, 306, 820, 10);
		frame.getContentPane().add(panel_5);
		
		JLabel lblNewLabel = new JLabel("CO 405");
		lblNewLabel.setBounds(345, 129, 151, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCo = new JLabel("CO 401");
		lblCo.setBounds(345, 176, 151, 22);
		frame.getContentPane().add(lblCo);
		
		JLabel lblCo_1 = new JLabel("CO 402");
		lblCo_1.setBounds(345, 221, 151, 22);
		frame.getContentPane().add(lblCo_1);
		
		JLabel lblCo_2 = new JLabel("CO 403");
		lblCo_2.setBounds(345, 271, 151, 22);
		frame.getContentPane().add(lblCo_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.BLACK);
		panel_6.setBounds(57, 118, 10, 198);
		frame.getContentPane().add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.BLACK);
		panel_7.setBounds(867, 118, 10, 198);
		frame.getContentPane().add(panel_7);
		
		JButton btnNewButton = new JButton("MANUAL_ATTENDANCE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				a.count2(1);
				a.run();
				
				
			}
		});
		btnNewButton.setBounds(493, 128, 165, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("MANUAL_ATTENDANCE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				a.count2(2);
				a.run();
			}
		});
		btnNewButton_1.setBounds(493, 180, 165, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("MANUAL_ATTENDANCE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				a.count2(3);
				//a.count2(3);
				//a.
				a.run();
			}
		});
		btnNewButton_2.setBounds(493, 220, 165, 25);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("MANUAL_ATTENDANCE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				a.count2(4);
				a.run();
			}
		});
		btnNewButton_3.setBounds(493, 275, 165, 25);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblCourses = new JLabel("COURSES");
		lblCourses.setBounds(351, 49, 261, 56);
		frame.getContentPane().add(lblCourses);
		
		JButton btnNewButton_5 = new JButton("DATABASE_ATTENDANCE");
		btnNewButton_5.setBounds(115, 424, 202, 25);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_7 = new JButton("FINGERPRINT_ATTENDANCE");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Verification v=new Verification(1);
				First.createAndShowGUI();
				
			}
		});
		btnNewButton_7.setBounds(681, 128, 174, 25);
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnFingerprintattendance = new JButton("FINGERPRINT_ATTENDANCE");
		btnFingerprintattendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Verification v=new Verification(2);
			
				
				
				First.createAndShowGUI();
			}
		});
		btnFingerprintattendance.setBounds(681, 173, 174, 25);
		frame.getContentPane().add(btnFingerprintattendance);
		
		JButton btnFingerprintattendance_1 = new JButton("FINGERPRINT_ATTENDANCE");
		btnFingerprintattendance_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Verification v=new Verification(3);
				//Verification.count1(3);
				First.createAndShowGUI();
			}
		});
		btnFingerprintattendance_1.setBounds(681, 220, 174, 25);
		frame.getContentPane().add(btnFingerprintattendance_1);
		
		JButton btnFingerprintattendance_2 = new JButton("FINGERPRINT_ATTENDANCE");
		btnFingerprintattendance_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Verification v=new Verification(4);
				//Verification.count1(4);
				First.createAndShowGUI();
			}
		});
		btnFingerprintattendance_2.setBounds(681, 275, 174, 25);
		frame.getContentPane().add(btnFingerprintattendance_2);
	}
}
