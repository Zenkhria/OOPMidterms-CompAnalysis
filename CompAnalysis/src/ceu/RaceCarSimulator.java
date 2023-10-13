package ceu;
import java.util.Scanner;
import java.util.Scanner;

public class RaceCarSimulator {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Race race = new Race();	
		System.out.print("");
		
		int distance = scan.nextInt();		
		race.setDistance(distance);
		
		String carState = scan.next();
		race.setCarState(carState);
	}
}
