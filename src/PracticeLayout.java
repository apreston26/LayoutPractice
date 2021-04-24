import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PracticeLayout extends JFrame {

    JPanel buttonPanel;
    JLabel buttonCounterLabel = new JLabel();
    FlowLayout flowLayout = new FlowLayout();
    Color backgroundColor = Color.LIGHT_GRAY;
    int numOfMouseClicks = 0;

    private enum ShapeChoice {
        CIRCLE, RECTANGLE, ROUND_RECTANGLE;
    }

    private ShapeChoice shape = ShapeChoice.CIRCLE;

    public PracticeLayout() {
        JPanel jPanel1 = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Color alien = new Color(15, 253, 1);
                g.setColor(alien);
                g.drawArc(xPos,yPos,size/3,size/4,0,180);
                g.fillArc(xPos,yPos,size/3,size/4,0,180);

                Color base = new Color(170, 170, 170);
                g.setColor(base);
                g.fillOval(xPos-size/3, yPos+size/8, size, size/4);

                Color stroke = new Color(0,0,0, 196);
                g.setColor(stroke);
                g.setStroke(new BasicStroke(2));
                g.drawLine(xPos-size/3,yPos+size/4, xPos+size-size/3,yPos+size/4);
            }
        };
        getContentPane().add(jPanel1,"Center");
    }
        private void createGUI () {
            LayoutPractice frame = new LayoutPractice();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //Set up the content pane.
            frame.addComponents(frame.getContentPane());
            frame.setTitle("Layout Practice");
            //Display the window.
            frame.pack();
        }

        public static void main(String[] paramArrayOfString) {
                    PracticeLayout practiceLayout = new PracticeLayout();
                    practiceLayout.setVisible(true);

        }

}
