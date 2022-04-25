/**
 * File: ClickListener.java
 * Authors: Steven Phung, Daniel Tripp, Joseph Freedman
 * Class: CECS-544-01 - Software Test and Verification
 * 
 * Assignment: Semester Project
 * Due Date: April 25, 2022 @ 5pm
 * 
 * Purpose: Class listens for single and double clicks.
 */
package filemanager;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClickListener extends MouseAdapter implements ActionListener {
    private final static int clickInterval = (Integer)Toolkit.getDefaultToolkit().
        getDesktopProperty("awt.multiClickInterval");

    MouseEvent lastEvent;
    Timer timer;

    public ClickListener()
    {
        this(clickInterval);
    }

    public ClickListener(int delay)
    {
        timer = new Timer( delay, this);
    }

    public void mouseClicked (MouseEvent e)
    {
        if (e.getClickCount() > 2) return;

        lastEvent = e;

        if (timer.isRunning())
        {
            timer.stop();
            doubleClick( lastEvent );
        }
        else
        {
            timer.restart();
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        timer.stop();
        singleClick( lastEvent );
    }

    public void singleClick(MouseEvent e) {}
    public void doubleClick(MouseEvent e) {}
    
}
