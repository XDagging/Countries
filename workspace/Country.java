public class Country
{
  // add private instance variables for the name, capital, language, and image file.

  private String name="";
  private String capital="";
  private String language="";
  private String imageFile="";


  public Country(String name, String capital, String language, String imageFile) 
  {
    this.name = name;
    this.capital = capital;
    this.language = language;
    this.imageFile = imageFile;
  }

  public Country() {
    name = "United States";
    capital = "Washington D.C.";
    language = "English";
    imageFile = "US.jpg";
  }


  public String getName() {
    return name;
  }

  public String getCapital() {
    return capital;
  }

  public String getLanguage() {
    return language;
  }

  public String getImageFile() {
    return imageFile;
  }

  public String toString() {

    return name+"'s capital is " + capital + " and its primary language is " + language;
  }



  // add constructors

  // Write accessor/get methods for each instance variable that returns it.

  // Write a toString() method that returns a concatenated String of 3 of the instance variables in a sentence like "..'s capital is .. and its primary language is ..."
 



  // getImage()
  
}