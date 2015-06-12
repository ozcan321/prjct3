import java.awt.CheckboxMenuItem;
import java.awt.Dimension;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{
	JPanel mainPanel;
	public static CheckboxMenuItem sounds;
	
	Main()
	{
		super("REAL PEASHTEA");
		setBounds(350,250,500,500);
		setLocationRelativeTo(null); 
		Dimension minSize = new Dimension(300,300);
		setMinimumSize(minSize);
		setVisible(true);
		mainPanel = new JPanel();
		add(mainPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		MenuBar mBar = new MenuBar();
		setMenuBar(mBar);
		
		Menu menu = new Menu("Menu");
		MenuItem newGame = new MenuItem("New Game");
		MenuItem exit = new MenuItem("Exit");
		menu.add(newGame);
		menu.add(exit);
		mBar.add(menu);
		
		Menu options = new Menu("Options");
		MenuItem maxScore = new MenuItem("Adjust Max Score");
		MenuItem scoringSystem = new MenuItem("Determine Scoring System");
		MenuItem lookScores = new MenuItem("Look at Scores");
		sounds = new CheckboxMenuItem("Sounds", true);		
		options.add(lookScores);
		//options.add(maxScore);
		options.add(scoringSystem);

		options.add(sounds);
		mBar.add(options);
		
		Menu settings = new Menu("Settings");
		MenuItem setColors = new MenuItem("Set Colors");
		MenuItem setNames = new MenuItem("Set Names");
		settings.add(setColors);
		settings.add(setNames);
		mBar.add(settings);
		
		ActionListenerDSS listenerDSS = new ActionListenerDSS();
		scoringSystem.addActionListener(listenerDSS);
		
		ActionListenerLookScores listenerLookScores = new ActionListenerLookScores();
		lookScores.addActionListener(listenerLookScores);
		
		ActionListenerMenuItemSound listenerMenuItemSound = new ActionListenerMenuItemSound();
		newGame.addActionListener(listenerMenuItemSound);
		setColors.addActionListener(listenerMenuItemSound);
		setNames.addActionListener(listenerMenuItemSound);
		sounds.addActionListener(listenerMenuItemSound);
		maxScore.addActionListener(listenerMenuItemSound);
		scoringSystem.addActionListener(listenerMenuItemSound);
		lookScores.addActionListener(listenerMenuItemSound);
		
		ActionListenerNewGame listenerNewGame = new ActionListenerNewGame();
		newGame.addActionListener(listenerNewGame);
		
		ActionListenerSetNames listenerSetNames = new ActionListenerSetNames();
		setNames.addActionListener(listenerSetNames);
		
		ActionListenerExit listenerExit = new ActionListenerExit();
		exit.addActionListener(listenerExit);
		
		ActionListenerSetColors listenerSetColors = new ActionListenerSetColors();
		setColors.addActionListener(listenerSetColors);
	}
	class ActionListenerDSS implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			new DSS();
		}
	}
	class ActionListenerLookScores implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			new LookScores();
		}
	}
	class ActionListenerExit implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();
			System.out.println(obj.toString());
			System.exit(0);
		}
	}
	class ActionListenerNewGame implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			JFrame newGameF = new JFrame("Game");
			newGameF.add(new NewGame());	
			newGameF.setBounds(350,250,650,650);
			newGameF.setLocationRelativeTo(null);
			Dimension minSize = new Dimension(600,600);
			setMinimumSize(minSize);
			newGameF.setVisible(true);
		}
	}
	class ActionListenerSetColors implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			SetColors sc = new SetColors();
			sc.setLocationRelativeTo(null); 
			sc.setVisible(true);
		}
	}
	class ActionListenerSetNames implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			new SetNames();
		}
	}
	public class ActionListenerMenuItemSound implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{	
			if(sounds.getState() == true)
			{
			
		      try {
		         // Open an audio input stream.
		         URL url = this.getClass().getClassLoader().getResource("menuItem.wav");
		         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
		         // Get a sound clip resource.
		         Clip clip = AudioSystem.getClip();
		         // Open audio clip and load samples from the audio input stream.
		         clip.open(audioIn);
		         clip.start();
		      } catch (UnsupportedAudioFileException e) {
		         e.printStackTrace();
		      } catch (IOException e) {
		         e.printStackTrace();
		      } catch (LineUnavailableException e) {
		         e.printStackTrace();
		      }
			}
		}	   
	}
	public static void main(String[] args){
		new Main();
	}
}
