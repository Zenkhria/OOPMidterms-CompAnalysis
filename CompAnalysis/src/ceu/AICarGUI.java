import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AICar 
{
    private JFrame frame;
    private JPanel raceTrack;
    private JLabel userCarLabel;
    private JLabel aiCarLabel;
    private int raceDistance = 400; // Set your race distance

    private int userSpeed;
    private int aiSpeed;
    private int userPosition;
    private int aiPosition;
    private int userGears;
    private int aiGears;

    public RacingGameGUI() 
		{
        frame = new JFrame( "Racing Game" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setLayout( new BorderLayout() );

        raceTrack = new JPanel();
        userCarLabel = new JLabel( "User Car" );
        aiCarLabel = new JLabel( "AI Car" );
        userCarLabel.setHorizontalAlignment( JLabel.CENTER );
        aiCarLabel.setHorizontalAlignment( JLabel.CENTER );

        frame.add( raceTrack, BorderLayout.CENTER );
        frame.add( userCarLabel, BorderLayout.NORTH );
        frame.add( aiCarLabel, BorderLayout.SOUTH );

        initializeGame();

        Timer timer = new Timer( 100, new ActionListener() 
				{
            @Override
            public void actionPerformed( ActionEvent e )
						{
                simulateRace();
                updateCarsPosition();
                checkForWinner();
            }
        } );

        timer.start();
        frame.setSize( 800, 400 );
        frame.setVisible( true );
    }

    private void initializeGame() 
		{
        userSpeed = 0;
        aiSpeed = 0;
        userPosition = 0;
        aiPosition = 0;
        userGears = 1;
        aiGears = 1;
    }

    private void simulateRace() 
		{
        Random random = new Random();
        userSpeed = random.nextInt( 11 );
        aiSpeed = random.nextInt( 11 );
        if ( userGears < 6 ) 
				{
            userSpeed += userGears * 5; // Simulate gear shift for the user
        }
        aiSpeed += aiGears * 5; // Simulate AI gear shift
    }

    private void updateCarsPosition() 
		{
        userPosition += userSpeed;
        aiPosition += aiSpeed;
        userCarLabel.setText( "User Car: " + userPosition + "m" );
        aiCarLabel.setText( "AI Car: " + aiPosition + "m" );
    }

    private void checkForWinner() 
		{
        if ( userPosition >= raceDistance || aiPosition >= raceDistance ) 
				{
            Timer timer = ( Timer ) frame.getFocusOwner();
            timer.stop();
            if ( userPosition >= raceDistance && aiPosition >= raceDistance ) 
						{
                JOptionPane.showMessageDialog( frame, "It's a tie!" );
            } 
						else if ( userPosition >= raceDistance ) 
						{
                JOptionPane.showMessageDialog( frame, "You win!" );
            } 
						else 
						{
                JOptionPane.showMessageDialog( frame, "AI wins!" );
            }
        }
    }

    public static void main( String[] args ) 
		{
        SwingUtilities.invokeLater( () -> new RacingGameGUI() );
    }
}
