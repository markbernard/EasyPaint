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
public class Renderer<T extends GraphicObject> {
    private T graphicObject;
    
    /**
     * @param graphicObject
     */
    public Renderer(T graphicObject) {
        this.graphicObject = graphicObject;
        
    }
    /**
     * Render the provided object.
     * 
     * @param graphics 
     */
    public void render(Graphics2D graphics) {
        graphics.drawImage(graphicObject.getImage(), graphicObject.getX(), graphicObject.getY(), 
                graphicObject.getWidth(), graphicObject.getHeight(), null);
    }
}
