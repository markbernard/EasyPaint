/**
 * 
 */
package easypaint;

import java.awt.Dimension;

import javax.swing.JSpinner;
import javax.swing.SpinnerModel;

/**
 * @author Mark Bernard
 *
 */
public class EasySpinner extends JSpinner {
    private static final long serialVersionUID = 7168023158190098501L;

    /**
     * 
     */
    public EasySpinner() {
        super();
    }

    /**
     * @param model
     */
    public EasySpinner(SpinnerModel model) {
        super(model);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        
        return new Dimension(size.width + 100, size.height);
    }
}
