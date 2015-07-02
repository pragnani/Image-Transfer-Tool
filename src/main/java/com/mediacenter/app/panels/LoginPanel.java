package com.mediacenter.app.panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mediacenter.app.listeners.ButtonClickListener;
import com.mediacenter.app.util.IdUtil;
import com.mediacenter.app.util.SizesUtil;

public class LoginPanel extends JPanel implements ActionListener {

	public ButtonClickListener listener;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JTextField userIdTextField;
	private JLabel forgotPasswordLabel;

	public LoginPanel(MainPanel panel) {
		prepateUI();
		listener= (ButtonClickListener)panel;
	}

	public void prepateUI() {
		
		JPanel wrapperPanel = new JPanel();
		
		forgotPasswordLabel= new JLabel();
		forgotPasswordLabel.setText("<html><font color='blue'>Forgot Password ?</font></html>");
		forgotPasswordLabel.setName("ForgotId");
		JPanel labelWrapperPanel = new JPanel();
		labelWrapperPanel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ActionEvent ae = new ActionEvent(e.getSource(),IdUtil.FORGOT_PASSWORD, e.paramString());
				
				listener.buttonClicked(ae);
				
			}
		});
		labelWrapperPanel.add(forgotPasswordLabel);

		userIdTextField = new JTextField(15);
		userIdTextField.setSize(SizesUtil.TEXTBOX_WIDTH,
				SizesUtil.TEXTBOX_HEIGHT);
		JLabel userId = new JLabel("UserName");

		JPanel userIdPanel = new JPanel(new FlowLayout());
		userIdPanel.add(userId);
		userIdPanel.add(userIdTextField);

		// Password TextField Panel

		passwordField = new JPasswordField(15);
		passwordField
				.setSize(SizesUtil.TEXTBOX_WIDTH, SizesUtil.TEXTBOX_HEIGHT);
		JLabel password = new JLabel("Password");

		JPanel passwordPanel = new JPanel(new FlowLayout());
		passwordPanel.add(password);
		passwordPanel.add(passwordField);

		// Send Mail Panel

		JButton login = new JButton("Login");
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
		jpanel.add(loginWrapper);
		jpanel.add(labelWrapperPanel);
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
