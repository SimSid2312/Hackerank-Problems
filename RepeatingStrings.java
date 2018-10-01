import java.io.IOException;
import java.util.Scanner;

public class RepeatingStrings {
	
	/*
	 * input: aba
     * 10
     *Output:  7
	 *Counting the a in the input string
	 * https://www.hackerrank.com/challenges/repeated-string/problem
	 */
	  // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
     
    	   long a_count=0,count=0;
           long characters_counted=0;
           long  character_to_count=n/s.length();
           
           for (int i=0;i<s.length();i++){
               if(s.charAt(i)=='a'){
                   a_count++; // the given s has these many a.
                   
               }
           }
           
           count=a_count * character_to_count;
           characters_counted=s.length() * character_to_count;       
                   
           if(characters_counted<n){
               long remaining_characters=n%s.length();
               for(int i=0;i<remaining_characters;i++){
                   if (s.charAt(i)=='a'){
                       count++;
                   }
               }
           }
           
           
           return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);
        System.out.println(result);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }

}
