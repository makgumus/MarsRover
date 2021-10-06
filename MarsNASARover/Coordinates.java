package MarsNASARover;

import java.util.List;

public class Coordinates {
	private int x;
    private int y;
    
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void moveForward(int xMove, int yMove) {
        this.x+= xMove;
        this.y+= yMove;
    }
    
    public void moveBack(int xMove, int yMove) {
        this.x-= xMove;
        this.y-= yMove;
    }
    
    public boolean checkRoverOutsidePlateau(Coordinates plateauCoordinate)
    {
    	return plateauCoordinate.getX()<this.x || plateauCoordinate.getY()<this.y || this.x<0 || this.y<0;
    }
    
    public boolean checkPointRover(List<Coordinates> beforeMovedRover)
    {
    	for(Coordinates c : beforeMovedRover)
    	{
    		if (c.getX()==this.x && c.getY()==this.y)
    			return true;
    	}
    	
    	return false;
    }
    
}
