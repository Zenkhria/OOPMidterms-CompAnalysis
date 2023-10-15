package ceu;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class UserData 
{
  // ATTRIBUTES
  private String fullName;
  private String firstName;
  private String address;
  private String course;
  private String favMovie;
  private int favNum;
  private String favMovieChar; 
  private String favFood;
  private String birthDate;
  private String birthPlace;
  private int prefChildCount;
  // private int rerunCount;
  
  static Scanner sc = new Scanner( System.in );
  static boolean validated;
  static InputValidation validation = new InputValidation();
  
  // SETTERS
  public void setfullName()
  {
    System.out.print( "\nFull Name: " );
    fullName = sc.nextLine();

    setFirstName( fullName );
  }

  public void setFirstName( String fulLName)
  {
    String[] nameParts = fulLName.split(" ");
    String firstName = nameParts[ 0 ];
    this.firstName = firstName;  
  }

  public void setAddress() throws IOException
  {
    System.out.print( "\nAddress: " );
    address = sc.nextLine();
  }

  public void setCourse( )
  {
    System.out.print( "\nCourse: " );
    course = sc.nextLine();
  }

  public void setFavMovie( )
  {
    System.out.print( "\nFavorite Movie: " );
    favMovie = sc.nextLine();
  }

  public void setFavMovieChar( )
  {
    System.out.println( "\nFavorite Movie Character: " );
    favMovieChar = sc.nextLine();
  }

  public void setFavFood( )
  {
		  System.out.print( "\nFavorite Food: " );
		  favFood = sc.nextLine();
  }

  public void setFavNum( )
  {
		  System.out.print( " \nFavorite Number: " );
      favNum = sc.nextInt();
      sc.nextLine();
  }

  public void setBirthDate()
  {
		  System.out.print( "\nBirthDate (YYYY-mm-dd): " );
		  String birthDateString = sc.nextLine();
      this.birthDate = birthDateString;
  }

  public void setBirthPlace( )
  {
		  System.out.print( "\nBirthPlace: " );
		  birthPlace = sc.nextLine();
      // FIXME: Convert String to Date and check if user's age is valid.

  }

  public void setPrefChildCount( )
  {
		  System.out.print( "\nPrefChildCount: " );
		  prefChildCount = sc.nextInt();
      sc.nextLine();
  }

  public void setFirstName()
  {

  }

  // GETTERS
  public String getfullName()
  {
    return this.fullName;
  }

  public String getAddress()
  {
    return this.address;
  }

  public String getCourse()
  {
	return this.course;
  }

  public String getFavMovie()
  {
	return this.favMovie;
  }

  public String getFavMovieChar()
  {
	return this.favMovieChar;
  }

  public String getFavFood()
  {
	return this.favFood;
  }

  public int getFavNum()
  {
	return this.favNum;
  }

  public String getBirthDate()
  {
	return this.birthDate;
  }

  public String getBirthPlace()
  {
	return this.birthPlace;
  }

  public int getPrefChildCount()
  {
	return this.prefChildCount;
  }

  public String getFirstName()
  {
    return this.firstName;
  }
}


