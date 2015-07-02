package com.mediacenter.app.util;

import javax.swing.SwingUtilities;

import com.mediacenter.app.panels.MainPanel;

public class Test {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater( new Runnable()
        {
            public void run()
            {
            	new MainPanel();
            }
        });

		
	}
}
