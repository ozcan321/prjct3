import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class SetNames extends JFrame{
	
	public static String playerName;
	public static String pc1Name;
	public static String pc2Name;
	public static String pc3Name;
	
	public JTextField tf1;
	public JTextField tf2;
	public JTextField tf3;
	public JTextField tf4;
	
	public SetNames()
	{
		super("Set Names of Players");
		setLayout(new GridLayout(4,3,40,40));
		setBounds(250,150,600,400);
		setEnabled(true);
		setVisible(true);
		setLocationRelativeTo(null); 
		Dimension minSize = new Dimension(550,350);
		setMinimumSize(minSize);
		
		JLabel setNamePlayer = new JLabel("Set Name of the Player:");
		JLabel setNamePc1 = new JLabel("Set Name of PC1:");
		JLabel setNamePc2 = new JLabel("Set Name of PC2:");
		JLabel setNamePc3 = new JLabel("Set Name of PC3:");
		
		JButton setPlayer = new JButton("OK");
		JButton setPc1 = new JButton("OK");
		JButton setPc2 = new JButton("OK");
		JButton setPc3 = new JButton("OK");
		
		ActionListenerOK listenerOK = new ActionListenerOK();
		setPlayer.addActionListener(listenerOK);
		setPc1.addActionListener(listenerOK);
		setPc2.addActionListener(listenerOK);
		setPc3.addActionListener(listenerOK);
		
		setPlayer.setName("p");
		setPc1.setName("pc1");
		setPc2.setName("pc2");
		setPc3.setName("pc3");
		
		tf1 = new JTextField(12);
		tf2 = new JTextField(12);
		tf3 = new JTextField(12);
		tf4 = new JTextField(12);
		
		Font f = new Font("Calibri", Font.ITALIC , 22);
		tf1.setFont(f);
		tf2.setFont(f);
		tf3.setFont(f);
		tf4.setFont(f);
		
		add(setNamePlayer);
		add(tf1);
		add(setPlayer);
		
		add(setNamePc1);
		add(tf2);
		add(setPc1);
		
		add(setNamePc2);
		add(tf3);
		add(setPc2);
		
		add(setNamePc3);
		add(tf4);
		add(setPc3);
		
		
	}
		class ActionListenerOK implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				if(((JButton)(event.getSource())).getName().equals("p"))
					playerName = tf1.getText();
				else if(((JButton)(event.getSource())).getName().equals("pc1"))
					pc1Name = tf2.getText();
				else if(((JButton)(event.getSource())).getName().equals("pc2"))
					pc2Name = tf3.getText();
				else if(((JButton)(event.getSource())).getName().equals("pc3"))
					pc3Name = tf4.getText();

				((JButton)(event.getSource())).setEnabled(false);
				
				NewGame.player.name = playerName;
				NewGame.pc1.name = pc1Name;
				NewGame.pc2.name = pc2Name;
				NewGame.pc3.name = pc3Name;
				
				System.out.println("Player name: " + NewGame.player.name);
				System.out.println("Pc1 name: " + NewGame.pc1.name);
				System.out.println("Pc2 name: " + NewGame.pc2.name);
				System.out.println("Pc3 name: " + NewGame.pc3.name);
			}
		}
		
	
}
