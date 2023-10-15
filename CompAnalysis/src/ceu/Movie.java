package ceu;

import java.util.List;

public class Movie 
{
  // ATTRIBUTES
  private String movieName;
  private int releaseDate;
  private List<Character> characters;
  private String genre;

  // CONSTRUCTORS
  public Movie ( String movieName, int releaseDate, List<Character> characters, String genre )
  {
    setMovieName( movieName );
    setReleaseDate( releaseDate );
    setCharacters( characters );
    setGenre( genre );
  }

  // SETTERS
  public void setMovieName( String movieName )
  {
    this.movieName = movieName;
  }

  public void setReleaseDate( int releaseDate )
  {
    this.releaseDate = releaseDate;
  }

  public void setCharacters( List<Character> character )
  {
    this.characters = character;
  }

  public void setGenre( String genre )
  {
    this.genre = genre;
  }

  // GETTERS
  public String getMovieName()
  {
    return this.movieName;
  }

  public int getReleaseDate()
  {
    return this.releaseDate;
  }

  public List<Character> getCharacters()
  {
    return this.characters;
  }

  public String getGenre()
  {
    return this.genre;
  }
}
