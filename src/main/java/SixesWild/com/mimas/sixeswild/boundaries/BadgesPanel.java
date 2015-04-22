package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * This class represents the view used to show badges that the player has
 * completed or has not completed in the game menu.
 * 
 * @author Yahel Nachum
 */
public class BadgesPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	DefaultListModel<String> badgeListModel;
	JScrollPane badgeScrollPane;
	JPanel previewPanel;
	ArrayList<String> badgeNames;

	/**
	 * Constructor for BadgesPanel class.
	 * 
	 * @param badgeNames
	 *            The list of badge names.
	 */
	public BadgesPanel(ArrayList<String> badgeNames) {

		// Attributes
		this.badgeNames = badgeNames;

		// Layout of panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Add the list of badge names
		badgeListModel = new DefaultListModel<String>();
		for (int i = 0; i < badgeNames.size(); i++) {
			badgeListModel.addElement(badgeNames.get(i));
		}

		// Badge list scroll pane
		badgeScrollPane = new JScrollPane();
		JList<String> list = new JList<String>(badgeListModel);
		badgeScrollPane.setViewportView(list);

		// Layout for scroll pane
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 0, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		add(badgeScrollPane, gbc_list);

		// Preview panel
		JPanel previewPanel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		add(previewPanel, gbc_panel);

		// Layout for preview panel
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
				1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		previewPanel.setLayout(gbl_panel);

		// Badges preview label
		JLabel badgesPreviewLabel = new JLabel("BadgePreview",
				SwingConstants.CENTER);
		badgesPreviewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));

		// Layout for preview label
		GridBagConstraints gbc_lblBadgepreview = new GridBagConstraints();
		gbc_lblBadgepreview.gridheight = 3;
		gbc_lblBadgepreview.fill = GridBagConstraints.BOTH;
		gbc_lblBadgepreview.insets = new Insets(0, 0, 5, 5);
		gbc_lblBadgepreview.gridx = 1;
		gbc_lblBadgepreview.gridy = 1;
		previewPanel.add(badgesPreviewLabel, gbc_lblBadgepreview);
	}

	/**
	 * Returns the level selection preview panel.
	 * 
	 * @return JPanel preview panel
	 */
	public JPanel getPreviewPanel() {
		return this.previewPanel;
	}

	/**
	 * Returns the badge list.
	 * 
	 * @return DefaultListModel for the badge list
	 */
	public DefaultListModel<String> getBadgeListModel() {
		return this.badgeListModel;
	}

	/**
	 * Returns the badge scroll pane.
	 * 
	 * @return JScrollPane for the badge list pane
	 */
	public JScrollPane getBadgeScrollPane() {
		return this.badgeScrollPane;
	}
}
