package ceu;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Evaluation 
{
  public String getRegion( String address )
  {
      Map<String, List<String>> regionCityMap = new HashMap<>();

			// National Capital Region (NCR)
			List<String> ncrCities = Arrays.asList(
					"Manila", "Quezon City", "Makati", "Caloocan", "Pasig", "Taguig", "Pasay", "Muntinlupa", "Las Piñas"
			);
			regionCityMap.put( "National Capital Region (NCR)", ncrCities );

			// Cordillera Administrative Region (CAR)
			List<String> carCities = Arrays.asList(
					"Baguio", "Benguet", "Ifugao", "Kalinga", "Apayao", "Abra"
			);
			regionCityMap.put( "Cordillera Administrative Region (CAR)", carCities );
			
			// Cagayan Valley (Region II)
			List<String> regionIICities = Arrays.asList(
					"Tuguegarao", "Isabela City", "Ilagan", "Santiago", "Cauayan", "Tabuk"
			);
			regionCityMap.put( "Cagayan Valley (Region II)", regionIICities );

			// Central Luzon (Region III)
			List<String> regionIIICities = Arrays.asList(
			"Angeles", "San Fernando (Pampanga)", "Olongapo", "Balanga", "Malolos", "Cabanatuan", "Tarlac City", "Mabalacat", "Gapan", "Meycauayan"
			);
			regionCityMap.put( "Central Luzon (Region III)", regionIIICities );

			// Calabarzon (Region IV-A)
			List<String> regionIVACities = Arrays.asList(
			"Batangas City", "Cavite City", "Santa Rosa", "Lipa", "Lucena", "Calamba", "San Pablo", "Tanauan", "Biñan", "Trece Martires"
			);
			regionCityMap.put( "Calabarzon (Region IV-A)", regionIVACities );

			// Mimaropa (Region IV-B)
			List<String> regionIVBCities = Arrays.asList(
			"Puerto Princesa", "Calapan", "San Jose", "Odiongan", "Roxas (Palawan)"
			);
			regionCityMap.put( "Mimaropa (Region IV-B)", regionIVBCities );

			// Bicol Region (Region V)
			List<String> regionVCities = Arrays.asList(
			"Legazpi", "Naga", "Ligao", "Sorsogon City", "Tabaco", "Iriga"
			);
			regionCityMap.put( "Bicol Region (Region V)", regionVCities );

			// Western Visayas (Region VI)
			List<String> regionVICities = Arrays.asList(
				"Iloilo City", "Bacolod", "Roxas City", "Passi", "San Carlos (Negros Occidental)"
			);
			regionCityMap.put( "Western Visayas (Region VI)", regionVICities );

			// Central Visayas (Region VII)
			List<String> regionVIICities = Arrays.asList(
				"Cebu City", "Mandaue", "Lapu-Lapu", "Tagbilaran", "Toledo"
			);
			regionCityMap.put( "Central Visayas (Region VII)", regionVIICities );

      String region = "";
			for ( Map.Entry<String, List<String>> entry : regionCityMap.entrySet() ) 
			{
				region = entry.getKey();
				List<String> cities = entry.getValue();

				for ( String city : cities ) 
				{
						if ( address.equalsIgnoreCase( city ) )
						{
							System.out.println( "Region of City Address: " + region );
						}
				}
      }
      return region;
  }

  public String getCourseCategory( String userCourse )
  {
    Map<String, List<String>> courseCategoryMap = new HashMap<>();

    // Accountancy & Management Department
    List<String> accountancy = Arrays.asList(
      "Accountancy", "Legal Management", "Business Administration"
    );
    courseCategoryMap.put( "Accountancy & Management Department", accountancy );

    // Computer Science and Information Technology Department
    List<String> csit = Arrays.asList(
      "Computer Science", "Information Technology", "CS", "IT"
    );
    courseCategoryMap.put( "Computer Science and Information Technology Department", csit );

    String courseCategory = "";
    for ( Map.Entry<String, List<String>> entry : courseCategoryMap.entrySet() ) 
    {
      courseCategory = entry.getKey();
      List<String> courses = entry.getValue();

      for ( String course : courses ) 
      {
        if ( course.equalsIgnoreCase( userCourse ) )
        {
          System.out.println( "Course Category: " + courseCategory );
        }
      }
    }
    return courseCategory;
  }

  public int fullNameConsonantCount( String fullName )
  {
    String fullNameCheck = fullName.toLowerCase();
    fullNameCheck = fullNameCheck.replaceAll( " ", "" );
    fullNameCheck = fullNameCheck.replaceAll( "\\.", "" );
    
    int consonantCount = 0;
    
    for ( char letter : fullNameCheck.toCharArray() )
    {
      String letterString = String.valueOf( letter );
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
    fullNameCheck = fullNameCheck.replaceAll( "\\.", "" );
    
    int  vowelCount = 0;
    
    for ( char letter : fullNameCheck.toCharArray() )
    {
      String letterString = String.valueOf( letter );
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

  public String getAgeCategory( long age )
  {
    String ageCategory; 
    if ( age > 0 && age <= 2 )
    {
      ageCategory = "Baby";
    }
    else if ( age > 2 && age <= 12 )
    {
      ageCategory = "Child";
    }
    else if ( age> 12 && age <= 19 )
    {
      ageCategory = "Teenager";
    }
    else if ( age > 19 && age < 65 )
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
				diagnosis = "Major Baby Syndrome (MaBs)";
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
