package com.yachtclub;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainMenuBar extends JMenuBar {

    private MainWindow mainWindow;

    public MainMenuBar(MainWindow mainWindow){

        //Passes on the Main Window to access methods

        this.mainWindow = mainWindow;

        //Creates top bar menus

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");

        //Creates items for file menu

        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem saveAs = new JMenuItem("Save As");
        JMenuItem exit = new JMenuItem("Exit");

        //Creates items for edit menu

        JMenuItem undo = new JMenuItem("Undo");
        JMenuItem redo = new JMenuItem("Redo");

        //Sets actions for JMenuItems

        open.addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        mainWindow.setCurrentImage(open());
                                    }
                               });

        //Adds menu items to menus

        file.add(open);
        file.add(save);
        file.add(saveAs);
        file.add(exit);

        edit.add(undo);
        edit.add(redo);

        //Adds menus to the menubar

        add(file);
        add(edit);
    }

    public BufferedImage open () {

        //Creates a new FileChooser dialog, sets the default location, and looks for a user response

        JFileChooser imageOpen = new JFileChooser();
        imageOpen.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = imageOpen.showOpenDialog(this);
        File selectedLocation = null;

        if(result == JFileChooser.APPROVE_OPTION){
            selectedLocation = imageOpen.getSelectedFile();
        }

        //Creates a buffered image

        BufferedImage selectedImage = null;

        //Reads from the file and writes to the buffered image

        try{
            selectedImage = ImageIO.read(selectedLocation);
        } catch (IOException e){

        }

        //Returns the buffered image;

        return selectedImage;
    }

}
