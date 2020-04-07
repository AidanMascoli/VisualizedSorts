import java.util.Random;
public class Sorts {
    //Shuffle array and graphics
    public void shuffle(int len)
    {
        //Reset statistics
        SortManager.tvalues[0] = 0;
        SortManager.tvalues[1] = 0;
        SortManager.tvalues[2] = (int) 1600 / len;
        SortManager.values = new int[len];
        SortManager.su.sc.updateGraphics(0, SortManager.values.length - 1);
        for (int i = 0; i < len; i++)
        {
            Random rand = new Random();
            int index = rand.nextInt(len);
            while (SortManager.values[index] != 0){
                index = rand.nextInt(len);
            }
            SortManager.values[index] = i + 1;
            //Update the graphics to array
            SortManager.su.sc.updateGraphics(index, index);
            //Delay for visibility
            try {
                Thread.sleep(SortManager.tvalues[2]);
            } catch (InterruptedException e) {
                System.out.println("got interrupted!");
            }
        }
        SortManager.su.sc.updateGraphics(0, SortManager.values.length - 1);
    }
    //Bubble sort array and graphics
    public void BubbleSort()
    {
        //Reset statistics
        SortManager.su.sc.updateGraphics(0, SortManager.values.length - 1);
        SortManager.tvalues[0] = 0;
        SortManager.tvalues[1] = 0;
        SortManager.tvalues[2] = (int) 400 / SortManager.values.length;
        //Bubble sort
        boolean sorted = false;
        while(sorted == false) {
            int first;
            int second;
            sorted =  true;
            for (int i = 0; i < SortManager.values.length - 1; i++) {
                first = SortManager.values[i];
                second = SortManager.values[i + 1];
                SortManager.tvalues[1] += 2;
                if (first > second) {
                    SortManager.values[i] = second;
                    SortManager.values[i + 1] = first;
                    SortManager.tvalues[1] += 2;
                    //Update graphics to array
                    SortManager.su.sc.updateGraphics(i, i + 1);
                    sorted = false;
                    //Delay for visibility
                    try {
                        Thread.sleep(SortManager.tvalues[2]);
                    } catch (InterruptedException e) {
                        System.out.println("got interrupted!");
                    }
                }
                SortManager.tvalues[0]++;
            }
        }
        SortManager.su.sc.updateGraphics(0, SortManager.values.length - 1);
    }
    //Insertion sort the array and graphics
    public void InsertionSort()
    {
        //Reset statistics
        SortManager.su.sc.updateGraphics(0, SortManager.values.length - 1);
        SortManager.tvalues[0] = 0;
        SortManager.tvalues[1] = 0;
        SortManager.tvalues[2] = (int) 800 / SortManager.values.length;
        //Insertion sort
        for (int i = 1; i < SortManager.values.length; ++i)
        {
            int key = SortManager.values[i];
            SortManager.tvalues[1]++;
            int x = i - 1;
            while (x >= 0 && SortManager.values[x] > key)
            {
                SortManager.values[x + 1] = SortManager.values[x];
                SortManager.tvalues[1] += 2;
                //Update graphics to array
                SortManager.su.sc.updateGraphics(x + 1, x + 1);
                //Delay for visibility
                try {
                    Thread.sleep(SortManager.tvalues[2]);
                } catch (InterruptedException e) {
                    System.out.println("got interrupted!");
                }
                x--;
                SortManager.tvalues[0]++;
            }
            SortManager.values[x + 1] = key;
            SortManager.tvalues[1]++;
            //Update graphics to array
            SortManager.su.sc.updateGraphics(x + 1, x + 1);
            //Delay for visibility
            try {
                Thread.sleep(SortManager.tvalues[2]);
            } catch (InterruptedException e) {
                System.out.println("got interrupted!");
            }
        }
        SortManager.su.sc.updateGraphics(0, SortManager.values.length - 1);
    }
    //Gnome sort array and graphics
    public void GnomeSort()
    {
        //Reset statistics
        SortManager.su.sc.updateGraphics(0, SortManager.values.length - 1);
        SortManager.tvalues[0] = 0;
        SortManager.tvalues[1] = 0;
        SortManager.tvalues[2] = (int) 800 / SortManager.values.length;
        //Gnome sort
        int pos = 0;
        int first;
        int second;
        while(pos < SortManager.values.length)
        {
            if (pos > 0)
            {
                first = SortManager.values[pos - 1];
                second = SortManager.values[pos];
                SortManager.tvalues[1] += 2;
                if (second > first) {
                    pos++;
                } else {
                    SortManager.values[pos - 1] = second;
                    SortManager.values[pos] = first;
                    SortManager.tvalues[1] += 2;
                    //Update graphics to array
                    SortManager.su.sc.updateGraphics(pos - 1, pos);
                    pos--;
                    //Delay for visibility
                    try {
                        Thread.sleep(SortManager.tvalues[2]);
                    } catch (InterruptedException e) {
                        System.out.println("got interrupted!");
                    }
                }
                SortManager.tvalues[0] ++;
            }
            else
            {
                pos++;
            }
        }
        SortManager.su.sc.updateGraphics(0, SortManager.values.length - 1);
    }
    //QuickSort array and graphics
    public void QuickSort(int low, int high)
    {
        //Set delay
        SortManager.tvalues[2] = (int) 1200 / SortManager.values.length;
        //QuickSort
        if (low < high)
        {
            int pivot = SortManager.values[high];
            SortManager.tvalues[1]++;
            int i = low - 1;
            int first;
            int second;
            for (int j = low; j < high; j++)
            {
                if (SortManager.values[j] < pivot)
                {
                    i++;
                    first = SortManager.values[i];
                    second = SortManager.values[j];
                    SortManager.values[i] = second;
                    SortManager.values[j] = first;
                    SortManager.tvalues[1] += 2;
                    //Update graphics to array
                    SortManager.su.sc.updateGraphics(i, j);
                    //Delay for visibility
                    try {
                        Thread.sleep(SortManager.tvalues[2]);
                    } catch (InterruptedException e) {
                        System.out.println("got interrupted!");
                    }
                }
                SortManager.tvalues[0]++;
            }
            first = SortManager.values[i + 1];
            second = SortManager.values[high];
            SortManager.values[i + 1] = second;
            SortManager.values[high] = first;
            SortManager.tvalues[1] += 2;
            //Update graphics to array
            SortManager.su.sc.updateGraphics(i + 1, high);
            //Delay for visibility
            try {
                Thread.sleep(SortManager.tvalues[2]);
            } catch (InterruptedException e) {
                System.out.println("got interrupted!");
            }
            int pi = i + 1;
            QuickSort(low, pi - 1);
            QuickSort(pi + 1, high);
        }
    }
}
