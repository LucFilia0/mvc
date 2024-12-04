package controller.obs;

/**
 * Represents a class that will be observed by others, and will be able to notify them if
 * there is an update.
 */
public interface Observable {
	
	/**
	 * Adds a new Observer, that will be able to update itself if a notification is send.
	 * @param observer The new Observer
	 */
	public void addObserver(Observer observer);

	/**
	 * Remove an Observer.
	 * @param observer The Observer to remove
	 */
	public void removeObserver(Observer observer);

	/**
	 * Notify all the registered Observers that a changement occured,
	 * and tell them to update themselves.
	 */
	public void notifyObservers();
}
