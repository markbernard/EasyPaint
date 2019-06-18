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

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }
}
