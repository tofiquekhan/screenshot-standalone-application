package myproject.trackerapplication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SpringBootApplication
@Slf4j
public class TrackerapplicationApplication {

    public static void screenShot(){
        try {
            String format = "jpg";
            String fileName = "FullScreenshot." + format;
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
            ImageIO.write(screenFullImage, format, new File(fileName));

            System.out.println("A full screenshot saved!");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(TrackerapplicationApplication.class);

        builder.headless(false);

        ConfigurableApplicationContext context = builder.run(args);
        screenShot();
        log.info("Tracker Application Started");
    }

}
