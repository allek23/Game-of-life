import java.util.Random;

public class Cell {
	
	boolean isAlive;
	int X;
	int Y;
	
	public Cell(int x, int y) {
		this.X = x;
		this.Y = y;
	}
	
	public void setAlive() {
		this.isAlive = true;
	}
	
	public void setDeath() {
		this.isAlive = false;
	}
	
	
	public boolean getIsAlive() {
		return this.isAlive;
	}
	
	public int getX() {
		return this.X;
	}
	
	public int getY() {
		return this.Y;
	}
	
	public void setValues(int x, int y, boolean isAlive) {
		this.X = x;
		this.Y = y;
		this.isAlive = isAlive;
	}
	
}
