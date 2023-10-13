package ceu;
import java.util.Scanner;
import java.util.Date; 
import com.fasterxml.jackson.databind.*;

public class Main{
	static Scanner sc = new Scanner( System.in );
	static int rerunCount = 0;
	public static void main( String[] args ) 
	{
		while ( true )
		{
			// WELCOME MESSAGE
			System.out.println( "\nPROFILYSIS: COMPREHENSIVE USER ANALYSIS SOFTWARE");
			System.out.println( "\nWelcome! To start your analysis, provide the following details. ");

			// CREATING NEW USER DATA OBJECT
			UserData user = new UserData();
			InputValidation validation = new InputValidation();

			// FULL NAME INPUT & VALIDATION
			System.out.print( "Full Name: " );
			String fullName = sc.nextLine();

			if ( validation.FullName() == true )
			{
				user.setfullName( fullName );
			}
			else
			{
				rerunCount++;
				// TODO: INSERT TIMER LOGIC
				// RECOMMENDATION: MAKE METHOD FOR THE LOGIC IN THIS ELSE BLOCK. 
				continue;
			}

			// ADDRESS INPUT & VALIDATION
			System.out.println( "Address: " );
			String address = sc.nextLine(); // FIXME: Idk how to fetch data from an API yet.

			if ( validation.Address() == true )
			{
				user.setAddress( address );
			}
			else
			{
				rerunCount++;
				// TODO: INSERT TIMER LOGIC
				// RECOMMENDATION: MAKE METHOD FOR THE LOGIC IN THIS ELSE BLOCK. 
				continue;
			}

			// COURSE INPUT & VALIDATION
			System.out.println( "Course: " );
			String course = sc.nextLine();

			if ( validation.Course() == true )
			{
				user.setCourse( course );
			}
			else
			{
				rerunCount++;
				// TODO: INSERT TIMER LOGIC
				// RECOMMENDATION: MAKE METHOD FOR THE LOGIC IN THIS ELSE BLOCK. 
				continue;
			}

			// FAVE MOVIE INPUT & VALIDATION
			System.out.println( "Favorite Movie (from 2000-2023): " );
			String favMovie = sc.nextLine();
			if ( validation.FavMovie() == true )
			{
				user.setFavMovie( favMovie );
			}
			else
			{
				rerunCount++;
				// TODO: INSERT TIMER LOGIC
				// RECOMMENDATION: MAKE METHOD FOR THE LOGIC IN THIS ELSE BLOCK. 
				continue;
			}

			// FAVE FOOD INPUT & VALIDATION
			System.out.println( "Favorite Food: " );
			String favFood = sc.nextLine();
			if ( validation.FavFood() == true )
			{
				user.setFavFood( favFood );
			}
			else
			{
				rerunCount++;
				// TODO: INSERT TIMER LOGIC
				// RECOMMENDATION: MAKE METHOD FOR THE LOGIC IN THIS ELSE BLOCK. 
				continue;
			}

			// BIRTH DATE INPUT & VALIDATION
			System.out.println( "Birth Date: " );
			Date birthDate = new Date();
			if ( validation.BirthDate() == true )
			{
				user.setBirthDate( birthDate );
			}
			else
			{
				rerunCount++;
				// TODO: INSERT TIMER LOGIC
				// RECOMMENDATION: MAKE METHOD FOR THE LOGIC IN THIS ELSE BLOCK. 
				continue;
			}

			// BIRTH PLACE INPUT & VALIDATION
			System.out.println( "Birth Place: " );
			String birthPlace = sc.nextLine();
			if ( validation.BirthPlace() == true )
			{
				user.setBirthPlace( birthPlace );
			}
			else
			{
				rerunCount++;
				// TODO: INSERT TIMER LOGIC
				// RECOMMENDATION: MAKE METHOD FOR THE LOGIC IN THIS ELSE BLOCK. 
				continue;
			}

			// PREFERRED NO. OF CHILDREN INPUT & VALIDATION
			System.out.println( "Preferred No. of Children: " );
			int prefChildCount = sc.nextInt();
			sc.nextLine();
			if ( validation.PrefChildCount() == true )
			{
				user.setPrefChildCount( prefChildCount );
			}
			else
			{
				rerunCount++;
				// TODO: INSERT TIMER LOGIC
				// RECOMMENDATION: MAKE METHOD FOR THE LOGIC IN THIS ELSE BLOCK. 
				continue;
			}

			// ASSIGN DETAILS TO RESPECTIVE POJO
			// ObjectMapper objectMapper = new ObjectMapper();
			// objectMapper.writeValue( new File( "userdata.json" ), user );

		}

	
	}
}
