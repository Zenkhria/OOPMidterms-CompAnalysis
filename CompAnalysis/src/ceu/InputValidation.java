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
    if ( !fullName.matches( ".*\\d+.*" ) && !fullName.matches( ".*[^aeiouAEIOU]{4,}.*" ) && !fullName.matches( ".*[aeiouAEIOU]{3,}.*" ) ) 
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
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.disable( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES );
    objectMapper.setVisibility( VisibilityChecker.Std.defaultInstance().withFieldVisibility( JsonAutoDetect.Visibility.ANY ) );
    File regionJsonfile = new File( "src/ceu/Resource/Region.json" );
    Region region = objectMapper.readValue( regionJsonfile, Region.class );
    
    System.out.println( region );
    System.out.println( region.getCAR() );
    
    return true;
  }

  public boolean Course( String course )
  {
    // TODO: ADD CODE HERE
    return true;
  }

  public boolean FavMovie( String movie )
  {
    // TODO: ADD CODE 
    return true;
  }
  
  public boolean FavNumber( int number )
  {
    // TODO: ADD CODE HERE
    return true;
  }

  public boolean FavMovieChar( String movieChar )
  {
    // TODO: ADD CODE HERE
    return true;
  }

  public boolean FavFood( String food )
  {
    // TODO: ADD CODE HERE
    return true;
  }

  public boolean BirthDate( Date birthDate )
  {
    // TODO: ADD CODE HER
    return true;
  }

  public boolean BirthPlace( String birthPlace )
  {
    // TODO: ADD CODE HERE
    return true;
  }

  public boolean PrefChildCount( int prefChildCount )
  {
    // TODO: ADD CODE HERE
    return true;
  }
}
