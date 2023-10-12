package ceu;

import java.util.Date;

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

  // SETTERS
  public void setfullName( String fullName )
  {
    this.fullName = fullName;
  }

  public void setAddress( String address )
  {
    this.address = address;
  }

  public void setCourse( String course )
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
}


