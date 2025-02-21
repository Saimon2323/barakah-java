package screenshot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

/**
 * @Author Muhammad Saimon
 * @since Jul 03,2024 7:40 AM
 */

public class FullScreenCaptureExample {
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            String fileFormat = "jpg";
            String fileName = "ScreenShot_" + LocalDate.now() + "." + fileFormat;

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

            // Full page
            Rectangle screenRect = new Rectangle(screenSize);

            // Partial Capture
            // Rectangle screenRect = new Rectangle(0, 0, screenSize.width / 2, screenSize.height / 2);

            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
            ImageIO.write(screenFullImage, fileFormat, new File(fileName));

            System.out.println("A Full Screenshot has been captured!");
        } catch (AWTException | IOException e) {
            System.err.println("Failed to Capture a Screenshot");
            throw new RuntimeException(e);
        }
    }
}
