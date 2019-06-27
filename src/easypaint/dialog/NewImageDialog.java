/**
 * 
 */
package easypaint.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;

import easypaint.EasySpinner;

/**
 * @author Mark Bernard
 *
 */
public class NewImageDialog extends JDialog {
    private static final long serialVersionUID = -8226459069512248518L;
    private boolean approved;
    private SpinnerNumberModel widthSpinnerNumberModel;
    private SpinnerNumberModel heightSpinnerNumberModel;
    
    /**
     * @param frame
     */
    public NewImageDialog(Frame frame) {
        super(frame, true);
        approved = false;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
        mainPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5), 
                BorderFactory.createEtchedBorder(EtchedBorder.RAISED)));
        
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 15, 15));
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        inputPanel.add(new JLabel("width"));
        widthSpinnerNumberModel = new SpinnerNumberModel();
        widthSpinnerNumberModel.setMinimum(0);
        widthSpinnerNumberModel.setValue(800);
        inputPanel.add(new EasySpinner(widthSpinnerNumberModel));
        inputPanel.add(new JLabel("height"));
        heightSpinnerNumberModel = new SpinnerNumberModel();
        heightSpinnerNumberModel.setMinimum(0);
        heightSpinnerNumberModel.setValue(600);
        inputPanel.add(new EasySpinner(heightSpinnerNumberModel));
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JButton okButton = new JButton("Ok");
        buttonPanel.add(okButton);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                approved = true;
                setVisible(false);
            }
        });
        getRootPane().setDefaultButton(okButton);
        JButton cancelButton = new JButton("Cancel");
        buttonPanel.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        pack();
    }

    /**
     * @return true if approve option clicked
     */
    public boolean showDialog() {
        setVisible(true);
        
        return approved;
    }
    
    /**
     * @return the users image width
     */
    public int getImageWidth() {
        return ((Integer) widthSpinnerNumberModel.getValue()).intValue();
    }
    
    /**
     * @return the users image height
     */
    public int getImageHeight() {
        return ((Integer) heightSpinnerNumberModel.getValue()).intValue();
    }
}
