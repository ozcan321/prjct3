import java.util.Random;
import java.util.Vector;


public class Player {
	public Card []cards4 = new Card[4];
	Vector<Card> gainedCards = new Vector<Card>();
	public int pisti;
	public int pistiJ;
	public int points;
	public String name;
	public int siralama;
	
	Player(){
	 	for(int i=0; i<4; i++)
			cards4[i] = new Card();
	 	pisti = 0;
	 	pistiJ = 0;
	 	points = 0;
	 	name = "noname";
	}
	Player(String n){
	 	for(int i=0; i<4; i++)
			cards4[i] = new Card();
	 	pisti = 0;
	 	pistiJ = 0;
	 	points = 0;
	 	name = n;
	}
	
	public  void kagitAta(Card cards[][]){
		for(int i=0; i<4; i++){
			Random rand = new Random();
			int rand1 = rand.nextInt(4);
			int rand2 = rand.nextInt(13);
			if(cards[rand1][rand2].unique == true){
				cards4[i] = cards[rand1][rand2];
				cards4[i].button.setName(cards[rand1][rand2].button.getName());
				cards4[i].number = cards[rand1][rand2].number;
				cards[rand1][rand2].unique = false;
			}
			else
				i--;
		}
		NewGame.totalCards = NewGame.totalCards - 4;
	}
}
