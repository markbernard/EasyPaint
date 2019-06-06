/**
 * 
 */
package easypaint.graphicobject;

/**
 * @author Mark Bernard
 *
 */
public class GraphicObjectException extends Exception {
    private static final long serialVersionUID = 6577933079360504576L;

    /**
     * 
     */
    public GraphicObjectException() {}

    /**
     * @param arg0
     */
    public GraphicObjectException(String arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     */
    public GraphicObjectException(Throwable arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     */
    public GraphicObjectException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    /**
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     */
    public GraphicObjectException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }
}
