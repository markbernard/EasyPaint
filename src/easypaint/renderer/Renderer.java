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
    private GraphicObject graphicObject;
    
    /**
     * @param graphicObject
     */
    public Renderer(GraphicObject graphicObject) {
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
