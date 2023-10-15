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
	  do {
		  System.out.print( "Course: " );
		  course = sc.next();
		  
		  validated = validation.FullName( course );
		  
		  rerunCount++;
	  }while( !validated );
  }

  public void setFavMovie( )
  {
	  do {
		  System.out.print( "FavMovie: " );
		  favMovie = sc.next();
		  
		  validated = validation.FullName( favMovie );
		  
		  rerunCount++;
	  }while( !validated );
  }

  public void setFavFood( )
  {
	  do {
		  System.out.print( "FavFood: " );
		  favFood = sc.next();
		  
		  validated = validation.FavFood( favFood );
		  
		  rerunCount++;
	  }while( !validated );
  }

  public void setFavNum( )
  {
	  do {
		  System.out.print( "FavNum: " );
		  	favNum = sc.nextInt();
		  
		  validated = validation.FavNumber( favNum );
		  
		  rerunCount++;
	  }while( !validated );
  }

  public void setBirthDate( )
  {
	  do {
		  System.out.print( "BirthDate: " );
		  // birthDate = sc.next();
		  
		  validated = validation.BirthDate( birthDate );
		  
		  rerunCount++;
	  }while( !validated );
  }

  public void setBirthPlace( )
  {
	  do {
		  System.out.print( "BirthPlace: " );
		  birthPlace = sc.next();
		  
		  validated = validation.BirthPlace( birthPlace );
		  
		  rerunCount++;
	  }while( !validated );
  }

  public void setPrefChildCount( )
  {
	  do {
		  System.out.print( "PrefChildCount: " );
		  prefChildCount = sc.nextInt();
		  
		  validated = validation.PrefChildCount( prefChildCount );
		  
		  rerunCount++;
	  }while( !validated );
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


