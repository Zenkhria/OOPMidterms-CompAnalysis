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

class Race{
	private int distance;
	private String carState;
	
	public int getDistance() {
		return this.distance;
	}
		
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public String getCarState() {
		return this.carState;
	}
		
	public void setCarState(String carState) {
		this.carState = carState;
	}	
}

class UserCar{
	
}

class AICar{
	
}