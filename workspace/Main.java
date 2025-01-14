import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Main 
{

  // array of 10 Country objects
  private Country[] countryArray = new Country[10];  
  // index of current shown country
  private int index = 0;

  // GUI elements
  private JFrame jFrame = new JFrame("Countries");
  private ImageIcon img;
  private JLabel imageLabel;
  private JLabel outputLabel;
  private JTextField textField;

  private JTextField input;
  

    // Precondition: initializes the gui
  // Postcondition: initializes the post condition
  public static void main(String[] args) {
    // Create the GUI
    Main gui = new Main();
    gui.loadCountries();
    gui.showCountry();
  }



  // Precondition: Country object has an img file
  // Postcondition: creates a Country class for each country inside the csv file. 
  /* loadCountries() reads in the data from the countries-data.csv file and fills in the countryArray with data. You need to add the loop that reads in the country data into the array. */
  public void loadCountries() 
  {
    // Open the data file - do not change
    File file = new File("/workspaces/Countries/workspace/countries-data.csv");
    Scanner scan = null;
    try {
      scan = new Scanner(file);
    } catch(FileNotFoundException e) { 
        System.out.println("File not found");     
    }
    
    // Write a for loop that goes through the countryArray.
    // for(int i ....) {
    // Do the following inside the loop
    for (int i=0; i<countryArray.length; i++) {
      String input = scan.nextLine();
      String[] data = input.split(",");
      System.out.println("Read in " + data[0]);
      countryArray[i] = new Country(data[0],data[1],data[2],data[3]);
    }
      
      // inside the loop, create a new Country using your constructor with 4 arguments and pass in data[0], data[1], data[2], data[3] as arguments.
     // inside the loop, set countryArray[i] to the created Country object
     
    
  }

  /* showCountry() will show the image associated with the current country. It should get the country at index from the countryArray. It should use its get method to get its image file name and use the code below to put the image in the GUI.
  */



    // Precondition: Index is defined
  // Postcondition:  Sets the image of the current country
  public void showCountry() {
    // Get the country at index from countryArray
    Country currentCountry = countryArray[index];
    
    // Use its get method to get the its image file name and save it into imagefile variable below instead of worldmap.jpg.
    String imagefile = currentCountry.getImageFile();
    // Use the following code to create an new Image Icon and put it into the GUI
    System.out.println(imagefile);
    img = new ImageIcon("/workspaces/Countries/workspace/"+imagefile);
    imageLabel.setIcon(img);
  }
  
  /* nextButton should increment index. If the index is greater than 9, reset it back to 0. Clear the outputLabel to empty string using setText, and call showCountry();*/
  
  // Precondition: Index is defined
  // Postcondition: changes the index and adds the queston to the outputLabel and then calls the showCountry method. 
  public void nextButtonClick()
  {
    if (index > 9) {
      index = 0;
    } else {
      index++;
    }

    Country currentCountry = countryArray[index];
    int randomNum = (int) Math.random()*3;
    if (randomNum == 0) {
      outputLabel.setText("What country is this?");
    } else if (randomNum == 1) {
      outputLabel.setText("What is this nation's capital?");
    }
 
    textField.setText("");
    
    showCountry();
    
  }
  
  /* reviewButton should get the country at index from the countryArray, call its toString() method and save the result, print it out with System.out.println and as an argument to outputLabel.setText( text to print out ); */
  
  
  public void reviewButtonClick()
  {
    outputLabel.setText(countryArray[index].toString());
    System.out.println(countryArray[index].toString());  
  }

  /* quizButton should clear the outputLabel (outputLabel.setText to empty string), get the country at index from countryArray, print out a question about it like What country is this? and/or What's this country's capital?. Get the user's answer using scan.nextLine() and check if it is equal to the country's data using its get methods and print out correct or incorrect.
  */
  public void quizButtonClick()
  {
    // Scanner scan = new Scanner(System.in); 
    // outputLabel.setText("")
    Country currentCountry = countryArray[index];

    if (outputLabel.getText().indexOf("capital") > 0) {

      // This means that we need to check if it has the same capital
      if (textField.getText().toLowerCase().equals(currentCountry.getCapital().toLowerCase())) {
        outputLabel.setText("Good Job! Click Next to continue");

      } else {
        outputLabel.setText("Incorrect try again!");
      }




    } else {

      if (textField.getText().toLowerCase().equals(currentCountry.getName().toLowerCase())) {
        outputLabel.setText("Good Job! Click Next to continue");

      } else {
        outputLabel.setText("Incorrect try again!");
      }



    
    }


    
   
    

    // textField.setText("");


    
    
    
  }




  /* Do NOT change anything below here */
  /* The Main() constructor is finished and will construct the GUI */
public Main() {
    jFrame.setLayout(new FlowLayout());
    jFrame.setSize(500, 360);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // buttons at the top
        JButton reviewButton = new JButton("Review");
        JButton quizButton = new JButton("Quiz");
        JButton newButton = new JButton("Next");
        


        jFrame.add(reviewButton);
        jFrame.add(quizButton);
        jFrame.add(newButton);
        
        // create a new image icon
        img = new ImageIcon("worldmap.jpg");
        // create a label to display image
        imageLabel = new JLabel(img);

        // and one for output
        outputLabel = new JLabel();
        jFrame.add(imageLabel);

        outputLabel.setText("Click next to start");
        jFrame.add(outputLabel);

        // add input

        textField = new JTextField(20);


        jFrame.add(textField);
        jFrame.setVisible(true);
        // add event listener for button click
        reviewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      reviewButtonClick();
    }
        });
    quizButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      quizButtonClick();
    }
    });
   
   newButton.addActionListener(new ActionListener()  {
    public void actionPerformed(ActionEvent e) 
    {
      nextButtonClick();
    }
   });
}
  

}
