/**
 * 
 */
package easypaint.graphicobject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * @author Mark Bernard
 *
 */
public class LineObject extends GraphicObject {
    private int targetX;
    private int targetY;
    
    /**
     * 
     */
    public LineObject() {
        super(10, 10);
        setTargetX(100);
        setTargetY(100);
    }

    /**
     * @return the targetX
     */
    public int getTargetX() {
        return targetX;
    }

    /**
     * @param targetX the targetX to set
     */
    public void setTargetX(int targetX) {
        this.targetX = targetX;
        width = Math.abs(x - targetX);
    }

    /**
     * @return the targetY
     */
    public int getTargetY() {
        return targetY;
    }

    /**
     * @param targetY the targetY to set
     */
    public void setTargetY(int targetY) {
        this.targetY = targetY;
        height = Math.abs(y - targetY);
    }

    @Override
    public BufferedImage getImage() {
        image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2 = image.createGraphics();
        g2.setColor(Color.BLACK);
        g2.drawLine(x, y, targetX, targetY);

        return super.getImage();
    }
}
