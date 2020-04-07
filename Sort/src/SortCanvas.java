import java.awt.*;
class SortCanvas extends Canvas
{
    int start = 0;
    int end = 99;
    public SortCanvas() {
        //Initialize the canvas
        setBackground (Color.BLACK);
        setSize(500, 500);
    }
    public void paint(Graphics g)
    {
        //Draw the statistics
        g.setColor(Color.WHITE);
        g.drawString("Comparisons:", 10, 20);
        g.drawString(Integer.toString(SortManager.tvalues[0]), 10, 40);
        g.drawString("Array Accesses:", 10, 60);
        g.drawString(Integer.toString(SortManager.tvalues[1]), 10, 80);
        g.drawString("Delay:", 10, 100);
        g.drawString(Integer.toString(SortManager.tvalues[2]) + "ms", 10, 120);
        //Draw the graphic
        if (SortManager.graphicsQuality == "Low")
        {
            //The whole thing
            switch (SortManager.graphicsType) {
                case "stairs":
                    for (int i = 0; i < SortManager.values.length; i++) {
                        int space = (int) 400 / SortManager.length;
                        g.fillRect(i * space + 100, 500 - SortManager.values[i] * space, space, SortManager.values[i] * space);
                    }
                    break;
                case "circle":
                    for (int i = 0; i < SortManager.values.length; i++)
                    {
                        int space = (int) 360 / SortManager.length;
                        float h = (float) SortManager.values[i] / SortManager.values.length;
                        Color myRGBColor = Color.getHSBColor(h, 1f, 1f);
                        g.setColor(myRGBColor);
                        g.fillArc(100, 100, 400, 400, space * i + 90, space);
                    }
                    break;
            }
        }
        else
        {
            //Specific part
            switch (SortManager.graphicsType) {
                case "stairs":
                    for (int i = start; i <= end; i++)
                    {
                        int space = (int) 400 / SortManager.length;
                        g.fillRect(i * space + 100, 500 - SortManager.values[i] * space, space, SortManager.values[i] * space);
                    }
                    break;
                case "circle":
                    for (int i = start; i <= end; i++)
                    {
                        int space = (int) 360 / SortManager.length;
                        float h = (float) SortManager.values[i] / SortManager.values.length;
                        Color myRGBColor = Color.getHSBColor(h, 1f, 1f);
                        g.setColor(myRGBColor);
                        g.fillArc(100, 100, 400, 400, space * i + 90, space);
                    }
                    break;
            }
        }
    }
    public void update(Graphics g)
    {
        //Reset the graphics
        int space = (int) 400 / SortManager.length;
        g.clearRect(0, 0, 100, 200);
        if (start == 12345)
        {
            //Special case to clear only
            g.clearRect(0, 0, 500, 500);
            g.setColor(Color.WHITE);
            g.drawString("Comparisons:", 10, 20);
            g.drawString(Integer.toString(SortManager.tvalues[0]), 10, 40);
            g.drawString("Array Accesses:", 10, 60);
            g.drawString(Integer.toString(SortManager.tvalues[1]), 10, 80);
            g.drawString("Delay:", 10, 100);
            g.drawString(Integer.toString(SortManager.tvalues[2]) + "ms", 10, 120);
        }
        else if (SortManager.graphicsType == "stairs")
        {
            //Clear Stairs
            switch (SortManager.graphicsQuality) {
                case "Low":
                    //Entire thing
                    g.clearRect(0, 0, 500, 500);
                    break;
                case "High":
                    //Specific parts
                    for (int i = start; i <= end; i++) {
                        g.clearRect(i * space + 100, 90, space, 510 - SortManager.values[i] * space);
                    }
                    break;
                default:
                    g.clearRect(start * space + 100, 90, (end - start + 1) * space, 410);
                    break;
            }
            //Redraw what was erased with updated values
            paint(g);
        }
        else
        {
            //Clear the circle
            switch (SortManager.graphicsQuality) {
                case "High":
                    //Whole sector
                    g.setColor(Color.BLACK);
                    g.fillArc(100, 100, 401, 401, space * start + 90, space * (end - start + 1));
                    break;
                case "Standard":
                    //Just the edge
                    g.setColor(Color.BLACK);
                    g.drawArc(100, 100, 399, 399, space * start + 90, space * (end - start + 1));
                    break;
            }
            //Redraw what was erased with updated values
            paint(g);
        }
    }
    public void updateGraphics(int low, int high)
    {
        //Update the update range
        start = low;
        end = high;
        //Call update
        repaint();
    }
}