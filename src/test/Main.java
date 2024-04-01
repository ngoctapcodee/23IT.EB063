package test;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        EditorModel model = new EditorModel();
        EditorView view = new EditorView();
        EditorController controller = new EditorController(model, view);

        SwingUtilities.invokeLater(() -> {
            controller.init();
            view.setVisible(true);
        });
    }
}