package com.mediacenter.app.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.mediacenter.app.listeners.ButtonClickListener;

public class MainPanel extends JFrame implements ActionListener,
		ButtonClickListener {

	/**
	 * 
	 */

	JPanel mainPanel;

	private JPanel targetPanel;
	private LoginPanel loginPanel;
	private TitlePanel titlePanel;

	private boolean isauthenticate = false;

	private static final long serialVersionUID = -1372258589469698192L;

	public MainPanel() {
		prepareUI();
	}

	private void prepareUI() {

		mainPanel = new JPanel();
		targetPanel = new JPanel();
		setTitle("Media Source Image Transfer Tool");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(800, 800));
		setResizable(false);

		if (isauthenticate) {

		} else {
			loginPanel = new LoginPanel(this);
			targetPanel.add(loginPanel);
		}
		titlePanel = new TitlePanel();
		mainPanel.add(titlePanel);
		mainPanel.add(targetPanel);
		add(mainPanel);
		setVisible(true);
	}

	public void reRender() {
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void buttonClicked(ActionEvent e) {
		if (e.getActionCommand().equals("Login")) {
			validateUser();
		}
	}

	private void validateUser() {
		String strUserName = loginPanel.getUserName();
		String strPassword = loginPanel.getPassword();
		if (strUserName == null || strPassword == null
				|| strUserName.trim().length() == 0
				|| strPassword.trim().length() == 0) {
			JOptionPane.showMessageDialog(null,
					"Please Enter UserName and Password.", "Warning",
					JOptionPane.WARNING_MESSAGE);
		} else {
//			targetPanel.removeAll();
//			mainPanel.revalidate();
		}
	}

}
