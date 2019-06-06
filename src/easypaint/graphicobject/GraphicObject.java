/**
 * 
 */
package easypaint.graphicobject;

import java.awt.image.BufferedImage;

/**
 * @author Mark Bernard
 *
 */
public abstract class GraphicObject {
    protected BufferedImage image;
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    protected GraphicObject(int width, int height) {
        this.width = width;
        this.height = height;
        image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
    }
    
    /**
     * @return the image
     */
    public BufferedImage getImage() {
        return image;
    }
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }
    /**
     * @return the y
     */
    public int getY() {
        return y;
    }
}
