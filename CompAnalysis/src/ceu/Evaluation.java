package ceu;

import java.io.File; 

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Evaluation 
{
  public void getRegion( String region, UserData user )
  {
    try 
    {
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode rootNode = objectMapper.readTree( new File( "C:\\Users\\user\\Favorites\\Downloads\\Compressed\\Resource" ) );

      for ( JsonNode regionNode : rootNode ) 
      {
        region = regionNode.get( "regionName" ).asText();
        JsonNode citiesNode = regionNode.get( "cities" );

        if ( citiesNode.isArray() && citiesNode.elements().hasNext() ) 
        {
          for ( JsonNode cityNode : citiesNode ) 
          {
            String city = cityNode.asText();
            if ( city.equals( user.getAddress() ) ) 
            {
              System.out.println( "Address Region: " + region );
            }
            else
            {
              System.out.println( "Address Region: Not Found" );
            }
          }
        }
      }
    } 
    catch ( Exception e ) 
    {
        e.printStackTrace();
    }
  }

  public int fullNameConsonantCount( String fullName )
  {
    String fullNameCheck = fullName.toLowerCase();
    fullNameCheck = fullNameCheck.replaceAll( " ", "" );
    fullNameCheck = fullNameCheck.replaceAll( ".", "" );
    
    int consonantCount = 0;
    
    for ( char letter : fullNameCheck.toCharArray() )
    {
      String letterString = Character.toString( letter );
      if ( letterString.matches( "[b-df-hj-np-tv-z]" ) )
      {
        consonantCount++;
      }
    }
    System.out.println( "No. of Consonants in Full Name: " + consonantCount );
    return consonantCount;
  }

  public int fullNameVowelCount( String fullName )
  {
    String fullNameCheck = fullName.toLowerCase();
    fullNameCheck = fullNameCheck.replaceAll( " ", "" );
    fullNameCheck = fullNameCheck.replaceAll( ".", "" );
    
    int  vowelCount = 0;
    
    for ( char letter : fullNameCheck.toCharArray() )
    {
      String letterString = Character.toString( letter );
      if ( letterString.matches( "[aeiou]" ) )
      {
        vowelCount++;
      }
    }
    System.out.println( "No. of Vowels in Full Name: " + vowelCount );
    return vowelCount;
  }

  public int fullNameWordCount( String fullName )
  {
    String[] wordsInFullName = fullName.split( "\\s+" );
    int fullNameWordCount = wordsInFullName.length;
    System.out.println( "No. of Words in Full Name: " + fullNameWordCount );
    return fullNameWordCount;
  }

  public String getAgeCategory( UserData user )
  {
    String ageCategory; // FIXME: My birthday is on Oct 19, 2003 but I get categorized as a Child.
    long age = user.getAge();
    if ( age > 0 && age <= 2 )
    {
      ageCategory = "Baby";
    }
    else if ( age <= 12 )
    {
      ageCategory = "Child";
    }
    else if ( age <= 19 )
    {
      ageCategory = "Teenager";
    }
    else if ( age < 65 )
    {
      ageCategory = "Mid";
    }
    else
    {
      ageCategory = "Senior";
    }
    System.out.println( "Age Category: " + ageCategory );
    return ageCategory;
  }

  public String getFavNumBinary( int favNum )
  {
    String binaryValue = Integer.toBinaryString( favNum );
    System.out.println( "Binary Value of FavNum: " + binaryValue );
    return binaryValue;
  }

  public String getFavNumOctal( int favNum )
  {
    String octalValue = Integer.toOctalString( favNum );
    System.out.println( "Octal Value of FavNum: " + octalValue );
    return octalValue;
  }

  public String getFavNumHex( int favNum )
  {
    String hexadecimalValue = Integer.toHexString( favNum );
    System.out.println( "Hexadecimal Value of FavNum: " + hexadecimalValue );
    return hexadecimalValue;
  }

  public String getPsychEval( int childCount )
  {
			String psychEvaluation = "";
			String diagnosis = "";

			if ( childCount < 0 )
			{
				diagnosis = "Baby Hatred Syndrome (BHS)";
				psychEvaluation = "they hate children and suffer from Baby Hatred Syndrome (BHS).";
			}
			else if ( childCount == 0 )
			{
				diagnosis = "Baby Allergy Syndrome (BAS)";
				psychEvaluation = "they don't want a child and suffer from Baby Allergy Syndrome (BAS).";
			}
			else if ( childCount < 2 )
			{
				diagnosis = "Normal";
				psychEvaluation = "they know the importance of family planning, which is completely normal. No diagnosis.";
			}
			else if ( childCount < 5 )
			{
				diagnosis = "Normal";
				psychEvaluation = "they must be living a comfortable life.";
			}
			else if ( childCount < 15 )
			{
				diagnosis = "Minor Baby Syndrome (MiBS)";
				psychEvaluation = "they are suffering from Minor Baby Syndrome (MiBS).";
			}
			else if ( childCount > 15 )
			{
				diagnosis = "Major Baby Syndrome (BHS)";
				psychEvaluation = "they are suffering from Major Baby Syndrome (MaBS).";
			}
			System.out.println( "Diagnosis: " + diagnosis );
      return psychEvaluation;
  }

  public String getZodiacSign( String birthDate )
  {
    String[] parts = birthDate.split( "-" );
    int month = Integer.parseInt( parts[ 1 ] );
    int day = Integer.parseInt( parts[ 2 ] );

    String[] zodiacSigns = {
      "Capricorn", "Aquarius", "Pisces", "Aries", "Taurus", "Gemini",
      "Cancer", "Leo", "Virgo", "Libra", "Scorpio", "Sagittarius"
    };

    int[] lastDayOfEachSign = { 20, 18, 20, 19, 20, 20, 22, 22, 22, 22, 21, 21 };

    int index = month - 1;
    if ( day > lastDayOfEachSign[ index ] ) 
    {
        index = ( index + 1 ) % 12;
    }
    String zodiacSign = zodiacSigns[ index ];
    System.out.println( "Zodiac Sign: " + zodiacSign );
    return zodiacSigns[ index ];
  }
}
