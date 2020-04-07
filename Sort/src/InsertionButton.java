import java.awt.event.*;
public class InsertionButton implements ActionListener
{
    //When button pressed
    public void actionPerformed(ActionEvent e){
        //Tell SortManager to run an insertion sort in a new Thread
        Runnable runSort = new Runnable() {
            @Override
            public void run() {
                SortManager.callSort("insertion");
            }
        };
        new Thread(runSort).start();
    }
}