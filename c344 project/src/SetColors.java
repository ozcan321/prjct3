import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.*;

public class SetColors extends JFrame{
	public JButton []colorButtons;
	public JButton []colorButtons2;
    private static JButton clickedButton;
    private JLabel validationLabel;
    private JLabel validationLabel2;
    private JLabel vL;
    private JLabel vL2;
    private JLabel preferredL;
    private JLabel []clrNmbrs;
    private JLabel []clrNmbrs2;
    public static ImageIcon selectedBackSide  = new ImageIcon("src\\arka\\arka13.GIF");
    public static ImageIcon selectedBackSideY  = new ImageIcon("src\\arkaY\\arka13.JPG");
    private JPanel clrBttns;
    private JPanel clrBttns2;
    private JButton selectedBttn;
    private String selectedNmbr;
	public static JButton clickedButton2;
	public static ImageIcon selectedBackSide2 = new ImageIcon("src\\background\\bg2.jpg");;
	public JLabel preferredL2;
	public String selectedNmbr2;
	public static JButton selectedBttn2;
	public static JLabel preferred;
	public static JLabel preferred2;
    
	SetColors(){
		super("Set Colors");
		//setDefaultCloseOperation(SetColors.EXIT_ON_CLOSE);		
		setBounds(950,950,600,600);
		Dimension minSize = new Dimension(300,300);
		setMinimumSize(minSize);
		//setLayout(new GridLayout(3,5,10,10));
		
		
		selectedBttn = new JButton(selectedBackSide);
		selectedBttn2 = new JButton(selectedBackSide);
		
		JTabbedPane color1Pane = new JTabbedPane();
		ImageIcon icon = new ImageIcon("clrs2.jpg");

		JPanel panel1 = new JPanel();
		color1Pane.addTab("Playing Cards' Back Side", icon, panel1, "Set color of back side of cards");
		color1Pane.setMnemonicAt(0, KeyEvent.VK_1);
		add(color1Pane);
		JTabbedPane color2Pane = new JTabbedPane();
		JPanel panel2 = new JPanel();
		color1Pane.addTab("Background", icon, panel2, "Set color of background");
		color1Pane.setMnemonicAt(1, KeyEvent.VK_2);

		panel1.setLayout(new BorderLayout());
		clrBttns = new JPanel();
		clrBttns.setLayout(new GridLayout(5,5,10,10));
		colorButtons = new JButton[20];
		colorButtons[0] = new JButton(new ImageIcon("src\\arka\\arka1.GIF"));
		colorButtons[1] = new JButton(new ImageIcon("src\\arka\\arka2.GIF"));
		colorButtons[2] = new JButton(new ImageIcon("src\\arka\\arka3.GIF"));
		colorButtons[3] = new JButton(new ImageIcon("src\\arka\\arka4.jpg"));
		colorButtons[4] = new JButton(new ImageIcon("src\\arka\\arka6.jpg"));
		colorButtons[5] = new JButton(new ImageIcon("src\\arka\\arka7.jpg"));
		colorButtons[6] = new JButton(new ImageIcon("src\\arka\\arka8.jpg"));
		colorButtons[7] = new JButton(new ImageIcon("src\\arka\\arka9.jpg"));
		colorButtons[8] = new JButton(new ImageIcon("src\\arka\\arka10.jpg"));
		colorButtons[9] = new JButton(new ImageIcon("src\\arka\\arka11.jpg"));
		colorButtons[10] = new JButton(new ImageIcon("src\\arka\\arka12.jpg"));
		colorButtons[11] = new JButton(new ImageIcon("src\\arka\\arka13.GIF"));
		colorButtons[12] = new JButton(new ImageIcon("src\\arka\\arka14.GIF"));
		colorButtons[13] = new JButton(new ImageIcon("src\\arka\\arka15.GIF"));
		colorButtons[14] = new JButton(new ImageIcon("src\\arka\\arka16.jpg"));
		colorButtons[15] = new JButton(new ImageIcon("src\\arka\\arka17.GIF"));
		colorButtons[16] = new JButton(new ImageIcon("src\\arka\\arka18.GIF"));
		colorButtons[17] = new JButton(new ImageIcon("src\\arka\\arka19.GIF"));
		colorButtons[18] = new JButton(new ImageIcon("src\\arka\\arka_random.GIF"));
		
		clrNmbrs = new JLabel[20];
		for(int i=0; i<19; i++)
			clrNmbrs[i] = new JLabel("" + (i+1));
		preferred = new JLabel("is choosed");
		
		for(int i=0; i<19; i++)
			colorButtons[i].setName("" + clrNmbrs[i].getText());
		
		for(int i=0; i<19; i++){
			clrBttns.add(colorButtons[i]);
			clrBttns.add(clrNmbrs[i]);
		}
		
		ColorButtonListener listenerColorButton = new ColorButtonListener();
		for(int i=0; i<19; i++)
			(colorButtons[i]).addActionListener(listenerColorButton);	
		
		panel1.add(clrBttns);
		
		validationLabel = new JLabel();
		validationLabel.setVisible(false);
		
		vL = new JLabel();
		panel1.add(vL, BorderLayout.SOUTH);
		
		//BACKGROUND COLOR
		
		panel2.setLayout(new BorderLayout());
		clrBttns2 = new JPanel();
		clrBttns2.setLayout(new GridLayout(8,4,10,6));
		colorButtons2 = new JButton[15];
		colorButtons2[0] = new JButton(new ImageIcon("src\\background\\bg1.jpg"));
		colorButtons2[1] = new JButton(new ImageIcon("src\\background\\bg2.jpg"));
		colorButtons2[2] = new JButton(new ImageIcon("src\\background\\bg3.jpg"));
		colorButtons2[3] = new JButton(new ImageIcon("src\\background\\bg4.jpg"));
		colorButtons2[4] = new JButton(new ImageIcon("src\\background\\bg5.jpg"));
		colorButtons2[5] = new JButton(new ImageIcon("src\\background\\bg6.jpg"));
		colorButtons2[6] = new JButton(new ImageIcon("src\\background\\bg7.jpg"));
		colorButtons2[7] = new JButton(new ImageIcon("src\\background\\bg8.jpg"));
		colorButtons2[8] = new JButton(new ImageIcon("src\\background\\bg9.jpg"));
		colorButtons2[9] = new JButton(new ImageIcon("src\\background\\bg10.jpg"));
		colorButtons2[10] = new JButton(new ImageIcon("src\\background\\bg11.jpg"));
		colorButtons2[11] = new JButton(new ImageIcon("src\\background\\bg12.jpg"));
		colorButtons2[12] = new JButton(new ImageIcon("src\\background\\bg13.jpg"));
		colorButtons2[13] = new JButton(new ImageIcon("src\\background\\bg14.jpg"));
		colorButtons2[14] = new JButton(new ImageIcon("src\\background\\soru.jpg"));
		clrNmbrs2 = new JLabel[15];
		
		for(int i=0; i<15; i++)
			clrNmbrs2[i] = new JLabel("" + (i+1));
		preferred2 = new JLabel("is choosed");
		
		for(int i=0; i<15; i++)
			colorButtons2[i].setName("" + clrNmbrs2[i].getText());
		
		for(int i=0; i<15; i++){
			clrBttns2.add(colorButtons2[i]);
			clrBttns2.add(clrNmbrs2[i]);
		}
		
		ColorButtonListener2 listenerColorButton2 = new ColorButtonListener2();
		for(int i=0; i<15; i++)
			(colorButtons2[i]).addActionListener(listenerColorButton2);	
		
		panel2.add(clrBttns2);
		
		validationLabel2 = new JLabel();
		validationLabel2.setVisible(false);
		
		vL2 = new JLabel();
		panel2.add(vL2, BorderLayout.SOUTH);
		
	}
	
	class ColorButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			clickedButton = (JButton)(e.getSource());
			String text = clickedButton.getName();
			validationLabel.setText(text);
			validationLabel.setVisible(true);	
			selectedBackSide =  (ImageIcon) clickedButton.getIcon();
				
			preferredL = new JLabel ("Preferred pattern: ");	
			
			selectedNmbr = (clickedButton.getName());
			
			if(selectedNmbr.equals("19"))
			{
				Random rand = new Random();
				int randBackSide = rand.nextInt(18);
				selectedBackSide = (ImageIcon)(colorButtons[randBackSide].getIcon());
				validationLabel.setText("" + randBackSide);
			}
			vL.setText(preferredL.getText() + "  " + validationLabel.getText());
			selectedBttn.setIcon(selectedBackSide);
			clrBttns.add(selectedBttn);
			
			clrBttns.add(preferred);
			
			
			ImageIcon iconn = new ImageIcon();
			iconn = selectedBackSide;
			ImageIcon iconY1 = new ImageIcon("src\\arka\\arka1.GIF");
			ImageIcon iconY2 = new ImageIcon("src\\arka\\arka2.GIF");
			ImageIcon iconY3 = new ImageIcon("src\\arka\\arka3.GIF");
			ImageIcon iconY4 = new ImageIcon("src\\arka\\arka4.jpg");
			ImageIcon iconY6 = new ImageIcon("src\\arka\\arka6.jpg");
			ImageIcon iconY7 = new ImageIcon("src\\arka\\arka7.jpg");
			ImageIcon iconY8 = new ImageIcon("src\\arka\\arka8.jpg");
			ImageIcon iconY9 = new ImageIcon("src\\arka\\arka9.jpg");
			ImageIcon iconY10 = new ImageIcon("src\\arka\\arka10.jpg");
			ImageIcon iconY11 = new ImageIcon("src\\arka\\arka11.jpg");
			ImageIcon iconY12 = new ImageIcon("src\\arka\\arka12.jpg");
			ImageIcon iconY13 = new ImageIcon("src\\arka\\arka13.GIF");
			ImageIcon iconY14 = new ImageIcon("src\\arka\\arka14.GIF");
			ImageIcon iconY15 = new ImageIcon("src\\arka\\arka15.GIF");
			ImageIcon iconY16 = new ImageIcon("src\\arka\\arka16.jpg");
			ImageIcon iconY17 = new ImageIcon("src\\arka\\arka17.GIF");
			ImageIcon iconY18 = new ImageIcon("src\\arka\\arka18.GIF");
			ImageIcon iconY19 = new ImageIcon("src\\arka\\arka19.GIF");
			
			int n = 0;
			if(iconn.getImage() == iconY1.getImage())
				n = 1;	
			else if(iconn.getImage() == iconY2.getImage())
				n = 2;
			else if(iconn.getImage() == iconY3.getImage())
				n = 3;
			else if(iconn.getImage() == iconY4.getImage())
				n = 4;
			else if(iconn.getImage() == iconY6.getImage())
				n = 6;
			else if(iconn.getImage() == iconY7.getImage())
				n = 7;
			else if(iconn.getImage() == iconY8.getImage())
				n = 8;
			else if(iconn.getImage() == iconY9.getImage())
				n = 9;
			else if(iconn.getImage() == iconY10.getImage())
				n = 10;
			else if(iconn.getImage() == iconY11.getImage())
				n = 11;
			else if(iconn.getImage() == iconY12.getImage())
				n = 12;
			else if(iconn.getImage() == iconY13.getImage())
				n = 13;
			else if(iconn.getImage() == iconY14.getImage())
				n = 14;
			else if(iconn.getImage() == iconY15.getImage())
				n = 15;
			else if(iconn.getImage() == iconY16.getImage())
				n = 16;
			else if(iconn.getImage() == iconY17.getImage())
				n = 17;
			else if(iconn.getImage() == iconY18.getImage())
				n = 18;
			else if(iconn.getImage() == iconY19.getImage())
				n = 19;
			
			if(n == 0)
				System.out.println("SelectedBackSideY oluþturulamadý.");
			
			if(n == 1)
				selectedBackSideY = new ImageIcon("src\\arkaY\\arka1.JPG");
			else if(n == 2)
				selectedBackSideY = new ImageIcon("src\\arkaY\\arka2.JPG");
			else if(n == 3)
				selectedBackSideY = new ImageIcon("src\\arkaY\\arka3.JPG");
			else if(n == 4)
				selectedBackSideY = new ImageIcon("src\\arkaY\\arka4.jpg");
			else if(n == 6)
				selectedBackSideY = new ImageIcon("src\\arkaY\\arka6.jpg");
			else if(n == 7)
				selectedBackSideY = new ImageIcon("src\\arkaY\\arka7.jpg");
			else if(n == 8)
				selectedBackSideY = new ImageIcon("src\\arkaY\\arka8.jpg");
			else if(n == 9)
				selectedBackSideY = new ImageIcon("src\\arkaY\\arka9.jpg");
			else if(n == 10)
				selectedBackSideY = new ImageIcon("src\\arkaY\\arka10.jpg");
			else if(n == 11)
				selectedBackSideY = new ImageIcon("src\\arkaY\\arka11.jpg");
			else if(n == 12)
				selectedBackSideY = new ImageIcon("src\\arkaY\\arka12.jpg");
			else if(n == 13)
				selectedBackSideY = new ImageIcon("src\\arkaY\\arka13.JPG");
			else if(n == 14)
				selectedBackSideY = new ImageIcon("src\\arkaY\\arka14.JPG");
			else if(n == 15)
				selectedBackSideY = new ImageIcon("src\\arkaY\\arka15.JPG");
			else if(n == 16)
				selectedBackSideY = new ImageIcon("src\\arkaY\\arka16.jpg");
			else if(n == 17)
				selectedBackSideY = new ImageIcon("src\\arkaY\\arka17.JPG");
			else if(n == 18)
				selectedBackSideY = new ImageIcon("src\\arkaY\\arka18.JPG");
			else if(n == 19)
				selectedBackSideY = new ImageIcon("src\\arkaY\\arka19.JPG");

		}
	}
	class ColorButtonListener2 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			clickedButton2 = (JButton)(e.getSource());
			String text2 = clickedButton2.getName();
			validationLabel2.setText(text2);
			validationLabel2.setVisible(true);	
			selectedBackSide2 =  (ImageIcon) clickedButton2.getIcon();
			preferredL2 = new JLabel ("Preferred pattern: ");	
			
			selectedNmbr2 = (clickedButton2.getName());
			
			if(selectedNmbr2.equals("15"))
			{
				Random rand2 = new Random();
				int randBackSide2 = rand2.nextInt(15);
				selectedBackSide2 = (ImageIcon)(colorButtons2[randBackSide2].getIcon());
				validationLabel2.setText("" + (randBackSide2+1));
			}
			vL2.setText(preferredL2.getText() + "  " + validationLabel2.getText());
			selectedBttn2.setIcon(((selectedBackSide2)));
			clrBttns2.add(selectedBttn2);

			clrBttns2.add(preferred2);
		}
	}
}
