package ceu;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.annotation.*;

public class InputValidation
{
  public boolean FullName( String fullName )
  {
    if ( !fullName.matches( ".*\\d+.*" ) && !fullName.matches( ".*[^aeiouAEIOU.]{4,}.*" ) && !fullName.matches( ".*[aeiouAEIOU]{3,}.*" ) ) 
    {
      System.out.println( "NAME RECORDED." );
      return true;
    } 
    else 
    {
      System.out.println( "Invalid Name. Rerunning Program..." );
      return false;
    }
  }

  public boolean Address( String address ) throws IOException
  {
    // ObjectMapper objectMapper = new ObjectMapper();
    // objectMapper.disable( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES );
    // objectMapper.setVisibility( VisibilityChecker.Std.defaultInstance().withFieldVisibility( JsonAutoDetect.Visibility.ANY ) );
    // File regionJsonfile = new File( "src/ceu/Resource/Region.json" );
    // Region region = objectMapper.readValue( regionJsonfile, Region.class );
    
    // System.out.println( region );
    // System.out.println( region.getCAR() );
    
    // return true;
    if ( !address.matches( ".*\\d+.*" ) && !address.matches( ".*[^aeiouAEIOU]{4,}.*" ) && !address.matches( ".*[aeiouAEIOU]{3,}.*" ) ) 
    {
      System.out.println( "ADDRESS RECORDED." );
      return true;
    } 
    else 
    {
      System.out.println( "Invalid Address. Rerunning Program..." );
      return false;
    }
  }

  public boolean Course( String course )
  {
    if ( !course.matches( ".*\\d+.*" ) && !course.matches( ".*[^aeiouAEIOU]{4,}.*" ) && !course.matches( ".*[aeiouAEIOU]{3,}.*" ) ) 
    {
      System.out.println( "COURSE RECORDED." );
      return true;
    } 
    else 
    {
      System.out.println( "Invalid Course. Rerunning Program..." );
      return false;
    }
  }

  public boolean FavMovie( String movie )
  {
    if ( !movie.matches( ".*[^aeiouAEIOU]{4,}.*" ) && !movie.matches( ".*[aeiouAEIOU]{3,}.*" ) ) 
    {
      System.out.println( "FAVORITE MOVIE RECORDED." );
      return true;
    } 
    else 
    {
      System.out.println( "Invalid Movie. Rerunning Program..." );
      return false;
    }
  }
  
  public boolean FavNumber( int number )
  {
    String numString = String.valueOf( number );
    if ( numString.matches( "^[a-zA-Z]+$" ) )
    {
      System.out.println( "Invalid Number. Rerunning Program..." );
      return false;
    } 
    else 
    {
      System.out.println( "FAVORITE NUMBER RECORDED." );
      return true;
    }
  }

  public boolean FavMovieChar( String movieChar )
  {
    if ( !movieChar.matches( ".*[^aeiouAEIOU]{4,}.*" ) && !movieChar.matches( ".*[aeiouAEIOU]{3,}.*" ) ) 
    {
      System.out.println( "FAVORITE MOVIE CHARACTER RECORDED." );
      return true;
    } 
    else 
    {
      System.out.println( "Invalid Movie Character. Rerunning Program..." );
      return false;
    }
  }

  public boolean FavFood( String food )
  {
    if ( !food.matches( ".*\\d+.*" ) && !food.matches( ".*[^aeiouAEIOU.]{4,}.*" ) && !food.matches( ".*[aeiouAEIOU]{3,}.*" ) ) 
    {
      System.out.println( "FAVORITE FOOD RECORDED." );
      return true;
    } 
    else 
    {
      System.out.println( "Invalid Food. Rerunning Program..." );
      return false;
    }
  }

  public boolean BirthDate( Date birthDate )
  {
    // TODO: ADD CODE HER
    return true;
  }

  public boolean BirthPlace( String birthPlace )
  {
    if ( !birthPlace.matches( ".*\\d+.*" ) && !birthPlace.matches( ".*[^aeiouAEIOU.]{4,}.*" ) && !birthPlace.matches( ".*[aeiouAEIOU]{3,}.*" ) ) 
    {
      System.out.println( "BIRTH PLACE RECORDED." );
      return true;
    } 
    else 
    {
      System.out.println( "Invalid Birth Place. Rerunning Program..." );
      return false;
    }
  }

  public boolean PrefChildCount( int prefChildCount )
  {
    String childCountString = String.valueOf( prefChildCount );
    if ( childCountString.matches( "^[a-zA-Z]+$" ) )
    {
      System.out.println( "Invalid No. of Children. Rerunning Program..." );
      return false;
    } 
    else 
    {
      System.out.println( "PREFERRED NO. OF CHILDREN RECORDED." );
      return true;
    }
  }
}
