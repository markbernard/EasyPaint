/**
 * 
 */
package easypaint;

import java.util.prefs.Preferences;

import javax.swing.JFrame;

/**
 * @author Mark Bernard
 *
 */
public class PreferencesUtil {
    private static final String WINDOW_X = "window_x";
    private static final String WINDOW_Y = "window_y";
    private static final String WINDOW_WIDTH = "window_width";
    private static final String WINDOW_HEIGHT = "window_height";
    private static final String WINDOW_MAXIMIZED = "window_maximized";
    
    /**
     * Load application preferences.
     * 
     * @param easyPaint
     */
    public static void loadPrefs(EasyPaint easyPaint) {
        Preferences prefs = Preferences.userNodeForPackage(PreferencesUtil.class);
        JFrame frame = easyPaint.getParentFrame();
        
        frame.setLocation(prefs.getInt(WINDOW_X, 0), prefs.getInt(WINDOW_Y, 0));
        frame.setSize(prefs.getInt(WINDOW_WIDTH, 1280), prefs.getInt(WINDOW_HEIGHT, 1024));
        if (prefs.getBoolean(WINDOW_MAXIMIZED, true)) {
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        try {
            prefs.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Save application preferences
     * 
     * @param easyPaint
     */
    public static void savePrefs(EasyPaint easyPaint) {
        Preferences prefs = Preferences.userNodeForPackage(PreferencesUtil.class);
        JFrame frame = easyPaint.getParentFrame();
        
        if (frame.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
            prefs.putBoolean(WINDOW_MAXIMIZED, true);
        } else {
            prefs.putInt(WINDOW_X, frame.getX());
            prefs.putInt(WINDOW_Y, frame.getY());
            prefs.putInt(WINDOW_WIDTH, frame.getWidth());
            prefs.putInt(WINDOW_HEIGHT, frame.getHeight());
            prefs.putBoolean(WINDOW_MAXIMIZED, false);
        }
    }
    
    private PreferencesUtil() {}
}
