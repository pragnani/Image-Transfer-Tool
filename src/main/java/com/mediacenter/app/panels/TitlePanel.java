package com.mediacenter.app.panels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5756780488780625412L;

	public TitlePanel() {
		prepareUI();
	}

	private void prepareUI() {
		JPanel titlePanel = new JPanel(new GridLayout(1, 2));

		JLabel titleLable = new JLabel("Media Center Image Transfer", JLabel.CENTER);
		titleLable.setFont(new Font("Serif", Font.PLAIN, 50));
		titlePanel.add(titleLable, BorderLayout.CENTER);
		add(titlePanel);
	}
}
