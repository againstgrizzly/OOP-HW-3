import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Brannon on 11/2/2016.
 */
public class HW_4737 {

    public static void main(String[] args){
        MyFrame myFrame = new MyFrame();
    }

}

class MyFrame extends JFrame{

    JButton undoButton;
    JButton clearButton;
    JComboBox colorComboBox;
    final String[] COLORS = {"Green", "Red", "Blue", "Black"};
    JComboBox shapeComboBox;
    final String[] SHAPES = {"Rectangle", "Ellipse", "Edge"};
    JCheckBox filledCheckBox;
    JLabel coordinatesLabel;
    Canvas drawCanvas;
    JPanel topButtonsPanel;

    List<Shape> shapeHolder = new ArrayList<>();

    public MyFrame(){

        GUI();
        Actions();

    }

    public void GUI(){

        undoButton = new JButton("Undo");
        clearButton = new JButton("Clear");
        colorComboBox = new JComboBox(COLORS);
        shapeComboBox = new JComboBox(SHAPES);
        filledCheckBox = new JCheckBox("Filled");
        filledCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
        coordinatesLabel = new JLabel("OUT");

        topButtonsPanel = new JPanel();
        topButtonsPanel.setLayout(new FlowLayout());
        topButtonsPanel.add(undoButton);
        topButtonsPanel.add(clearButton);
        topButtonsPanel.add(colorComboBox);
        topButtonsPanel.add(shapeComboBox);
        topButtonsPanel.add(filledCheckBox);

        drawCanvas = new Canvas();


        setLayout(new BorderLayout());

        add(drawCanvas, BorderLayout.CENTER);
        add(topButtonsPanel, BorderLayout.NORTH);
        add(coordinatesLabel, BorderLayout.SOUTH);

        setTitle("Paint");
        setSize(500, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void Actions(){

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawCanvas.shapes.clear();
                drawCanvas.repaint();
            }
        });

        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(drawCanvas.shapes.size() > 0) {
                    drawCanvas.shapes.remove(drawCanvas.shapes.size() - 1);
                    drawCanvas.repaint();
                }
            }
        });

        colorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String selectedColor = (String)cb.getSelectedItem();

                switch(selectedColor){
                    case "Green" : drawCanvas.setSelectedColor(Color.GREEN);
                        break;
                    case "Red" : drawCanvas.setSelectedColor(Color.RED);
                        break;
                    case "Blue" : drawCanvas.setSelectedColor(Color.BLUE);
                        break;
                    case "Black" : drawCanvas.setSelectedColor(Color.BLACK);
                        break;
                    default: System.out.println("Believe in yourself, Luke");
                }
            }
        });


        //shapeComboBox
         filledCheckBox.addItemListener(new ItemListener() {
             @Override
             public void itemStateChanged(ItemEvent e) {
                 if(e.getStateChange() == 1){
                     drawCanvas.setFilled(true);
                     System.out.println("checked");
                 }

                 if(e.getStateChange() == 2){
                     drawCanvas.setFilled(false);
                     System.out.println("not checked");
                 }
             }
         });

        drawCanvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {coordinatesLabel.setText("("+e.getX()+","+e.getY()+")");}

            @Override
            public void mouseMoved(MouseEvent e) {coordinatesLabel.setText("("+e.getX()+","+e.getY()+")");}
        });

        shapeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String selectedShape = (String)cb.getSelectedItem();

                switch(selectedShape){
                    case "Rectangle" : drawCanvas.setSelectedShape("Rectangle");
                        break;
                    case "Ellipse" : drawCanvas.setSelectedShape("Ellipse");
                        break;
                    case "Edge" : drawCanvas.setSelectedShape("Edge");
                        break;
                    default: System.out.println("Believe some more, Padawan");
                }

            }
        });

        drawCanvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {coordinatesLabel.setText("OUT");}
        });
    }
}
