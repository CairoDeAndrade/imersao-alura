package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class StickerFactory {

    public void createSticker(InputStream inputStream, String fileName) throws IOException {

        // Read the movie image
        BufferedImage originalImage = ImageIO.read(inputStream);

        // Create a new movie image in memory with another size and transparency
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 200;

        var newImage = new BufferedImage(width, newHeight, Transparency.TRANSLUCENT);

        // Copy the original image to the new one (In memory)
        var graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        // Style settings
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 64));

        // Write something on the new image
        String text = "Image text";

        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle2D textRectangle = fontMetrics.getStringBounds(text, graphics);

        int textWidth = (int) textRectangle.getWidth();
        int centeredPosition = (width - textWidth) / 2;

        graphics.drawString(text, centeredPosition, newHeight - 75);

        // Write the new image in a file
        ImageIO.write(newImage, "png", new File(fileName));
    }
}
