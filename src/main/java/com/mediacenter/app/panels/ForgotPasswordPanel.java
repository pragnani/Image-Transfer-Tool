package com.mediacenter.app.panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mediacenter.app.listeners.ButtonClickListener;
import com.mediacenter.app.util.SizesUtil;

public class ForgotPasswordPanel extends JPanel implements ActionListener {

	public ButtonClickListener listener;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField,passwordFieldNew;
	private JTextField userIdTextField;

	public ForgotPasswordPanel(MainPanel panel) {
		prepateUI();
		listener= (ButtonClickListener)panel;
	}

	public void prepateUI() {
		
		JPanel wrapperPanel = new JPanel();

		userIdTextField = new JTextField(15);
		userIdTextField.setSize(SizesUtil.TEXTBOX_WIDTH,
				SizesUtil.TEXTBOX_HEIGHT);
		JLabel userId = new JLabel("User Name");

		JPanel userIdPanel = new JPanel(new FlowLayout());
		userIdPanel.add(userId);
		userIdPanel.add(userIdTextField);
		
		passwordField = new JPasswordField(15);
		passwordField
				.setSize(SizesUtil.TEXTBOX_WIDTH, SizesUtil.TEXTBOX_HEIGHT);
		JLabel password = new JLabel("Old Password");

		JPanel passwordPanel = new JPanel(new FlowLayout());
		passwordPanel.add(password);
		passwordPanel.add(passwordField);


		// Password TextField Panel

		passwordFieldNew = new JPasswordField(15);
		passwordFieldNew
				.setSize(SizesUtil.TEXTBOX_WIDTH, SizesUtil.TEXTBOX_HEIGHT);
		JLabel newPassword = new JLabel("Old Password");

		JPanel newPasswordPanel = new JPanel(new FlowLayout());
		newPasswordPanel.add(newPassword);
		newPasswordPanel.add(passwordFieldNew);

		// Send Mail Panel

		JButton login = new JButton("Reset");
		login.addActionListener(this);
		login.setName("login");
		login.setSize(new Dimension(SizesUtil.BUTTON_WIDTH,
				SizesUtil.BUTTON_HEIGHT));
		JPanel loginWrapper = new JPanel();
		loginWrapper.add(login);

		JPanel jpanel = new JPanel(new GridLayout(4, 1, 0, 10));

		// Adding all panels to the mail panel
		jpanel.add(userIdPanel);
		jpanel.add(passwordPanel);
		jpanel.add(newPasswordPanel);
		jpanel.add(loginWrapper);
		wrapperPanel.add(jpanel);
		wrapperPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		add(wrapperPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		listener.buttonClicked(e);

	}
	
	public String getUserName()
	{
		return userIdTextField.getText();
	}
	@SuppressWarnings("deprecation")
	public String getPassword()
	{
		return passwordField.getText();
	}

}
