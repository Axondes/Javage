package com.yachtclub;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        //Sets the L&F to the default system appearance.

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException e) {
            // handle exception
        }
        catch (ClassNotFoundException e) {
            // handle exception
        }
        catch (InstantiationException e) {
            // handle exception
        }
        catch (IllegalAccessException e) {
            // handle exception
        }

	    //Creates an instance of the MainWindow class

        MainWindow mainWindow = new MainWindow();
    }
}
