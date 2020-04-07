import java.awt.event.*;
public class GnomeButton implements ActionListener
{
    //When button pressed
    public void actionPerformed(ActionEvent e){
        //Tell SortManager to run a gnome sort in a new Thread
        Runnable runSort = new Runnable() {
            @Override
            public void run() {
                SortManager.callSort("gnome");
            }
        };
        new Thread(runSort).start();
    }
}
