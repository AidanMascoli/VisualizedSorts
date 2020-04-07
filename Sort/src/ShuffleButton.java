import java.awt.event.*;
public class ShuffleButton implements ActionListener
{
    //When button pressed
    public void actionPerformed(ActionEvent e){
        //Tell SortManager to run a shuffle in a new Thread
        Runnable runSort = new Runnable() {
            @Override
            public void run() {
                SortManager.callSort("shuffle");
            }
        };
        new Thread(runSort).start();
    }
}