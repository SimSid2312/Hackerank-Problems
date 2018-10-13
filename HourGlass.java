import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
/*
 *  Given a  2D Array, :

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
We define an hourglass in  to be a subset of values with indices falling in this pattern in 's graphical representation:

a b c
  d
e f g
There are  hourglasses in , and an hourglass sum is the sum of an hourglass' values. Calculate the hourglass sum for every hourglass in , then print the maximum hourglass sum.

For example, given the 2D array:

-9 -9 -9  1 1 1 
 0 -9  0  4 3 2
-9 -9 -9  1 2 3
 0  0  8  6 6 0
 0  0  0 -2 0 0
 0  0  1  2 4 0
We calculate the following 16  hourglass values:

-63, -34, -9, 12, 
-10, 0, 28, 23, 
-27, -11, -2, 10, 
9, 17, 25, 18
Our highest hourglass value is 28 from the hourglass:

0 4 3
  1
8 6 6
 * 
 */

public class HourGlass {
	

	static int hourglassSum(int[][] arr)  {
		
		
		Boolean flag=false;
		int large=0;
		for (int i=0;i<=3;i++){
			for (int j=0;j<=3;j++){
				
				int sum=arr[i][j]+
					arr[i][j+1]+
					arr[i][j+2]+
					arr[i+1][j+1]+
					arr[i+2][j]+
					arr[i+2][j+1]+
					arr[i+2][j+2];
				
				if (flag==false)
				{
					large=sum;
					flag=true;
				}
				if (flag==true && sum > large)
					large=sum;					
				
			}
		}
		
		
		return large;
	}
	
    private static final Scanner scanner = new Scanner(System.in);
	public static void main(String [] args)throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        
      

        int result = hourglassSum(arr);
       
        System.out.println(result);
       // bufferedWriter.write(String.valueOf(result));
       // bufferedWriter.newLine();

       // bufferedWriter.close();

        scanner.close();
    }

}
