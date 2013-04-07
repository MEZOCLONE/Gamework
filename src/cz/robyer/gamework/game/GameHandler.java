package cz.robyer.gamework.game;

import java.util.WeakHashMap;

import cz.robyer.gamework.util.Log;

/**
 * Handler for broadcasting {@link GameEvent}s.
 * @author Robert P�sel
 */
public class GameHandler implements GameEventBroadcaster {
	private static final String TAG = GameHandler.class.getSimpleName();
	
	private final WeakHashMap<GameEventListener, Boolean> listeners = new WeakHashMap<GameEventListener, Boolean>();

	/**
	 * Add listener.
	 * @param listener
	 * @return true if listener was added or false if it already existed
	 */
	public synchronized boolean addListener(GameEventListener listener) {
		Log.d(TAG, "Adding GameEventListener " + listener.toString());
		return (listeners.put(listener, true) == null);
	}
	
	/**
	 * Remove registered listener.
	 * @param listener to remove
	 * @return true when listener was removed or false if it did not existed
	 */
	public synchronized boolean removeListener(GameEventListener listener) {
		Log.d(TAG, "Removing GameEventListener " + listener.toString());
		return (listeners.remove(listener) != null);
 	}
	
	/**
	 * Removes all registered listeners.
	 */
	public synchronized void clearListeners() {
		Log.d(TAG, "Clearing GameEventListeners");
		listeners.clear();
	}
	
	/**
	 * Broadcasts {@link GameEvent} to all registered listeners.
	 */
	@Override
	public synchronized void broadcastEvent(GameEvent event) {
		int severity = android.util.Log.INFO;
		if (event == GameEvent.UPDATED_LOCATION ||
			event == GameEvent.UPDATED_TIME) {
			severity = android.util.Log.DEBUG;
	    }
	
	    if (Log.loggingEnabled()) {
	    	Log.println(severity, TAG, "Broadcasting event " + event.name() + " to " + listeners.size() + " listeners");
	    }
	
	    for (GameEventListener listener : listeners.keySet()) {
	    	if (listener != null) {
	    		listener.receiveEvent(event);
	    	}
	    }
	}

	public long getGameTime() {
		// TODO: return game time somehow from GameService
		return 0;
	}
}
