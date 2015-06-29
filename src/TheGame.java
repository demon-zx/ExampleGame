import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Dmitry on 29.06.2015.
 */
public class TheGame extends JPanel {
    public static final int TILE_SIZE = 128;


    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(512, 512));
        frame.setLocationRelativeTo(null);

        TheGame game = new TheGame();

        frame.setContentPane(game);

        frame.setVisible(true);

    }

    BufferedImage sand;
    BufferedImage oil;

    public TheGame() throws IOException {
        sand = ImageIO.read(new FileInputStream("./images/sand.png"));
        oil = ImageIO.read(new FileInputStream("./images/oil.png"));
    }


    @Override
    protected void paintComponent(Graphics g) {
        int w = getWidth();
        int h = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, w, h);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                drawTile(graphics, sand, i, j);
            }
        }
        drawTile(graphics, oil, 1, 2);
    }

    public void drawTile(Graphics2D g, BufferedImage tile, int x, int y) {
        g.drawImage(tile, x * TILE_SIZE, y * TILE_SIZE, null);
    }
}
