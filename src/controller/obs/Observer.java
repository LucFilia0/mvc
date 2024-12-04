package controller.obs;

/**
 * Represents a class thar observes another, and update itself when the Observable
 * sends a notification.
 * 
 * @author Luc le Manifik
 */
public interface Observer {
	
	/**
	 * Refresh / Recreate the view. 
	 */
	public void update();
}
