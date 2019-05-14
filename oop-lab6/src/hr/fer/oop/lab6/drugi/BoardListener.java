package hr.fer.oop.lab6.drugi;

/**
 * The listener interface for receiving board events. The class
 * that is interested in processing a board event implements this
 * interface, and the object created with that class is registered 
 * with a component using the component's <code>addBoardListener<code> method.
 * When the board event occurs, that object's appropriate method is invoked.
 * 
 * @see BoardEvent
 * @author Luka
 *
 */

public interface BoardListener {
	
	/**
	 * Board changed
	 * @param board board
	 */
	void boardChanged(Board board);
}
