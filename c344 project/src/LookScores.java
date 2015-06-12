import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.Border;

public class LookScores extends JFrame{

	public int sortedPoints[];
	
	LookScores(){
		super("View Scores");
		setBounds(350,250,600,600);
		setLocationRelativeTo(null); 
		Dimension minSize = new Dimension(550,550);
		setMinimumSize(minSize);
		setVisible(true);
		
		setLayout(new GridLayout(2,2,16,16));
		
		Border blackLine = BorderFactory.createLineBorder(Color.black);
		
		JPanel playerP = new JPanel(new GridLayout(2,2,10,10));
		JPanel pc1P = new JPanel(new GridLayout(2,2,10,10));
		JPanel pc2P = new JPanel(new GridLayout(2,2,10,10));
		JPanel pc3P = new JPanel(new GridLayout(2,2,10,10));
		
		playerP.setBorder(blackLine);
		pc1P.setBorder(blackLine);
		pc2P.setBorder(blackLine);
		pc3P.setBorder(blackLine);
		
		add(playerP);
		add(pc1P);
		add(pc2P);
		add(pc3P);
		
		Font f = new Font("Arial", Font.TRUETYPE_FONT, 19);
		
		JLabel playerPoints = new JLabel(NewGame.player.name + "'s points: ");
		JLabel pc1Points = new JLabel(NewGame.pc1.name + "'s points: ");
		JLabel pc2Points = new JLabel(NewGame.pc2.name + "'s points: ");
		JLabel pc3Points = new JLabel(NewGame.pc3.name + "'s points: ");
		JLabel sira = new JLabel("Succession: ");
		JLabel sira1 = new JLabel("Succession: ");
		JLabel sira2 = new JLabel("Succession: ");
		JLabel sira3 = new JLabel("Succession: ");
		
		JLabel pp = new JLabel();
		JLabel pc1p = new JLabel();
		JLabel pc2p = new JLabel();
		JLabel pc3p = new JLabel();		
		
		playerPoints.setFont(f);
		pc1Points.setFont(f);
		pc2Points.setFont(f);
		pc3Points.setFont(f);
		sira.setFont(f);
		sira1.setFont(f);
		sira2.setFont(f);
		sira3.setFont(f);
		
		pp.setFont(f);
		pc1p.setFont(f);
		pc2p.setFont(f);
		pc3p.setFont(f);
		
		if(DSS.scoringSystem == "numberOfCards")
		{	
			for(int i=0; i<4; i++)
			{
				NewGame.player.points = 0;
				NewGame.pc1.points = 0;
				NewGame.pc2.points = 0;
				NewGame.pc3.points = 0;
			}
			evaluate1();
		}
		
		else if(DSS.scoringSystem == "worthOfCards")
		{
			for(int i=0; i<4; i++)
			{
				NewGame.player.points = 0;
				NewGame.pc1.points = 0;
				NewGame.pc2.points = 0;
				NewGame.pc3.points = 0;
			}
			evaluate2(NewGame.player);
			evaluate2(NewGame.pc1);
			evaluate2(NewGame.pc2);
			evaluate2(NewGame.pc3);
			kartFazlasiKimde(NewGame.player, NewGame.pc1, NewGame.pc2, NewGame.pc3);
		}
		else
			System.out.println("scoringSystem = ?");
		
		
		pp.setText("" + NewGame.player.points);
		pc1p.setText("" + NewGame.pc1.points);
		pc2p.setText("" + NewGame.pc2.points);
		pc3p.setText("" + NewGame.pc3.points);
		
		sortedPoints = new int[4];
		sortedPoints = sortPoints();
		int indexP = -1, indexpc1 = -1, indexpc2 = -1, indexpc3 = -1;

		for(int i=0; i<4; i++)
			if(NewGame.player.points == sortedPoints[i])
			{
				indexP = i;
				break;
			}
		for(int i=0; i<4; i++)
			if(NewGame.pc1.points == sortedPoints[i])
			{
				indexpc1 = i;
				break;
			}
		for(int i=0; i<4; i++)
			if(NewGame.pc2.points == sortedPoints[i])
			{
				indexpc2 = i;
				break;
			}
		for(int i=0; i<4; i++)
			if(NewGame.pc3.points == sortedPoints[i])
			{
				indexpc3 = i;
				break;
			}
		NewGame.player.siralama = 4 - indexP;
		NewGame.pc1.siralama = 4 - indexpc1;
		NewGame.pc2.siralama = 4 - indexpc2;
		NewGame.pc3.siralama = 4 - indexpc3;
		
		int flag = 1;
		for(int i=0; i<4; i++)
			if(sortedPoints[i] != 0)
				flag = 0;
		if(flag == 1)
		{
		
		playerP.add(playerPoints);
		playerP.add(pp);
		playerP.add(sira);
		playerP.add(new JLabel("-"));
		
		pc1P.add(pc1Points);
		pc1P.add(pc1p);
		pc1P.add(sira1);
		pc1P.add(new JLabel("-"));
		
		pc2P.add(pc2Points);
		pc2P.add(pc2p);
		pc2P.add(sira2);
		pc2P.add(new JLabel("-"));
		
		pc3P.add(pc3Points);
		pc3P.add(pc3p);
		pc3P.add(sira3);
		pc3P.add(new JLabel("-"));
		
		}
		else
		{
			JLabel pl = new JLabel(NewGame.player.siralama + ".");
			JLabel pc1l = new JLabel(NewGame.pc1.siralama + ".");
			JLabel pc2l = new JLabel(NewGame.pc2.siralama + ".");
			JLabel pc3l = new JLabel(NewGame.pc3.siralama + ".");
			
			pl.setFont(f);
			pc1l.setFont(f);
			pc2l.setFont(f);
			pc3l.setFont(f);
			
			playerP.add(playerPoints);
			playerP.add(pp);
			playerP.add(sira);
			playerP.add(pl);
			
			pc1P.add(pc1Points);
			pc1P.add(pc1p);
			pc1P.add(sira1);
			pc1P.add(pc1l);
			
			pc2P.add(pc2Points);
			pc2P.add(pc2p);
			pc2P.add(sira2);
			pc2P.add(pc2l);
			
			pc3P.add(pc3Points);
			pc3P.add(pc3p);
			pc3P.add(sira3);
			pc3P.add(pc3l);
		}
		
		System.out.println("Player.pisti: " + NewGame.player.pisti);
		System.out.println("Player.pistiJ: " + NewGame.player.pistiJ);
		System.out.println("pc1.pisti: " + NewGame.pc1.pisti);
		System.out.println("pc1.pistiJ: " + NewGame.pc1.pistiJ);
		System.out.println("pc2.pisti: " + NewGame.pc2.pisti);
		System.out.println("pc2.pistiJ: " + NewGame.pc2.pistiJ);
		System.out.println("pc3.pisti: " + NewGame.pc3.pisti);
		System.out.println("pc3.pistiJ: " + NewGame.pc3.pistiJ);
	}
	
	public int[] sortPoints()
	{
		int pp = NewGame.player.points;
		int pc1p = NewGame.pc1.points;
		int pc2p = NewGame.pc2.points;
		int pc3p = NewGame.pc3.points;
		
		int [] unsortedPoints = new int [4];
		unsortedPoints[0] = pp;
		unsortedPoints[1] = pc1p;
		unsortedPoints[2] = pc2p;
		unsortedPoints[3] = pc3p;
		
		
		Arrays.sort(unsortedPoints);
		System.out.println("Sýralý puanlar: " + Arrays.toString(unsortedPoints));
		System.out.println("\n");
		
		return unsortedPoints; // Now, it is sorted.
		
	}
	
	public void evaluate1()
	{
		NewGame.player.points = NewGame.player.gainedCards.size();
		NewGame.pc1.points = NewGame.pc1.gainedCards.size();
		NewGame.pc2.points = NewGame.pc2.gainedCards.size();
		NewGame.pc3.points = NewGame.pc3.gainedCards.size();
		
		NewGame.player.points = NewGame.player.pisti * 10 + NewGame.player.points;
		NewGame.player.points = NewGame.player.pistiJ * 20 + NewGame.player.points;
		NewGame.pc1.points = NewGame.pc1.pisti * 10 + NewGame.pc1.points;
		NewGame.pc1.points = NewGame.pc1.pistiJ * 20 + NewGame.pc1.points;
		NewGame.pc2.points = NewGame.pc2.pisti * 10 + NewGame.pc2.points;
		NewGame.pc2.points = NewGame.pc2.pistiJ * 20 + NewGame.pc2.points;
		NewGame.pc3.points = NewGame.pc3.pisti * 10 + NewGame.pc3.points;
		NewGame.pc3.points = NewGame.pc3.pistiJ * 20 + NewGame.pc3.points;
		
	}
	public void kartFazlasiKimde(Player player, Player pc1, Player pc2, Player pc3)
	{
		int p1, p2, p3, p4;
		
		p1 = player.gainedCards.size();
		p2 = pc1.gainedCards.size();
		p3 = pc2.gainedCards.size();
		p4 = pc3.gainedCards.size();
		
		if(p1 > p2 && p1 > p3 && p1 > p4)
			player.points += 3;
		else if(p2 > p1 && p2 > p3 && p2 > p4)
			pc1.points += 3;
		else if(p3 > p1 && p3 > p2 && p3 > p4)
			pc2.points += 3;
		else if(p4 > p1 && p4 > p2 && p4 > p3)
			pc3.points += 3;
		else
			System.out.println("kartFazlasiKimde fonk. da sorun var");
		
	}
	public void evaluate2(Player p)
	{		
		for(int i=0; i<p.gainedCards.size(); i++)
		{
			if(p.gainedCards.get(i).number == 1 || p.gainedCards.get(i).number == 11)
				p.points++;
			else if(p.gainedCards.get(i).number == 2 && p.gainedCards.get(i).type.equals("sinek"))
				p.points += 2;
			else if(p.gainedCards.get(i).number == 10 && p.gainedCards.get(i).type.equals("karo"))
				p.points += 3;				
		}
		
		p.points = p.pisti * 10 + p.points;
		p.points = p.pistiJ * 20 + p.points;
		
	}
}
