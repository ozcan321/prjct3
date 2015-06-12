import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;


public class DSS extends JFrame{
	
	public static String scoringSystem = "numberOfCards";
	public JRadioButton rb1, rb2;
	
	public DSS()
	{
		super("Choose a Scoring System");
		setBounds(350,250,600,600);
		setLocationRelativeTo(null); 
		Dimension minSize = new Dimension(550,550);
		setMinimumSize(minSize);
		setVisible(true);
		
		setLayout(new GridLayout(2,2,30,30));
		
		JPanel p11 = new JPanel(new BorderLayout());
		JPanel p12 = new JPanel(new BorderLayout());
		JPanel p21 = new JPanel(new BorderLayout());
		JPanel p22 = new JPanel(new BorderLayout());
		
		rb1 = new JRadioButton("Number of Cards");
		rb2 = new JRadioButton("Worth of Cards");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rb1);
		group.add(rb2);
		ActionListenerRB l1 = new ActionListenerRB();
		ActionListenerRB l2 = new ActionListenerRB();
		rb1.addActionListener(l1);
		rb2.addActionListener(l2);
		
		Font f = new Font("Arial", Font.HANGING_BASELINE, 16);
		
		JTextArea ta1 = new JTextArea();
		JTextArea ta2 = new JTextArea();
		ta1.setText("* All players' points are evaluated"
				+ "\naccording to the number of"
				+ "\ntheir gained cards."
				+ "\n\n* Also, duplicate cards are"
				+ "\nscored with 10 points.");
		ta2.setText("All players' points are evaluated"
				+ "\naccording to specific card properties."
				+ "\n\nThese worthy cards:"
				+ "\n-> A - (1) card : 1 point"
				+ "\n-> J - (Jack) card : 1 point"
				+ "\n-> Club - 2 card : 2 points"
				+ "\n-> Diomond - 10 card : 3 points"
				+ "\n-> Jack Duplicate : 20 points"
				+ "\n-> Other Duplicates : 10 points"
				+ "\n-> Overage : 3 points");
		ta1.setFont(f);
		ta2.setFont(f);
		
		p11.add(rb1);
		p12.add(rb2);
		p21.add(ta1);
		p22.add(ta2);
		
		add(p11);
		add(p12);
		add(p21);
		add(p22);
	}
	class ActionListenerRB implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
				if(e.getSource() == rb1)
				{
					scoringSystem = "numberOfCards";
				}
				else if(e.getSource() == rb2)
				{
					scoringSystem = "worthOfCards";
				}
				else 
					System.out.println("ActionListenerRB fonk. ???");
				
				System.out.println("scoringSystem: " + scoringSystem);			
		}

	}
}
