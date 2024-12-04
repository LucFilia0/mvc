package exception;

/**
 * Exception threw when no student matches the searched number.
 * 
 * @author Luc le Manifik
 */
public class StudentNotFoundException extends Exception {
	
	/**
	 * Creates a new StudentNotFoundException.
	 * @param number The number that gave nothing.
	 */
	public StudentNotFoundException(int number) {
		super("Le numéro " + number + " n'est attribué à aucun étudiant.");
	}
}
