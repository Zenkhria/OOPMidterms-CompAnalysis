package.ceu;

import java.util.Scanner;
import java.util.Random;

public class AICar 
{
    public static void main( String[] args ) 
    {
        Scanner scanner = new Scanner( System.in );
        Random random = new Random();

        // Get the race distance from the user
        System.out.print( "Enter the race distance in meters: " );
        int raceDistance = scanner.nextInt();

        // Get the type of the user's car (automatic or manual)
        System.out.print( "Enter the type of your car ( automatic/manual ): " );
        String userCarType = scanner.next();
        int userGears = 1; // For a manual car

        // Initialize AI's car
        int aiGears = 1; // AI's car always starts in 1st gear

        // Initialize variables for car speeds and positions
        int userSpeed = 0;
        int aiSpeed = 0;
        int userPosition = 0;
        int aiPosition = 0;

        // Countdown timer
        for ( int i = 3; i >= 1; i-- ) 
        {
            System.out.println( "Race starts in " + i );
            try 
            {
                Thread.sleep( 1000 ); // Sleep for 1 second
            } catch ( InterruptedException e ) 
            {
                e.printStackTrace();
            }
        }
        System.out.println( "Go!" );

        boolean userHeatedUp = false;
        boolean aiHeatedUp = false;
        double heatUpProbability = 0.2; // 20% chance of heating up

        while ( userPosition < raceDistance && aiPosition < raceDistance ) 
        {
            // Simulate acceleration
            int userAcceleration = random.nextInt( 11 ); // 0 to 10
            int aiAcceleration = random.nextInt( 11 ); // 0 to 10

            // Simulate heat-up probability
            if ( random.nextDouble() < heatUpProbability ) 
            {
                userHeatedUp = true;
                System.out.println( "Your car heated up!" );
            }
            if ( random.nextDouble() < heatUpProbability ) 
            {
                aiHeatedUp = true;
                System.out.println( "AI's car heated up!" );
            }

            if ( !userHeatedUp ) 
            {
                userSpeed += userAcceleration;
                if ( "manual".equalsIgnoreCase( userCarType ) && userGears < 6 ) 
                {
                    userSpeed += userGears * 10; // Manual gear shift
                }
            }

            if ( !aiHeatedUp ) 
            {
                aiSpeed += aiAcceleration;
                aiSpeed += aiGears * 10; // AI always shifts up
            }

            userPosition += userSpeed;
            aiPosition += aiSpeed;

            // Display the current status
            System.out.println( "User: Position=" + userPosition + "m, Speed=" + userSpeed + "m/s, Gear=" + userGears );
            System.out.println( "AI: Position=" + aiPosition + "m, Speed=" + aiSpeed + "m/s, Gear=" + aiGears );
        }

        // Determine the winner
        if ( userPosition >= raceDistance && aiPosition >= raceDistance ) 
        {
            System.out.println( "It's a tie!" );
        } 
        else if ( userPosition >= raceDistance ) 
        {
            System.out.println( "You win!" );
        } 
        else 
        {
            System.out.println( "AI wins!" );
        }
    }
}
