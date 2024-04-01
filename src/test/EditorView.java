package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeModel;
	    class EditorView extends JFrame {
	        JTree fileTree;
	        private JTextArea textArea;
	        private JButton saveButton;

	        public EditorView() {
	            setTitle("Text Editor");
	            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            setSize(600, 400);
	            setLocationRelativeTo(null);

	            fileTree = new JTree();
	            JScrollPane treeScrollPane = new JScrollPane(fileTree);
	            getContentPane().add(treeScrollPane, BorderLayout.WEST);

	            textArea = new JTextArea();
	            JScrollPane textAreaScrollPane = new JScrollPane(textArea);
	            getContentPane().add(textAreaScrollPane, BorderLayout.CENTER);

	            saveButton = new JButton("Save");
	            getContentPane().add(saveButton, BorderLayout.SOUTH);
	        }

	        public void setTreeModel(DefaultTreeModel treeModel) {
	            fileTree.setModel(treeModel);
	        }

	        public void addTreeSelectionListener(TreeSelectionListener listener) {
	            fileTree.addTreeSelectionListener(listener);
	        }

	        public void setTextAreaContent(String content) {
	            textArea.setText(content);
	        }

	        public String getTextAreaContent() {
	            return textArea.getText();
	        }

	        public void addSaveButtonListener(ActionListener listener) {
	            saveButton.addActionListener(listener);
	        }
	    }
