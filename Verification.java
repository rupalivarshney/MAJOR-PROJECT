package code1;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import com.digitalpersona.uareu.*;
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
//import code1.Verification;
import code1.curses;
public class Verification 
	extends JPanel
	implements ActionListener
{
	private static final long serialVersionUID = 6;
	private static final String ACT_BACK = "back";

	private CaptureThread m_capture;
	private Reader  m_reader;
	private Fmd[]   m_fmds;
	private JDialog m_dlgParent;
	private JTextArea m_text;
	public 	int count=0;
	public int count1;
	int [] b =new int[10];
	//int[][] array=new int[100][100];
	//int []  a=new  int [];
	
	private final String m_strPrompt1 = "Verification started\n    put any finger on the reader\n\n";
	private final String m_strPrompt2 = "    put the same or any other finger on the reader\n\n";

	public Verification(Reader reader){
		m_reader = reader;
		m_fmds = new Fmd[2]; //two FMDs to perform comparison

		final int vgap = 5;
		final int width = 380;
   
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(layout);
		
		m_text = new JTextArea(22, 1);
		m_text.setEditable(false);
		JScrollPane paneReader = new JScrollPane(m_text);
		add(paneReader);
		Dimension dm = paneReader.getPreferredSize();
		dm.width = width;
		paneReader.setPreferredSize(dm);
		
		add(Box.createVerticalStrut(vgap));
		
		JButton btnBack = new JButton("Back");
		btnBack.setActionCommand(ACT_BACK);
		btnBack.addActionListener(this);
		add(btnBack);
		add(Box.createVerticalStrut(vgap));

		setOpaque(true);
	}

	public Verification(int count) {
		count1=count;
		// TODO Auto-generated constructor stub
	}

	public void count1 (int count)
	{
		 
		count1 =count;
		
		 
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals(ACT_BACK)){
			//cancel capture
			StopCaptureThread();
		}
		else if(e.getActionCommand().equals(CaptureThread.ACT_CAPTURE)){
			//process result
			CaptureThread.CaptureEvent evt = (CaptureThread.CaptureEvent)e;
			
			if(ProcessCaptureResult(evt)){
				//restart capture thread
				WaitForCaptureThread();
				StartCaptureThread();
			}
			else{
				//destroy dialog
				m_dlgParent.setVisible(false);
			}
		}
	}
	
	private void StartCaptureThread(){
		
		m_capture = new CaptureThread(m_reader, false, Fid.Format.ANSI_381_2004, Reader.ImageProcessing.IMG_PROC_DEFAULT);
		m_capture.start(this);
	}
	
	private void StopCaptureThread(){
		if(null != m_capture) m_capture.cancel();
	}
	
	private void WaitForCaptureThread(){
		if(null != m_capture) m_capture.join(1000);
	}
	
	private boolean ProcessCaptureResult(CaptureThread.CaptureEvent evt){
		boolean bCanceled = false;
		attendance a=new attendance();
		if(null != evt.capture_result){
			if(null != evt.capture_result.image && Reader.CaptureQuality.GOOD == evt.capture_result.quality){
				//extract features
				Engine engine = UareUGlobal.GetEngine();
					
				try{
					Fmd fmd = engine.CreateFmd(evt.capture_result.image, Fmd.Format.ANSI_378_2004);
					if(null == m_fmds[0]) 
					{
						m_fmds[0] = fmd;
						
					}
					else if(null == m_fmds[1]) m_fmds[1] = fmd;
				}
				catch(UareUException e){ MessageBox.DpError("Engine.CreateFmd()", e); }
					
				if(null != m_fmds[0] &&  null != m_fmds[1]){
					
					//perform comparison
					try{
						
						int falsematch_rate = engine.Compare(m_fmds[0], 0, m_fmds[1], 0);
						int target_falsematch_rate = Engine.PROBABILITY_ONE / 100000; //target rate is 0.00001
						if(falsematch_rate < target_falsematch_rate){
							count++;
						//	System.out.println(m_fmds[0]);
						//	System.out.println(m_fmds[1]);
						//	System.out.println(evt);
						//	System.out.println(count);
						//	System.out.println("the value of count1\n");
						//	System.out.println(count1);
							a.array[count1][count]=1;
							b[count]=1;
							//array[count]=1;
							m_text.append("Fingerprints matched.\n");
							m_text.append("ATTENDANCE MARKED.\n");
						//	System.out.println(a.array[count1][count]);
							String str = String.format("dissimilarity score: 0x%x.\n", falsematch_rate);
							m_text.append(str);
							str = String.format("false match rate: %e.\n\n\n", (double)(falsematch_rate / Engine.PROBABILITY_ONE));
							m_text.append(str);
						}
						else{
							count++;
							m_text.append("Fingerprints did not match.\n\n\n");
							m_text.append("ATTENDANCE NOT MARKED.\n");
							a.array[count1][count]=0;
							b[count]=0;
							//System.out.println(a.array[count1][count]);
							//System.out.println(count);
						}
					}
					catch(UareUException e){ MessageBox.DpError("Engine.CreateFmd()", e); }
						
					//discard FMDs
					m_fmds[0] = null;
					m_fmds[1] = null;

					//the new loop starts
					m_text.append(m_strPrompt1);
				}
				else{
					//the loop continues
					m_text.append(m_strPrompt2);
				}
				
								
			}
			else if(Reader.CaptureQuality.CANCELED == evt.capture_result.quality){
				bCanceled = true;
				int total_att=0;
				for(int i=1;i<=count;i++)
				{
					if(b[i]==1)
					{
					total_att=total_att+1;
					}
				}
				System.out.println("THE OVERALL ATTENDANCE IS ");
				System.out.println(total_att);
				a.overall_att.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
				//	final	bCanceled = true;
						int i;
						//System.out.println("hllo");
						int count=0;
						for(i=1;i<=7;i++)
						{
							
							if(a.array[count1][i]==1)
							{
							//	System.out.println("hllo");
								count++;
							}
										
						
		              // a.overall_at.setText(String.valueOf(count));
				    	}
						m_text.append(String.valueOf(count));
				//capture or streaming was canceled, just quit
						
			}});
			}
			else{
				//bad quality
				MessageBox.BadQuality(evt.capture_result.quality);
			}
		}
		else if(null != evt.exception){
			//exception during capture
			MessageBox.DpError("Capture", evt.exception);
			bCanceled = true;
		}
		else if(null != evt.reader_status){
			//reader failure
			MessageBox.BadStatus(evt.reader_status);
			bCanceled = true;
		}

		return !bCanceled;
	}

	private void doModal(JDialog dlgParent){
		//open reader
		try{
			m_reader.Open(Reader.Priority.COOPERATIVE);
		}
		catch(UareUException e){ MessageBox.DpError("Reader.Open()", e); }
		
		//start capture thread
		StartCaptureThread();

		//put initial prompt on the screen
		m_text.append(m_strPrompt1);
		
		//bring up modal dialog
		m_dlgParent = dlgParent;
		m_dlgParent.setContentPane(this);
		m_dlgParent.pack();
		m_dlgParent.setLocationRelativeTo(null);
		m_dlgParent.toFront();
		m_dlgParent.setVisible(true);
		m_dlgParent.dispose();
		
		//cancel capture
		StopCaptureThread();
		
		//wait for capture thread to finish
		WaitForCaptureThread();
		
		//close reader
		try{
			m_reader.Close();
		}
		catch(UareUException e){ MessageBox.DpError("Reader.Close()", e); }
	}
	
	public static void Run(Reader reader){
    	JDialog dlg = new JDialog((JDialog)null, "Verification", true);
    	Verification verification = new Verification(reader);
    	verification.doModal(dlg);
	}
}
