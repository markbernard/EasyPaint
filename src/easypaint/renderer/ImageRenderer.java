/**
 * 
 */
package easypaint.renderer;

import java.awt.Graphics2D;

import easypaint.graphicobject.ImageObject;

/**
 * @author Mark Bernard
 *
 */
public class ImageRenderer implements Renderer<ImageObject> {
    private ImageObject imageObject;
    
    /**
     * @param imageObject
     */
    public ImageRenderer(ImageObject imageObject) {
        this.imageObject = imageObject;
    }
    
    @Override
    public void render(Graphics2D graphics) {
        graphics.drawImage(imageObject.getImage(), imageObject.getX(), imageObject.getY(), null);
    }
}
