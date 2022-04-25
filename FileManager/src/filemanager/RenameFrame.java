/**
 * File: RenameFrame.java
 * Authors: Steven Phung, Daniel Tripp, Joseph Freedman
 * Class: CECS-544-01 - Software Test and Verification
 * 
 * Assignment: Semester Project
 * Due Date: April 25, 2022 @ 5pm
 * 
 * Purpose: This creates the Dialog for requesting a file to be renamed / copied.
 */
package filemanager;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RenameFrame extends JDialog implements ActionListener {

	String directory, operation;
	JLabel currentDirLabel, fromLabel, toLabel;
	JTextField fromText, toText;
	JButton ok, cancel;
	
	public RenameFrame(String op, String curDir, String curFile) {
		super();
		this.setModal(true);
		setTitle(op);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		directory = curDir;
		operation = op;
		
		currentDirLabel = new JLabel("Current Directory:            " + curDir);  
		currentDirLabel.setBounds(25,20,400,20);
		fromLabel = new JLabel("From:");  
		fromLabel.setBounds(25,60,300,20);
		toLabel = new JLabel("To:");  
		toLabel.setBounds(25,85,300,20);
		add(currentDirLabel);add(fromLabel);add(toLabel);
		
		fromText = new JTextField(curFile);
		fromText.setBounds(100,60,300,20);
		toText = new JTextField();
		toText.setBounds(100,85,300,20);
		add(fromText);add(toText);
		
		ok = new JButton("Ok");
        ok.setBounds(450,25,100,30);
        cancel = new JButton("Cancel");
        cancel.setBounds(450,75,100,30);
        ok.addActionListener(this);
        cancel.addActionListener(this);
        
        add(ok); add(cancel);
        
        setSize(new Dimension(600, 180));
        setLocationRelativeTo(null);
        setLayout(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==ok) {
			try {
				Path source = Paths.get(directory + "\\" + fromText.getText());
				if(operation.equals("Rename")) {
					Files.move(source, source.resolveSibling(toText.getText()));
				}
				if(operation.equals("Copy")) {
					Files.copy(source, Paths.get(directory + "\\" + toText.getText()));
				}
			} catch (IOException e1) {}
			this.setVisible(false);
		}
		
		if(e.getSource()==cancel) { this.setVisible(false); }
	}
	
}
