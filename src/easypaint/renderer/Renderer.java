/**
 * 
 */
package easypaint.renderer;

import java.awt.Graphics2D;

import easypaint.graphicobject.GraphicObject;

/**
 * @author Mark Bernard
 * @param <T> 
 */
public interface Renderer<T extends GraphicObject> {
    /**
     * Render the provided object.
     * 
     * @param graphics 
     */
    public void render(Graphics2D graphics);
}
