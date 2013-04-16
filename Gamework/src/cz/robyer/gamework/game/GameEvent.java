package cz.robyer.gamework.game;

import java.io.Serializable;

/**
 * Represents game event.
 * @author Robert P�sel
 */
public class GameEvent implements Serializable {

	private static final long serialVersionUID = -624979683919801177L;

	public enum EventType {
		GAME_START,			/** Game start/continue. */
		GAME_PAUSE,			/** Event for pausing game service. */
		GAME_WIN,			/** Player won the game. */
		GAME_LOSE,			/** Player lost the game. */
		GAME_QUIT,			/** Event for stop game service. */
		UPDATED_LOCATION, 	/** Player's location was updated. */
		UPDATED_TIME,		/** Game time was updated. */
		UPDATED_MESSAGES,	/** Game message was received */
		CUSTOM,
	}
	
	public final EventType type;
	public final Object value;
	
	/**
	 * Class constructor.
	 * @param type
	 */
	public GameEvent(EventType type) {
		this(type, null);
	}
	
	/**
	 * Class constructor for custom events. // TODO: use values also for UPDATED_* events?
	 * @param type
	 * @param value
	 */
	public GameEvent(EventType type, Object value) {
		this.type = type;
		this.value = value;
	}
}
