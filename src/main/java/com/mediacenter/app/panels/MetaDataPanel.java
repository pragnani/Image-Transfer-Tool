package com.mediacenter.app.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MetaDataPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8273835973576327711L;
	private JLabel metaDataLabel;
	
	
	public MetaDataPanel() {
		prepateUI();
	}

	private void prepateUI() {
		metaDataLabel= new JLabel();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.add(metaDataLabel);
		
		add(scrollPane);
	}
	
	public void seMetaData(String metaData){
		metaDataLabel.setText(metaData);
	}
}
