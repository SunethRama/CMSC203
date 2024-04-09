/*
 * Class: CMSC203 
 * Instructor: Prof. Monshi
 * Description: Property management company
 * Due: 4/8/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Suneth Ramawickrama
*/

public class Plot {

	private int x;
	private int y;
	private int width;
	private int depth;
	
	public Plot() {
		this.width = 1;
		this.depth = 1;
	}
	
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	public Plot(Plot anotherPlot){
		this(anotherPlot.x , anotherPlot.y, anotherPlot.width, anotherPlot.depth);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public boolean overlaps(Plot plot) {
		
		/*
		the plot can be overlapped from left, right, top, and bottom. If all these conditions satisfy,
		the plot is overlapped 
		*/
		
		boolean overlapsFromTheLeft = ( plot.getX() + plot.getWidth() ) > this.x;
		boolean overlapsFromTheRight = plot.getX() < ( this.x + this.width );
		boolean overlapsFromTheTop = ( plot.getY() + plot.getDepth() ) > this.y;
		boolean overlapsFromTheBottom = plot.getY() < this.y + this.depth;

	    return overlapsFromTheLeft && overlapsFromTheRight && overlapsFromTheTop && overlapsFromTheBottom;
	}
	
	public boolean encompasses (Plot plot) {
		
		/* we can check the x bounds by considering the x value of top left and the x value 
		 * of top right of the given plot. If they place inside the width of the company's plot, it is inside 
		 * the x bounds
		*/
	    boolean InXBounds = (plot.getX() >= this.x) && 
	    					((plot.getX() + plot.getWidth()) <= (this.x + this.width));
	    
	    /* we can check the y bounds by considering the y value of top left and the y value 
		 * of bottom left of the given plot. If they place inside the depth of the company's plot, it is inside 
		 * the y bounds
		*/
	    boolean InYBounds = (plot.getY() >= this.y) && 
	    					((plot.getY() + plot.getDepth()) <= (this.y + this.depth));

	    /* if the plot is in x bound and y bounds, it can fit in the comapny's plot*/
	    return InXBounds && InYBounds;
	}
	
	public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }

}
