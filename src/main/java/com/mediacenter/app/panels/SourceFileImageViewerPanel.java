package com.mediacenter.app.panels;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.mediacenter.app.listeners.ButtonClickListener;
import com.mediacenter.app.util.SizesUtil;

public class SourceFileImageViewerPanel extends JPanel implements
		ActionListener {

	public ButtonClickListener listener;

	private JFileChooser chooser;

	private JTextField chooseFileTextField;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SourceFileImageViewerPanel(MainPanel panel) {
		prepateUI();
		listener = (ButtonClickListener) panel;

		chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"JPG & GIF Images", "jpg", "gif", "png", "tiff", "pdf", "eps");
		chooser.setFileFilter(filter);
		
		JPanel chooseFilePanel = new JPanel(new GridLayout(1, 3, 5, 0));
		
		JLabel selectFileLable = new JLabel();
		selectFileLable.setText("<html><font color='black'> Choose File</font></html>");
		
		 chooseFileTextField = new JTextField(15);
		 chooseFileTextField.setSize(SizesUtil.TEXTBOX_WIDTH,
				SizesUtil.TEXTBOX_HEIGHT);
		 
		 JButton chooseButton = new JButton("Choose");
			chooseButton.addActionListener(this);
			chooseButton.setName("Choose");
			chooseButton.setSize(new Dimension(SizesUtil.BUTTON_WIDTH,
					SizesUtil.BUTTON_HEIGHT));
		 
		
		chooseFilePanel.add(selectFileLable); 
		chooseFilePanel.add(chooseFileTextField); 
		chooseFilePanel.add(chooseButton); 
		add(chooseFilePanel);
		

	}

	private void prepateUI() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		listener.buttonClicked(e);
	}
	
	public JFileChooser getFileChooser()
	{
		return chooser;
	}
	
	public void setChooseFileText(String fileName)
	{
		chooseFileTextField.setText(fileName);
	}

}
