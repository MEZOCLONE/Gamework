package cz.robyer.gamework.activity;

import android.os.Bundle;
import cz.robyer.gamework.R;
import cz.robyer.gamework.game.GameEvent;

/**
 * Represents list of game objectives (tasks)
 * @author Robert P�sel
 */
public class GameObjectivesActivity extends BaseGameActivity {
	private static final String TAG = GameObjectivesActivity.class.getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_tasks);
		super.initButtons();
	}

	/**
	 * Checks UPDATED_OBJECTIVES event and updates objectives list.
	 */
	@Override
	public void receiveEvent(GameEvent event) {
		// TODO: think up and implement
		switch (event) {
		case UPDATED_OBJECTIVES:
			break;
		}
		super.receiveEvent(event);
	}

}
