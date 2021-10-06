package MarsNASARover;

import java.util.List;

public class Rover {
	private String direction ;
	private Direction directionEnum;
	private int directionPosition;
	private Coordinates roverCoordinates, plateauCoordinates;
	private List<Coordinates> allRoverLocation;

	private int[][] coordinateMove = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    
    public Rover(Coordinates plateau, Coordinates firstLocation, List<Coordinates> allRoverLocation, String direction)
    {    	
    	this.roverCoordinates=firstLocation;
    	this.plateauCoordinates=plateau;
    	this.direction=direction;
    	this.allRoverLocation=allRoverLocation;    	
    }   
    
    public Coordinates execute(char[] commandArray)
    {    
		for (char command : commandArray) 
    	{ 
    		switch (command) 
    		{
	            case 'L':  
	            	turnLeft();
	                break;
	            case 'R':  
	            	turnRight();
	            	break;
	            case 'M':  
	            	moveForward();
	                break;            
    		}
    	}
    	getCurrentLocation();
    	 	
    	return roverCoordinates;
    }
    
    public void getCurrentLocation()
    {
    	System.out.println(roverCoordinates.getX()+" "+roverCoordinates.getY()+" "+direction);
    }
    
    private void moveForward()
    {
    	roverCoordinates.moveForward(coordinateMove[Direction.valueOf(direction).getValue()][0],coordinateMove[Direction.valueOf(direction).getValue()][1]);

    	if(roverCoordinates.checkRoverOutsidePlateau(plateauCoordinates) || roverCoordinates.checkPointRover(allRoverLocation))
    		roverCoordinates.moveBack(coordinateMove[Direction.valueOf(direction).getValue()][0],
        			coordinateMove[Direction.valueOf(direction).getValue()][1]
        			);

    }
    
    private void turnRight()
    {
    	directionEnum=Direction.valueOf(direction);
    	directionPosition=directionEnum.getValue();
    	
    	if(directionPosition==3)
    		directionPosition=0;
    	else
    		directionPosition++;
    	
    	this.direction=Direction.valueOf(directionPosition).name();
    }
    
    private void turnLeft()
    {
    	directionEnum=Direction.valueOf(direction);
    	directionPosition=directionEnum.getValue();
    	
    	if(directionPosition==0)
    		directionPosition=3;
    	else
    		directionPosition--;
    	
    	this.direction=Direction.valueOf(directionPosition).name();
    }
}
