package ceu;
import java.util.Scanner;

import javax.swing.JFrame;

import java.util.Scanner;

public class RaceCarSimulator extends JFrame 
{	
	public RaceCarSimulator()
	{	
	}
	
	public void RunGame() throws InterruptedException {
		Race race = new Race();		
		
        JFrame app=new JFrame();
        app.add(race);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(500, race.getDistance());
        app.setVisible(true);
	}
}