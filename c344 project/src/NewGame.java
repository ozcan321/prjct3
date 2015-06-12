import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

import java.io.*;
import java.net.URL;

import javax.sound.sampled.*;

public class NewGame extends JPanel{
	
	int flag = 0;
	
	public static Player player = new Player("Player");
    public static Player pc1 = new Player("Pc1");
    public static Player pc3 = new Player("Pc3");
    public static Player pc2 = new Player("Pc2");

	Center center = new Center();;
	public static int totalCards = 52;
	Card  [][]cards;
	JPanel centerCardsPanel;
	public static JButton showingCard;
	public static int tur = 0;
	public JPanel pc1CardsP;
	public JPanel pc2CardsP;
	public JPanel pc3CardsP;
	public JPanel playerCardsPanel;
	public static Player enSonAlan;
	JPanel playersPanel;
	JPanel centerCardsP;
	
	NewGame(){
		
		flag = 0;
		
		setLayout(new BorderLayout());
		setBounds(250,150,400,400);
		setEnabled(true);
		setVisible(true);		
		
		tur = 0;
		
		cards = new Card[4][13];
	 	cards = Card.makeCards(cards);
		
		System.out.println("TotalCads: " + totalCards);		
	 	player.kagitAta(cards);
		System.out.println("TotalCads: " + totalCards);
	 	pc1.kagitAta(cards);
		System.out.println("TotalCads: " + totalCards);		
	 	pc2.kagitAta(cards);
		System.out.println("TotalCads: " + totalCards);
	 	pc3.kagitAta(cards);
		System.out.println("TotalCads: " + totalCards);
		center.kagitAta(cards);
	
		
		for(int i=0; i<4; i++)
		{
			pc1.cards4[i].button.setIcon(SetColors.selectedBackSideY);		//image yanlamasýna gösteriliyor
			pc2.cards4[i].button.setIcon(SetColors.selectedBackSide);
			pc3.cards4[i].button.setIcon(SetColors.selectedBackSideY);		//image yanlamasýna gösteriliyor
		}
		
		for(int i=0; i<center.allCards.size(); i++)
			System.out.println(center.allCards.get(i).number + " " + center.allCards.get(i).button.getName());
		
		for(int i=0; i<4; i++)
			player.cards4[i].openFaced = true;
		
		playersPanel = new JPanel(new BorderLayout());
		add(playersPanel);
		
		System.out.println("\n\n");
		playerCardsPanel = new JPanel(new FlowLayout());
		playersPanel.add(playerCardsPanel, BorderLayout.SOUTH);
		Dimension preferredSizeB = new Dimension(70, 96);
		System.out.println("Player ýn ilk eldeki kagitlarý: ");
		for(int i=0; i<4; i++){
			playerCardsPanel.add(player.cards4[i].button);
			player.cards4[i].button.setPreferredSize(preferredSizeB);
			System.out.println(player.cards4[i].number);
			System.out.println(player.cards4[i].type);
		}
		System.out.println("\n");
		
		JPanel pc1CardsPanel = new JPanel(new FlowLayout());
		playersPanel.add(pc1CardsPanel, BorderLayout.EAST);
		pc1CardsP = new JPanel(new GridLayout(10,1,5,5));
		pc1CardsPanel.add(pc1CardsP);
		JLabel pc1GainedCards = new JLabel();
		pc1CardsP.add(pc1GainedCards);
		Dimension preferredSizeBpc1 = new Dimension(98, 63);
		System.out.println("Pc1 in ilk eldeki kagitlarý: ");
		for(int i=0; i<4; i++){
			pc1CardsP.add(pc1.cards4[i].button);	
			pc1.cards4[i].button.setPreferredSize(preferredSizeBpc1);
			System.out.println(pc1.cards4[i].number);
			System.out.println(pc1.cards4[i].type);
		}
		System.out.println("\n");
		
		pc2CardsP = new JPanel(new FlowLayout());
		playersPanel.add(pc2CardsP, BorderLayout.NORTH);
		Dimension preferredSizeBpc2 = new Dimension(63, 98);
		System.out.println("Pc2 nin ilk eldeki kagitlarý: ");
		for(int i=0; i<4; i++){
			pc2CardsP.add(pc2.cards4[i].button);	
			pc2.cards4[i].button.setPreferredSize(preferredSizeBpc2);
			System.out.println(pc2.cards4[i].number);
			System.out.println(pc2.cards4[i].type);
		}
		System.out.println("\n");
		
		JPanel pc3CardsPanel = new JPanel(new FlowLayout());
		playersPanel.add(pc3CardsPanel, BorderLayout.WEST);
		pc3CardsP = new JPanel(new GridLayout(10,1,5,5));
		pc3CardsPanel.add(pc3CardsP);
		JLabel pc3GainedCards = new JLabel();
		pc3CardsP.add(pc3GainedCards);
		Dimension preferredSizeBpc3 = new Dimension(98, 63);
		System.out.println("Pc3 ün ilk eldeki kagitlarý: ");
		for(int i=0; i<4; i++){
			pc3CardsP.add(pc3.cards4[i].button);	
			pc3.cards4[i].button.setPreferredSize(preferredSizeBpc3);
			System.out.println(pc3.cards4[i].number);
			System.out.println(pc3.cards4[i].type);
		}
		System.out.println("\n");

		centerCardsPanel = new JPanel(new BorderLayout());
		playersPanel.add(centerCardsPanel, BorderLayout.CENTER);
		centerCardsP = new JPanel(new BorderLayout());
		Dimension preferredSizeBcenter = new Dimension(63, 98);
		showingCard = new JButton();
		showingCard = center.allCards.get(3).button;
		showingCard.setPreferredSize(preferredSizeBcenter);
		
		Rectangle r = new Rectangle(63, 98);
		showingCard.setBounds(r);
		
		centerCardsP.add(showingCard, BorderLayout.CENTER);
		centerCardsPanel.add(centerCardsP, BorderLayout.CENTER);
		
		/*
		JPanel north = new JPanel();
		JPanel south = new JPanel();
		JPanel west = new JPanel();
		JPanel east = new JPanel();
		
		JLabel l1 = new JLabel("sdthsrthjrswthjrwytjhswryjrswyjtswswtrh");
		JLabel l2 = new JLabel("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		north.add(l1);
		south.add(l1);
		west.add(l1);
		east.add(l1);
		
		centerCardsPanel.add(north, BorderLayout.NORTH);
		centerCardsPanel.add(south, BorderLayout.SOUTH);
		centerCardsP.add(west, BorderLayout.WEST);
		centerCardsPanel.add(east, BorderLayout.EAST);*/
		
		System.out.println("Baþta ortaya konulan 4 kagýt");
		for(int i=0; i<center.allCards.size(); i++)
			System.out.println(center.allCards.get(i).number + " " + center.allCards.get(i).type);
		
		//btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.new_todo_image));

		
		add(playersPanel);
		
		for(int i1=0; i1<4; i1++)
			player.cards4[i1].button.addActionListener(new ActionListenerSelectedCard());


	}
	

	public void removePlayerCards(){
		for(int i=0; i<4; i++)
			playerCardsPanel.remove(player.cards4[i].button);
	}
	public void removepc1Cards(){
		for(int i=0; i<4; i++)
			pc1CardsP.remove(pc1.cards4[i].button);
	}
	public void removepc2Cards(){
		for(int i=0; i<4; i++)
			pc2CardsP.remove(pc2.cards4[i].button);
	}
	public void removepc3Cards(){
		for(int i=0; i<4; i++)
			pc3CardsP.remove(pc3.cards4[i].button);
	}
	
	public void hideCards(Player p){
		for(int i=0; i<4; i++)
			p.cards4[i].button.hide();
	}
	
	class ActionListenerSelectedCard implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			ImageIcon cardImage = new ImageIcon();
			int card1, card2;
			
			System.out.println("flag: " + flag);
			
			if (flag%4 == 3 && flag != 0)
				((JButton)(e.getSource())).setEnabled(false);
			
			if (flag%4 == 0)
			{
			
			
			System.out.println("Center.allCards.number larý");
			for(int i=0; i<center.allCards.size(); i++)
				System.out.println(center.allCards.get(i).number);
			
			
			
			showingCard.setIcon(((JButton)(e.getSource())).getIcon());
			int index = 0;
			for(int i=0; i<4 ; i++){
				if(player.cards4[i].button.getName().equals( ((JButton)(e.getSource())).getName() )){
					index = i;
				break;		
				}
			}			
			center.allCards.add(player.cards4[index]);
			
			System.out.println("Center.allCards.number larý (Player attýktan sonraki)");
			for(int i=0; i<center.allCards.size(); i++)
				System.out.println(center.allCards.get(i).number);
			
			
			new SoundClipTest();	//ses
			
			card1 = (center.allCards.get(center.allCards.size()-1).number);
			card2 = -1;
			if(center.allCards.size() > 1)
				card2 = (center.allCards.get(center.allCards.size()-2).number);
			if(card1 == card2 || (card1 == 11 && center.allCards.size() != 0)) 
			{ 
				if(center.allCards.size() == 2 && card1 == 11 && card2 == 11)
					player.pistiJ++;
				else if(center.allCards.size() == 2)
					player.pisti++;
				
				showingCard.setIcon(new ImageIcon("src\\cards\\bos.jpg"));
				player.gainedCards.addAll(center.allCards);
				center.allCards.clear();
				System.out.println("Player aldý.");
				enSonAlan = player;				
			}
			else
				showingCard.setName(((JButton)(e.getSource())).getName());
			

			
			System.out.println("player's cards:");
			for(int i=0; i<player.gainedCards.size(); i++)
				System.out.println("\t" + player.gainedCards.get(i).number);
			System.out.println("player gainedCards Size: " + player.gainedCards.size());
			
			((JButton)(e.getSource())).setIcon((new ImageIcon("src\\play.jpg")));
			
			}

			
			
			if(flag%4 == 1)
			{
			// PC 1 atýyor.
			Card pc1Card = new Card();
			pc1Card = pcPlay(pc1, tur);
			
			cardImage = getCardImage(pc1Card);//
		
	
			showingCard.setIcon(cardImage);	
			
			//centerCardsP.add(showingCard, BorderLayout.CENTER);
				
			
			/*try {
				Thread.sleep(5000);
				System.out.println("5 sn");
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/	

			center.allCards.add(pc1Card);
			
			card1 = -1;
			if(center.allCards.size() > 0)
				card1 = (center.allCards.get(center.allCards.size()-1).number);
			card2 = -1;
			if(center.allCards.size() > 1)
				card2 = (center.allCards.get(center.allCards.size()-2).number);
			
			new SoundClipTest();	//ses
			
			if(card1 == card2 || (card1 == 11 && center.allCards.size() != 0))
			{
				if(center.allCards.size() == 2 && card1 == 11 && card2 == 11)
					pc1.pistiJ++;
				else if(center.allCards.size() == 2)
					pc1.pisti++;
				
				showingCard.setIcon(new ImageIcon("src\\cards\\bos.jpg"));
				pc1.gainedCards.addAll(center.allCards);
				center.allCards.clear();
				System.out.println("Pc1 aldý.");
				enSonAlan = pc1;
			}
			else
				showingCard.setName(pc1Card.button.getName());
			
			
			System.out.println("Center.allCards.number larý (pc1 attýktan sonraki)");
			for(int i=0; i<center.allCards.size(); i++)
				System.out.println(center.allCards.get(i).number);
			
			System.out.println("pc1's cards:");
			for(int i=0; i<pc1.gainedCards.size(); i++)
				System.out.println("\t" + pc1.gainedCards.get(i).number);
			System.out.println("pc1 gainedCards Size: " + pc1.gainedCards.size());
			
			System.out.println("Atýlan pc1 card: " + " " + pc1Card.number);
			
			
			}
			
			
			
			if (flag%4 == 2)
			{
			// PC 2 atýyor
			Card pc2Card = new Card();
			pc2Card = pcPlay(pc2, tur);
			cardImage = getCardImage(pc2Card);//

			//System.out.println("pc2Card: " + pc2Card.number + "Card1: " + card1 + "  Card2:" + card2);

			center.allCards.add(pc2Card);

			showingCard.setIcon(cardImage);
			
			card1 = -1;
			if(center.allCards.size() > 0)
				card1 = (center.allCards.get(center.allCards.size()-1).number);
			card2 = -1;
			if(center.allCards.size() > 1)
				card2 = (center.allCards.get(center.allCards.size()-2).number);
			
			new SoundClipTest();	//ses
			
			if(card1 == card2 || (card1 == 11 && center.allCards.size() != 0))
			{
				if(center.allCards.size() == 2 && card1 == 11 && card2 == 11)
					pc2.pistiJ++;
				else if(center.allCards.size() == 2)
					pc2.pisti++;
				
				showingCard.setIcon(new ImageIcon("src\\cards\\bos.jpg"));
				pc2.gainedCards.addAll(center.allCards);
				center.allCards.clear();
				System.out.println("pc2 aldý.");
				enSonAlan = pc2;
			}
			else
				showingCard.setName(pc2Card.button.getName());
			
			
			System.out.println("Center.allCards.number larý (pc2 attýktan sonraki)");
			for(int i=0; i<center.allCards.size(); i++)
				System.out.println(center.allCards.get(i).number);
			
			System.out.println("pc2's cards:");
			for(int i=0; i<pc2.gainedCards.size(); i++)
				System.out.println("\t" + pc2.gainedCards.get(i).number);
			System.out.println("pc2 gainedCards Size: " + pc2.gainedCards.size());
			
			System.out.println("Atýlan pc2 card: " + pc2Card.number);
			
			
			}
			
			
			if(flag%4 == 3)
			{
			//PC 3 atýyor
			Card pc3Card = new Card();
			pc3Card = pcPlay(pc3, tur);
			cardImage = getCardImage(pc3Card);

			//System.out.println("pc3Card: " + pc3Card.number + "Card1: " + card1 + "  Card2:" + card2);
			
			center.allCards.add(pc3Card);
			
			showingCard.setIcon(cardImage);	
		
			card1 = -1;
			if(center.allCards.size() > 0)
				card1 = (center.allCards.get(center.allCards.size()-1).number);
			card2 = -1;
			if(center.allCards.size() > 1)
				card2 = (center.allCards.get(center.allCards.size()-2).number);
			
			new SoundClipTest();	//ses
			
			if(card1 == card2 || (card1 == 11 && center.allCards.size() != 0))
			{
				if(center.allCards.size() == 2 && card1 == 11 && card2 == 11)
					pc3.pistiJ++;
				else if(center.allCards.size() == 2)
					pc3.pisti++;
				
				showingCard.setIcon(new ImageIcon("src\\cards\\bos.jpg"));
				pc3.gainedCards.addAll(center.allCards);
				center.allCards.clear();
				System.out.println("pc3 aldý.");
				enSonAlan = pc3;
			}
			else
				showingCard.setName(pc3Card.button.getName());
			
			
			System.out.println("Center.allCards.number larý (pc3 attýktan sonraki)");
			for(int i=0; i<center.allCards.size(); i++)
				System.out.println(center.allCards.get(i).number);
			
			System.out.println("pc3's cards:");
			for(int i=0; i<pc3.gainedCards.size(); i++)
				System.out.println("\t" + pc3.gainedCards.get(i).number);
			System.out.println("pc3 gainedCards Size: " + pc3.gainedCards.size());
			
			System.out.println("Atýlan pc3 card: " + pc3Card.number);
			
			tur++;
			System.out.println("\nTur: " + tur + "\n");
			
			//player.cards4[0].button.setIcon(new ImageIcon("src\\cards\\bos.jpg"));
			if(tur == 4 ){
				
				kagitYenile();
			
				System.out.println("Kagit yenileden sonraki player Cards: ");			
				for(int i=0; i<4; i++){
					System.out.println(player.cards4[i].number + " " + player.cards4[i].type);
				}
				System.out.println("Kagit yenileden sonraki pc1 Cards: ");			
				for(int i=0; i<4; i++){
					System.out.println(pc1.cards4[i].number + " " + pc1.cards4[i].type);
				}
				System.out.println("Kagit yenileden sonraki pc2 Cards: ");			
				for(int i=0; i<4; i++){
					System.out.println(pc2.cards4[i].number + " " + pc2.cards4[i].type);
				}
				System.out.println("Kagit yenileden sonraki pc3 Cards: ");			
				for(int i=0; i<4; i++){
					System.out.println(pc3.cards4[i].number + " " + pc3.cards4[i].type);
				}			

				for(int j=0; j<4; j++)
				{					
					player.cards4[j].button.setEnabled(true);
					pc1.cards4[j].button.setEnabled(true);
					pc2.cards4[j].button.setEnabled(true);
					pc3.cards4[j].button.setEnabled(true);
				}
			}
			else if(tur == 8){
				
				System.out.println("\n\n!!! --- SON EL --- !!!");
				
				kagitYenile();
				
				System.out.println("Kagit yenileden sonraki player Cards: ");			
				for(int i=0; i<4; i++){
					System.out.println(player.cards4[i].number + " " + player.cards4[i].type);
				}
				System.out.println("Kagit yenileden sonraki pc1 Cards: ");			
				for(int i=0; i<4; i++){
					System.out.println(pc1.cards4[i].number + " " + pc1.cards4[i].type);
				}
				
				System.out.println("Kagit yenileden sonraki pc2 Cards: ");			
				for(int i=0; i<4; i++){
					System.out.println(pc2.cards4[i].number + " " + pc2.cards4[i].type);
				}
				System.out.println("Kagit yenileden sonraki pc3 Cards: ");			
				for(int i=0; i<4; i++){
					System.out.println(pc3.cards4[i].number + " " + pc3.cards4[i].type);
				}			

				for(int j=0; j<4; j++)
				{					
					player.cards4[j].button.setEnabled(true);
					pc1.cards4[j].button.setEnabled(true);
					pc2.cards4[j].button.setEnabled(true);
					pc3.cards4[j].button.setEnabled(true);
				}
			}
			else if(tur == 12){
				System.out.println("\n!!! --- OYUN BÝTTÝ --- !!!");
				
				if(center.allCards.size() != 0)
				{
					System.out.println("en son alan: " + enSonAlan + " ve eklenen kaðýtlar: ");
					for(int i=0; i<center.allCards.size(); i++)
					{
						enSonAlan.gainedCards.add(center.allCards.get(i));
						System.out.println(center.allCards.get(i).number + " " + center.allCards.get(i).type);
					}
				}
						
				System.out.println("\n\nPlayer ýn aldýklarý:");
				for(int i=0; i<player.gainedCards.size(); i++)
					System.out.println(player.gainedCards.get(i).number + " " + player.gainedCards.get(i).type);
				System.out.println("\nToplam: " + player.gainedCards.size());
				
				System.out.println("\n\nPc1 in aldýklarý:");
				for(int i=0; i<pc1.gainedCards.size(); i++)
					System.out.println(pc1.gainedCards.get(i).number + " " + pc1.gainedCards.get(i).type);
				System.out.println("\nToplam: " + pc1.gainedCards.size());
				
				System.out.println("\n\nPc2 nin aldýklarý:");
				for(int i=0; i<pc2.gainedCards.size(); i++)
					System.out.println(pc2.gainedCards.get(i).number + " " + pc2.gainedCards.get(i).type);
				System.out.println("\nToplam: " + pc2.gainedCards.size());
				
				System.out.println("\n\nPc3 ün aldýklarý:");
				for(int i=0; i<pc3.gainedCards.size(); i++)
					System.out.println(pc3.gainedCards.get(i).number + " " + pc3.gainedCards.get(i).type);
				System.out.println("\nToplam: " + pc3.gainedCards.size());
				
				System.out.println("\n" + center.allCards.size() + " kart ortada kalmýþtý.");
			}
			else
				System.out.println("\nTur sayýsý 4, 8 ya da 12 deðil.");
			
			
			}
			
			flag++;
			System.out.println("\nTur: " + tur);
			
		}
	}
	
	public void kagitYenile(){
		
			flag = -1;
			
			System.out.println("TotalCards: " + totalCards);

			if(isCards4Empty(pc3.cards4) && totalCards > 0){
				 System.out.println("oyuncu kagitlarý yenilendi.");
				 
				 removePlayerCards();
				 removepc1Cards();
				 removepc2Cards();
				 removepc3Cards();
				 
				 player.cards4[0].button.hide();
				 player.cards4[1].button.hide();
				 player.cards4[2].button.hide();
				 player.cards4[3].button.hide();
				 
				 player.kagitAta(cards);
				 pc1.kagitAta(cards);
				 pc2.kagitAta(cards);
				 pc3.kagitAta(cards);
				 
				 for(int i=0; i<4; i++)
				 {
					 pc1.cards4[i].button.setIcon(SetColors.selectedBackSideY);			//image yanlamasýna gösteriliyor
					 pc2.cards4[i].button.setIcon(SetColors.selectedBackSide);
					 pc3.cards4[i].button.setIcon(SetColors.selectedBackSideY);			//image yanlamasýna gösteriliyor
				 }
				 
				 System.out.println("Yeni Kagitlar atandý.");
				 
				 for(int i=0; i<4; i++)
					 playerCardsPanel.add(player.cards4[i].button);
				 for(int i=0; i<4; i++)
					 pc1CardsP.add(pc1.cards4[i].button);
				 for(int i=0; i<4; i++)
					 pc2CardsP.add(pc2.cards4[i].button);
				 for(int i=0; i<4; i++)
					 pc3CardsP.add(pc3.cards4[i].button);
				 
				Dimension preferredSizePlayerB = new Dimension(70, 96);
				Dimension preferredSizePc1Pc3B = new Dimension(96, 63);
				Dimension preferredSizePc2B = new Dimension(63, 96);
				
				for(int i=0; i<4; i++)
				{
					(player.cards4[i].button).setPreferredSize(preferredSizePlayerB);
					(pc1.cards4[i].button).setPreferredSize(preferredSizePc1Pc3B);
					(pc2.cards4[i].button).setPreferredSize(preferredSizePc2B);
					(pc3.cards4[i].button).setPreferredSize(preferredSizePc1Pc3B);
				}
				System.out.println("yeni atanan kagitlar yerleþtirildi.");
				
				for(int i=0; i<4; i++)
				{
					player.cards4[i].button.addActionListener(new ActionListenerSelectedCard());
					pc1.cards4[i].button.addActionListener(new ActionListenerSelectedCard());
					pc2.cards4[i].button.addActionListener(new ActionListenerSelectedCard());
					pc3.cards4[i].button.addActionListener(new ActionListenerSelectedCard());
				}
				System.out.println("Yeni atanan kagitlara actionListener lar eklendi");
			}
	}
	public boolean isCards4Empty(Card []cards4){
		for(int i=0; i<4; i++)
			if(cards4[i].atilmis == false)
				return false;
		System.out.println("pc3.cards4 is empty.");

		return true;
	}
	
	public Card pcPlay(Player pc, int t){
		
		//sleep();
				
		if(t == 4)
		{
			for(int i=0; i<4; i++)
				if(pc.cards4[i].atilmis == true)
					continue;
				else{
					pc.cards4[i].button.setEnabled(false);
					pc.cards4[i].atilmis = true;
					return pc.cards4[i];
				}
		}
		  
		
			if(showingCard.getIcon() == (new ImageIcon("src\\cards\\bos.jpg")))		
			{
				int rand1;
				int temp = 0;
				for(int i=0; i<4; i++){
					if(pc.cards4[i].atilmis == true)
						continue;
					if(pc.cards4[i].number != 11)
						temp = 1;
				}
				if(temp == 0){
					for(int i=0; i<4; i++)
						if(pc.cards4[i].atilmis == true)
							continue;
						else{
							pc.cards4[i].atilmis = true;
							pc.cards4[i].button.setEnabled(false);
							return pc.cards4[i];
						}
				}
				do{
					Random rand = new Random();
					rand1 = rand.nextInt(4);
				}while(pc.cards4[rand1].number == 11 || pc.cards4[rand1].atilmis == true);
				pc.cards4[rand1].atilmis = true;
				pc.cards4[rand1].button.setEnabled(false);
				return pc.cards4[rand1];
				
			}
			else{
				int index = -1;
				int rand1;
				String ortadakiSayi = showingCard.getName();
				System.out.println("\n\nortadakissayi: " + ortadakiSayi);
				for(int i=0; i<4; i++){
					if(pc.cards4[i].atilmis == true){
						continue;
					}
					if((pc.cards4[i].button.getName()).equals(ortadakiSayi)){
						index = i;
						pc.cards4[index].atilmis = true;
						pc.cards4[index].button.setEnabled(false);

						return pc.cards4[index];
						
					}

				}
				
				if(index == -1){
					for(int i=0; i<4; i++){
						if(pc.cards4[i].atilmis == true)
							continue;
						if(pc.cards4[i].button.getName() == "11")
						{
							index = i;
							pc.cards4[index].atilmis = true;
							pc.cards4[index].button.setEnabled(false);
							return pc.cards4[index];
						}	
					}
				}
				if(index == -1)
				{
					do{
						Random rand = new Random();
						rand1 = rand.nextInt(4);
					}while(pc.cards4[rand1].atilmis == true);
					pc.cards4[rand1].atilmis = true;
					pc.cards4[rand1].button.setEnabled(false);
					return pc.cards4[rand1];
				}	
			}

		
		System.out.println("pcPlay fonksiyonu bozuk!");
		return null;
	}


public ImageIcon getCardImage(Card card){
	System.out.println("getCardImage a girdi.");
	
	if(card == null)
		System.out.println("Error: getCardImage e gelen card null.");
	else{
		ImageIcon cardImage = new ImageIcon();
		if(card.type.equals("maca"))
		{
			if (card.number == 1) {cardImage = new ImageIcon(("src\\cards\\maca\\maca1.jpg")); }
			else if (card.number == 2)  {cardImage = new ImageIcon(("src\\cards\\maca\\maca2.jpg")); }
			else if (card.number == 3) {cardImage = new ImageIcon(("src\\cards\\maca\\maca3.jpg")); }
			else if (card.number == 4) {cardImage = new ImageIcon(("src\\cards\\maca\\maca4.jpg")); }
			else if (card.number == 5) {cardImage = new ImageIcon(("src\\cards\\maca\\maca5.jpg")); }
			else if (card.number == 6) {cardImage = new ImageIcon(("src\\cards\\maca\\maca6.jpg"));}
			else if (card.number == 7) cardImage = new ImageIcon(("src\\cards\\maca\\maca7.jpg"));
			else if (card.number == 8) cardImage = new ImageIcon(("src\\cards\\maca\\maca8.jpg"));
			else if (card.number == 9) cardImage = new ImageIcon(("src\\cards\\maca\\maca9.jpg"));
			else if (card.number == 10) cardImage = new ImageIcon(("src\\cards\\maca\\maca10.jpg"));
			else if (card.number == 11) cardImage = new ImageIcon(("src\\cards\\maca\\maca11.jpg"));
			else if (card.number == 12) cardImage = new ImageIcon(("src\\cards\\maca\\maca12.jpg"));
			else if (card.number == 13) cardImage = new ImageIcon(("src\\cards\\maca\\maca13.jpg"));
			
			return cardImage;
		}
		else if(card.type.equals("karo"))
		{	
			if (card.number == 1) {cardImage = new ImageIcon("src\\cards\\karo\\karo1.jpg"); }
			else if (card.number == 2)  {cardImage = new ImageIcon("src\\cards\\karo\\karo2.jpg"); }
			else if (card.number == 3) {cardImage = new ImageIcon("src\\cards\\karo\\karo3.jpg"); }
			else if (card.number == 4) {cardImage = new ImageIcon("src\\cards\\karo\\karo4.jpg"); }
			else if (card.number == 5) {cardImage = new ImageIcon("src\\cards\\karo\\karo5.jpg"); }
			else if (card.number == 6) {cardImage = new ImageIcon("src\\cards\\karo\\karo6.jpg");}
			else if (card.number == 7) cardImage = new ImageIcon("src\\cards\\karo\\karo7.jpg");
			else if (card.number == 8) cardImage = new ImageIcon("src\\cards\\karo\\karo8.jpg");
			else if (card.number == 9) cardImage = new ImageIcon("src\\cards\\karo\\karo9.jpg");
			else if (card.number == 10) cardImage = new ImageIcon("src\\cards\\karo\\karo10.jpg");
			else if (card.number == 11) cardImage = new ImageIcon("src\\cards\\karo\\karo11.jpg");
			else if (card.number == 12) cardImage = new ImageIcon("src\\cards\\karo\\karo12.jpg");
			else if (card.number == 13) cardImage = new ImageIcon("src\\cards\\karo\\karo13.jpg");
			
			return cardImage;
		}
		else if(card.type.equals("kupa"))
		{	
				if (card.number == 1) {cardImage = new ImageIcon("src\\cards\\kupa\\kupa1.jpg"); }
				else if (card.number == 2)  {cardImage = new ImageIcon("src\\cards\\kupa\\kupa2.jpg"); }
				else if (card.number == 3) {cardImage = new ImageIcon("src\\cards\\kupa\\kupa3.jpg"); }
				else if (card.number == 4) {cardImage = new ImageIcon("src\\cards\\kupa\\kupa4.jpg"); }
				else if (card.number == 5) {cardImage = new ImageIcon("src\\cards\\kupa\\kupa5.jpg"); }
				else if (card.number == 6) {cardImage = new ImageIcon("src\\cards\\kupa\\kupa6.jpg");}
				else if (card.number == 7) cardImage = new ImageIcon("src\\cards\\kupa\\kupa7.jpg");
				else if (card.number == 8) cardImage = new ImageIcon("src\\cards\\kupa\\kupa8.jpg");
				else if (card.number == 9) cardImage = new ImageIcon("src\\cards\\kupa\\kupa9.jpg");
				else if (card.number == 10) cardImage = new ImageIcon("src\\cards\\kupa\\kupa10.jpg");
				else if (card.number == 11) cardImage = new ImageIcon("src\\cards\\kupa\\kupa11.jpg");
				else if (card.number == 12) cardImage = new ImageIcon("src\\cards\\kupa\\kupa12.jpg");
				else if (card.number == 13) cardImage = new ImageIcon("src\\cards\\kupa\\kupa13.jpg");
				
				return cardImage;
		}
		else if(card.type.equals("sinek"))
		{			
				if (card.number == 1) {cardImage = new ImageIcon("src\\cards\\sinek\\sinek1.jpg"); }
				else if (card.number == 2)  {cardImage = new ImageIcon("src\\cards\\sinek\\sinek2.jpg"); }
				else if (card.number == 3) {cardImage = new ImageIcon("src\\cards\\sinek\\sinek3.jpg"); }
				else if (card.number == 4) {cardImage = new ImageIcon("src\\cards\\sinek\\sinek4.jpg"); }
				else if (card.number == 5) {cardImage = new ImageIcon("src\\cards\\sinek\\sinek5.jpg"); }
				else if (card.number == 6) {cardImage = new ImageIcon("src\\cards\\sinek\\sinek6.jpg");}
				else if (card.number == 7) cardImage = new ImageIcon("src\\cards\\sinek\\sinek7.jpg");
				else if (card.number == 8) cardImage = new ImageIcon("src\\cards\\sinek\\sinek8.jpg");
				else if (card.number == 9) cardImage = new ImageIcon("src\\cards\\sinek\\sinek9.jpg");
				else if (card.number == 10) cardImage = new ImageIcon("src\\cards\\sinek\\sinek10.jpg");
				else if (card.number == 11) cardImage = new ImageIcon("src\\cards\\sinek\\sinek11.jpg");
				else if (card.number == 12) cardImage = new ImageIcon("src\\cards\\sinek\\sinek12.jpg");
				else if (card.number == 13) cardImage = new ImageIcon("src\\cards\\sinek\\sinek13.jpg");
				
				return cardImage;
		}
		else
			System.out.println("getCardImage() -> card.type belli deðil ?");
	}
	return null;
}

public class SoundClipTest {
	   
	   // Constructor
	   public SoundClipTest() {
		   if(Main.sounds.getState() == true)
		   {
			   try {
				   // Open an audio input stream.
				   URL url = this.getClass().getClassLoader().getResource("kartAtma.wav");
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

}
