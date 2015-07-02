package com.mediacenter.app.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.mediacenter.app.listeners.ButtonClickListener;
import com.mediacenter.app.util.IdUtil;

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

	private MetaDataPanel metaDataPanel;
	private ForgotPasswordPanel forgotPanel;

	private SourceFileImageViewerPanel sourcefileImageViewerPanel;

	private static final long serialVersionUID = -1372258589469698192L;

	public MainPanel() {
		prepareUI();
	}

	private void prepareUI() {

		JPanel metaPanel = new JPanel();
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
		mainPanel.add(metaPanel);
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
			// validateUser();
			// Temporary for testing purpose
			isauthenticate = true;
			showMainPanel();

		} else if (e.getActionCommand().toString().contains("MOUSE_CLICKED")) {
			if (e.getID() == IdUtil.FORGOT_PASSWORD) {
				forgotPanel = new ForgotPasswordPanel(MainPanel.this);
				targetPanel.removeAll();
				targetPanel.add(forgotPanel);
				mainPanel.revalidate();
			}
		} else if (e.getActionCommand().equals("Choose")) {
			openFileChooseDialog();
		}

	}

	private void openFileChooseDialog() {

		JFileChooser fileChooser = sourcefileImageViewerPanel.getFileChooser();
		int returnVal = fileChooser.showOpenDialog(MainPanel.this);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			sourcefileImageViewerPanel.setChooseFileText(file.getName());
			try {
				
				extractImageMetaData(file);
				
			} catch (Exception e) {
				// TODO: handle exception
			}

		} else {
			System.out.println("Open command cancelled by user.");
		}

	}

	private void extractImageMetaData(File file) {
		try {
			Metadata metaData= ImageMetadataReader.readMetadata(file);
			for (Directory directory : metaData.getDirectories()) {
			    for (Tag tag : directory.getTags()) {
			        System.out.println(tag);
			    }
			}
			
			
		} catch (ImageProcessingException | IOException e) {
			e.printStackTrace();
		}
	}
	

	private void showMainPanel() {

		sourcefileImageViewerPanel = new SourceFileImageViewerPanel(
				MainPanel.this);
		targetPanel.removeAll();
		targetPanel.add(sourcefileImageViewerPanel);
		mainPanel.revalidate();

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
			//
		}
	}

}
