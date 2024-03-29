/**
 * 
 */
package easypaint.graphicobject;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * @author Mark Bernard
 *
 */
public class ImageObject extends GraphicObject {
    /**
     * @param filePath 
     * @throws GraphicObjectException
     */
    public ImageObject(String filePath) throws GraphicObjectException {
        super(1, 1);
        try {
            loadImage(new FileInputStream(filePath));
        } catch (Exception e) {
            throw new GraphicObjectException("Could not load image.", e);
        }
    }
    
    private void loadImage(InputStream in) throws GraphicObjectException {
        try {
            image = ImageIO.read(in);
            width = image.getWidth();
            height = image.getHeight();
        } catch (Exception e) {
            throw new GraphicObjectException("Could not load image.", e);
        }
    }
}
