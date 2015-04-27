package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * This class represents the inner view for selecting a level and displaying a
 * preview to the player.
 *
 * @author Cameron Jones
 */
public class LevelSelectionPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	protected DefaultListModel<String> levelListModel;
	protected JScrollPane levelScrollPane;
	protected JPanel previewPanel;
	protected JButton playLevelButton;
	protected ArrayList<String> levelNames;
	protected JList<String> levelList;

	/**
	 * Creates a LevelSelectionPanel instance with the specified level names and
	 * highest level unlocked.
	 *
	 * @param levelNames
	 *            The names of levels to populate the list.
	 * @param highestLevelUnlocked
	 *            The highest number user level that is unlocked to play.
	 */
	public LevelSelectionPanel(ArrayList<String> levelNames,
			int highestLevelUnlocked) {

		// Attributes
		this.levelNames = levelNames;

		// Layout for panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Add the list of level names
		levelListModel = new DefaultListModel<String>();
		for (int i = 0; i < levelNames.size(); i++) {
			levelListModel.addElement(levelNames.get(i));
		}

		// Level list scroll pane
		levelScrollPane = new JScrollPane();
		levelList = new JList<String>(levelListModel);
		levelList.setMaximumSize(new Dimension(100, 100));
		levelList.setPreferredSize(new Dimension(100, 100));
		levelList.setMinimumSize(new Dimension(100, 100));
		levelList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		levelList.setCellRenderer(new LevelListCellRenderer(
				highestLevelUnlocked));
		levelScrollPane.setViewportView(levelList);

		// Layout for level list scroll pane
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 0, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		add(levelScrollPane, gbc_list);

		// Preview panel
		JPanel previewPanel = new JPanel();

		// Layout for preview panel
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		add(previewPanel, gbc_panel);

		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
				1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		previewPanel.setLayout(gbl_panel);

		// Level preview label
		JLabel lblLevelPreview = new JLabel("Level Preview",
				SwingConstants.CENTER);
		lblLevelPreview.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblLevelPreview.setBackground(Color.WHITE);

		// Layout for level preview label
		GridBagConstraints gbc_lblLevelPreview = new GridBagConstraints();
		gbc_lblLevelPreview.fill = GridBagConstraints.BOTH;
		gbc_lblLevelPreview.gridheight = 3;
		gbc_lblLevelPreview.insets = new Insets(0, 0, 5, 5);
		gbc_lblLevelPreview.gridx = 1;
		gbc_lblLevelPreview.gridy = 1;
		previewPanel.add(lblLevelPreview, gbc_lblLevelPreview);

		// Play level button
		playLevelButton = new JButton("Play Level");

		// Layout for play level button
		GridBagConstraints gbc_btnPlay = new GridBagConstraints();
		gbc_btnPlay.insets = new Insets(0, 0, 0, 5);
		gbc_btnPlay.gridx = 1;
		gbc_btnPlay.gridy = 9;
		previewPanel.add(playLevelButton, gbc_btnPlay);
	}

	/**
	 * Returns the levelScrollPane object for this panel.
	 *
	 * @return the levelScrollPane property
	 */
	public JScrollPane getLevelScrollPane() {
		return this.levelScrollPane;
	}

	/**
	 * Returns the playLevelButton object for this panel.
	 *
	 * @return the playLevelButton property
	 */
	public JButton getPlayButton() {
		return this.playLevelButton;
	}

	/**
	 * Returns the previewPanel object for this panel.
	 *
	 * @return the previewPanel property
	 */
	public JPanel getPreviewPanel() {
		return this.previewPanel;
	}

	/**
	 * Returns the levelList object for this panel.
	 *
	 * @return the levelList property
	 */
	public JList<String> getLevelList() {
		return this.levelList;
	}

	/**
	 * Refreshes the view with the specified highest level unlocked.
	 * 
	 * @param highestUnlocked
	 *            The new highest level number unlocked.
	 */
	public void refreshView(int highestUnlocked) {
		levelList.setCellRenderer(new LevelListCellRenderer(highestUnlocked));
		levelScrollPane.setViewportView(levelList);
		this.invalidate();
		this.revalidate();
		this.repaint();
	}
}
