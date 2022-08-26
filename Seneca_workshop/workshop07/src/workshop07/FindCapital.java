package workshop07;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class FindCapital {

	public static void main(String[] args) {
		
        Map capitalCities  = new HashMap();
        // add countries and cities to the map
        capitalCities.put("Australia", "Canberra");
        capitalCities.put("Austria", "Vienna");
        capitalCities.put("Belgium", "Brussels");
        capitalCities.put("Cambodia", "Phnom Penh");
        capitalCities.put("Chile", "Santiago");
        capitalCities.put("Cuba", "Havana");
        capitalCities.put("Denmark", "Copenhagen");
        capitalCities.put("Dominica", "Roseau");
        capitalCities.put("Egypt", "Cairo");
        capitalCities.put("Fiji", "Suva");
        capitalCities.put("France", "Paris");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Greece", "Athens");
        capitalCities.put("Haiti", "Port au Prince");
        capitalCities.put("Hungary", "Budapest");
        capitalCities.put("Iceland", "Reykjavik");
        capitalCities.put("India", "New Delhi");
        capitalCities.put("Iran", "Tehran");
        capitalCities.put("Kenya", "Nairobi");
        capitalCities.put("Laos", "Vientiane");
        capitalCities.put("Maldives", "Male");
        capitalCities.put("Netherlands", "Amsterdam");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("Russia", "Moscow");
        capitalCities.put("Taiwan", "Taipei");
        capitalCities.put("Thailand", "Bangkok");
        capitalCities.put("Turkey", "Ankara");
        
        
        Scanner scan = new Scanner(System.in);
        //get country name from user
        System.out.print("Enter country: ");
        String country = scan.next();
        
        Iterator iter = capitalCities.entrySet().iterator();
        boolean noCountries = false;
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            //compare country name
            if (entry.getKey().equals(country)) {
            	noCountries = true;
                System.out.println("Capital of " + country + " is " + entry.getValue());
            } 
        }
        if(!noCountries) {
        	System.out.println("No Countries");
        }

	}

}
