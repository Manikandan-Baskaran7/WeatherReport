package jsondetails;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonfile {

	private static int DateSelection;

	public static void main(String[] args) throws IOException, ParseException, java.text.ParseException {
		
		ChoiceSelection();  
	        
	}
	
	private static void ChoiceSelection() throws IOException, ParseException, java.text.ParseException {
	   
	int ChoiceSelection;
	
	
	int Weather = 1;
	int Wind_Speed = 2;
    int Pressure = 3;
    int Exit = 0;
    
    JSONParser jsonparser = new JSONParser();
	
	FileReader read = new FileReader(".\\json\\weatherreport.json");
	
	Object object = jsonparser.parse(read);
	
	JSONObject jsonobject =(JSONObject)object;
	
	JSONArray weatherreportArray = (JSONArray)jsonobject.get("list");
	
	double weatherDate, nortemp, windSpeed, pressure;

	for(int i=0; i < weatherreportArray.size(); i++) {
    	
    JSONObject dailyreport = (JSONObject)weatherreportArray.get(i);
    
    String dates = (String)dailyreport.get("dt_txt");
    
    JSONObject temper = (JSONObject)dailyreport.get("main");
	
	JSONObject envPressure = (JSONObject)dailyreport.get("main");
	
	JSONObject wSpeed = (JSONObject)dailyreport.get("wind");
	
	nortemp = (Double) temper.get("temp");
	
	pressure = (Double) envPressure.get("pressure");
	
	windSpeed = (Double) wSpeed.get("speed");

    Scanner keyboard = new Scanner(System.in);
		        
		        

    System.out.println("User Choice?");
    System.out.println("1. Weather");
    System.out.println("2. Wind_Speed");
	System.out.println("3. Pressure");
	System.out.println("0. Exit");
		        
	ChoiceSelection = keyboard.nextInt();
	
	
		        
	if (ChoiceSelection ==1) {
		
		
		Scanner board = new Scanner(System.in);
		System.out.println("Enter the date and time you want to know the weather report? (Format is yyyy-MM-dd)");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateSelection = board.next();
		if(dates.compareTo(dateSelection) > 0) {
			
			System.out.println("Hi User!  Today weather is" +":"+ dateSelection + "    --    " + nortemp);
			
		}
		
	
	    } else if (ChoiceSelection == 2) {
			Scanner board = new Scanner(System.in);
			System.out.println("Enter the date and time you want to know the weather report? (Format is yyyy-MM-dd)");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String dateSelection = board.next();
			
	    	ChoiceSelection = (int) windSpeed;
				
			System.out.println("Hi User!  Today wind speed is" +":"+ dateSelection + "    --    " + windSpeed);
				
	    	
	   	} else if (ChoiceSelection == 3) {
			Scanner board = new Scanner(System.in);
			System.out.println("Enter the date and time you want to know the weather report? (Format is yyyy-MM-dd)");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String dateSelection = board.next();
			
	   		ChoiceSelection = (int) pressure;
	   		System.out.println("Hi User!  Today Atmospheric pressure is" +":"+ dateSelection + "    --    " +pressure);
	    	
        } else if(ChoiceSelection == 0) {
	        System.out.println("Exit...");
	        System.exit(0);
	        
        } else if (ChoiceSelection > 3 || ChoiceSelection < 1 || ChoiceSelection != 0) {
		    System.out.println("Retry...");
		    ChoiceSelection = -1;
		    
        }
	
	    }
	    
	}
}	




	
			
	
		
		
	/*		
		
		System.out.println("WindSpeed:"+windSpeed);
		System.out.println("Pressure:"+Pressure);
		
		
		*/
	
