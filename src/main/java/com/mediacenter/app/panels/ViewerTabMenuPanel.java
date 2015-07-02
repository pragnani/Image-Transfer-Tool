package com.mediacenter.app.panels;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

public class ViewerTabMenuPanel extends JTabbedPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = -848042448316406034L;
	private MetaDataPanel metaDataPanel;
	private SourceFileImageViewerPanel viewerPanel;

	public ViewerTabMenuPanel() {
		prepareUI();
	}

	public void prepareUI() {

		ImageIcon infoIcon = new ImageIcon("info.png");
		ImageIcon viewIcon = new ImageIcon("View.png");
		metaDataPanel = new MetaDataPanel();
		viewerPanel = new SourceFileImageViewerPanel();

		addTab("Info", infoIcon, metaDataPanel);
		setMnemonicAt(0, KeyEvent.VK_1);

		addTab("View", viewIcon, viewerPanel);
		setMnemonicAt(1, KeyEvent.VK_2);

	}

	public MetaDataPanel getMetaDataPanel() {
		return metaDataPanel;
	}

	public SourceFileImageViewerPanel getViewerPanel() {
		return viewerPanel;
	}

}
