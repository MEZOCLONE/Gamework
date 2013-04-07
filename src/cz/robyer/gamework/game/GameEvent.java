package cz.robyer.gamework.game;

/**
 * Represents game event.
 * @author Robert P�sel
 */
public enum GameEvent {
  GAME_START,
  GAME_PAUSE,
  GAME_RESUME,
  GAME_WIN,
  GAME_LOSE,
  GAME_QUIT,
  UPDATED_LOCATION,
  UPDATED_TIME,
  UPDATED_OBJECTIVES,
  UPDATED_MESSAGES,
  UPDATED_INVENTORY,
}
