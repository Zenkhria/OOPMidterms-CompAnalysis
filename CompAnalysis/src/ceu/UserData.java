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
  private int rerunCount;
  
  static Scanner sc = new Scanner( System.in );
  InputValidation validation = new InputValidation();
  static boolean validated;
  
  // SETTERS
  public void setfullName()
  {
	  do {
		  System.out.print( "Full Name: " );
		  fullName = sc.next();
		  
		  validated = validation.FullName( fullName );
		  
		  rerunCount++;
	  }while( !validated );
  }

  public void setAddress() throws IOException
  {
	  do {
		  System.out.println( "Address: " );
		  address = sc.nextLine();
		 
		  validated = validation.Address( address );
		  
		  rerunCount++;
	  }while( !validated );
  }

  public void setCourse( )
  {
    this.course = course;
  }

  public void setFavMovie( String favMovie )
  {
    this.favMovie = favMovie;
  }

  public void setFavFood( String favFood )
  {
    this.favFood = favFood;
  }

  public void setFavNum( int favNum )
  {
    this.favNum = favNum;
  }

  public void setBirthDate( Date birthDate )
  {
    this.birthDate = birthDate;
  }

  public void setBirthPlace( String birthPlace )
  {
    this.birthPlace = birthPlace;
  }

  public void setPrefChildCount( int prefChildCount )
  {
    this.prefChildCount = prefChildCount;
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


