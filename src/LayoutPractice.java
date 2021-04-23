import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LayoutPractice extends JFrame {

    JPanel buttonPanel;
    FlowLayout flowLayout = new FlowLayout();


    public LayoutPractice() {
//        this.setVisible(true);
//        this.setTitle("GUIPractice");
//        this.setSize(500,500);
//        JPanel panel = createDialogue();
//        panel.setBackground(Color.LIGHT_GRAY);
//        this.setContentPane(panel);
//        Border padding = BorderFactory.createEmptyBorder(250,325,250,75);
//        panel.setBorder(padding);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setBackground(Color.LIGHT_GRAY);
        this.addComponents(this.getContentPane());
    }

    private JPanel createDialogue() {
        JButton button = new JButton("Fun Fact");
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(buttonPanel,
                        "FUN FACT OF THE DAY:" +
                        "Cats with more than 3 colors are always female" );
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        return createPanel(button);
    }

    private void addComponents(final Container pane) {
        final JPanel jPanel = new JPanel();
        jPanel.setLayout(flowLayout);
        flowLayout.setAlignment(FlowLayout.CENTER);
        jPanel.add(createDialogue());
        pane.add(jPanel, BorderLayout.CENTER);
    }

    private JPanel createPanel(JButton showButton) {
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(box,BorderLayout.PAGE_START);
        panel.add(showButton,BorderLayout.PAGE_END);
        return panel;
    }

    public static void main(String[] args) {
       new LayoutPractice();
    }


}
