/**
 * 
 */
package easypaint.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import easypaint.IconGenerator;

/**
 * @author Mark Bernard
 *
 */
public class LineAction extends AbstractAction {
    private static final long serialVersionUID = 7568145594789797977L;

    /**
     * 
     */
    public LineAction() {
        putValue(SMALL_ICON, IconGenerator.loadIcon("/res/icons/lines_small.png"));
        //putValue(LARGE_ICON_KEY, IconGenerator.loadIcon("/res/icons/lines.png"));
        putValue(SHORT_DESCRIPTION, "Draw lines");
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
    }
}
