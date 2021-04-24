import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LayoutPractice extends JFrame {

    JPanel buttonPanel;
    JLabel buttonCounterLabel = new JLabel();
    FlowLayout flowLayout = new FlowLayout();
    Color backgroundColor = Color.LIGHT_GRAY;
    int numOfMouseClicks = 0;

    private JPanel createDialogue() {
        JButton button = new JButton("Fun Fact");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(buttonPanel,
                        "FUN FACT OF THE DAY: " +
                                "Cats with more than 3 colors are always female" );
                numOfMouseClicks++;
                buttonCounterLabel.setText("Button Amount: " + numOfMouseClicks);
                System.out.println(numOfMouseClicks);
            }
        });
        return createPanel(button);
    }

    private JPanel createPanel(JButton showButton) {
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
        JPanel panel = new JPanel(new FlowLayout());
        panel.setBackground(backgroundColor);
        panel.add(box,BorderLayout.PAGE_START);
        panel.add(showButton,BorderLayout.PAGE_END);
        return panel;
    }

    private JPanel picture(Graphics g) {
        JPanel panel = new JPanel(new FlowLayout());
        g.setColor(Color.GREEN);
        g.fillOval(50,50,50,50);
        repaint();
        return panel;
    }

    private void addComponents(Container pane) {
        //makes the dialogue button
        JPanel dialogue = new JPanel();
        dialogue.setLayout(flowLayout);
        flowLayout.setAlignment(FlowLayout.LEFT);
        dialogue.add(createDialogue());
        dialogue.setBackground(backgroundColor);

        //makes the labelPanel
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(flowLayout);
        labelPanel.add(buttonCounterLabel);
        buttonCounterLabel.setText("Button Count: 0");
        labelPanel.setBackground(backgroundColor);


        //Makes the picturePanel
        JPanel picturePanel = new JPanel();
        picturePanel.setLayout(new FlowLayout());
        picturePanel.setAlignmentX(FlowLayout.CENTER);
//        picturePanel.add(picture());



        //Adds the elements to one spot to put into the GUI
        pane.add(dialogue, BorderLayout.CENTER);
        pane.add(labelPanel, BorderLayout.WEST);
    }

    private  void createGUI() {
        LayoutPractice frame = new LayoutPractice();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponents(frame.getContentPane());
        frame.setTitle("Layout Practice");
        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        LayoutPractice layoutPractice = new LayoutPractice();
        layoutPractice.createGUI();
    }



}
