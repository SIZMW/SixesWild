package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;
import SixesWild.com.mimas.sixeswild.entities.LevelType;

/**
 * This controller handles the xstacy move when the xstacy special move button
 * is pressed.
 *
 * @author Aditya Nivarthi
 */
public class XStacyMoveButtonController implements ActionListener {

	private static final Logger logger = Logger.getGlobal();

	protected GameApplication app;

	/**
	 * Creates a XStacyMoveButtonController instance with the specified
	 * GameApplication.
	 *
	 * @param app
	 *            The GameApplication currently running.
	 */
	public XStacyMoveButtonController(GameApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		// Get the number of xstacy moves remaining
		int moves = this.app.getLevelPanel().getLevel().getSpecialMoves()
				.getXStacySpecialMoveCount();

		// Execute the move if there are moves of this type left
		if (moves > 0) {
			if (this.app.getLevelPanel().getLevel().getType()
					.equals(LevelType.LIGHTNING)) {
				this.app.getLevelPanel().getLevel().updateTimerCount(20);
			} else {
				this.app.getLevelPanel().getLevel().updateMoveCount(10);
			}
			this.app.getLevelPanel().getLevel().getSpecialMoves()
					.updateXStacySpecialMoveCount(-1);
			logger.log(Level.INFO,
					"XStacy special move requested and completed.");
		} else {
			logger.log(Level.INFO,
					"XStacy special move cannot be completed. Moves left: "
							+ moves);
		}

		// Update the level display
		this.app.getLevelPanel().updateLevelStats();
		this.app.getLevelPanel().updateUI();
	}
}
