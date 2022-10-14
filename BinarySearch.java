import java.util.Scanner;

public class BinarySearch
{
    public static void main(String[] args)
    {
        //Declare Stuff, Create Array, Sort Array, Print Array
        Scanner in = new Scanner(System.in);
        int[] vals = new int[(int)(Math.random()*40)+20];
        for(int i=0;i<vals.length;i++)
        {
            vals[i] = ((int)(Math.random()*100));
        }
        insertionSort(vals);
        printArr(vals);

        //Give array info, get User Input
        System.out.printf("%n%n%s %d%n%s ", "Array of size", vals.length,"What number do you want to search for?");
        int target = in.nextInt();
        System.out.printf("%s %d%n%n", "Searching for:", target);
        in.close();

        //Initiate Search
        binarySearch(vals, target);
    }


    public static void printArr(int[] arrIn)
    {
        for(int i = 0; i < arrIn.length; i++)
        {
            System.out.printf("%d ", arrIn[i]);
        }
    }
    public static void insertionSort(int[] arrIn)
    {
        int valueHolder = 0;            //Holds the value of the number we are comparing(inserting)
        
        //Insertion Sort
        for(int i=0; i<arrIn.length; i++) //Outer Loop, grabs the next unsorted value each iteration starting from offset 0
        {
            valueHolder = arrIn[i];      //Holds the value we are comparing in an int, so we don't have to worry about the offset of the value we are checking changing
 
            for(int j=(i-1); j>=0; j--) //Inner Loop, starts at the offset right before the value we are currently sorting, decrements until we reach offset 0
            {
                if(valueHolder < arrIn[j]) //If the value of the number we are comparing is less than the number before it, we will swap the two
                {
                    arrIn[j + 1] = arrIn[j]; //Moves the higher value into our value's spot
                    arrIn[j] = valueHolder;    //Puts our value into the higher value's old spot
                }
            }
        }
    }
    public static void binarySearch(int[] arrIn, int target)
    {
        //Declare and initiate first last and mid
        int first = 0;
        int last = arrIn.length - 1;
        int mid = ((first + last)/2);
        
        //Just a fun print statement to see whats happening
        System.out.println("Mid: " + arrIn[mid]);
        
        //Base Case
        if(arrIn.length == 1)
        {
            if(arrIn[0] == target)
            {
                System.out.printf("%d %s%n", target, "is in the array");
            }
            else
            {
                System.out.printf("%d %s%n", target, "is not in the array");
            }
        }

        //Splitting the array into the half to search for the target in
        else
        {
            //Checks if our mid is our target
            if(target == arrIn[mid])
            {
                System.out.printf("%d %s%n", target, "is in the array");
            }
            
            //Finds and executes code for if our target is above or below the middle
            else
            {
                //Runs if our target is above the mid
                if(target > arrIn[mid])
                {
                    int[] returnArr = new int[last - mid];                      //Creates a return array with a size of last - mid, which is the size of the upper half of the array
                    int returnArrWorkingOffset = returnArr.length-1;            //New var to relate the "same" offset of our new array to our original array
                    for(int i = last; i>mid; i--)                               //For loop where i is the offset of our original array
                    {
                        returnArr[returnArrWorkingOffset--] = arrIn[i];         //Copies the i into its corresponding offset, then decrements it
                    }

                    //Some printing stuff
                    printArr(returnArr);
                    System.out.printf("%n%n");

                    //Recursive call
                    binarySearch(returnArr, target);
                }

                //Runs if our target is below mid
                if(target < arrIn[mid])
                {
                    //When the array is size 2, the mid offset will be 0, and we don't want to declare an array of size 0
                    if(mid == 0)
                    {
                        int[] returnArr = new int[1];
                        for(int i = 0; i<mid; i++)
                        {
                            returnArr[i] = arrIn[i];        //The i's of each array correspond so we don't need extra variables
                        }

                        //Printing stuff
                        printArr(returnArr);
                        System.out.printf("%n%n");

                        //Recursive call
                        binarySearch(returnArr, target);
                    }
                    
                    //If our array isn't size two we can just use mid as our new array size
                    else
                    {
                        int[] returnArr = new int[mid];
                        for(int i = 0; i<mid; i++)
                        {
                            returnArr[i] = arrIn[i];
                        }

                        //Printing stuff
                        printArr(returnArr);
                        System.out.printf("%n%n");

                        //Recursive call
                        binarySearch(returnArr, target);
                    }
                }
            }
        }
    }
}