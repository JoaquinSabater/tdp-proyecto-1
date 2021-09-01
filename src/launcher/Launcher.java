package launcher;

import java.awt.*;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student joaquinSabater = new Student(125817,"Sabater","Joaquin","Joaquinsabater15@gmail.com","https://github.com/JoaquinSabater","/images/Foto.png");
            	SimplePresentationScreen s = new SimplePresentationScreen(joaquinSabater);
            	s.setVisible(true);
            	s.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/tdp.png")));
            }
        });
    }
}