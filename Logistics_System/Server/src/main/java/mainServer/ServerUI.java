package mainServer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import config.XMLReader;

public class ServerUI extends JFrame{
	
	private static ServerUI serverFrame;
	public ServerPanel myPanel;
	
	private ServerUI(){
		myPanel=new ServerPanel();
		this.setContentPane(myPanel);
		this.setSize(400,255);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static ServerUI getFrame(){
		if(serverFrame==null)
			serverFrame=new ServerUI();
		return serverFrame;
	}
	
	public class ServerPanel extends JPanel{
		JLabel jlabel;
		private JScrollPane scrollPane;
	    private JTextArea textArea;
	    
		public ServerPanel(){
			this.setLayout(null);
			jlabel=new JLabel("Server start! IP:"+XMLReader.loadipconfig().getIP());
			jlabel.setSize(300, 30);
		    jlabel.setLocation(20, 10);
		    scrollPane=new JScrollPane();
		    scrollPane.setSize(350, 150);
		    scrollPane.setLocation(20, 40);
	        textArea=new JTextArea(); 
	        textArea.setEditable(false);
	        scrollPane.setViewportView(textArea);
		    this.add(jlabel);
		    this.add(scrollPane);
		    
		}
		
		public void add(String content){
			textArea.append(content);
		}
		
	}
}
