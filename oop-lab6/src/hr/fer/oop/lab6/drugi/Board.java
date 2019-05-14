package hr.fer.oop.lab6.drugi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The class Board
 * @author Luka
 *
 */

public class Board {
	
	private int width;
	private int height;
	private StateOfCells[][] board;
	private LinkedList<BoardListener> listeners=new LinkedList<>();
	
	/**
	 * Instantiates a new Board
	 * @param width width
	 * @param height height
	 */
	
	public Board(int width, int height) {
		this.width=width;
		this.height=height;
		board=StateOfCells.defaultArray(width, height);
	}
	
	/**
	 * Checks if a cell is alive
	 * 
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @return true if cell is alive, false otherwise
	 */
	
	public boolean isCellAlive(int x, int y) {
		if(x<0 || y<0 || x>=getWidth() || y>=getHeight()) {
			return false;
		}
		if(board[x][y]!=StateOfCells.ALIVE) {
			return false;
		}
		return true;
	}
	
	/**
	 * Getter for width
	 * @return width
	 */
	
	public int getWidth() {
		return width;
	}
	
	/**
	 * Getter for height
	 * @return height
	 */
	
	public int getHeight() {
		return height;
	}
	
	/**
	 * Sets the cell
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @param alive alive
	 */
	
	public void setCell(int x, int y, boolean alive) {
		if(alive==true) {
			board[x][y]=StateOfCells.ALIVE;
		} else {
			board[x][y]=StateOfCells.DEAD;
		}
	}
	
	/**
	 * Counts the alive neighbors
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @return number of alive cells
	 */
	
	public int countAliveNeighbors(int x, int y) {
		int aliveNeighbors=0;
		for(int i=x-1; i<=x+1; i++) {
			for(int j=y-1; j<=y+1; j++) {
				if(i==x && j==y) {
					continue;
				} 
				if(isCellAlive(i,j)) {
					aliveNeighbors+=1;
				}
			}
		}
		return aliveNeighbors;
	}
	
	/**
	 * Plays one iteration of game
	 */
	
	public void playOneIteration() {
		List<Pair<Integer, Integer>> deadElements=new ArrayList<>();
		List<Pair<Integer, Integer>> aliveElements=new ArrayList<>();
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(board[i][j]==StateOfCells.ALIVE) {
					if(countAliveNeighbors(i, j)<2 || countAliveNeighbors(i, j)>3) {
						deadElements.add(new Pair<Integer, Integer>(i,j));
					} else if(board[i][j]==StateOfCells.DEAD) {
						if(countAliveNeighbors(i, j)==3) {
							aliveElements.add(new Pair<Integer,Integer>(i,j));
						}
					}
				}
			}
		}
		
		for(Pair<Integer,Integer> pair : deadElements) {
			board[pair.getLeft()][pair.getRight()]=StateOfCells.DEAD;
		}
		
		for(Pair<Integer,Integer> pair : aliveElements) {
			board[pair.getLeft()][pair.getRight()]=StateOfCells.ALIVE;
		}
		
		listeners.forEach(listener -> listener.boardChanged(this));
	}
	
	/**
	 * Adds the listener
	 * @param listener listener
	 */
	
	public void addListener(BoardListener listener) {
		listeners.add(listener);
	}
	
	/**
	 * Removes the listener
	 * @param listener listener
	 */
	
	public void removeListener(BoardListener listener) {
		listeners.remove(listener);
	}
}
