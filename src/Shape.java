import javafx.scene.input.MouseDragEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Brannon on 11/3/2016.
 */
public class Shape extends Rectangle implements MyShape {

    boolean filled;
    boolean selected = false;
    Color color;
    int width;
    int height;
    int xPosition;
    int yPosition;
    String shape = "Rectangle";

    public Shape(){


    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);

        if(shape.equals("Rectangle")){


            if(filled){

                g.fillRect(xPosition, yPosition, width, height);
            }

            else{
               // System.out.println("triggerd");


                g.drawRect(xPosition, yPosition, width, height);



            }
        }

        if(shape.equals("Ellipse")){

            if(filled){
                g.fillOval(xPosition, yPosition, width, height);
            }

            else{
                g.drawOval(xPosition, yPosition, width, height);
            }

        }

        if(shape.equals("Edge")){
            System.out.println(xPosition);
            System.out.println(yPosition);
            System.out.println(width);
            System.out.println(height);

            g.drawLine(xPosition, yPosition, width + xPosition, height + yPosition);
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

        if(true){
            return true;
        }

        else {
            return false;
        }
    }

    @Override
    public void move(int dx, int dy) {

    }

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

    public void setxPosition(int xPosition){
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition){
        this.yPosition = yPosition;
    }

    public int getxPosition(){
        return this.xPosition;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    public void setHeight(int height){
        this.height = height;
    }


    public int getyPosition(){
        return this.yPosition;
    }

    public void setShape(String shape){
        this.shape = shape;
    }


}
