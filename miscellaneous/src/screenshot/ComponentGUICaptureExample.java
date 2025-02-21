package screenshot;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This program demonstrates how to capture screenshot of a specific
 * GUI component and save it to an image file.
 *
 * @Author Muhammad Saimon
 * @since Jul 03,2024 7:56 AM
 */
public class ComponentGUICaptureExample extends JFrame implements ActionListener {

    private JButton button1 = new JButton("Capture Me!");
    private JButton button2 = new JButton("Capture This Frame!");

    public ComponentGUICaptureExample() {
        super("Component GUI Capture Demo");
        setLayout(new FlowLayout());

        button1.setName("button1");
        button1.addActionListener(this);

        button2.setName("button2");
        button2.addActionListener(this);

        add(button1);
        add(button2);

        setSize(400, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void captureComponent(Component component) {
        Rectangle rect = component.getBounds();

        try {
            String format = "png";
            String fileName = component.getName() + "." + format;
            BufferedImage captureImage = new BufferedImage(rect.width, rect.height, BufferedImage.TYPE_INT_ARGB);
            component.paint(captureImage.getGraphics());

            ImageIO.write(captureImage, format, new File(fileName));

            System.out.printf("The screenshot of %s was saved!", component.getName());
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton clickedButton = (JButton) event.getSource();
        if (clickedButton == button1) {
            // capture the button
            captureComponent(button1);
        } else if (clickedButton == button2) {
            // capture the frame
            captureComponent(this);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ComponentGUICaptureExample().setVisible(true);
            }
        });
    }
}
