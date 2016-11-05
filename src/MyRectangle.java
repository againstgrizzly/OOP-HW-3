import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Brannon on 11/5/2016.
 */
public class MyRectangle extends Rectangle2D.Double implements MyShape {

    boolean filled;
    int width;
    int height;
    int xPosition;
    int yPosition;
    Color color;

    public MyRectangle(){
        super();
    }

    public void setOrigin(int x, int y){
        xPosition = x;
        yPosition = y;
    }

    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public double getX() {
        return xPosition;
    }

    @Override
    public double getY() {
        return yPosition;
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
    public void draw(Graphics g) {

        g.setColor(color);


        if(filled){
            g.fillRect(xPosition, yPosition,width,height);
        }

        else{
            g.drawRect(xPosition, yPosition, width, height);
        }

    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public boolean isSelected(int x, int y) {

        if(contains(x, y)){
            return true;
        }

        else{
            return false;
        }
    }

    @Override
    public void move(int dx, int dy) {

    }

}
