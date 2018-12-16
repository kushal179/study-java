package oas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Engen_1 {

	/**
	 * @param args
	 */
	int countHoles(int num) {
		int sum = 0;
		int temp = num;
		if(num<1 && num>Math.pow(10, 9))
			return -1;
		
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		hmap.put(0, 0);
		hmap.put(1, 0);
		hmap.put(2, 0);
		hmap.put(3, 0);
		hmap.put(5, 0);
		hmap.put(7, 0);
		hmap.put(0, 1);
		hmap.put(4, 1);
		hmap.put(6, 1);
		hmap.put(9, 1);
		hmap.put(8, 2);
		
		
		while(temp != 0){
			int d = temp%10;
			temp = temp/10;
			sum = sum + hmap.get(d);
		}
		
		return sum;

	}
	public static String merge(String s1, String s2) 
    { 
        StringBuilder out = new StringBuilder();
        int i = 0, j = 0;
        if(s1==null && s2==null)
        	return null;
        int length_1 = s1.length();
        int length_2 = s2.length();
        
        while (i < length_1 && j < length_2) { 
            
            out.append(s1.charAt(i++)); 
            out.append(s2.charAt(j++)); 
        } 
  
        if (i != length_1) { 
            out.append(s1.substring(i)); 
        } 
        if (j != length_2) { 
        	out.append(s2.substring(j)); 
        } 
        return out.toString(); 
    }
	
    static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {
    	int n = scores.length;
    	int q = lowerLimits.length;
    	if(n<1 && n > Math.pow(10, 5))
    		return null;
    	if(q < 1 && q > Math.pow(10, 5))
    		return null;
    	int result[] = new int[q];
    	result[0] = 0;
    	int i = 0, j = 0;
    	for(j=0;j<n;j++){
    		int score = scores[j];
    		for(i=0;i<q;i++){
    			if(score >= lowerLimits[i] && score <= upperLimits[i]) {
    				result[q] = result[q]+1;
    			}
    		}
    	}
    	return result;
    }
    public static String electionWinner(String[] votes) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		String winner = "";
		int maxVote = 0;
		int n = votes.length;
		if(n<1 && n > Math.pow(10, 4))
    		return null;

		for (int i = 0; i < n; i++) {
			String c = votes[i];

			Integer vote = map.get(c);
			if (vote == null) {
				vote = 0;
			}
			vote += 1;
			map.put(c, vote);

			if (vote > maxVote) {
				winner = c;
				maxVote = vote;
			} else if (vote == maxVote) {
				winner = c.compareTo(winner) > 0 ? c : winner;
			}
		}

		return winner;
}  
    public static List<String> missingwords(String s,String t){
	  
    String[] a = s.split(" ");
    String[] b = t.split(" ");
    int size = a.length - b.length;
    String [] missing = new String[size];
    List<String> result = new ArrayList<String>();
    int c = 0;
    for(int i=0;i<a.length;i++){
        int flag=0;
       for(int j=0;j<b.length;j++){
      	 if(a[i].equals(b[j]))
      		 flag=1; 
       }
       if(flag==0){
      	 missing[c++]=a[i];
           
       }
    }
    for(int j=0;j<missing.length;j++)
		  result.add(missing[j]);
    return result;

  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 819;
		Engen_1 e = new Engen_1();
		e.countHoles(n);
		String s1 = "geeks"; 
        String s2 = "forgeeks"; 
        System.out.println(merge(s1, s2));
        int scores[] = {4,8,7};
        int lowerLimits[] = {2,4};
        int upperLimits[] = {8,4};
        //System.out.println(jobOffers(scores, lowerLimits, upperLimits));
        
        String[] votes = { "Alex", "Michael", "Harry", "Dave", "Michael", "Victor", "Harry", "Alex", "Mary", "Mary" };
        System.out.println(electionWinner(votes));
        
        String t = "I am using hackerrank to improve programming";
		  String s = "am hackerrank to improve";
		  System.out.println(missingwords(t,s));

	}

}
