/**
 * 
 */
package easypaint;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import easypaint.action.FileAction;
import easypaint.action.LineAction;
import easypaint.dialog.NewImageDialog;

/**
 * @author Mark Bernard
 *
 */
public class EasyPaint extends JPanel implements WindowListener {
    private static final long serialVersionUID = -8277245995513882880L;

    private JFrame parentFrame;
    private int newImageCounter;
    private JTabbedPane tabbedPane;
    
    /**
     * @param parentFrame 
     */
    public EasyPaint(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        parentFrame.addWindowListener(this);
        setLayout(new BorderLayout());
        PreferencesUtil.loadPrefs(this);
        setTitle();
        createMenu();
        add(createToolbar(), BorderLayout.WEST);
        tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);
    }
    
    private void createMenu() {
        JMenuBar bar = new JMenuBar();
        parentFrame.setJMenuBar(bar);
        
        JMenu fileMenu = new JMenu(new FileAction());
        bar.add(fileMenu);
        fileMenu.add(new JMenuItem(new FileAction.NewAction(this)));
    }
    
    private JToolBar createToolbar() {
        JToolBar toolbar = new JToolBar(JToolBar.VERTICAL);
        
        toolbar.add(new LineAction());
        
        return toolbar;
    }

    private void exit() {
        PreferencesUtil.savePrefs(this);
        System.exit(0);
    }
    
    /**
     * 
     */
    public void newImage() {
        NewImageDialog newImageDialog = new NewImageDialog(parentFrame);
        
        if (newImageDialog.showDialog()) {
            EasyPaintImage easyPaintImage = new EasyPaintImage(newImageDialog.getImageWidth(), newImageDialog.getImageHeight(), newImageCounter++);
            JScrollPane scroll = new JScrollPane(easyPaintImage, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            tabbedPane.addTab(easyPaintImage.getName(), scroll);
        }
    }
    
    @Override
    public void windowActivated(WindowEvent e) {}
    @Override
    public void windowClosed(WindowEvent e) {}
    @Override
    public void windowDeactivated(WindowEvent e) {}
    @Override
    public void windowDeiconified(WindowEvent e) {}
    @Override
    public void windowIconified(WindowEvent e) {}
    @Override
    public void windowOpened(WindowEvent e) {}
    @Override
    public void windowClosing(WindowEvent e) {
        exit();
    }
    
    private void setTitle() {
        parentFrame.setTitle("Easy Paint - ");
    }
    
    /**
     * @return the parentFrame
     */
    public JFrame getParentFrame() {
        return parentFrame;
    }

    /**
     * Launch the application
     * 
     * @param args
     */
    public static void main(String... args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        JFrame f = new JFrame();
        f.add(new EasyPaint(f), BorderLayout.CENTER);
        f.setVisible(true);
    }
}
