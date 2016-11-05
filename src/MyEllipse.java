import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by Brannon on 11/5/2016.
 */
public class MyEllipse extends Ellipse2D implements MyShape {
    @Override
    public double getX() {
        return 0;
    }

    @Override
    public double getY() {
        return 0;
    }

    @Override
    public void setSize(int width, int height) {

    }

    @Override
    public void setOrigin(int x, int y) {

    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void setFrame(double x, double y, double w, double h) {

    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void setColor(Color color) {

    }

    @Override
    public void setFilled(boolean filled) {

    }

    @Override
    public boolean isSelected(int x, int y) {
        return false;
    }

    @Override
    public void move(int dx, int dy) {

    }
}
