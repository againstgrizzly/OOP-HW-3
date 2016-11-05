import java.awt.*;

/**
 * Created by Brannon on 11/3/2016.
 */
interface MyShape {

    void draw(Graphics g);
    void setColor(Color color);
    void setFilled(boolean filled);
    boolean isSelected(int x, int y);
    void move(int dx, int dy);
    double getX();
    double getY();
    void setSize(int width, int height);
    void setOrigin(int x, int y);

}
