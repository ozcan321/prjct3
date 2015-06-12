import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Card {
		public int number;
		public String type;
		public JButton button;
		public Color typeColor;
		public boolean unique;
		public ImageIcon icon;
		public boolean openFaced;
		public boolean atilmis;
		
		Card(){
			button = new JButton();
			unique = true;
			openFaced = false;
			atilmis = false;
			number = 0;
			type = "";
		}
		
		public static Card[][] makeCards(Card cards[][]){
			for(int j = 0; j < 4; j++)
				for(int i=0; i<13; i++)
					cards[j][i] = new Card();
						
			ImageIcon [] macaIcons = new ImageIcon[13];
			macaIcons[0] = new ImageIcon("src\\cards\\maca\\maca1.jpg");
			macaIcons[1] = new ImageIcon("src\\cards\\maca\\maca2.jpg");
			macaIcons[2] = new ImageIcon("src\\cards\\maca\\maca3.jpg");
			macaIcons[3] = new ImageIcon("src\\cards\\maca\\maca4.jpg");
			macaIcons[4] = new ImageIcon("src\\cards\\maca\\maca5.jpg");
			macaIcons[5] = new ImageIcon("src\\cards\\maca\\maca6.jpg");
			macaIcons[6] = new ImageIcon("src\\cards\\maca\\maca7.jpg");
			macaIcons[7] = new ImageIcon("src\\cards\\maca\\maca8.jpg");
			macaIcons[8] = new ImageIcon("src\\cards\\maca\\maca9.jpg");
			macaIcons[9] = new ImageIcon("src\\cards\\maca\\maca10.jpg");
			macaIcons[10] = new ImageIcon("src\\cards\\maca\\maca11.jpg");
			macaIcons[11] = new ImageIcon("src\\cards\\maca\\maca12.jpg");
			macaIcons[12] = new ImageIcon("src\\cards\\maca\\maca13.jpg");
			
			ImageIcon [] karoIcons = new ImageIcon[13];
			karoIcons[0] = new ImageIcon("src\\cards\\karo\\karo1.jpg");
			karoIcons[1] = new ImageIcon("src\\cards\\karo\\karo2.jpg");
			karoIcons[2] = new ImageIcon("src\\cards\\karo\\karo3.jpg");
			karoIcons[3] = new ImageIcon("src\\cards\\karo\\karo4.jpg");
			karoIcons[4] = new ImageIcon("src\\cards\\karo\\karo5.jpg");
			karoIcons[5] = new ImageIcon("src\\cards\\karo\\karo6.jpg");
			karoIcons[6] = new ImageIcon("src\\cards\\karo\\karo7.jpg");
			karoIcons[7] = new ImageIcon("src\\cards\\karo\\karo8.jpg");
			karoIcons[8] = new ImageIcon("src\\cards\\karo\\karo9.jpg");
			karoIcons[9] = new ImageIcon("src\\cards\\karo\\karo10.jpg");
			karoIcons[10] = new ImageIcon("src\\cards\\karo\\karo11.jpg");
			karoIcons[11] = new ImageIcon("src\\cards\\karo\\karo12.jpg");
			karoIcons[12] = new ImageIcon("src\\cards\\karo\\karo13.jpg");
			
			ImageIcon [] kupaIcons = new ImageIcon[13];
			kupaIcons[0] = new ImageIcon("src\\cards\\kupa\\kupa1.jpg");
			kupaIcons[1] = new ImageIcon("src\\cards\\kupa\\kupa2.jpg");
			kupaIcons[2] = new ImageIcon("src\\cards\\kupa\\kupa3.jpg");
			kupaIcons[3] = new ImageIcon("src\\cards\\kupa\\kupa4.jpg");
			kupaIcons[4] = new ImageIcon("src\\cards\\kupa\\kupa5.jpg");
			kupaIcons[5] = new ImageIcon("src\\cards\\kupa\\kupa6.jpg");
			kupaIcons[6] = new ImageIcon("src\\cards\\kupa\\kupa7.jpg");
			kupaIcons[7] = new ImageIcon("src\\cards\\kupa\\kupa8.jpg");
			kupaIcons[8] = new ImageIcon("src\\cards\\kupa\\kupa9.jpg");
			kupaIcons[9] = new ImageIcon("src\\cards\\kupa\\kupa10.jpg");
			kupaIcons[10] = new ImageIcon("src\\cards\\kupa\\kupa11.jpg");
			kupaIcons[11] = new ImageIcon("src\\cards\\kupa\\kupa12.jpg");
			kupaIcons[12] = new ImageIcon("src\\cards\\kupa\\kupa13.jpg");
			
			ImageIcon [] sinekIcons = new ImageIcon[13];
			sinekIcons[0] = new ImageIcon("src\\cards\\sinek\\sinek1.jpg");
			sinekIcons[1] = new ImageIcon("src\\cards\\sinek\\sinek2.jpg");
			sinekIcons[2] = new ImageIcon("src\\cards\\sinek\\sinek3.jpg");
			sinekIcons[3] = new ImageIcon("src\\cards\\sinek\\sinek4.jpg");
			sinekIcons[4] = new ImageIcon("src\\cards\\sinek\\sinek5.jpg");
			sinekIcons[5] = new ImageIcon("src\\cards\\sinek\\sinek6.jpg");
			sinekIcons[6] = new ImageIcon("src\\cards\\sinek\\sinek7.jpg");
			sinekIcons[7] = new ImageIcon("src\\cards\\sinek\\sinek8.jpg");
			sinekIcons[8] = new ImageIcon("src\\cards\\sinek\\sinek9.jpg");
			sinekIcons[9] = new ImageIcon("src\\cards\\sinek\\sinek10.jpg");
			sinekIcons[10] = new ImageIcon("src\\cards\\sinek\\sinek11.jpg");
			sinekIcons[11] = new ImageIcon("src\\cards\\sinek\\sinek12.jpg");
			sinekIcons[12] = new ImageIcon("src\\cards\\sinek\\sinek13.jpg");

			
			int j;
			for(int i=0; i<4; i++)
				for(j=0; j < 13; j++){
					if(i == 0){
						cards[i][j].button.setName("" + (j+1));
						cards[i][j].number = (j+1);
						cards[i][j].type = "maca";
						cards[i][j].typeColor = Color.BLACK;
						cards[i][j].button.setIcon(macaIcons[j]);
					}
					else if(i == 1){
						cards[i][j].button.setName("" + (j+1));
						cards[i][j].number = (j+1);
						cards[i][j].type = "sinek";
						cards[i][j].typeColor = Color.BLACK;
						cards[i][j].button.setIcon(sinekIcons[j]);
					}
					else if(i == 2){
						cards[i][j].button.setName("" + (j+1));
						cards[i][j].number = (j+1);
						cards[i][j].type = "kupa";
						cards[i][j].typeColor = Color.RED;
						cards[i][j].button.setIcon(kupaIcons[j]);
					}
					else if(i == 3){
						cards[i][j].button.setName("" + (j+1));
						cards[i][j].number = (j+1);
						cards[i][j].type = "karo";
						cards[i][j].typeColor = Color.RED;
						cards[i][j].button.setIcon(karoIcons[j]);
					}
				}
			return cards;
		}

}