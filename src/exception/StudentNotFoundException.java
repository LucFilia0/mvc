package exception;

public class StudentNotFoundException extends Exception {
	
	public StudentNotFoundException(int number) {
		super("Le numéro " + number + " n'est attribué à aucun étudiant.");
	}
}
