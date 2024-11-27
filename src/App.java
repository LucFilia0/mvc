import view.Window;
import model.GraduatedClass;
import controller.DataImportation;

import java.io.File;
import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) throws Exception {

        try {
            GraduatedClass gc = DataImportation.importGraduatedClassFrom(new File("data/promoBUT.csv"));

            Window window = new Window("Zikette", gc);
            window.setVisible(true); // TODO
        } catch(FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
