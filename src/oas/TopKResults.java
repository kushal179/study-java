package oas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TopKResults {
	
	List<List<Integer>> nearestXsteakHouses(int totalSteakhouses,
			List<List<Integer>> allLocations, int numSteakhouses) {
		
		List<List<Integer>> topXResult = new ArrayList<List<Integer>>();
		
		if (numSteakhouses > totalSteakhouses)
			return topXResult;
		
		int count = 0;
		
		//Created a hashmap of all the SteakHouses in given city.
		//Key being unique index representing each SteakHouse.
		Map<Integer, List<Integer>> allSteakHouseMap = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < totalSteakhouses; i++) {
			allSteakHouseMap.put(i, allLocations.get(i));
		}
		
		//Calculating distance of each SteakHouse from user's location.
		
		Map<Integer, Float> unOrdered = new HashMap<Integer, Float>();
		for (Map.Entry<Integer, List<Integer>> entry : allSteakHouseMap.entrySet()) {
			
			int x = entry.getValue().get(0);
			int y = entry.getValue().get(1);
			float d = (float)Math.sqrt( (Math.pow(x, 2) + Math.pow(y, 2)) );
			unOrdered.put(entry.getKey(), d);
			
		}
		
		//Create a SortedMap (Ascending) with Key being unique SteakHouse index created above.
		 List<Entry<Integer, Float>> ordered = new ArrayList<Entry<Integer, Float>>(unOrdered.entrySet());
	     
	     Collections.sort( ordered, new Comparator<Map.Entry<Integer, Float>>(){
	    	 public int compare( Map.Entry<Integer, Float> o1, Map.Entry<Integer, Float> o2 ){
	                return (o1.getValue()).compareTo( o2.getValue() );
	            }
	     	});
	        
		for(Map.Entry<Integer, Float> it:ordered){
			if(count==numSteakhouses)
				break;
			int idx = it.getKey();
			topXResult.add(allSteakHouseMap.get(idx));
			count++;
		}

		return topXResult;

	}

	// OP: [1,-1] [1,2]
	// METHOD SIGNATURE ENDS
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TopKResults a = new TopKResults();
		int totalSteakhouses = 3;
		int numSteakhouses = 2;
		List<List<Integer>> allLocations = new ArrayList<List<Integer>>();
		allLocations.add(Arrays.asList(1, 2));
		allLocations.add(Arrays.asList(3, 4));
		allLocations.add(Arrays.asList(1, -1));
		System.out.println(allLocations);
		System.out.println(a.nearestXsteakHouses(totalSteakhouses,
				allLocations, numSteakhouses));

	}

}
