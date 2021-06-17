package code1;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
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
public class attendance_application {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel jStdNo1;
	private JLabel jStdNo2;
	private JLabel jStdNo3;
	private JLabel jStdNo4;
	private JLabel jStdNo5;
	private JLabel jStdNo6;
	private JLabel jStdNo7;
	private JLabel jStdNo8;
	private JLabel jStdNo9;
	private JLabel jStdNo10;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox comboBox_4;
	private JComboBox comboBox_5; 
	private JComboBox comboBox_6;
	private JComboBox comboBox_7;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					attendance_application window = new attendance_application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public attendance_application() {
		initialize();
	}

		private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(0, 0, 1970, 1020);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 10, 1, 963);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setForeground(Color.BLACK);
		panel_2.setBounds(150, 40, 10, 697);
		frame.getContentPane().add(panel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setForeground(Color.BLACK);
		panel.setBounds(445, 40, 10, 697);
		frame.getContentPane().add(panel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(709, 41, 10, 696);
		frame.getContentPane().add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(942, 41, 10, 697);
		frame.getContentPane().add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLACK);
		panel_5.setBounds(1195, 40, 10, 697);
		frame.getContentPane().add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.BLACK);
		panel_6.setBounds(13, 112, 1899, 10);
		frame.getContentPane().add(panel_6);
		
		JLabel lblNewLabel_1 = new JLabel("Student No.");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(198, 83, 178, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Student name");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(495, 83, 143, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Course code");
		lblNewLabel_3.setBounds(765, 83, 119, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNo = new JLabel("No.");
		lblNo.setBackground(Color.BLACK);
		lblNo.setBounds(48, 83, 56, 16);
		frame.getContentPane().add(lblNo);
		
		JLabel lblNewLabel = new JLabel("ALIGARH MUSLIM UNIVERSITY");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(1360, 40, 350, 59);
		frame.getContentPane().add(lblNewLabel);
		
	    comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1"}));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(965, 80, 90, 22);
		frame.getContentPane().add(comboBox);
				
		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(comboBox.getSelectedItem().equals("0"))
				{		
				
					comboBox_1.setSelectedItem("ABSENT");
					comboBox_2.setSelectedItem("ABSENT");
					comboBox_3.setSelectedItem("ABSENT");
					comboBox_4.setSelectedItem("ABSENT");
					comboBox_5.setSelectedItem("ABSENT");
					comboBox_6.setSelectedItem("ABSENT");
					comboBox_7.setSelectedItem("ABSENT");
				}
				
				else if(comboBox.getSelectedItem().equals("1"))
				{
				
					comboBox_1.setSelectedItem("PRESENT");
					comboBox_2.setSelectedItem("PRESENT");
					comboBox_3.setSelectedItem("PRESENT");
					comboBox_4.setSelectedItem("PRESENT");
					comboBox_5.setSelectedItem("PRESENT");
					comboBox_6.setSelectedItem("PRESENT");
					comboBox_7.setSelectedItem("PRESENT");
					
				}
				
			
			}
		});
		button.setBounds(1109, 79, 75, 25);
		frame.getContentPane().add(button);

		JLabel label = new JLabel("");
		label.setBounds(1258, 168, 56, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(attendance_application.class.getResource("/Project/download.jpg")));
		label_1.setBackground(Color.BLACK);
		label_1.setBounds(1258, 131, 641, 340);
		frame.getContentPane().add(label_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.BLACK);
		panel_7.setBounds(13, 204, 1192, 10);
		frame.getContentPane().add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.BLACK);
		panel_8.setBounds(13, 291, 1192, 10);
		frame.getContentPane().add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.BLACK);
		panel_9.setBounds(12, 364, 1193, 10);
		frame.getContentPane().add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.BLACK);
		panel_10.setBounds(13, 456, 1192, 10);
		frame.getContentPane().add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.BLACK);
		panel_11.setBounds(13, 536, 1192, 10);
		frame.getContentPane().add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.BLACK);
		panel_12.setBounds(13, 619, 1192, 10);
		frame.getContentPane().add(panel_12);
		
		JLabel lblNewLabel_4 = new JLabel("1.");
		lblNewLabel_4.setBounds(48, 150, 56, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("2.");
		lblNewLabel_5.setBounds(48, 244, 56, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("3.");
		lblNewLabel_6.setBounds(48, 327, 56, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("4.");
		lblNewLabel_7.setBounds(48, 416, 56, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("5.");
		lblNewLabel_8.setBounds(48, 490, 56, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("6.");
		lblNewLabel_9.setBounds(48, 575, 56, 16);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("7.");
		lblNewLabel_10.setBounds(48, 679, 56, 16);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("A");
		lblNewLabel_11.setBounds(495, 150, 148, 16);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("B");
		lblNewLabel_12.setBounds(495, 244, 190, 16);
		frame.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("C");
		lblNewLabel_13.setBounds(495, 327, 202, 16);
		frame.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("D");
		lblNewLabel_14.setBounds(495, 416, 196, 16);
		frame.getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("E");
		lblNewLabel_15.setBounds(495, 490, 187, 16);
		frame.getContentPane().add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("F");
		lblNewLabel_16.setBounds(495, 575, 178, 16);
		frame.getContentPane().add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("G");
		lblNewLabel_17.setBounds(495, 658, 190, 16);
		frame.getContentPane().add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("PRESENT");
		lblNewLabel_18.setBounds(202, 150, 56, 16);
		frame.getContentPane().add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("New label");
		lblNewLabel_19.setBounds(202, 244, 56, 16);
		frame.getContentPane().add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("New label");
		lblNewLabel_20.setBounds(198, 327, 56, 16);
		frame.getContentPane().add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("CO 431");
		lblNewLabel_21.setBounds(758, 168, 56, 16);
		frame.getContentPane().add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("CO 521");
		lblNewLabel_22.setBounds(758, 262, 56, 16);
		frame.getContentPane().add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("CO 431");
		lblNewLabel_23.setBounds(758, 335, 56, 16);
		frame.getContentPane().add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("CO 123");
		lblNewLabel_24.setBounds(758, 416, 56, 16);
		frame.getContentPane().add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("CO 145");
		lblNewLabel_25.setBounds(758, 503, 56, 16);
		frame.getContentPane().add(lblNewLabel_25);
		
		JLabel lblNewLabel_26 = new JLabel("CO 761");
		lblNewLabel_26.setBounds(758, 575, 56, 16);
		frame.getContentPane().add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("CO 561");
		lblNewLabel_27.setBounds(758, 679, 56, 16);
		frame.getContentPane().add(lblNewLabel_27);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBounds(12, 761, 1182, -6);
		frame.getContentPane().add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.BLACK);
		panel_14.setBounds(13, 727, 1192, 10);
		frame.getContentPane().add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.BLACK);
		panel_15.setBounds(12, 40, 1193, 16);
		frame.getContentPane().add(panel_15);
		
		JLabel lblNewLabel_28 = new JLabel("New label");
		lblNewLabel_28.setBounds(198, 405, 56, 16);
		frame.getContentPane().add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel("New label");
		lblNewLabel_29.setBounds(202, 490, 56, 16);
		frame.getContentPane().add(lblNewLabel_29);
		
		JLabel lblNewLabel_30 = new JLabel("New label");
		lblNewLabel_30.setBounds(198, 575, 56, 16);
		frame.getContentPane().add(lblNewLabel_30);
		
		JLabel lblNewLabel_31 = new JLabel("New label");
		lblNewLabel_31.setBounds(198, 679, 56, 16);
		frame.getContentPane().add(lblNewLabel_31);
		
		JLabel lblNewLabel_32 = new JLabel("REGISTER_NO");
		lblNewLabel_32.setBounds(1273, 490, 160, 16);
		frame.getContentPane().add(lblNewLabel_32);
		
		JLabel lblNewLabel_33 = new JLabel("OVERALL ATTENDANCE %");
		lblNewLabel_33.setBounds(1273, 556, 178, 16);
		frame.getContentPane().add(lblNewLabel_33);
		
		JLabel lblNewLabel_34 = new JLabel("LECTURER'S NAME");
		lblNewLabel_34.setBounds(1273, 637, 160, 16);
		frame.getContentPane().add(lblNewLabel_34);
		
		textField = new JTextField();
		textField.setBounds(1526, 487, 90, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(1526, 553, 90, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(1526, 634, 97, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"PRESENT", "ABSENT"}));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(953, 162, 148, 22);
		frame.getContentPane().add(comboBox_1);
		
	    comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"PRESENT", "ABSENT"}));
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(953, 241, 148, 22);
		frame.getContentPane().add(comboBox_2);
		
	    comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"PRESENT", "ABSENT"}));
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(953, 324, 148, 22);
		frame.getContentPane().add(comboBox_3);
		
	    comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"PRESENT", "ABSENT"}));
		comboBox_4.setBackground(Color.WHITE);
		comboBox_4.setBounds(953, 413, 148, 22);
		frame.getContentPane().add(comboBox_4);
		
	    comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"PRESENT", "ABSENT"}));
		comboBox_5.setBackground(Color.WHITE);
		comboBox_5.setBounds(953, 487, 148, 22);
		frame.getContentPane().add(comboBox_5);
		
	    comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"PRESENT", "ABSENT"}));
		comboBox_6.setBackground(Color.WHITE);
		comboBox_6.setBounds(953, 572, 148, 22);
		frame.getContentPane().add(comboBox_6);
		
		comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"PRESENT", "ABSENT"}));
		comboBox_7.setBackground(Color.WHITE);
		comboBox_7.setBounds(953, 673, 148, 22); 
		frame.getContentPane().add(comboBox_7);
		
		JButton verification = new JButton("START_VERIFICATION");
		
		verification.setBounds(942, 857, 214, 25);
		frame.getContentPane().add(verification);
}
}
