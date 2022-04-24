/**
 * File: MainFrame.java
 * Authors: Steven Phung, Daniel Tripp, Joseph Freedman
 * Class: CECS-544-01 - Software Test and Verification
 * 
 * Assignment: Semester Project
 * Due Date: April 25, 2022 @ 5pm
 * 
 * Purpose: This is the MainFrame which will contain all other panes and frames.
 */
package filemanager;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.DefaultListModel;

public class MainFrame extends javax.swing.JFrame {
    
    //ArrayList of internal frames to keep track of multiple frames
    private ArrayList<JInternalFrame> windows;
    //Keep track of current list (the one we want to update)
    private JSplitPane currentWindow;
    //Detailed view / simple view
    boolean detailed;
    
    //Constructor
    public MainFrame() {
        initComponents();
        initProperties();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aboutDialog = new javax.swing.JDialog();
        button_OK = new javax.swing.JButton();
        panel_About_ProgramName = new javax.swing.JPanel();
        label_About_ProgramName = new javax.swing.JLabel();
        panel_About_Names = new javax.swing.JPanel();
        label_About_Names = new javax.swing.JLabel();
        panel_Main = new javax.swing.JPanel();
        panel_Toolbar = new javax.swing.JPanel();
        comboBox_Drives = new javax.swing.JComboBox<>();
        button_Details = new javax.swing.JButton();
        button_Simple = new javax.swing.JButton();
        panel_Desktop = new javax.swing.JPanel();
        desktopPane = new javax.swing.JDesktopPane();
        label_Status = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menu_File = new javax.swing.JMenu();
        menuItem_Rename = new javax.swing.JMenuItem();
        menuItem_Copy = new javax.swing.JMenuItem();
        menuItem_Delete = new javax.swing.JMenuItem();
        menuItem_Run = new javax.swing.JMenuItem();
        menuItem_Exit = new javax.swing.JMenuItem();
        menu_Tree = new javax.swing.JMenu();
        menuItem_Expand = new javax.swing.JMenuItem();
        menuItem_Collapse = new javax.swing.JMenuItem();
        menu_Window = new javax.swing.JMenu();
        menuItem_New = new javax.swing.JMenuItem();
        menuItem_Cascade = new javax.swing.JMenuItem();
        menu_Help = new javax.swing.JMenu();
        menuItem_Help = new javax.swing.JMenuItem();
        menuItem_About = new javax.swing.JMenuItem();

        aboutDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        aboutDialog.setTitle("About");
        aboutDialog.setMinimumSize(new java.awt.Dimension(500, 250));
        aboutDialog.setModal(true);

        button_OK.setText("OK");
        button_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_OKActionPerformed(evt);
            }
        });

        label_About_ProgramName.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        label_About_ProgramName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_About_ProgramName.setText("CECS 544 File Manager");

        javax.swing.GroupLayout panel_About_ProgramNameLayout = new javax.swing.GroupLayout(panel_About_ProgramName);
        panel_About_ProgramName.setLayout(panel_About_ProgramNameLayout);
        panel_About_ProgramNameLayout.setHorizontalGroup(
            panel_About_ProgramNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_About_ProgramNameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_About_ProgramName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_About_ProgramNameLayout.setVerticalGroup(
            panel_About_ProgramNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_About_ProgramNameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_About_ProgramName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        label_About_Names.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_About_Names.setText("Copyright (c) 2022 : Steven Phung, Daniel Tripp, Joseph Freedman");

        javax.swing.GroupLayout panel_About_NamesLayout = new javax.swing.GroupLayout(panel_About_Names);
        panel_About_Names.setLayout(panel_About_NamesLayout);
        panel_About_NamesLayout.setHorizontalGroup(
            panel_About_NamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_About_NamesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_About_Names, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_About_NamesLayout.setVerticalGroup(
            panel_About_NamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_About_NamesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_About_Names)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout aboutDialogLayout = new javax.swing.GroupLayout(aboutDialog.getContentPane());
        aboutDialog.getContentPane().setLayout(aboutDialogLayout);
        aboutDialogLayout.setHorizontalGroup(
            aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aboutDialogLayout.createSequentialGroup()
                        .addComponent(button_OK)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panel_About_ProgramName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_About_Names, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        aboutDialogLayout.setVerticalGroup(
            aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_About_ProgramName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_About_Names, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(button_OK)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CECS 544 - File Manager");
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setSize(new java.awt.Dimension(1280, 720));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        panel_Toolbar.setMinimumSize(new java.awt.Dimension(1280, 50));

        comboBox_Drives.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBox_Drives.setMinimumSize(new java.awt.Dimension(200, 38));
        comboBox_Drives.setPreferredSize(new java.awt.Dimension(200, 38));
        comboBox_Drives.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                comboBox_DrivesPopupMenuWillBecomeVisible(evt);
            }
        });
        panel_Toolbar.add(comboBox_Drives);

        button_Details.setText("Details");
        button_Details.setMaximumSize(new java.awt.Dimension(100, 38));
        button_Details.setMinimumSize(new java.awt.Dimension(100, 38));
        button_Details.setPreferredSize(new java.awt.Dimension(100, 38));
        button_Details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_DetailsActionPerformed(evt);
            }
        });
        panel_Toolbar.add(button_Details);

        button_Simple.setText("Simple");
        button_Simple.setMaximumSize(new java.awt.Dimension(100, 38));
        button_Simple.setMinimumSize(new java.awt.Dimension(100, 38));
        button_Simple.setPreferredSize(new java.awt.Dimension(100, 38));
        button_Simple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_SimpleActionPerformed(evt);
            }
        });
        panel_Toolbar.add(button_Simple);

        panel_Desktop.setMinimumSize(new java.awt.Dimension(1280, 642));
        panel_Desktop.setPreferredSize(new java.awt.Dimension(1280, 642));

        desktopPane.setMinimumSize(new java.awt.Dimension(1280, 642));

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_DesktopLayout = new javax.swing.GroupLayout(panel_Desktop);
        panel_Desktop.setLayout(panel_DesktopLayout);
        panel_DesktopLayout.setHorizontalGroup(
            panel_DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_DesktopLayout.setVerticalGroup(
            panel_DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        label_Status.setText("Current Drive:");
        label_Status.setMinimumSize(new java.awt.Dimension(1280, 16));
        label_Status.setPreferredSize(new java.awt.Dimension(1280, 16));

        javax.swing.GroupLayout panel_MainLayout = new javax.swing.GroupLayout(panel_Main);
        panel_Main.setLayout(panel_MainLayout);
        panel_MainLayout.setHorizontalGroup(
            panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Toolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_Desktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_MainLayout.createSequentialGroup()
                .addComponent(label_Status, javax.swing.GroupLayout.PREFERRED_SIZE, 1149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel_MainLayout.setVerticalGroup(
            panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_MainLayout.createSequentialGroup()
                .addComponent(panel_Toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_Desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(panel_Main, java.awt.BorderLayout.CENTER);

        menu_File.setText("File");

        menuItem_Rename.setText("Rename");
        menu_File.add(menuItem_Rename);

        menuItem_Copy.setText("Copy");
        menu_File.add(menuItem_Copy);

        menuItem_Delete.setText("Delete");
        menu_File.add(menuItem_Delete);

        menuItem_Run.setText("Run");
        menuItem_Run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_RunActionPerformed(evt);
            }
        });
        menu_File.add(menuItem_Run);

        menuItem_Exit.setText("Exit");
        menuItem_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_ExitActionPerformed(evt);
            }
        });
        menu_File.add(menuItem_Exit);

        menuBar.add(menu_File);

        menu_Tree.setText("Tree");

        menuItem_Expand.setText("Expand Branch");
        menuItem_Expand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_ExpandActionPerformed(evt);
            }
        });
        menu_Tree.add(menuItem_Expand);

        menuItem_Collapse.setText("Collapse Branch");
        menuItem_Collapse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_CollapseActionPerformed(evt);
            }
        });
        menu_Tree.add(menuItem_Collapse);

        menuBar.add(menu_Tree);

        menu_Window.setText("Window");

        menuItem_New.setText("New Window");
        menuItem_New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_NewActionPerformed(evt);
            }
        });
        menu_Window.add(menuItem_New);

        menuItem_Cascade.setText("Cascade Windows");
        menuItem_Cascade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_CascadeActionPerformed(evt);
            }
        });
        menu_Window.add(menuItem_Cascade);

        menuBar.add(menu_Window);

        menu_Help.setText("Help");

        menuItem_Help.setText("Help");
        menu_Help.add(menuItem_Help);

        menuItem_About.setText("About");
        menuItem_About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_AboutActionPerformed(evt);
            }
        });
        menu_Help.add(menuItem_About);

        menuBar.add(menu_Help);

        setJMenuBar(menuBar);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Function: menuItem_ExitActionPerformed(ActionEvent)
    //Clicking Menu's File > Exit exits program
    private void menuItem_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_ExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_menuItem_ExitActionPerformed

    //Function: menuItem_AboutActionPerformed(ActionEvent)
    //Purpose: Clicking Menu's Help > About creates About dialog box 
    private void menuItem_AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_AboutActionPerformed
        aboutDialog.setLocationRelativeTo(null);
        aboutDialog.setVisible(true);
    }//GEN-LAST:event_menuItem_AboutActionPerformed

    //Function: button_OKActionPerformed(ActionEvent)
    //Purpose: Destroys About dialog box
    private void button_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_OKActionPerformed
        aboutDialog.dispose();
    }//GEN-LAST:event_button_OKActionPerformed

    //Function: comboBox_DrivesPopupMenuWillBecomeVisible(PopupMenuEvent)
    //Purpose: Opening combo box menu will update drivers
    private void comboBox_DrivesPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboBox_DrivesPopupMenuWillBecomeVisible
        //Gets currently selected item
        Object selectedItem = comboBox_Drives.getSelectedItem().toString();
        //Reloads
        reloadDrivers();
        //Displays previously selected item if new item not selected
        comboBox_Drives.setSelectedItem(selectedItem);
    }//GEN-LAST:event_comboBox_DrivesPopupMenuWillBecomeVisible

    //Function: menuItem_NewActionPerformed(ActionEvent)
    //Purpose: Create new internal frame when new window button is clicked
    private void menuItem_NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_NewActionPerformed
        //Update status bar to new window created
        updateStatus(String.valueOf(comboBox_Drives.getSelectedItem()));
        
        //Create internal frame
        JInternalFrame intFrame = new JInternalFrame(String.valueOf(comboBox_Drives.getSelectedItem()), true, true, true, true);
        //Add listener for internal frame
        addInternalFrameListener(intFrame);
        
        //Create scroll pane containing tree
        JScrollPane tree = createRootTree(String.valueOf(comboBox_Drives.getSelectedItem()), intFrame);
        
        //Create scroll pane containing list
        JScrollPane list = createList(String.valueOf(comboBox_Drives.getSelectedItem()));
        
        //Create split pane and add tree to left side and list to right side
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, tree, list);
        
        //Drag n Drop
        splitPane.setDropTarget(new MyDropTarget());
        
        //Set initial divider location and allow divider to be movable
        splitPane.setDividerLocation(150);
        splitPane.setEnabled(true);
        
        //Add split pane to internal frame
        intFrame.add(splitPane);
        
        //New internal window added in cascade style:
        intFrame.setBounds(25 * windows.size() % 700, 25 * windows.size() % 250, 800, 500);
        
        //Internal frame can be resized
        intFrame.setResizable(true);
        intFrame.setVisible(true);
        
        //Add internal frame to main frame window, send frame to front
        windows.add(intFrame);
        desktopPane.add(windows.get(windows.size()-1));
        windows.get(windows.size()-1).toFront();
    }//GEN-LAST:event_menuItem_NewActionPerformed

    //Function: formWindowStateChanged(WindowEvent)
    //Purpose: Resize frame size when window is maximized (iconified) or minimized (deiconified)
    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        resizeInternalWindow();
    }//GEN-LAST:event_formWindowStateChanged

    //Function: formComponentResized(ComponentEvent)
    //Purpose: Resize frame size by clicking and dragging window sides
    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        resizeInternalWindow();
    }//GEN-LAST:event_formComponentResized

    //Function: button_DetailsActionPerformed(ActionEvent)
    //Purpose: When details button in toolbar is clicked, redraw graphics in detailed manner
    private void button_DetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_DetailsActionPerformed
        //Detailed view is set to true
        detailed = true;
        //Update graphics
        currentWindow.update(currentWindow.getGraphics());
    }//GEN-LAST:event_button_DetailsActionPerformed

    //Function: button_SimpleActionPerformed(ActionEvent)
    //Purpose: When simple button in toolbar is clicked, redraw graphics in simple manner
    private void button_SimpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_SimpleActionPerformed
        //Simple view
        detailed = false;
        //Update graphics
        currentWindow.update(currentWindow.getGraphics());
    }//GEN-LAST:event_button_SimpleActionPerformed

    //Function: menuItem_CascadeActionPerformed(ActionEvent)
    //Purpose: When cascade menu button is clicked, each internal frame gets it's position set to a cascade effect
    private void menuItem_CascadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_CascadeActionPerformed
        //Cascade windows
        for(int i = 0, j = 0; i < windows.size(); i++, j++) {
            if(windows.get(i).isIcon()) {
                j--;
                continue;
            }
            windows.get(i).setLocation(25 * j % 700, 25 * j % 250);
            windows.get(i).toFront();
        }
    }//GEN-LAST:event_menuItem_CascadeActionPerformed

    //Function: menuItem_ExpandActionPerformed(ActionEvent)
    //Purpose: Expand tree
    private void menuItem_ExpandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_ExpandActionPerformed
        resizeTree(true);
    }//GEN-LAST:event_menuItem_ExpandActionPerformed
    
    //Function: menuItem_CollapseActionPerformed(ActionEvent)
    //Purpose: Collapse tree
    private void menuItem_CollapseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_CollapseActionPerformed
        resizeTree(false);
    }//GEN-LAST:event_menuItem_CollapseActionPerformed

    //Function: menuItem_RunActionPerformed(ActionEvent)
    //Purpose: Run selected item in list
    private void menuItem_RunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_RunActionPerformed
        try {
            JScrollPane scrollPane = (JScrollPane) currentWindow.getRightComponent();
            JList theList = (JList) scrollPane.getViewport().getView();
            File selectedFile = ((File) theList.getSelectedValue());

            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(selectedFile.getAbsolutePath()));
        } catch (IOException e1) {
            System.out.println("Failed to run selected program.");
        } catch (NullPointerException ex) {
            System.out.println("No file selected.");
        }
    }//GEN-LAST:event_menuItem_RunActionPerformed
    
    //Function: resizeTree(boolean)
    //Purpose: boolean == true means we want to expand tree
    //false means we want to collapse tree
    private void resizeTree(boolean expand) {
        try {
            //Get tree
            JScrollPane scrollPane = (JScrollPane) currentWindow.getLeftComponent();
            JTree currentTree = (JTree) scrollPane.getViewport().getView();
            if(expand)
                //Trigger tree's expand action
                currentTree.fireTreeExpanded(currentTree.getSelectionPath());
            else
                //Trigger tree's collapse action
                currentTree.fireTreeCollapsed(currentTree.getSelectionPath());
        } catch(Exception e) {
            //A tree node must be selected to expand/collapse
            System.out.println("Cannot expand this branch or branch has not been selected");
        }
    }
    
    //Function: resizeInternalWindow()
    //Purpose: Resize DesktopPane so it fits inside frame when the window size is changed
    private void resizeInternalWindow() {
        //Combined height of toolbar/statusbar/menu
        int heightOtherComponents = 140;
        panel_Desktop.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()-heightOtherComponents));
        desktopPane.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()-heightOtherComponents));
        panel_Desktop.setSize(new Dimension(this.getWidth(), this.getHeight()-heightOtherComponents));
        desktopPane.setSize(new Dimension(this.getWidth(), this.getHeight()-heightOtherComponents));
    }
    
    //Function: addInternalFrameListener(JInternalFrame)
    //Purpose: adds an InternalFrameListener to the given JInternalFrame
    //Every frame will have its own listener
    private void addInternalFrameListener(JInternalFrame intFrame) {
        intFrame.addInternalFrameListener(new InternalFrameListener() {
            @Override
            public void internalFrameOpened(InternalFrameEvent e) {}
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {}
            //Listener for when frame is closed
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                //Remove any frames that are closed
                for(int i = 0; i < windows.size(); i++) { 		      
                    if(windows.get(i).isClosed()) {
                        windows.remove(i);
                    }
                }
            }
            @Override
            public void internalFrameIconified(InternalFrameEvent e) {}
            @Override
            public void internalFrameDeiconified(InternalFrameEvent e) {}
            //Listener for when the frame gains focus
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                //Update status bar to reflect correct drive
                updateStatus(intFrame.getTitle());
                //First grab internal frame's components
                Component[] comps = intFrame.getContentPane().getComponents();
                for (Component comp : comps) {
                    //Find the JSplitPane inside internal frame (JSplitPane contains JTree/JList)
                    if (comp instanceof JSplitPane) {
                        currentWindow = (JSplitPane) comp;
                    }
                }
            }
            @Override
            public void internalFrameDeactivated(InternalFrameEvent e) {}
        });
    }
    
    //Function: updateList(String)
    //Purpose: Update list given a String path to a directory
    private void updateList(String directory) {
        //Get model
        JScrollPane scrollPane = (JScrollPane) currentWindow.getRightComponent();
        JList currentList = (JList) scrollPane.getViewport().getView();
        DefaultListModel model = (DefaultListModel) currentList.getModel();
        
        //Clear model
        model.clear();
        
        //Get files
        File fileRoot = new File(directory);
        File[] folder = fileRoot.listFiles();
        
        //If no files found in folder
        if(folder == null)
            return;
        
        //Add files to model
        for(File f : folder) {
            model.addElement(f);
        }
    }
    
    //Function: createList(String)
    //Purpose: Create a scrollpane containing a list structure representing the files in a directory
    //using the given String path
    private JScrollPane createList(String directory) {
        //Get files
        File fileRoot = new File(directory);
        File[] folder = fileRoot.listFiles();

        //Create model, add files to model
        DefaultListModel model = new DefaultListModel();
        for (File f: folder) {
            model.addElement(f);
        }
        
        //Add model to list
        JList list = new JList(model);
        
        //List listener
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //System.out.println("List: " + e.toString());
            }
        });
        
        
        //creates the JPopUpMenu for single click use and defines menu functionality
        JPopupMenu fileEditMenu = new JPopupMenu("FileEdit");
        
        //rename will use the RenameFrame class
        JMenuItem renameMenuItem = new JMenuItem("Rename");
        //Listener for rename
        ActionListener renameListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Get selected file from current list
                    JScrollPane scrollPane = (JScrollPane) currentWindow.getRightComponent();
                    JList currentList = (JList) scrollPane.getViewport().getView();
                    File selectedFile = ((File) currentList.getSelectedValue());
                    
                    //Get path to destination
                    JInternalFrame frame = (JInternalFrame) currentWindow.getParent().getParent().getParent().getParent();
                    String currentPath = frame.getTitle();
                    
                    //Rename
                    RenameFrame rename = new RenameFrame("Rename", currentPath, selectedFile.getName());
                    
                    //Update list visually
                    updateList(currentPath);
                } catch(Exception ex) {}
            }
        };
        
        //Add rename functionality to popup menu and toolbar menu
        renameMenuItem.addActionListener(renameListener);
        menuItem_Rename.addActionListener(renameListener);
        
        //copy will also use the RenameFrame class
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        //Listener for copy
        ActionListener copyListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Get selected file from current list
                    JScrollPane scrollPane = (JScrollPane) currentWindow.getRightComponent();
                    JList currentList = (JList) scrollPane.getViewport().getView();
                    File selectedFile = ((File) currentList.getSelectedValue());
                    
                    //Get path to destination
                    JInternalFrame frame = (JInternalFrame) currentWindow.getParent().getParent().getParent().getParent();
                    String currentPath = frame.getTitle();
                    
                    //Copy
                    RenameFrame rename = new RenameFrame("Copy", currentPath, selectedFile.getName());

                    //Update list visually
                    updateList(currentPath);
                } catch(Exception ex) {}
            }
        };
        
        //Add copy functionality to popup menu and toolbar menu
        copyMenuItem.addActionListener(copyListener);
        menuItem_Copy.addActionListener(copyListener);

        JMenuItem pasteMenuItem = new JMenuItem("Paste");
        //Paste functionality??
        
        //delete will use a lightweight JOptionPane for decision making
        JMenuItem deleteMenuItem = new JMenuItem("Delete");
        //Listener for delete
        ActionListener deleteListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Get selected file from current list
                    JScrollPane scrollPane = (JScrollPane) currentWindow.getRightComponent();
                    JList currentList = (JList) scrollPane.getViewport().getView();
                    File selectedFile = ((File) currentList.getSelectedValue());

                    //Get path to destination
                    JInternalFrame frame = (JInternalFrame) currentWindow.getParent().getParent().getParent().getParent();
                    String currentPath = frame.getTitle();
                    
                    //Option dialog
                    Object[] options = {"Yes", "No"};
                    int choice = JOptionPane.showOptionDialog((JScrollPane) currentWindow.getRightComponent(),"Delete " + selectedFile.getAbsolutePath(),
                                    "Deleting!",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);

                    if(choice==0) {
                        //Delete and update list visually
                        selectedFile.getAbsoluteFile().delete();
                        updateList(currentPath);
                    }
                } catch(Exception ex) {}
            }
        };
        
        //Add delete functionality to popup menu and toolbar menu
        deleteMenuItem.addActionListener(deleteListener);
        menuItem_Delete.addActionListener(deleteListener);
        
        //adds the completed menu items to the fileEditMenu
        fileEditMenu.add(renameMenuItem); fileEditMenu.add(copyMenuItem);
        fileEditMenu.add(pasteMenuItem); fileEditMenu.add(deleteMenuItem);
        
        //Add mouseButtonListener to jList for single and double clicking
        MouseListener listClickListener = new ClickListener() {
        	
        	//Defines behavior for the new listener
        	//single click behavior
            public void singleClick(MouseEvent e) {
                JList<String> theList = (JList) e.getSource();
                
                //removes the selection and cancels action if cursor is not hovering a list item
                int index = theList.locationToIndex(e.getPoint());
                boolean withinBounds = index > -1 && theList.getCellBounds(index, index).contains(e.getPoint());
                if(!withinBounds) {
                	theList.clearSelection();
                	return;
                }
                
            	//creates the JPopUpMenu
            	fileEditMenu.show(e.getComponent(), e.getX(), e.getY());  
            }
            
            //double click behavior
            public void doubleClick(MouseEvent e) {
            	JList<String> theList = (JList) e.getSource();
            	
            	//removes the selection and cancels action if cursor is not hovering a list item
                int index = theList.locationToIndex(e.getPoint());
                boolean withinBounds = index > -1 && theList.getCellBounds(index, index).contains(e.getPoint());
                if(!withinBounds) {
                	theList.clearSelection();
                	return;
                }
            	
                File selectedFile = ((File) list.getSelectedValue());
                try {
                	Desktop desktop = Desktop.getDesktop();
                    desktop.open(new File(selectedFile.getAbsolutePath()));
				} catch (IOException e1) {
					System.out.println("Failed to run selected program.");
				}
            }
        };
          
        //appends the new listener to jList  
        list.addMouseListener(listClickListener);
        
        //Custom labeling and icons for folders / files
        list.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                //Get File
                File file = (File) value;
                
                //Get date last modified and format it
                long dateLastModified = file.lastModified();
                DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                
                //File size in bytes
                long fileSize = file.length();
                
                //Set text to display file info
                if(detailed)    
                    label.setText(String.format("%-30s %12s %,15d", file.getName(), sdf.format(dateLastModified), fileSize));
                else
                    label.setText(file.getName());
                
                //Folder icon for folders
                if (value instanceof File && ((File) value).isDirectory()) {
                    Icon folderIcon = new ImageIcon(MainFrame.class.getClassLoader().getResource("resources/closed.png"));
                    label.setIcon(folderIcon);
                //File icons for regular files
                } else if(value instanceof File && ((File) value).isFile()) {
                    Icon docIcon = new ImageIcon(MainFrame.class.getClassLoader().getResource("resources/file.png"));
                    label.setIcon(docIcon);
                }
                return label;
            }
        });

        //Set as monospaced font for easier formatting
        list.setFont(new Font("Courier New", Font.PLAIN, 14));
        //Allow multiple file selection
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //List all things in a single vertical column
        list.setLayoutOrientation(JList.VERTICAL);
        //List as many rows as possible
        list.setVisibleRowCount(-1);
        //Drag enable (?)
        list.setDragEnabled(true);
        //Return scrollpane with list inside
        return new JScrollPane(list);
    }

    //Function: createRootTree(String, JInternalFrame)
    //Purpose: Create a scroll pane containing tree structure representing the entire folder structure
    //using the given directory path
    private JScrollPane createRootTree(String root, JInternalFrame frame) {
        //Create root node, treemodel, and tree
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(root);
        DefaultTreeModel treeModel = new DefaultTreeModel(top);
        JTree tree = new JTree(treeModel);
        
        //Add tree listener to tree
        addTreeListener(tree, frame);
        
        //Set icons for tree
        DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) tree.getCellRenderer();
        Icon openIcon = new ImageIcon(MainFrame.class.getClassLoader().getResource("resources/open.png"));
        Icon closedIcon = new ImageIcon(MainFrame.class.getClassLoader().getResource("resources/closed.png"));
        
        //Directories that have subdirectories have an empty dummy node so the system registers
        //it as a ClosedDirectory (otherwise it is seen as leaf) (this matches the screenshots provided)
        renderer.setOpenIcon(openIcon);
        renderer.setClosedIcon(openIcon);
        renderer.setLeafIcon(closedIcon);

        //Create nodes of directories and add to the tree
        createNodes(root, top);
        //Expand tree one level
        expandNodes(tree, top);
        //Return scrollpane containing tree
        return new JScrollPane(tree);
    }
    
    //Function: addTreeListener(JTree, JInternalFrame)
    //Purpose: adds a TreeExpansionListener to the given JTree
    //Every frame will have its own listener
    private void addTreeListener(JTree tree, JInternalFrame frame) {
        //Listener for when tree is expanded 
        tree.addTreeExpansionListener(new TreeExpansionListener() {
            @Override
            public void treeExpanded(TreeExpansionEvent event) {
                //Get tree model
                DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
                
                //Get node that was clicked on
                TreePath tp = event.getPath();
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tp.getLastPathComponent();
                
                //Build path to directory given tree path
                String currentPath = buildPath(tp);

                //Update frame title to path
                frame.setTitle(currentPath);
                
                //If we found a dummy node, tree was not expanded yet
                //So simply remove the dummy node and expand 1 level further
                if(node.getChildAt(node.getChildCount()-1).toString().equals("empty")) {
                    //Remove the dummy node
                    node.removeAllChildren();

                    //Add nodes to current node with found directories using file path
                    createNodes(currentPath, node);

                    //Expand tree a level
                    expandNodes(tree, node);

                    //Reload tree
                    model.reload(node);
                //If no dummy node is found, tree has already been expanded
                //So simply get all the previously expanded nodes and re-expand
                } else {
                    //List of tree paths
                    ArrayList<TreePath> paths = new ArrayList<>();
                    Enumeration<TreePath> expandEnum = tree.getExpandedDescendants(tp);
                    //Add paths of nodes to arraylist that have been expanded
                    while(expandEnum.hasMoreElements()) {
                        paths.add(expandEnum.nextElement());
                    }
                    //Expand paths
                    for(TreePath p : paths) {
                        tree.expandPath(p);
                    }
                }
            }
            @Override
            public void treeCollapsed(TreeExpansionEvent event) {
            }
        });
        
        //Listener for when a node is selected (clicked) in the tree
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //Update list to match selected folder
                TreePath tp = e.getPath();
                String currentPath = buildPath(tp);
                //Set title
                frame.setTitle(currentPath);
                updateList(currentPath);
            }
        });
    }
    
    //Function: buildPath(TreePath)
    //Purpose: Build absolute path for folder given tree path
    private String buildPath(TreePath tp) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < tp.getPath().length; i++) {
            //Add "\" for example: "C:\DocumentsAnotherFolder" becomes "C:\Documents\AnotherFolder"
            if(i > 1) {
                sb.append("\\").append(tp.getPath()[i].toString());
            } else {
                sb.append(tp.getPath()[i].toString());
            }
        }
        return sb.toString();
    }
    
    //Function: expandNodes(JTree, DefaultMutableTreeNode)
    //Purpose: Takes a tree and a node and expands 1 level beyond the given node
    private void expandNodes(JTree tree, DefaultMutableTreeNode top) {
        DefaultMutableTreeNode currentNode = top;
        do {
            if (currentNode.getLevel() == 0)
                tree.expandPath(new TreePath(currentNode.getPath()));
            currentNode = currentNode.getNextNode();
        } while (currentNode != null);
    }
    
    //Function: createNodes(String, DefaultMutableTreeNode)
    //Purpose: Takes current node and adds any subdirectories to tree
    private void createNodes(String root, DefaultMutableTreeNode top) {
        //Get list of files in current directory
        File fileRoot = new File(root);
        File[] files = fileRoot.listFiles();
        
        if(files == null)
            return;
        
        //For each file in directory, check if there is a subdirectory
        for(File file : files) {
            String fileName = file.toString().substring(file.toString().lastIndexOf("\\") + 1);
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(fileName);
            //If there is a subdirectory, add it to the tree
            if(file.isDirectory()) {
                top.add(newNode);
                File[] subFiles = file.listFiles();
                //Checking subdirectory's files for diretories (for correct rendering)
                if(subFiles != null) {
                    for(File subfiles : subFiles) {
                        //If there is a folder inside subdirectory, add dummy node
                        //Dummy node is there so the correct icon appears, but the user will never see this
                        if(subfiles.isDirectory()) {
                            DefaultMutableTreeNode emptyNode = new DefaultMutableTreeNode("empty");
                            newNode.add(emptyNode);
                            //Immediately break after finding at least 1 directory 
                            break;
                        }
                    }
                }
            }
        }
    }

    //Function: updateStatus(String)
    //Purpose: updates status bar based on given string path
    public void updateStatus(String root) {
        //No drive selected yet
        if(root.equals("none")){
            label_Status.setText("Current Drive: None selected.");
        } else {
            //Get drive
            String selectedDrive = String.valueOf(root).substring(0, 3);
            
            //Get drive's attributes
            File[] drives = File.listRoots();
            for (File drive : drives) {
                //For selected driver get attributes
                if(String.valueOf(drive).equals(selectedDrive)) {
                    long freeSpace = drive.getFreeSpace()/(1024*1024*1024);
                    long totalSpace = drive.getTotalSpace()/(1024*1024*1024);
                    //Update label to display attributes
                    label_Status.setText("Current Drive: " + drive + "     Free Space: " + freeSpace + "GB     Used Space: " + (totalSpace - freeSpace) + "GB     Total Space: " + totalSpace + "GB");
                }
            }
        }
    }
    
    //Function: reloadDrivers()
    //Purpose: reloads drivers into combobox
    private void reloadDrivers() {
        comboBox_Drives.removeAllItems();
        File[] paths = File.listRoots();
        for(File path:paths) {
            comboBox_Drives.addItem(path.toString());
        }
    }
    
    //Function: initProperties
    //Purpose: Initializes features and properties needed for main frame
    private void initProperties() {
        //Desktop Pane's windows
        windows = new ArrayList<>();
        //Detail viewing
        detailed = true;
        //Load drivers in comboBox
        reloadDrivers();
        //Initialize status bar
        updateStatus("none");
        //Shows window
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog aboutDialog;
    private javax.swing.JButton button_Details;
    private javax.swing.JButton button_OK;
    private javax.swing.JButton button_Simple;
    private javax.swing.JComboBox<String> comboBox_Drives;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel label_About_Names;
    private javax.swing.JLabel label_About_ProgramName;
    private javax.swing.JLabel label_Status;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItem_About;
    private javax.swing.JMenuItem menuItem_Cascade;
    private javax.swing.JMenuItem menuItem_Collapse;
    private javax.swing.JMenuItem menuItem_Copy;
    private javax.swing.JMenuItem menuItem_Delete;
    private javax.swing.JMenuItem menuItem_Exit;
    private javax.swing.JMenuItem menuItem_Expand;
    private javax.swing.JMenuItem menuItem_Help;
    private javax.swing.JMenuItem menuItem_New;
    private javax.swing.JMenuItem menuItem_Rename;
    private javax.swing.JMenuItem menuItem_Run;
    private javax.swing.JMenu menu_File;
    private javax.swing.JMenu menu_Help;
    private javax.swing.JMenu menu_Tree;
    private javax.swing.JMenu menu_Window;
    private javax.swing.JPanel panel_About_Names;
    private javax.swing.JPanel panel_About_ProgramName;
    private javax.swing.JPanel panel_Desktop;
    private javax.swing.JPanel panel_Main;
    private javax.swing.JPanel panel_Toolbar;
    // End of variables declaration//GEN-END:variables
}
