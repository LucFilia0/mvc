import view.Window;
import model.GraduatedClass;

import java.io.File;
import java.io.FileNotFoundException;

import controller.data.DataImportation;

public class App {
    public static void main(String[] args) throws Exception {

        try {
            GraduatedClass gc = DataImportation.importGraduatedClassFrom(new File("data/promoBUT.csv"));
            Window window = new Window("Zikette", gc);
            window.setVisible(true);
        } catch(FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
