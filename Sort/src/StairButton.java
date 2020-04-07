import java.awt.event.*;
public class StairButton implements ActionListener
{
    //When button pressed
    public void actionPerformed(ActionEvent e){
        //Default length to 100
        SortManager.su.t.setText("100");
        SortManager.length = 100;
        //Reset the array
        SortManager.values = new int[SortManager.length];
        //Update the graphics
        SortManager.su.sc.updateGraphics(0, SortManager.values.length - 1);
        //Set the visualization to stairs
        SortManager.graphicsType = "stairs";
    }
}
