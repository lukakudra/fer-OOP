package hr.fer.oop.lab6.drugi;

/**
 * The enumeration StateOfCells
 * @author Luka
 *
 */

public enum StateOfCells {
	ALIVE, DEAD;
	
	/**
	 * Array of default values
	 * @param width width
	 * @param height height
	 * @return cell state [] []
	 */
	
	public static StateOfCells[][] defaultArray(int width, int height) {
		StateOfCells[][] result=new StateOfCells[width][height];
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result.length; j++) {
				result[i][j]=DEAD;
			}
		}
		return result;
	}
}
