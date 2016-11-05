import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Brannon on 11/3/2016.
 */
public class Canvas extends JPanel {

    List<MyShape> shapes = new ArrayList<>();
    Color selectedColor = Color.GREEN;
    boolean filled = false;
    String selectedShape = "Rectangle";

    int originX, originY;


    public Canvas(){
        super();
        this.setBackground(Color.WHITE);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

               // for(MyShape shape: shapes){



               // }


            }

            @Override
            public void mousePressed(MouseEvent e) {

                originX = e.getX();
                originY = e.getY();

                if(false) {

                    for (MyShape shape : shapes) {
                        System.out.println(shape.getX());
                    }

                }

                else{
                    MyRectangle rectangle = new MyRectangle();
                    shapes.add(rectangle);

                }


                repaint();


            }

            @Override
            public void mouseReleased(MouseEvent e) {


            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {


                /*Shape temp = shapeList.get(shapeList.size()-1);
                    temp.setWidth(e.getX()-temp.getxPosition());
                    temp.setHeight(e.getY()-temp.getyPosition());*/

                //MyShape temp = shapes.get(shapes.size()-1);
               // temp.



                    MyShape temp = shapes.get(shapes.size()-1);
                    temp.setColor(selectedColor);
                    temp.setOrigin(originX, originY);
                    temp.setSize(e.getX() - originX, e.getY() - originY);
                    temp.setFilled(filled);



            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);



        for(MyShape shape: shapes){
            Graphics2D g2d = (Graphics2D)g;
            g2d.fill((Shape)shape);
            shape.draw(g);
        }

        repaint();

    }


    public void setSelectedColor(Color color){
        this.selectedColor = color;
    }

    public void setFilled(boolean filled){
        this.filled = filled;
    }

    public void setSelectedShape(String shape){
        this.selectedShape = shape;
    }

}
