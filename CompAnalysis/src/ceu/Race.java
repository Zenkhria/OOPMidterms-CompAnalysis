package ceu;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;

public class Race extends JPanel implements ActionListener, KeyListener{
	Scanner scan = new Scanner(System.in);
	private int distance;
	private String carState;
	
    private int width = 80;
    private int height = 70;
    private int aiSpeed = 1;
    private int speed = 1;
    private int WIDTH = 500;
    private int HEIGHT;
    private int distanceTracked = 0;
    private int aiDistanceTracked = 0;
    private int shiftGear = 1;
    private int aiShiftGear = 1;
    
    private Rectangle userCar;
    private Rectangle aiCar;
    Timer t;
    
    public Race() throws InterruptedException {
		
    	System.out.print("Input distance: ");

    	while(true) {
    		try {
    			distance = scan.nextInt();
    			
    			break;
    		}catch(InputMismatchException e){
    			System.out.println("Input a valid distance: ");
    			scan.next();
    			}
    	}
    	
    	setDistance(distance);
    	
    	HEIGHT = getDistance(); 	
    	
    	while(true) {
    		
    		System.out.print("Input Car State(Automatic/Manual): ");
    		carState = scan.next();
    		
    		if(carState.equalsIgnoreCase("Manual") || carState.equalsIgnoreCase("Automatic"))
    		{
    			break;
    		}
    	}
    	
    	
    	System.out.println("\nPress [Arrow Up Key] to Move");
    	if(carState.equalsIgnoreCase("Manual")) {
    		System.out.println("Press [Space] to Shift Gears");
    	}
    	System.out.println("5% Chance for Car to Heat Up!");
    	
    	System.out.println();
    	for(int i = 3; i > 0; i--) {
    		System.out.println(i + "\n");
    		Thread.sleep(1500);
    	}
    	
        t = new Timer(100,this);     
        userCar = new Rectangle(WIDTH/2-90,HEIGHT-100,width,height);
        aiCar = new Rectangle(WIDTH/2+10,HEIGHT-100,width,height);
        addKeyListener(this);
        setFocusable(true);
        t.start();
	}

    public void paintComponent(Graphics g){
        super.paintComponents(g);
        
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.white);
        g.fillRect(WIDTH/2-100, 0, 200, HEIGHT);
        g.setColor(Color.red);
        g.fillRect(userCar.x, userCar.y, userCar.width, userCar.height);
        g.setColor(Color.magenta);
        g.fillRect(aiCar.x, aiCar.y, aiCar.width, aiCar.height);
        g.setColor(Color.blue);
        g.drawLine(WIDTH/2, 0, WIDTH/2, HEIGHT);
        g.setColor(Color.gray);
        g.fillRect(WIDTH/2-100, 0, 200, HEIGHT/20);
        g.setColor(Color.black);
        g.drawLine(WIDTH/2, 0, WIDTH/2, HEIGHT/16);
        g.drawString("User", 187, HEIGHT/45);
        g.drawString(Integer.toString(speed), 190, HEIGHT/25);
        g.drawLine(WIDTH/2, 0, WIDTH/2, HEIGHT/16);
        g.drawString("AI", 295, HEIGHT/45);
        g.drawString(Integer.toString(aiSpeed), 290, HEIGHT/25); 

        if(userCar.y <= 17) {
        	g.setColor(Color.black);
        	g.drawString("You Win", 227, 200);
        	
        	t.stop();
        }
        else if(aiCar.y <= 17) {
        	g.setColor(Color.red);
        	g.drawString("You Lose", 227, 300);
        	
        	t.stop();
        }
        
        
    }
    public void actionPerformed(ActionEvent e) {
	        Random rNG = new Random();
	     	int randomMove = rNG.nextInt(100);
	     	
	     	if(randomMove >= 10){
	     		aiMoveUp();     	
            }
	     	else if(randomMove <= 1) {
	     		aiMoveStop();
	     	}
        repaint();
    }

    public void moveUp(){
    	Random chance = new Random();
    	
        if(userCar.y - speed < 0){
            System.out.println("\b");
        }else{
            userCar.y -= speed;
            
            distanceTracked += speed;     
        }
        
        // 5% chance to heat up and stop
        if(chance.nextInt(40) <= 2) {
        	speed = 1;
        	distanceTracked = 0;
        	shiftGear = 1;
    	}
    }
    public void moveStop(){
        if(userCar.y + speed + userCar.height > HEIGHT - 1){
            System.out.println("\b");
        }else{
            userCar.y += speed;
            
            speed = 1;
        	distanceTracked = 0;
        	shiftGear = 1;
        }
    }
    
    public void engineShift(){ 	
	    if(shiftGear < 6) {       	
	        speed += 3;
	       	shiftGear += 1;	    	
    	}
    }
    
    public void autoEngineShift() {
    	if(shiftGear < 6) {       	
	        if(distanceTracked >= 20) {
	        	speed += 3;
	        	distanceTracked = 0;
	        	shiftGear += 1;
	        }
    	}
    }
    
    public void aiMoveUp() {
    	Random chance = new Random();
    	
    	if(aiCar.y - aiSpeed < 0){
            System.out.println("\b");
        }else{
            aiCar.y -= aiSpeed;
            
            aiDistanceTracked += aiSpeed;
            
            if(aiShiftGear < 6) {       	
    	        if(aiDistanceTracked >= 20) {
    	        	aiSpeed += 3;
    	        	aiDistanceTracked = 0;
    	        	aiShiftGear += 1;
    	        }
            }
        }
    	
    	// 3% chance to heat up and stop //for fair AI advantage
    	if(chance.nextInt(60) <= 2) {
        	aiSpeed = 1;
        	aiDistanceTracked = 0;
        	aiShiftGear = 1;
    	}
    }
    
    public void aiMoveStop(){
        if(aiCar.y + aiSpeed + aiCar.height > HEIGHT - 1){
            System.out.println("\b");
        }else{
        	aiSpeed = 1;
        	aiDistanceTracked = 0;
        	aiShiftGear = 1;
        }
    }
    
    @Override
	public void keyTyped(KeyEvent e) {
    	//unimplemented
	}
    
    @Override
    public void keyReleased(KeyEvent e) {
    	//unimplemented
    }
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		
		if(carState.equalsIgnoreCase("Automatic")) {
			switch(key){
				case KeyEvent.VK_UP:
					moveUp();
					autoEngineShift();
					break;
				case KeyEvent.VK_DOWN:
					moveStop();
					autoEngineShift();
					break;
			}
		}
		else if(carState.equalsIgnoreCase("Manual")) {
			switch(key){
            	case KeyEvent.VK_UP:
            		moveUp();
            		break;
            	case KeyEvent.VK_DOWN:
            		moveStop();
            		break;
            	case KeyEvent.VK_SPACE:
            		engineShift();
            		break;
			}
		}
	} 

	public int getDistance() {
		return this.distance;
	}
		
	public void setDistance(int distance) {
		this.distance = distance;
	}
		
	public void setCarState(String carState) {
		this.carState = carState;
	}
}