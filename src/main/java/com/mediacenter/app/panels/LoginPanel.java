package com.mediacenter.app.panels;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mediacenter.app.util.SizesUtil;

public class LoginPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JTextField userIdTextField;

	public LoginPanel() {
		prepateUI();
	}

	public void prepateUI(){
		
	JPanel wrapperPanel = new JPanel();

	userIdTextField = new JTextField(15);
	userIdTextField.setSize(SizesUtil.TEXTBOX_WIDTH, SizesUtil.TEXTBOX_HEIGHT);
	JLabel userId = new JLabel("UserName");

	JPanel userIdPanel = new JPanel(new FlowLayout());
	userIdPanel.add(userId);
	userIdPanel.add(userIdTextField);

	// Password TextField Panel

	passwordField = new JPasswordField(15);
	passwordField.setSize(SizesUtil.TEXTBOX_WIDTH, SizesUtil.TEXTBOX_HEIGHT);
	JLabel password = new JLabel("Password");

	JPanel passwordPanel = new JPanel(new FlowLayout());
	passwordPanel.add(password);
	passwordPanel.add(passwordField);

	// Send Mail Panel

	JButton login = new JButton("Login");
	login.setName("login");
	login.setSize(new Dimension(SizesUtil.BUTTON_WIDTH, SizesUtil.BUTTON_HEIGHT));
	JPanel loginWrapper = new JPanel();
	loginWrapper.add(login);

	JPanel jpanel = new JPanel(new GridLayout(3, 1, 0, 10));
	
	// Adding all panels to the mail panel
	jpanel.add(userIdPanel);
	jpanel.add(passwordPanel);
	jpanel.add(loginWrapper);
	wrapperPanel.add(jpanel);
	wrapperPanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
	add(wrapperPanel);
	}

}
