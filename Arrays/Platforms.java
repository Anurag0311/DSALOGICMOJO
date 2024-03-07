package com.anurag.Arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Platforms
{
//********************************WRONG SOLN***********************************
	public static int minimumNumberOfPlatformsModified(int[] arrival, int[] departure) {
        if (arrival.length != departure.length) {
            throw new IllegalArgumentException("Arrays must have the same length");
        }

        ArrayList<Integer> platforms = new ArrayList<>();

        for (int i = 0; i < arrival.length; i++) {
            if (platforms.isEmpty()) {
                platforms.add(departure[i]);
            } else {
                int earliestDepartureIndex = getEarliestDepartureIndex(platforms);
                int earliestDeparture = platforms.get(earliestDepartureIndex);

                if (arrival[i] >= earliestDeparture) {
                    // Train can reuse the platform
                    platforms.set(earliestDepartureIndex, departure[i]);
                } else {
                    // Need a new platform
                    platforms.add(departure[i]);
                }
            }
        }

        return platforms.size();
    }

    private static int getEarliestDepartureIndex(ArrayList<Integer> platforms) {
        return IntStream.range(0, platforms.size())
                .reduce((i, j) -> platforms.get(i) < platforms.get(j) ? i : j)
                .orElseThrow(() -> new RuntimeException("Unexpected error in platform calculation"));
    }
// ********************************LOGIC MOJO*********************************   
    static int minimumNumberOfPlatform(int array[], int departure[], int n) 
    { 
        //Sort arrival and departure arrays
        Arrays.sort(array); 
        Arrays.sort(departure); 
        //plat_needed indicates number of platforms needed at a time
        int plat_needed = 1, maxPlatform = 1; 
        int i = 1, j = 0; 
        
        while (i < n && j < n) { 
            //If next event in sorted order is arrival, increment count of platforms needed
            if (array[i] <= departure[j]) 
            { 
                plat_needed++; 
                i++; 
                if (plat_needed > maxPlatform) 
                maxPlatform = plat_needed;
            } //Else decrement count of platforms needed
            else if (array[i] > departure[j]) { 
                plat_needed--; 
                j++; 
            } 
             
        } 
  
        return maxPlatform; 
    } 
	public static void main(String[] args)
	{
		int[] arrival = { 900,940,950,1100,1500,1800 };
		int[] departure = {910, 1200, 1120, 1130, 1900, 2000};
         int n = arrival.length; 

		System.out.print("Minimum platforms required is "
					+ minimumNumberOfPlatformsModified(arrival, departure));
	}
}

/* Try more Inputs
case 1: 
actual = minimumNumberOfPlatform([900,940,950,1100,1500,1800],[910, 1200, 1120, 1130, 1900, 2000],6)
expected = 3

case2: 
actual = minimumNumberOfPlatform([200, 210, 300, 320, 350, 500],[230, 340, 320, 430, 400, 520],6)
expected = 3
 
case3: 
actual = minimumNumberOfPlatform([900, 1100, 1235],[1000, 1200, 1240],3)
expected = 1
*/

