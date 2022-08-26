package workshop07;
import java.util.*;
import java.io.IOException;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FindBothGenderName {

	public static void main(String[] args) throws IOException {
		//get file name and open a file
		System.out.print("Enter a file name for baby name ranking: ");
		Scanner scan = new Scanner(System.in);
		String fileName = scan.nextLine();
		FileInputStream input = null;
		try {
			input = new FileInputStream("src\\files\\" + fileName);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		List<String> namesForBoy = new ArrayList<String>();
		List<String> namesForGirl = new ArrayList<String>();
		Scanner oneLine = new Scanner(input);
		while (oneLine.hasNextLine()) {
			//order number of boy's name and girl's name from the string 
			int counter = 0;
			String temp = oneLine.nextLine();
			Scanner lineBuffer = new Scanner(temp);
			while (lineBuffer.hasNext()) {
				String name = lineBuffer.next();
				//count the order
				counter++;
				if(counter == 2) {
					namesForBoy.add(name);
				}
				if(counter == 4) {
					namesForGirl.add(name);
				}
			}	
		}
		
		input.close();
		
		//sort list array
		Collections.sort(namesForBoy);
		Collections.sort(namesForGirl);
		
		//compare names
		namesForBoy.retainAll(namesForGirl);
		
		//display names
		int nextLine = 1;
		for(String name: namesForBoy) {
			nextLine++;
			System.out.print(name + " ");
			if(nextLine % 15 == 0) {
				System.out.println();
			}
		}
	}

}
