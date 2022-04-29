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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;

public class MainFrame extends JFrame {
    
    //Panels
    private JPanel panel_About_Names;           //About panel (names)
    private JPanel panel_About_ProgramName;     //About panel (program name)
    private JPanel panel_Desktop;               //Panel for JDesktopPane
    private JPanel panel_Main;                  //Main panel
    private JPanel panel_Toolbar;               //Panel for toolbar
    
    //Dialog
    private JDialog aboutDialog;                //dialog for about
    
    //Buttons
    private JButton button_Simple;              //Simple button (toolbar)
    private JButton button_Details;             //Details button (toolbar)
    private JButton button_OK;                  //OK button (about)
    
    //Combobox
    private JComboBox<String> comboBox_Drives;  //Display drives
    
    //DesktopPane
    private JDesktopPane desktopPane;           //Hold internal frames
    
    //Labels
    private JLabel label_About_Names;           //Names in about dialog
    private JLabel label_About_ProgramName;     //Program name in about dialog
    private JLabel label_Status;                //Drive status at bottom of window
    
    //Menu bar
    private JMenuBar menuBar;                   //Menu in toolbar
    
    //Menu items (categories)
    private JMenu menu_File;                    //File menu
    private JMenu menu_Tree;                    //Tree menu
    private JMenu menu_Window;                  //Window menu
    private JMenu menu_Help;                    //Help menu
    
    //Menu items
    private JMenuItem menuItem_Rename;          //Rename menu button
    private JMenuItem menuItem_Copy;            //Copy menu button
    private JMenuItem menuItem_Delete;          //Delete menu button
    private JMenuItem menuItem_Run;             //Run menu button
    private JMenuItem menuItem_Exit;            //Exit menu button
    private JMenuItem menuItem_Expand;          //Expand menu button
    private JMenuItem menuItem_Collapse;        //Collapse menu button
    private JMenuItem menuItem_New;             //New window menu button
    private JMenuItem menuItem_Cascade;         //Cascade menu button
    private JMenuItem menuItem_Help;            //Help menu button
    private JMenuItem menuItem_About;           //About menu button
    
    //Arraylist of JInternalFrames
    private ArrayList<JInternalFrame> windows;  //Track multiple frames
    
    //JSplitPane
    private JSplitPane currentWindow;           //Current window's JSplitPane (hold's tree/list)
    
    //Constructor
    public MainFrame() {
        initComponents();
        setTitle("CECS 544 Project - Steven Phung [Daniel Tripp, Joseph Freedman]");
    }
    
    //Function: initComponents()
    //Purpose: Create components, add and set locations, initialize to start up data state
    private void initComponents() {
        
        //Panels
        panel_About_Names = new JPanel();
        panel_About_ProgramName = new JPanel();
        panel_Desktop = new JPanel();
        panel_Main = new JPanel();
        panel_Toolbar = new JPanel();
        
        //About dialog
        aboutDialog = new JDialog();
        
        //Buttons
        button_Simple = new JButton();
        button_Details = new JButton();
        button_OK = new JButton();
        
        //Combobox
        comboBox_Drives = new JComboBox<>();
        
        //DesktopPane
        desktopPane = new JDesktopPane();
        
        //Labels
        label_About_Names = new JLabel();
        label_About_ProgramName = new JLabel();
        label_Status = new JLabel();
        
        //Menu bar
        menuBar = new JMenuBar();
        
        //Menu items (categories)
        menu_File = new JMenu();
        menu_Tree = new JMenu();
        menu_Window = new JMenu();
        menu_Help = new JMenu();
        
        //Menu items
        menuItem_Rename = new JMenuItem();
        menuItem_Copy = new JMenuItem();
        menuItem_Delete = new JMenuItem();
        menuItem_Run = new JMenuItem();
        menuItem_Exit = new JMenuItem();
        menuItem_Expand = new JMenuItem();
        menuItem_Collapse = new JMenuItem();
        menuItem_New = new JMenuItem();
        menuItem_Cascade = new JMenuItem();
        menuItem_Help = new JMenuItem();
        menuItem_About = new JMenuItem();

        //About Dialog
        aboutDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);     //Destroy component on close
        aboutDialog.setTitle("About");                                              //Title
        aboutDialog.setMinimumSize(new Dimension(500, 250));                        //Size
        aboutDialog.setModal(true);                                                 //Block input to other windows

        //Labels in About Dialog
        label_About_ProgramName.setFont(new Font("Segoe UI", 0, 24));                                   //Font
        label_About_ProgramName.setHorizontalAlignment(SwingConstants.CENTER);                          //Center text
        label_About_ProgramName.setText("CECS 544 File Manager");                                       //Text
        label_About_Names.setHorizontalAlignment(SwingConstants.CENTER);                                //Center text
        label_About_Names.setText("Copyright (c) 2022 : Steven Phung, Daniel Tripp, Joseph Freedman");  //Text
        
        //Layout for panels in about dialog (horizontal)
        GroupLayout panel_About_ProgramNameLayout = new GroupLayout(panel_About_ProgramName);
        panel_About_ProgramName.setLayout(panel_About_ProgramNameLayout);
        panel_About_ProgramNameLayout.setHorizontalGroup(
            panel_About_ProgramNameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel_About_ProgramNameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_About_ProgramName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        //Layout for panels in about dialog (vertical)
        panel_About_ProgramNameLayout.setVerticalGroup(
            panel_About_ProgramNameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel_About_ProgramNameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_About_ProgramName)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //Layout for panels in about dialog (horizontal)
        GroupLayout panel_About_NamesLayout = new GroupLayout(panel_About_Names);
        panel_About_Names.setLayout(panel_About_NamesLayout);
        panel_About_NamesLayout.setHorizontalGroup(
            panel_About_NamesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel_About_NamesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_About_Names, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addContainerGap())
        );
        //Layout for panels in about dialog (vertical)
        panel_About_NamesLayout.setVerticalGroup(
            panel_About_NamesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel_About_NamesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_About_Names)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //Layout for about dialog (horizontal)
        GroupLayout aboutDialogLayout = new GroupLayout(aboutDialog.getContentPane());
        aboutDialog.getContentPane().setLayout(aboutDialogLayout);
        aboutDialogLayout.setHorizontalGroup(
            aboutDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(aboutDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aboutDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(aboutDialogLayout.createSequentialGroup()
                        .addComponent(button_OK)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panel_About_ProgramName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_About_Names, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        //Layout for about dialog (vertical)
        aboutDialogLayout.setVerticalGroup(
            aboutDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, aboutDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_About_ProgramName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_About_Names, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(button_OK)
                .addContainerGap())
        );
        
        //OK button
        button_OK.setText("OK");
        //ActionListener for About Dialog's OK button
        button_OK.addActionListener((var evt) -> {
            //Destroys About dialog box
            aboutDialog.dispose();
        });

        //Main frame
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    //Main Frame exits on close
        setTitle("CECS 544 - File Manager");                        //Title
        setMinimumSize(new Dimension(1280, 720));                   //Window size
        setSize(new Dimension(1280, 720));                          //Window size
        //Listener for component resize (clicking and dragging)
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent evt) {
                formComponentResized();
            }
        });
        //Listener for window state change (iconified, deiconified)
        addWindowStateListener((WindowEvent evt) -> {
            formWindowStateChanged();
        });

        //Toolbar panel
        panel_Toolbar.setMinimumSize(new Dimension(1280, 50));              //Size

        //Combobox
        comboBox_Drives.setModel(new DefaultComboBoxModel<>());             //Create default model
        comboBox_Drives.setMinimumSize(new Dimension(200, 38));             //Size
        comboBox_Drives.setPreferredSize(new Dimension(200, 38));           //Size
        //Listener for combobox
        comboBox_Drives.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuCanceled(PopupMenuEvent evt) {}
            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent evt) {
                loadComboDrive(comboBox_Drives.getSelectedItem().toString());
            }
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent evt) {
                //Reload drives when combobox is selected
                reloadComboBox();
            }
        });
        //Add combobox to toolbar
        panel_Toolbar.add(comboBox_Drives);
        //Load drivers in comboBox
        reloadDrivers();

        //Details button
        button_Details.setText("Details");                          //Text
        button_Details.setMinimumSize(new Dimension(100, 38));      //Size
        button_Details.setPreferredSize(new Dimension(100, 38));    //Size
        button_Details.addActionListener((ActionEvent evt) -> {
            try {
                JScrollPane scrollPane = (JScrollPane) currentWindow.getRightComponent();
                JList currentList = (JList) scrollPane.getViewport().getView();
                renderList(currentList, true);
                //Update graphics
                currentList.update(currentList.getGraphics());
            } catch(NullPointerException ex) { System.out.println("No window selected. "); }
        });
        //Add button to toolbar
        panel_Toolbar.add(button_Details);

        //Simple button
        button_Simple.setText("Simple");                            //Text
        button_Simple.setMinimumSize(new Dimension(100, 38));       //Size
        button_Simple.setPreferredSize(new Dimension(100, 38));     //Size
        button_Simple.addActionListener((ActionEvent evt) -> {
            try {
                JScrollPane scrollPane = (JScrollPane) currentWindow.getRightComponent();
                JList currentList = (JList) scrollPane.getViewport().getView();
                renderList(currentList, false);
                //Update graphics
                currentList.update(currentList.getGraphics());
            } catch(NullPointerException ex) { System.out.println("No window selected. "); }
        });
        //Add button to toolbar
        panel_Toolbar.add(button_Simple);

        //DesktopPanel
        panel_Desktop.setMinimumSize(new Dimension(1280, 642));     //Size
        panel_Desktop.setPreferredSize(new Dimension(1280, 642));   //Size

        //DesktopPane
        desktopPane.setMinimumSize(new Dimension(1280, 642));       //Size
        //DesktopPane layout (horizontal)
        GroupLayout desktopPaneLayout = new GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        //DesktopPane layout (vertical)
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
        );

        //DesktopPanel layout (horizontal)
        GroupLayout panel_DesktopLayout = new GroupLayout(panel_Desktop);
        panel_Desktop.setLayout(panel_DesktopLayout);
        panel_DesktopLayout.setHorizontalGroup(
            panel_DesktopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        //DesktopPanel layout (vertical)
        panel_DesktopLayout.setVerticalGroup(
            panel_DesktopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        //Status bar
        label_Status.setText("Current Drive:");                     //Text
        label_Status.setMinimumSize(new Dimension(1280, 16));       //Size
        label_Status.setPreferredSize(new Dimension(1280, 16));     //Size

        //Main panel layout (horizontal)
        GroupLayout panel_MainLayout = new GroupLayout(panel_Main);
        panel_Main.setLayout(panel_MainLayout);
        panel_MainLayout.setHorizontalGroup(
            panel_MainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel_Toolbar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_Desktop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_MainLayout.createSequentialGroup()
                .addComponent(label_Status, GroupLayout.PREFERRED_SIZE, 1149, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        //Main panel layout (vertical)
        panel_MainLayout.setVerticalGroup(
            panel_MainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel_MainLayout.createSequentialGroup()
                .addComponent(panel_Toolbar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_Desktop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_Status, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        //Add main panel to main frame with border layout
        getContentPane().add(panel_Main, BorderLayout.CENTER);

        //File menu
        menu_File.setText("File");
        
        //Sub file menu item rename
        menuItem_Rename.setText("Rename");
        menu_File.add(menuItem_Rename);
        
        //Sub file menu item copy
        menuItem_Copy.setText("Copy");
        menu_File.add(menuItem_Copy);
        
        //Sub file menu item delete
        menuItem_Delete.setText("Delete");
        menu_File.add(menuItem_Delete);
        
        //Sub file menu item run
        menuItem_Run.setText("Run");
        //Listener for run
        menuItem_Run.addActionListener((ActionEvent evt) -> {
            runSelectedFile();
        });
        menu_File.add(menuItem_Run);
        
        //Sub file menu item exit
        menuItem_Exit.setText("Exit");
        //Listener for exit
        menuItem_Exit.addActionListener((var evt) -> {
            dispose();
        });
        menu_File.add(menuItem_Exit);

        //Add file menu to menu bar
        menuBar.add(menu_File);

        //Tree menu
        menu_Tree.setText("Tree");

        //Sub tree menu Expand branch menu item
        menuItem_Expand.setText("Expand Branch");
        //Listener
        menuItem_Expand.addActionListener((ActionEvent evt) -> {
            //Expand selected tree
            expandTree();
        });
        menu_Tree.add(menuItem_Expand);

        //Sub tree menu Collapse branch menu item
        menuItem_Collapse.setText("Collapse Branch");
        //Listener
        menuItem_Collapse.addActionListener((ActionEvent evt) -> {
            //Collapse selected tree
            collapseTree();
        });
        menu_Tree.add(menuItem_Collapse);
        
        //Add tree menu to menu bar
        menuBar.add(menu_Tree);

        //Window menu
        menu_Window.setText("Window");

        //Sub window menu new window menu item
        menuItem_New.setText("New Window");
        //Listener
        menuItem_New.addActionListener((ActionEvent evt) -> {
            createNewWindow();
        });
        menu_Window.add(menuItem_New);

        //Sub window menu cascade windows menu item
        menuItem_Cascade.setText("Cascade Windows");
        //Listener
        menuItem_Cascade.addActionListener((ActionEvent evt) -> {
            cascadeWindows();
        });
        menu_Window.add(menuItem_Cascade);

        //Add window menu to menu bar
        menuBar.add(menu_Window);

        //Help menu
        menu_Help.setText("Help");

        //Sub Help menu help menu item
        menuItem_Help.setText("Help");
        menu_Help.add(menuItem_Help);

        //Sub Help menu about menu item
        menuItem_About.setText("About");
        menuItem_About.addActionListener((var evt) -> {
            aboutDialog.setLocationRelativeTo(null);
            aboutDialog.setResizable(false);
            aboutDialog.setVisible(true);
        });
        menu_Help.add(menuItem_About);

        //Add help menu to menu bar
        menuBar.add(menu_Help);

        //Add menu bar to main frame
        setJMenuBar(menuBar);

        pack();
        
        //Set to center of screen
        setLocationRelativeTo(null);
        
        //Desktop Pane's windows
        windows = new ArrayList<>();
        
        //Initialize status bar
        updateStatus("none");
        
        //Shows window
        this.setVisible(true);
    }                       

    //Function: formWindowStateChanged()
    //Purpose: Resize frame size when window is maximized (iconified) or minimized (deiconified)
    private void formWindowStateChanged() {                                        
        resizeInternalWindow();
    }                                       

    //Function: formComponentResized()
    //Purpose: Resize frame size by clicking and dragging window sides
    private void formComponentResized() {                                      
        resizeInternalWindow();
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
    
    //Function: reload_ComboBox()
    //Purpose: Opening combo box menu will update drivers
    private void reloadComboBox() {                                                           
        //Gets currently selected item
        Object selectedItem = comboBox_Drives.getSelectedItem().toString();
        //Reloads
        reloadDrivers();
        //Displays previously selected item if new item not selected
        comboBox_Drives.setSelectedItem(selectedItem);
    }
    
    //Function: reloadDrivers()
    //Purpose: gets current drivers listed and loads them into combobox
    private void reloadDrivers() {
        comboBox_Drives.removeAllItems();
        File[] paths = File.listRoots();
        for(File path:paths) {
            comboBox_Drives.addItem(path.toString());
        }
    }
    
    //Function: expandTree()
    //Purpose: Expand tree
    private void expandTree() {                                                
        resizeTree(true);
    }
    
    //Function: collapseTree()
    //Purpose: Collapse tree
    private void collapseTree() {                                                  
        resizeTree(false);
    } 
    
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
    
    //Function: createNewWindow()
    //Purpose: Create new internal frame when new window button is clicked
    private void createNewWindow() {                                             
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
        tree.addTreeSelectionListener((TreeSelectionEvent e) -> {
            //Update list to match selected folder
            TreePath tp = e.getPath();
            String currentPath = buildPath(tp);
            //Set title
            frame.setTitle(currentPath);
            updateList(currentPath);
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
    
    //Function: createNodes(String, DefaultMutableTreeNode)
    //Purpose: Takes current node and adds any subdirectories to tree
    private void createNodes(String root, DefaultMutableTreeNode top) {
        //Get list of files in current directory
        File fileRoot = new File(root);
        File[] files = fileRoot.listFiles();
        
        //No files found
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
    
    //Function: createList(String)
    //Purpose: Create a scrollpane containing a list structure representing the files in a directory using the given String path
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
        
        //creates the JPopUpMenu for single click use and defines menu functionality
        JPopupMenu fileEditMenu = new JPopupMenu("FileEdit");
        
        //rename will use the RenameFrame class
        JMenuItem renameMenuItem = new JMenuItem("Rename");
        //Listener for rename
        ActionListener renameListener = (ActionEvent e) -> {
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
        };
        
        //Add rename functionality to popup menu and toolbar menu
        renameMenuItem.addActionListener(renameListener);
        menuItem_Rename.addActionListener(renameListener);
        
        //copy will also use the RenameFrame class
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        //Listener for copy
        ActionListener copyListener = (ActionEvent e) -> {
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
        };
        
        //Add copy functionality to popup menu and toolbar menu
        copyMenuItem.addActionListener(copyListener);
        menuItem_Copy.addActionListener(copyListener);

        JMenuItem pasteMenuItem = new JMenuItem("Paste");
        //Paste functionality??
        
        //delete will use a lightweight JOptionPane for decision making
        JMenuItem deleteMenuItem = new JMenuItem("Delete");
        //Listener for delete
        ActionListener deleteListener = (ActionEvent e) -> {
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
            } catch(HeadlessException ex) {}
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
            @Override
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
            @Override
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
        //Set list icons and detailed/simple view (true == detailed, false == simple)
        renderList(list, true);
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
    
    //Function: renderList(JList, boolean)
    //Purpose: Updates a list's graphics / view to detailed or simple view
    //true == detailed, false == simple view
    private void renderList(JList list, boolean detailed) {
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
    
    //Function: cascadeWindows()
    //Purpose: When cascade menu button is clicked, each internal frame gets it's position set to a cascade effect
    private void cascadeWindows() {                                                 
        //Cascade windows
        for(int i = 0, j = 0; i < windows.size(); i++, j++) {
            if(windows.get(i).isIcon()) {
                j--;
                continue;
            }
            windows.get(i).setLocation(25 * j % 700, 25 * j % 250);
            windows.get(i).toFront();
        }
    }
    
    //Function: runSelectedFile()
    //Purpose: Run selected item in list
    private void runSelectedFile() {                                             
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
    }
    
    //Function: loadComboDrive(String)
    //Purpose: Reload list / tree with new drive
    private void loadComboDrive(String directory) {
        try {
            JScrollPane scrollPane = (JScrollPane) currentWindow.getLeftComponent();
            JTree currentTree = (JTree) scrollPane.getViewport().getView();
            currentTree.setModel(null);
            
            DefaultMutableTreeNode top = new DefaultMutableTreeNode(directory);
            DefaultTreeModel treeModel = new DefaultTreeModel(top);
            currentTree.setModel(treeModel);
            //Create nodes of directories and add to the tree
            createNodes(directory, top);
            //Expand tree one level
            expandNodes(currentTree, top);

            updateList(directory);
        } catch (NullPointerException ex) {
            System.out.println("No window selected");
        }
    }
}