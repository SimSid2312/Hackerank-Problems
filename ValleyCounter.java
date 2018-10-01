import java.io.IOException;
import java.util.Scanner;

public class ValleyCounter {
	/*
	 * Input : 
	 * 8
     * UDDDUDUU
     * Output:1
     * Link:
     * https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
	 */
 
    private static int valley_count=0;
    private static int old_step=0;
    private static int step=0; 

   public static int countingValleys(int n, String s){       
   
	   
	   for (int i=0;i<s.length();i++){   
		   
		   if(s.charAt(i)=='U'){
			   
			   old_step=step;
			   step++;
			  
		   }
		   else
		   {
			   old_step=step;
			   step--;
			  
			   
		   }
		   
            if (old_step< step && step==0){
			   
			   valley_count++;
		   }
		   
	   }
	   
       
       return valley_count;
   }
           

   
   private static final Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) throws IOException {
  

       int n = scanner.nextInt();
       scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

       String s = scanner.nextLine();

       int result = countingValleys(n, s);
       
       System.out.println(result);
 
       scanner.close();
   }

}
