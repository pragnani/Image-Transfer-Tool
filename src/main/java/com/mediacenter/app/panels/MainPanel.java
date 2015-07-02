package com.mediacenter.app.panels;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;

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

	private ForgotPasswordPanel forgotPanel;

	private FileChoosePanel fileChooserPanel;

	
	private ViewerTabMenuPanel viewerTabPanel;

	private static final long serialVersionUID = -1372258589469698192L;

	public MainPanel() {
		prepareUI();
	}

	private void prepareUI() {
		

		viewerTabPanel=new ViewerTabMenuPanel();
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
			if (isauthenticate) {
				showMainPanel();
			}

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

		JFileChooser fileChooser = fileChooserPanel.getFileChooser();
		int returnVal = fileChooser.showOpenDialog(MainPanel.this);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			fileChooserPanel.setChooseFileText(file.getName());
			try {
				if(file!= null && file.canRead()){
				targetPanel.removeAll();
				targetPanel.add(viewerTabPanel);
				targetPanel.revalidate();
				extractImageMetaData(file);
				}
				else
				{
					
				}

			} catch (Exception e) {
			}

		} else {
			System.out.println("Open command cancelled by user.");
		}

	}

	private void extractImageMetaData(File file) {
		MetaDataPanel metaDataPanel= viewerTabPanel.getMetaDataPanel();
		metaDataPanel.seMetaData("");
		StringBuilder builder = new StringBuilder();
		try {
			AutoDetectParser parser = new AutoDetectParser();
			BodyContentHandler handler = new BodyContentHandler();
			Metadata metadata = new Metadata();
			FileInputStream inputstream = new FileInputStream(file);
			ParseContext context = new ParseContext();

			parser.parse(inputstream, handler, metadata, context);
			System.out.println(handler.toString());

			// getting the list of all meta data elements
			String[] metadataNames = metadata.names();
			builder.append("<html>");
			for (String name : metadataNames) {

				builder.append("<font color='blue'><b>" + name
						+ ": </b></font>" + "<font color='green'>"
						+ metadata.get(name) + "</font>");
				builder.append("<br/>");
			}
			builder.append("</html>");
			metaDataPanel.seMetaData(builder.toString());
			mainPanel.revalidate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void showMainPanel() {
		fileChooserPanel = new FileChoosePanel(
				MainPanel.this);
		targetPanel.removeAll();
		targetPanel.add(fileChooserPanel);
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
			// Temporary for testing purpose
			isauthenticate = true;
		}
	}

}
