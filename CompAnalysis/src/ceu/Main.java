package ceu;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main
{
	static Scanner sc = new Scanner( System.in );
	static int rerunCount = 0;
	static InputValidation validation = new InputValidation();
	static String region;

	public static void main( String[] args ) throws IOException
	{
		while ( true )
		{		
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
				continue;
			};

			// ADDRESS INPUT & VALIDATION
			user.setAddress();
			if ( !validation.Address( user.getAddress() ) )
			{
				rerunCount++;
				continue;
			};

			// COURSE INPUT & VALIDATION
			user.setCourse();
			if ( !validation.Course( user.getCourse() ) )
			{
				rerunCount++;
				continue;
			};

			// FAVE MOVIE INPUT & VALIDATION
			user.setFavMovie();
			if ( !validation.FavMovie( user.getFavMovie() ) )
			{
				rerunCount++;
				continue;
			};

			// FAVE FOOD INPUT & VALIDATION
			user.setFavFood();
			if ( !validation.FavFood( user.getFavFood() ) )
			{
				rerunCount++;
				continue;
			};

			// BIRTH DATE INPUT & VALIDATION
			user.setBirthDate();
			if ( !validation.BirthDate( user.getBirthDate() ) )
			{
				rerunCount++;
				continue;
			};

			// BIRTH PLACE INPUT & VALIDATION
			user.setBirthPlace();
			if ( !validation.BirthPlace( user.getBirthPlace() ) )
			{
				rerunCount++;
				continue;
			};

			// PREFERRED NO. OF CHILDREN INPUT & VALIDATION
			user.setPrefChildCount();
			if ( !validation.PrefChildCount( user.getPrefChildCount() ) )
			{
				rerunCount++;
				continue;
			};
			
			System.out.println( "EVALUATION");
			// GET THE REGION OF USER'S ADDRESS
			// FIXME: Can't run code (access to file denied). Therefore, can't test. Please test.
			try 
			{
				ObjectMapper objectMapper = new ObjectMapper();
				JsonNode rootNode = objectMapper.readTree( new File( "C:\\Users\\user\\Favorites\\Downloads\\Compressed\\Resource" ) );

				for ( JsonNode regionNode : rootNode ) 
				{
					region = regionNode.get( "regionName" ).asText();
					JsonNode citiesNode = regionNode.get( "cities" );

					if ( citiesNode.isArray() && citiesNode.elements().hasNext() ) 
					{
						for ( JsonNode cityNode : citiesNode ) 
						{
							String city = cityNode.asText();
							if ( city.equals( user.getAddress() ) ) 
							{
								System.out.println( "The address " + user.getAddress() + " is in the region " + region );
							}
							else
							{
								System.out.println( "The address " + user.getAddress() + " is not in any region." );
							}
						}
					}
				}
			} 
			catch ( Exception e ) 
			{
					e.printStackTrace();
			}
			
			// GET THE CLASSIFICATION OF USER'S COURSE
			// FIXME: Add more code here
			String courseCategory = null; // <- use this variable 

			// GET NO. OF CONSONANTS & VOWELS IN USER'S FULL NAME
			String fullNameCheck = user.getfullName().toLowerCase();
			fullNameCheck = fullNameCheck.replaceAll( " ", "" );
			fullNameCheck = fullNameCheck.replaceAll( ".", "" );
			
			int consonantCount = 0;
			int  vowelCount = 0;
			
			for ( char letter : fullNameCheck.toCharArray() )
			{
				String letterString = Character.toString( letter );
				if ( letterString.matches( "[b-df-hj-np-tv-z]" ) )
				{
					consonantCount++;
				}
				else if ( letterString.matches( "[aeiou]" ) )
				{
					vowelCount++;
				}
			}

			// GET NO. OF WORDS IN USER'S FULL NAME
			String fullName = user.getfullName();
			String[] wordsInFullName = fullName.split( "\\s+" );
			int fullNameWordCount = wordsInFullName.length;
			
			// CHECK IF USER'S AGE IS SENIOR, MID, TEENAGER, CHILD, OR BABY
			String ageCategory;
			long age = user.getAge();
			if ( age > 0 && age <= 2 )
			{
				ageCategory = "Baby";
			}
			else if ( age <= 12 )
			{
				ageCategory = "Child";
			}
			else if ( age <= 19 )
			{
				ageCategory = "Teenager";
			}
			else if ( age < 65 )
			{
				ageCategory = "Mid";
			}
			else
			{
				ageCategory = "Senior";
			}

			// GET ZODIAC SIGN OF THE USER
			// TODO: Place code here

			// IDENTIFY IF USER'S FAVE MOVIE IS ACTION, COMEDY, DRAMA, OR THRILLER
			// TODO: Place code here

			// IDENTIFY IF USER'S FAVE MOVIE CHARACTER IS A MAIN OR SUPPORTING CHARACTER
			// TODO: Place code here

			// GET THE BINARY, OCTAL, AND HEXADECIMAL VALUES OF FAVE NUMBER
			int favNum = user.getFavNum();
			String binaryValue = Integer.toBinaryString( favNum );
			String octalValue = Integer.toOctalString( favNum );
			String hexadecimalValue = Integer.toHexString( favNum );

			// PROVIDE PSYCH FEEDBACK BASED ON PREFCHILDNUM
			int childCount = user.getPrefChildCount();
			String psychEvaluation = "";
			String diagnosis = "";

			if ( childCount < 0 )
			{
				diagnosis = "Baby Hatred Syndrome (BHS)";
				psychEvaluation = "they hate children and suffer from Baby Hatred Syndrome (BHS).";
			}
			else if ( childCount == 0 )
			{
				diagnosis = "Baby Allergy Syndrome (BAS)";
				psychEvaluation = "they don't want a child and suffer from Baby Allergy Syndrome (BAS).";
			}
			else if ( childCount < 2 )
			{
				diagnosis = "Normal";
				psychEvaluation = "they know the importance of family planning, which is completely normal. No diagnosis.";
			}
			else if ( childCount < 5 )
			{
				diagnosis = "Normal";
				psychEvaluation = "they must be living a comfortable life.";
			}
			else if ( childCount < 15 )
			{
				diagnosis = "Minor Baby Syndrome (MiBS)";
				psychEvaluation = "they are suffering from Minor Baby Syndrome (MiBS).";
			}
			else if ( childCount > 15 )
			{
				diagnosis = "Major Baby Syndrome (BHS)";
				psychEvaluation = "they are suffering from Major Baby Syndrome (MaBS).";
			}
			System.out.println( "Diagnosis: " + diagnosis );

			// PLACEHOLDER VARIABLES
			String userZodiacSign = null;
			String movieCategory = null;
			String characterType = null;
			
			// COMPREHENSIVE USER ANALYSIS REPORT
			System.out.println( "\nCOMPREHENSIVE USER ANALYSIS REPORT" );
			String compAnalysisReport = user.getfullName() + " lives in " + user.getAddress() + "which can be found in " + region + 
										". Their course, " +  user.getCourse() + ", is classified under CEU-Makati's " + courseCategory + 
										" . There are " + consonantCount + " consonants, " + vowelCount + " vowels, and " + fullNameWordCount + " words in " + user.getFirstName() + "'s full name." +
										" Their age falls under the " + ageCategory + " category. " + user.getFirstName() + "'s  zodiac sign is " + userZodiacSign + 
										". Their favorite movie, " + user.getFavMovie() + ", falls under the " + movieCategory + "genre. "
										+ "Their favorite movie character, " + user.getFavMovieChar() + ", is a " + characterType + " character. Their favorite number, " + user.getFavNum() + ", has a "
										+ "binary value of " + binaryValue + ", an octal value of " + octalValue + ", and a hexadecimal value of " + hexadecimalValue + ". Based on " + user.getfullName() + "'s "
										+ "preferred number of children ( " + user.getPrefChildCount() + " ), " + psychEvaluation;
			
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
					AICar.main( args );
				}
				else if ( answer.equalsIgnoreCase( "no" ) )
				{
					System.exit( 0 );
				}
				else
				{
					System.out.println( "Invalid Input." ); // FIXME: Not much of a priority but fix the loop for this if we have spare time.
				}
			}
			else if ( replyWordCount == 30 )
			{
				System.exit( 0 );
			}
			else if ( replyWordCount < 30 )
			{
				MineSweeper minesweeper = new MineSweeper( 8, 8, 10 );
				minesweeper.playGame();			
			}
		}
	}
}
