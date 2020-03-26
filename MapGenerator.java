import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapGenerator {
	
	public Cell map[][];
	public int brickWidth;
	//public Cell mapNextGen[][];
	public int brickHeight;
	
	public MapGenerator(int row, int col) {
		this.map = new Cell[row][col];
		for(int i = 0; i < this.map.length; i++) {
			for( int j = 0; j < this.map[0].length; j++) {
				Cell cell = new Cell(i,j);
				cell.setDeath();
				this.map[i][j] = cell;
			}
		}		
		brickWidth = 25;
		brickHeight = 25;
	}
	
	public void draw(Graphics2D g) {
		for(int i = 0; i < map.length; i++) {
			for( int j = 0; j < map[0].length; j++) {
				if(map[i][j].getIsAlive() == true) {
					g.setColor(Color.green);
					g.fillRect(j * brickWidth,  i * brickHeight,  brickWidth,  brickHeight);
				} else {
					g.setColor(Color.black);
					g.fillRect(j * brickWidth,  i * brickHeight,  brickWidth,  brickHeight);
				}
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.white);
				g.drawRect(j * brickWidth,i * brickHeight, brickWidth, brickHeight);	
			}
		}
	}
	
	public void nextGeneration(MapGenerator Nextmap) {
		for(int i = 0; i < this.map.length; i++) {
			for( int j = 0; j < this.map[0].length; j++) {
				int posX = this.map[i][j].getX();
				int posY = this.map[i][j].getY();
				int neighborsSum = this.getNeighbors(this.map[i][j]);
				if( this.map[i][j].getIsAlive() == false ) {
					if( neighborsSum == 3 ) {
						Nextmap.map[i][j].setAlive();
						//System.out.println("SetAlive: posX: " + posX +", posY: " + posY + ", NeighborsSum: " + neighborsSum);
					}
				} 
				if( this.map[i][j].getIsAlive() == true ) {
					if( neighborsSum <= 1 || neighborsSum > 3 ) {
						Nextmap.map[i][j].setDeath();
						//System.out.println("SetDeath: posX: " + posX +", posY: " + posY + ", NeighborsSum: " + neighborsSum);

					}
				}
			}
		}
	}
	
	public int getNeighbors(Cell cell) {
		int X = cell.getX();
		int Y = cell.getY();
		int neighborsSum = 0;
		for(int i = X -1; i <= X +1; i++) {
			for(int j = Y -1; j <= Y +1; j++) {
				int posX = i;
				int posY = j;
				
				if( i == -1) {
					posX = 27;
				}
				if( i == 28) {
					posX = 0;
				}
				if( j == -1) {
					posY = 27;
				}
				if( j == 28) {
					posY = 0;
				}
				
				if( this.map[posX][posY] != this.map[X][Y]) {
					if(this.map[posX][posY].getIsAlive() == true ) {
						neighborsSum = neighborsSum +1; 
						System.out.println("Cell: " + X+"/"+Y +" Neighbor: "+ posX+"/"+posY + "IsAlive: NeighborsSum: " + neighborsSum);
					}
				}
			}
		}
		return neighborsSum;
	}
	
	public void copyMapInto(MapGenerator map2) {
		//System.out.println("copy map");
		for(int i = 0; i < this.map.length; i++) {
			for( int j = 0; j < this.map[0].length; j++) {
				int x = this.map[i][j].getX();
				int y = this.map[i][j].getY();
				boolean isAlive = this.map[i][j].getIsAlive();
				map2.map[i][j].setValues(x,y,isAlive);
			}
		}
	}
}
