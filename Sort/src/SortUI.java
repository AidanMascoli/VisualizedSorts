import java.awt.*;
import javax.swing.*;
public class SortUI
{
    SortCanvas sc;
    JTextField t;
    JSpinner s;
    public SortUI()
    {
        //Create the window
        JFrame f= new JFrame("Visualized Sort");
        //Create and add the sort graphic
        sc = new SortCanvas();
        Canvas c = sc;
        f.add(c);
        //Create and add the Bubble Sort button
        JButton b1 = new JButton("Bubble Sort");
        b1.setBounds(25,510,125,40);
        b1.addActionListener(new BubbleButton());
        f.add(b1);
        //Create and add the Insertion Sort button
        JButton b2 = new JButton("Insertion Sort");
        b2.setBounds(160,510,125,40);
        b2.addActionListener(new InsertionButton());
        f.add(b2);
        //Create and add the Gnome Sort button
        JButton b3 = new JButton("Gnome Sort");
        b3.setBounds(295,510,125,40);
        b3.addActionListener(new GnomeButton());
        f.add(b3);
        //Create and add the Quick Sort button
        JButton b4 = new JButton("Quick Sort");
        b4.setBounds(430,510,125,40);
        b4.addActionListener(new QuickButton());
        f.add(b4);
        //Create and add the Shuffle button
        JButton b5 = new JButton("Shuffle");
        b5.setBounds(500,10,80,40);
        b5.addActionListener(new ShuffleButton());
        f.add(b5);
        //Create and add array size field label
        JLabel l = new JLabel("Array Size:");
        l.setBounds(510,400, 90,30);
        l.setForeground(Color.white);
        f.add(l);
        //Create and add array size field
        t = new JTextField();
        t.setBounds(510,430, 70,30);
        t.setText("100");
        f.add(t);
        //Create and add the graphics quality spinner label
        JLabel gql = new JLabel("<html>Graphics<br>Quality:");
        gql.setBounds(510,310, 90,30);
        gql.setForeground(Color.white);
        f.add(gql);
        //Create and add the graphics quality spinner
        String[] gq = {"Low", "Standard", "High"};
        s = new JSpinner(new SpinnerListModel(gq));
        s.setBounds(510,350,70,30);
        s.setValue("Standard");
        f.add(s);
        //Create and add the stair visualization button
        Icon sp = new ImageIcon("C:\\Users\\aidan\\IdeaProjects\\Sort\\src\\Stairs.png");
        JButton sb = new JButton(sp);
        sb.setBounds(500,70,80,80);
        sb.addActionListener(new StairButton());
        f.add(sb);
        //Create and add the color circle visualization button
        Icon cp = new ImageIcon("C:\\Users\\aidan\\IdeaProjects\\Sort\\src\\ColorCircle.png");
        JButton cb = new JButton(cp);
        cb.setBounds(500,160,80,80);
        cb.addActionListener(new CircleButton());
        f.add(cb);
        //Create and add exit button
        JButton eb = new JButton("Exit");
        eb.setBounds(510,250,70,30);
        eb.addActionListener(new ExitButton());
        f.add(eb);
        //Set the size, color, etc. of the JFrame
        f.setSize(600, 600);
        f.getContentPane().setBackground(Color.BLACK);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        //Show the UI
        f.setVisible(true);
    }
}
