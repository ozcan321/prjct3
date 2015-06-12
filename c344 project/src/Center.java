import java.awt.Color;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;


public class Center{
 	public Vector<Card> allCards = new Vector<Card>();
 	
 	Center(){ 	 	

 	}
 	public void kagitAta(Card cards[][]){
 	 	
		for(int i=0; i<4; i++){
			Random rand = new Random();
			int rand1 = rand.nextInt(4);
			int rand2 = rand.nextInt(13);
			if(cards[rand1][rand2].unique == true){
				allCards.add(cards[rand1][rand2]);
				cards[rand1][rand2].unique = false;
				//center.cards4[i].button.setEnabled(false);
				allCards.get(i).button.setBackground(Color.GRAY);
			}
			else
				i--;
		}
		NewGame.totalCards = NewGame.totalCards - 4;		
	}
 	
}
