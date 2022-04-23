/**
 * File: MyDropTarget.java
 * Authors: Steven Phung, Daniel Tripp, Joseph Freedman
 * Class: CECS-544-01 - Software Test and Verification
 * 
 * Assignment: Semester Project
 * Due Date: April 25, 2022 @ 5pm
 * 
 * Purpose: This class executes the internal and external drag and drop for main frame.
 */
package filemanager;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

class MyDropTarget extends DropTarget {

    @Override
    public void drop(DropTargetDropEvent evt) {
        //Get current model to add to
        JSplitPane splitPane = (JSplitPane) evt.getDropTargetContext().getDropTarget().getComponent();
        JScrollPane scrollPane = (JScrollPane) splitPane.getRightComponent();
        JList currentList = (JList) scrollPane.getViewport().getView();
        DefaultListModel model = (DefaultListModel) currentList.getModel();

        //Get current window frame's path directory
        JInternalFrame frame = (JInternalFrame) evt.getDropTargetContext().getDropTarget().getComponent().getParent().getParent().getParent().getParent();
        //Get path to destination/target
        String currentPath = frame.getTitle();

        try {
            evt.acceptDrop(DnDConstants.ACTION_COPY);
            //Internal DnD
            if(evt.getTransferable().isDataFlavorSupported(DataFlavor.stringFlavor)) {
                String temp = (String) evt.getTransferable().getTransferData(DataFlavor.stringFlavor);
                String[] next = temp.split("\\n");
                for(int i = 0; i < next.length; i++) {
                    //Get file
                    File f = new File(next[i]);
                    //Add to model
                    model.addElement(f);
                    //If file already exists in directory
                    if(f.getAbsolutePath().equals(toPath(f, currentPath)))
                        throw new FileAlreadyExistsException("");
                    //Copy to new directory
                    Files.copy(Paths.get(f.getAbsolutePath()), Paths.get(toPath(f, currentPath)));
                }
            //External DnD
            } else {
                List result = (List) evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                for(Object o : result) {
                    //Get file
                    File f = (File) o;
                    //Add to model
                    model.addElement(f);
                    //If file already exists in directory
                    if(f.getAbsolutePath().equals(toPath(f, currentPath)))
                        throw new FileAlreadyExistsException("");
                    //Copy to new directory
                    Files.copy(Paths.get(f.getAbsolutePath()), Paths.get(toPath(f, currentPath)));
                }
            }
        } catch(FileAlreadyExistsException ex) {
            model.removeElementAt(model.getSize()-1);
            System.out.println("File already exists in directory");
        } catch(UnsupportedFlavorException | IOException ex) {
            System.out.println(ex);
        }
    }

    public String toPath(File file, String currentPath) {
        String toPath = "";
        if(currentPath.length() != 3) {
            toPath = currentPath + "\\" + file.getName();
        } else {
            toPath = currentPath + file.getName();
        }
        return toPath;
    }
}