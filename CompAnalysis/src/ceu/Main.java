package ceu;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main
{
	static Scanner sc = new Scanner( System.in );
	static int rerunCount = 0;
	static int seconds = 20;
	static InputValidation validation = new InputValidation();
	static String userRegion;

	public static void main( String[] args ) throws IOException, InterruptedException
	{
		while ( true )
		{	
			if ( rerunCount > 0 )
			{
				System.out.println( "\n" );
				Timer.run( rerunCount, seconds );
				System.out.println( "\n" );
			}
	
			// WELCOME MESSAGE
			System.out.println( "\nPROFILYSIS: COMPREHENSIVE USER ANALYSIS SOFTWARE");
			System.out.println( "Welcome! To start your analysis, provide the following details. ");		
			
			// CREATING NEW USER DATA OBJECT
			UserData user = new UserData();

			// FULL NAME INPUT & VALIDATION
			user.setfullName();	
			if ( !validation.FullName( user.getfullName() ) )
			{
				rerunCount++;
				if ( rerunCount > 1 )
				{
					seconds += 5;
				}
				continue;
			};

			// ADDRESS INPUT & VALIDATION
			user.setAddress();
			if ( !validation.Address( user.getAddress() ) )
			{
				rerunCount++;
				if ( rerunCount > 1 )
				{
					seconds += 5;
				}
				continue;
			};

			// COURSE INPUT & VALIDATION
			user.setCourse();
			if ( !validation.Course( user.getCourse() ) )
			{
				rerunCount++;
				if ( rerunCount > 1 )
				{
					seconds += 5;
				}
				continue;
			};

			// FAVE MOVIE INPUT & VALIDATION
			user.setFavMovie();
			if ( !validation.FavMovie( user.getFavMovie() ) )
			{
				rerunCount++;
				if ( rerunCount > 1 )
				{
					seconds += 5;
				}
				continue;
			};

			// FAVE MOVIE CHAR INPUT & VALIDATION
			user.setFavMovieChar();
			if ( !validation.FavMovieChar( user.getFavMovieChar() ) )
			{
				rerunCount++;
				if ( rerunCount > 1 )
				{
					seconds += 5;
				}
				continue;
			};

			// FAVE FOOD INPUT & VALIDATION
			user.setFavFood();
			if ( !validation.FavFood( user.getFavFood() ) )
			{
				rerunCount++;
				if ( rerunCount > 1 )
				{
					seconds += 5;
				}
				continue;
			};

			// FAVE NUMBER INPUT & VALIDATION
			try
			{
				user.setFavNum();
				System.out.println( "FAVORITE NUMBER RECORDED." );
			}
			catch ( Exception InputMismatchException )
			{
				System.out.println( "Invalid Number. Rerunning Program..." );
				rerunCount++;
				if ( rerunCount > 1 )
				{
					seconds += 5;
				}
				continue;
			}

			// BIRTH DATE INPUT & VALIDATION
			user.setBirthDate();
			if ( !validation.BirthDate( user.getBirthDate() ) )
			{
				rerunCount++;
				if ( rerunCount > 1 )
				{
					seconds += 5;
				}
				continue;
			};

			// BIRTH PLACE INPUT & VALIDATION
			user.setBirthPlace();
			if ( !validation.BirthPlace( user.getBirthPlace() ) )
			{
				rerunCount++;
				if ( rerunCount > 1 )
				{
					seconds += 5;
				}
				continue;
			};

			// PREFERRED NO. OF CHILDREN INPUT & VALIDATION
			try
			{
				user.setPrefChildCount();
				System.out.println( "PREFERRED NO. OF CHILDREN RECORDED." );
			}
			catch ( Exception InputMismatchException )
			{
				System.out.println( "Invalid Number. Rerunning Program..." );
				rerunCount++;
				if ( rerunCount > 1 )
				{
					seconds += 5;
				}
				continue;
			}
			
			// EVALUATION
			System.out.println( "\nEVALUATION");
			Evaluation evaluate = new Evaluation();

			// GET THE REGION OF USER'S ADDRESS
			userRegion = evaluate.getRegion( user.getAddress() );
			
			// GET THE CLASSIFICATION OF USER'S COURSE
			String courseCategory = evaluate.getCourseCategory( user.getCourse() );

			// GET NO. OF CONSONANTS & VOWELS IN USER'S FULL NAME
			int consonantCount = evaluate.fullNameConsonantCount( user.getfullName() );
			int vowelCount = evaluate.fullNameVowelCount( user.getfullName() );

			// GET NO. OF WORDS IN USER'S FULL NAME
			int wordCount = evaluate.fullNameWordCount( user.getfullName() );
			
			// GET USER'S AGE
			Date currentDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
			long userAge = 0;
			try
			{
				Date userBirthDate = dateFormat.parse( user.getBirthDate() );
				long ageInMillis = currentDate.getTime() - userBirthDate.getTime();
				long years = ageInMillis / ( 365 * 24 * 60 * 60 * 1000L );
				user.setAge( years );
			}
			catch ( ParseException e ) 
			{
			}

			// CHECK IF USER'S AGE IS SENIOR, MID, TEENAGER, CHILD, OR 
			System.out.println( "Age: " + user.getAge() );
			String ageCategory = evaluate.getAgeCategory( user.getAge() );

			// GET ZODIAC SIGN OF THE USER
			String zodiacSign = evaluate.getZodiacSign( user.getBirthDate() );

			// MINI MOVIE MAKER (HARD-CODED)
			String movieCategory = "";
			String characterType = "";
			Character cobb = new Character( "Dominic Cobb", "Main" );
			List<Character> inceptionChars = new ArrayList();
			inceptionChars.add( cobb );
			Movie inception = new Movie( "Inception", 2010, inceptionChars, "Action" );
			List<Movie> movieDatabase= new ArrayList();
			movieDatabase.add( inception );

			// IDENTIFY IF USER'S FAVE MOVIE IS ACTION, COMEDY, DRAMA, OR THRILLER
			for ( Movie movie : movieDatabase )
			{
				if ( user.getFavMovie().equalsIgnoreCase( movie.getMovieName() ) )
				{
					movieCategory = movie.getGenre();
					// IDENTIFY IF USER'S FAVE MOVIE CHARACTER IS A MAIN OR SUPPORTING CHARACTER
					for ( Character character : movie.getCharacters() )
					{
						characterType = character.getCharRole();
					}
				}
			}

			System.out.println( "Movie Genre: " + movieCategory );
			System.out.println( "Movie Character Role: " + characterType );

			// GET THE BINARY, OCTAL, AND HEXADECIMAL VALUES OF FAVE NUMBER
			String binaryValue = evaluate.getFavNumBinary( user.getFavNum() );
			String octalValue = evaluate.getFavNumOctal( user.getFavNum() );
			String hexValue = evaluate.getFavNumHex( user.getFavNum() );

			// PROVIDE PSYCH FEEDBACK BASED ON PREFCHILDNUM
			String psychEval = evaluate.getPsychEval( user.getPrefChildCount() );
			
			// COMPREHENSIVE USER ANALYSIS REPORT
			System.out.println( "\nCOMPREHENSIVE USER ANALYSIS REPORT" );
			String compAnalysisReport = user.getfullName() + " lives in " + user.getAddress() + " which can be found in " + userRegion + 
										". Their course, " +  user.getCourse() + ", is classified under CEU-Makati's " + courseCategory + 
										" . There are " + consonantCount + " consonants, " + vowelCount + " vowels, and " + wordCount + " words in " + user.getFirstName() + "'s full name." +
										" Their age falls under the " + ageCategory + " category. " + user.getFirstName() + "'s zodiac sign is " + zodiacSign + 
										". Their favorite movie, " + user.getFavMovie() + ", falls under the " + movieCategory + " genre. "
										+ "Their favorite movie character, " + user.getFavMovieChar() + ", is a " + characterType + " character. Their favorite number ( " + user.getFavNum() + " ), has a "
										+ "binary value of " + binaryValue + ", an octal value of " + octalValue + ", and a hexadecimal value of " + hexValue + 
										". Based on their preferred number of children ( " + user.getPrefChildCount() + " ), " + psychEval;
			
			// CHECK IF PARAGRAPH IS GREATER THAN 300 LETETRS
			String reportNoWhiteSpace = compAnalysisReport.replaceAll( " ", "" );
			int letterCount = reportNoWhiteSpace.length();
			
			if ( letterCount > 300 )
			{
				System.out.println( "\n" );	
			}
			
			// PROVIDE COMPREHENSIVE USER ANALYSIS REPORT TO USER
			System.out.println( compAnalysisReport );
			System.out.println( "\nLetter Count: " + letterCount );
			
			// GET REPLY FROM USER
			System.out.println( "\nWhat do you think about the report?" );
			System.out.print( ">>> " );
			
			String reply = sc.nextLine();
			
			// CHECK IF USER REPLY IS GREATER THAN 30 WORDS
			String[] words = reply.split( "\\s+" );
			
			int replyWordCount = words.length;
			System.out.println( "Reply word count: " + replyWordCount );	

			if ( replyWordCount > 30 )
			{
				System.out.println( "Do you want to play a game? Yes/No" );
				System.out.println( ">>> " );
				
				String answer = sc.nextLine();
				
				if ( answer.equalsIgnoreCase( "yes" ) )
				{
					RaceCarSimulator raceCarSimulator = new RaceCarSimulator();
					raceCarSimulator.RunGame();				
				}
				else if ( answer.equalsIgnoreCase( "no" ) )
				{
					System.exit( 0 );
				}
				else
				{
					System.out.println( "Invalid Input." );
				}
			}
			else if ( replyWordCount == 30 )
			{
				System.exit( 0 );
			}
			else if ( replyWordCount < 30 )
			{
				System.out.println( "\nMINESWEEPER" );
				MineSweeper minesweeper = new MineSweeper( 8, 8, 10 );
				minesweeper.playGame();	
				sc.close();
				System.exit( 0 );
			}
		}
	}
}
