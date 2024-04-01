package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

class EditorController {
    private EditorModel model;
    private EditorView view;

    public EditorController(EditorModel model, EditorView view) {
        this.model = model;
        this.view = view;
    }

    public void init() {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Computer");
        File[] roots = File.listRoots();
        for (File root : roots) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(root.getAbsolutePath());
            rootNode.add(node);
            buildTree(root, node);
        }
        DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
        view.setTreeModel(treeModel);

        view.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) view.fileTree.getLastSelectedPathComponent();
            if (selectedNode == null) return;
            Object selectedObject = selectedNode.getUserObject();
            if (selectedObject instanceof String) {
                String filePath = (String) selectedObject;
                File file = new File(filePath);
                if (file.isFile()) {
                    model.setCurrentFile(file);
                    view.setTextAreaContent(model.readFile(file));
                }
            }
        });

        view.addSaveButtonListener(e -> {
            String content = view.getTextAreaContent();
            File currentFile = model.getCurrentFile();
            if (currentFile != null) {
                model.saveFile(currentFile, content);
            }
        });
    }

    private void buildTree(File file, DefaultMutableTreeNode parentNode) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File child : files) {
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(child.getAbsolutePath());
                    parentNode.add(node);
                    buildTree(child, node);
                }
            }
        }
    }
}