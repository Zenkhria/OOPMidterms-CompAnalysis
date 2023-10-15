package ceu;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class UserData 
{
  // ATTRIBUTES
  private String fullName;
  private String address;
  private String course;
  private String favMovie;
  private int favNum;
  private String favMovieChar; 
  private String favFood;
  private Date birthDate;
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
		  fullName = sc.next();
  }

  public void setAddress() throws IOException
  {
		  System.out.println( "\nAddress: " );
		  address = sc.nextLine();
  }

  public void setCourse( )
  {
		  System.out.print( "\nCourse: " );
		  course = sc.next();
  }

  public void setFavMovie( )
  {
		  System.out.print( "\nFavMovie: " );
		  favMovie = sc.next();
  }

  public void setFavFood( )
  {
		  System.out.print( "\nFavFood: " );
		  favFood = sc.next();
  }

  public void setFavNum( )
  {
		  System.out.print( "\nFavNum: " );
		  	favNum = sc.nextInt();
  }

  public void setBirthDate( )
  {
		  System.out.print( "\nBirthDate: " );
		  // birthDate = sc.next();
  }

  public void setBirthPlace( )
  {
		  System.out.print( "\nBirthPlace: " );
		  birthPlace = sc.next();
  }

  public void setPrefChildCount( )
  {
		  System.out.print( "\nPrefChildCount: " );
		  prefChildCount = sc.nextInt();
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

  public String getFavFood()
  {
	return this.favFood;
  }

  public int getFavNum()
  {
	return this.favNum;
  }

  public Date getBirthDate()
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
}


