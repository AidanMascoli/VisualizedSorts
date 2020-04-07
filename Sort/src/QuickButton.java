import java.awt.event.*;
public class QuickButton implements ActionListener
{
    //When button pressed
    public void actionPerformed(ActionEvent e){
        //Tell SortManager to run a quick sort in a new Thread
        Runnable runSort = new Runnable() {
            @Override
            public void run() {
                SortManager.callSort("quick");
            }
        };
        new Thread(runSort).start();
    }
}
