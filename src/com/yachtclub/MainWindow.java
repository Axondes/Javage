package com.yachtclub;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MainWindow extends JFrame {

    private BufferedImage currentImage;
    private double windowRatio;

    private JPanel mainPanel;

    public MainWindow () {

        //Sets the size and initial appearance of the window

        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creates a default buffered image

        currentImage = new BufferedImage(this.getWidth(),this.getHeight(),BufferedImage.TYPE_INT_ARGB);

        //Adds a border layout for more functionality

        setLayout(new BorderLayout());

        //Defines the ratio of the current window size

        windowRatio = (double)getWidth()/(double)getHeight();

        //Adds mainPanel for image

        mainPanel = new JPanel() {

            @Override
            protected void paintComponent(Graphics G){

                //Gets the ratio of the image to be shown

                double ratio = (double)currentImage.getWidth(null)/(double)currentImage.getHeight(null);

                //Resets the current window ratio.

                windowRatio = (double)getWidth()/(double)getHeight();

                //Declares if height or width is prioritized to fit image

                if(ratio > windowRatio) {
                    G.drawImage(currentImage, 0, 0, this.getWidth(), (int) ((double) this.getWidth() / ratio), null);
                } else {
                    G.drawImage(currentImage, 0, 0, (int)((double)this.getHeight()*ratio), this.getHeight(), null);
                }

            }
        };

        //Adds components to frame

        mainPanel.setMinimumSize(new Dimension(600,600));
        add(mainPanel, BorderLayout.CENTER);

        //Creates and adds a menubar

        setJMenuBar(new MainMenuBar(this));

        //Sets the frame to visible

        setMinimumSize(new Dimension(600,600));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void setCurrentImage(BufferedImage newImage) {

        //Only replaces the image if there is actually a new image

        if(newImage != null) {
            currentImage = newImage;
        }

        //Repaints the panel showing the image

        mainPanel.repaint();

        //Resets the current window ratio.

        windowRatio = (double)getWidth()/(double)getHeight();

    }

}
