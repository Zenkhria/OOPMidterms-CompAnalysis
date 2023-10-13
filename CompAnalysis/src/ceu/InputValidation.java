package ceu;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.annotation.*;

public class InputValidation
{
  public boolean FullName(String fullName)
  {
	  for(int i = 0 ; i < fullName.length();i++){
			char ch = fullName.charAt(i);
		    if (Character.isLetter(ch) || ch == ' ') 
		    {
		      continue;
		    }
		    return false;
	  }
	  return true;
  }

  public boolean Address(String address) throws IOException
  {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    objectMapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
    File regionJsonfile = new File("src/ceu/Resource/Region.json");
    Region region = objectMapper.readValue(regionJsonfile, Region.class);
    
    System.out.println(region);
    System.out.println(region.getCAR());
    
    return true;
  }

  public boolean Course()
  {
    // TODO: ADD CODE HERE
    return true;
  }

  public boolean FavMovie()
  {
    // TODO: ADD CODE 
    return true;
  }

  public boolean FavNumber()
  {
    // TODO: ADD CODE HERE
    return true;
  }

  public boolean FavMovieChar()
  {
    // TODO: ADD CODE HERE
    return true;
  }

  public boolean FavFood()
  {
    // TODO: ADD CODE HERE
    return true;
  }

  public boolean BirthDate()
  {
    // TODO: ADD CODE HERE
    return true;
  }

  public boolean BirthPlace()
  {
    // TODO: ADD CODE HERE
    return true;
  }

  public boolean PrefChildCount()
  {
    // TODO: ADD CODE HERE
    return true;
  }
}
