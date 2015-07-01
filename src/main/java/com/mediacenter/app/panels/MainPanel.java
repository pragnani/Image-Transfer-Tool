package com.mediacenter.app.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPanel extends JFrame implements ActionListener {

	/**
	 * 
	 */

	JPanel mainPanel;

	private LoginPanel loginPanel;
	private TitlePanel titlePanel;

	private static final long serialVersionUID = -1372258589469698192L;

	public MainPanel() {
		prepareUI();
	}

	private void prepareUI() {

		mainPanel = new JPanel();

		setTitle("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(800, 800));
		setResizable(false);
		loginPanel = new LoginPanel();
		titlePanel = new TitlePanel();
		mainPanel.add(titlePanel);
		mainPanel.add(loginPanel);
		add(mainPanel);
		setVisible(true);
	}

	public void reRender() {
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
