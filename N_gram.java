import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class N_gram {

	public static List<String> arrayInput=new ArrayList<String>();
	public static HashMap<String,Integer> outFreq = new HashMap<String,Integer>();
	public static int whichGram;
	public static Map.Entry<String, Integer> maxEntry = null;
	
	public static void calculate_gramFrequencies(){ 
		for(int i =0;i< arrayInput.size();i++){
			String inp [] = arrayInput.get(i).split("");
			int charactercounted = 0;
			String str="";
			for(int j=0;j<inp.length;j++){				
				
				if(charactercounted==whichGram){
					charactercounted=0;
					j=j-whichGram;					
					str="";
					continue;
				}
				else
				{
					str+=inp[j];
					charactercounted++;
					if(str.length()==whichGram){
						if(outFreq.containsKey(str)){
							int currentFrequency=outFreq.get(str);
							currentFrequency++;
							outFreq.put(str, currentFrequency);
						}
						else{
							outFreq.put(str, 1);
						}
					}
				}				
				
			}
			
		}
	}
		
	public static void find_maxgramEntry(){
		
		for (Map.Entry<String, Integer> entry : outFreq.entrySet())
		{
		    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
		    {
		        maxEntry = entry;
		    }
		}
	}
	
	public static void main(String [] args){
		
		Scanner sc = new Scanner(System.in);
		int numLines= Integer.parseInt(sc.nextLine());		
		for(int i=0;i<numLines;i++){
			arrayInput.add(sc.nextLine().replaceAll("\\W", ""));			
		}
		whichGram=Integer.parseInt(sc.nextLine());
		
		calculate_gramFrequencies();		
		find_maxgramEntry();	
		
		if(whichGram==1)
			System.out.println("Unigram "+maxEntry.getKey());
		else if (whichGram==2)
			System.out.println("Bigram "+maxEntry.getKey());
		else 
			System.out.println("Trigram "+maxEntry.getKey());
		
		sc.close();
	}

}
