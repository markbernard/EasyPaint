/**
 * 
 */
package easypaint.action;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import easypaint.EasyPaint;

/**
 * @author Mark Bernard
 *
 */
public class FileAction extends AbstractAction {
    private static final long serialVersionUID = 2047943427523642578L;

    /**
     * 
     */
    public FileAction() {
        putValue(NAME, "File");
        putValue(MNEMONIC_KEY, KeyEvent.VK_F);
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
    }
    
    /**
     * @author Mark Bernard
     *
     */
    public static class NewAction extends AbstractAction {
        private static final long serialVersionUID = 5332773985745163034L;
        private EasyPaint easyPaint;

        /**
         * @param easyPaint 
         * 
         */
        public NewAction(EasyPaint easyPaint) {
            this.easyPaint = easyPaint;
            putValue(MNEMONIC_KEY, KeyEvent.VK_N);
            putValue(ACCELERATOR_KEY, 
                    KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
            putValue(NAME, "New...");
            putValue(SHORT_DESCRIPTION, "Create a new blank image.");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    easyPaint.newImage();
                }
            }, "New Image").start();
        }
    }
}
