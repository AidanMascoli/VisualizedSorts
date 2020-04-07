import java.awt.event.*;
public class CircleButton implements ActionListener
{
    //When button pressed
    public void actionPerformed(ActionEvent e){
        //Clear canvas
        SortManager.su.sc.updateGraphics(12345, SortManager.values.length - 1);
        //Default length to 180
        SortManager.su.t.setText("180");
        SortManager.length = 180;
        //Clear the array
        SortManager.values = new int[SortManager.length];
        //Set the visualization to color circle
        SortManager.graphicsType = "circle";
        //Clear the canvas
        SortManager.su.sc.updateGraphics(12345, SortManager.values.length - 1);
    }
}