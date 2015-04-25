package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

/**
 * This controller handles mouse dragging when selecting tiles on the Board in
 * the game.
 * 
 * @author Aditya Nivarthi
 */
public class GameBoardViewMouseMotionController extends MouseAdapter {

	protected GameApplication app;

	/**
	 * Creates a GameBoardViewMouseMotionController instance with the specified
	 * GameApplication.
	 * 
	 * @param app
	 *            The currently running GameApplication.
	 */
	public GameBoardViewMouseMotionController(GameApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseAdapter#mouseDragged(java.awt.event.MouseEvent)
	 */
	public void mouseDragged(MouseEvent me) {
		app.getLevelPanel().getBoardViewPanel()
				.updateGameSelection(me.getX(), me.getY());
		if (!app.getLevelPanel().getBoardViewPanel().getCurrentSelection()
				.isSelectionSumStillValid()
				|| !app.getLevelPanel().getBoardViewPanel()
						.getCurrentSelection().isValidPositionSelection()) {
			this.app.getLevelPanel()
					.getLevel()
					.setMoveCount(
							this.app.getLevelPanel().getLevel().getMoveCount() - 1);
			app.getLevelPanel().getBoardViewPanel().clearGameSelection();
		}
		app.getLevelPanel().updateLevelStats();
		app.getLevelPanel().getBoardViewPanel().updateUI();
	}
}
