package processmgrsim;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.LinkedList;
import java.util.Random;
import processmgrsim.manager.Manager;
import processmgrsim.manager.Process;
import processmgrsim.manager.Address;

/**
 *
 * @author janoc
 */
public class MemoryPainter {

    private javax.swing.JPanel canvas;
    private Graphics2D g2d;
    private LinkedList<Color> colors;
    private FontMetrics fontMetrics;

    public MemoryPainter(javax.swing.JPanel canvas, int nOfAvailableColors) {
        this.canvas = canvas;
        this.g2d = (Graphics2D) canvas.getGraphics();
        this.g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        this.fontMetrics = g2d.getFontMetrics();
        this.initColors(nOfAvailableColors);
    }

    public void paint(Manager man) {
        canvas.paint(g2d);
        drawWatermark();
        for (Process p : man.getRunningProcesses()) {
            for (Address a : p.getAddr()) {
                //Rectangle
                g2d.setColor(colors.get(man.getRunningProcesses().indexOf(p)));
                g2d.fillRect(0, a.firstByte, canvas.getWidth() - 1, a.getTotalBytes());
                //Title
                g2d.setColor(getForeColor(g2d.getColor()));
                if (fontMetrics.getAscent() + 2 <= a.getTotalBytes()) {
                    drawCenteredString(
                            String.format("PID: %d, Size: %d", p.getPID(), a.getTotalBytes()),
                            a.firstByte,
                            a.getTotalBytes());
                }
                //Border
                g2d.setColor(Color.GRAY);
                g2d.drawRect(0, a.firstByte, canvas.getWidth() - 1,
                        a.lastByte == man.MAXADDR ? a.getTotalBytes() - 1 : a.getTotalBytes());
            }
        }
    }
    private void drawCenteredString(String str, int yOffset, int height) {
        g2d.drawString(str,
                (canvas.getWidth() - fontMetrics.stringWidth(str)) / 2f,
                yOffset + ((height - fontMetrics.getHeight()) / 2f) + fontMetrics.getAscent()
        );
    }
    public void drawWatermark() {
        g2d.setColor(Color.gray);
        drawCenteredString("MEMORIA", canvas.getHeight() / 2, 0);
    }

    //<editor-fold defaultstate="collapsed" desc="Color management">
    private void initColors(int n) {
        colors = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            //get a pastel color
            colors.add(mixColors(
                    generateRandomColor(),
                    Color.WHITE));
        }
    }
    private Color generateRandomColor() {
        Random r = new Random();
        int red = r.nextInt(256);
        int green = r.nextInt(256);
        int blue = r.nextInt(256);

        return new Color(red, green, blue);
    }
    private Color mixColors(Color a, Color b) {
        int red = (a.getRed() + b.getRed()) / 2;
        int green = (a.getGreen() + b.getGreen()) / 2;
        int blue = (a.getBlue() + b.getBlue()) / 2;
        return new Color(red, green, blue);
    }
    private static Color getForeColor(Color color) {
        if (getBrightness(color) < 130) {
            return Color.white;
        } else {
            return Color.black;
        }
    }
    private static int getBrightness(Color c) {
        return (int) Math.sqrt(
                c.getRed() * c.getRed() * .241
                + c.getGreen() * c.getGreen() * .691
                + c.getBlue() * c.getBlue() * .068);
    }
    //</editor-fold>
}
