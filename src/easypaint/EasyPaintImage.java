/**
 * 
 */
package easypaint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import easypaint.graphicobject.GraphicObject;
import easypaint.graphicobject.GraphicObjectException;
import easypaint.graphicobject.ImageObject;
import easypaint.renderer.ImageRenderer;
import easypaint.renderer.Renderer;

/**
 * @author Mark Bernard
 *
 */
public class EasyPaintImage extends JPanel {
    private static final long serialVersionUID = -7452081113016891340L;
    
    private int imageWidth;
    private int imageHeight;
    private List<Renderer<? extends GraphicObject>> renderList;
    private BufferedImage displayImage;
    private String name = "";
    
    /**
     * @param imageWidth 
     * @param imageHeight 
     * @param newImageCounter 
     */
    public EasyPaintImage(int imageWidth, int imageHeight, int newImageCounter) {
        setBackground(Color.WHITE);
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        name = "new-" + newImageCounter;
        displayImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_4BYTE_ABGR);
        renderList = new ArrayList<>();
    }

    /**
     * @param imageWidth 
     * @param imageHeight 
     * @param filePath 
     */
    public EasyPaintImage(int imageWidth, int imageHeight, String filePath) {
        setBackground(Color.WHITE);
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        displayImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_4BYTE_ABGR);
        renderList = new ArrayList<>();
        try {
            renderList.add(new ImageRenderer(new ImageObject(filePath)));
        } catch (GraphicObjectException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D imageGraphics = displayImage.createGraphics();
        for (Renderer<? extends GraphicObject> renderer : renderList) {
            renderer.render(imageGraphics);
        }
        
        g.drawImage(displayImage, 0, 0, this);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(imageWidth, imageHeight);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
}
