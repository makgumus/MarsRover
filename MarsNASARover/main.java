package MarsNASARover;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner= new Scanner(System.in);
		
		String [] plateauMaxCoordinate= scanner.nextLine().split(" ");
		Coordinates plateauCoordinate=new Coordinates(Integer.parseInt(plateauMaxCoordinate[0]),Integer.parseInt(plateauMaxCoordinate[1]));
		
		List<Coordinates> allRoverLocation=new ArrayList<Coordinates>(); 
		
		int i=0;
		while(i < (plateauCoordinate.getX()*plateauCoordinate.getY()))
		{
			String [] firstCoordinateRover= scanner.nextLine().split(" ");
			Coordinates firstCoordinate=new Coordinates(Integer.parseInt(firstCoordinateRover[0]),Integer.parseInt(firstCoordinateRover[1]));
									
			if(firstCoordinate.checkRoverOutsidePlateau(plateauCoordinate) || firstCoordinate.checkPointRover(allRoverLocation))
	    	{
	    		System.out.println("Konum geçersiz");
	    	}
			else
			{			
				String str= scanner.nextLine().toUpperCase();
				char[] commandArray = str.toCharArray();
				
				Rover rover=new Rover(plateauCoordinate,firstCoordinate,allRoverLocation,firstCoordinateRover[2].toUpperCase());
				
				Coordinates lastRoverCoordinates=rover.execute(commandArray);				
				allRoverLocation.add(lastRoverCoordinates);
				i++;
				System.out.println();
			}
		}
		
		
	}

}
