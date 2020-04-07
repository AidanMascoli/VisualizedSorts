import java.awt.event.*;
public class BubbleButton  implements ActionListener
{
    //When button pressed
    public void actionPerformed(ActionEvent e){
        //Tell SortManager to run a bubble sort in a new Thread
        Runnable runSort = new Runnable() {
            @Override
            public void run() {
                SortManager.callSort("bubble");
            }
        };
        new Thread(runSort).start();
    }
}
