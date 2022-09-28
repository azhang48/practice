public class quickSort
{
    public static void main(String[] args)
    {
        int[] testArr = new int[] {5, 3, 12, 52, 32, 4, 9, 34, 51, 44, 23, 80, 33, 0, 13, 43, 10};
        printArr(testArr);
        System.out.printf("%n");
        swapVals(testArr, 1, 3);
        printArr(testArr);
    }

    public static int[] quicksort(int[] arrIn)
    {
        if(arrIn.length == 2) //base case :sunglasses:
        {
            int[] returnArr = new int[arrIn.length];
            if(arrIn[0] > arrIn[1])
            returnArr[0] = arrIn[0];
            return returnArr;
        }
        else
        {
            int pivot = arrIn[getPivotIndex(arrIn)];
            for(int i=0; i<arrIn.length; i++)
            {
                for(int j=0;j<arrIn.length; j++)
                {
                    
                }
            }

            return arrIn;
        }
    }

public static void swapVals(int[] arrIn, int offset1, int offset2)
{
    int temp;
    temp = arrIn[offset1];
    arrIn[offset1] = arrIn[offset2];
    arrIn[offset2] = temp;
}

    public static int getPivotIndex(int[] arrIn) //Gets a index inbounds to be a pivot point
    {
        int pivotIndex = (int)(Math.random()*arrIn.length);
        return pivotIndex;
    }

    public static void printArr(int[] arrIn)
    {
        for(int i = 0; i < arrIn.length; i++)
        {
            System.out.printf("%d ", arrIn[i]);
        }
    }
}

/*
 * PSEUDOCODE
 * 
 * IF ARRAY IS SIZE ONE JUST RETURN THE NUMBER
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */