public class SortManager {
    //Declare and Initialize Variables
    public static int length = 100;
    public static int[] values = new int[length];
    public static int[] tvalues = new int[3];
    public static SortUI su;
    public static Sorts s;
    public static boolean doingSort = false;
    public static String graphicsQuality = "Standard";
    public static String graphicsType = "stairs";
    //Main Code
    public static void main(String[] args)
    {
        //Create SortUI
        su = new SortUI();
        //Create Sorts
        s = new Sorts();
        //Shuffle the array
        s.shuffle(length);
    }
    //Run a sort
    public static void callSort(String sort)
    {
        //If not busy
        if (!doingSort)
        {
            doingSort = true;
            //Update graphics quality
            graphicsQuality = (String) su.s.getValue();
            //Determine which sort to run
            switch (sort) {
                case "bubble":
                    s.BubbleSort();
                    break;
                case "insertion":
                    s.InsertionSort();
                    break;
                case "gnome":
                    s.GnomeSort();
                    break;
                case "quick":
                    s.QuickSort(0, values.length - 1);
                    su.sc.updateGraphics(0, SortManager.values.length - 1);
                    break;
                default:
                    length = Integer.parseInt(su.t.getText());
                    s.shuffle(length);
                    break;
            }
            doingSort = false;
        }
    }
}
