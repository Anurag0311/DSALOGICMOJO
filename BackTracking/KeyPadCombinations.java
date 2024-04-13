package com.anurag.BackTracking;

import java.util.Arrays;
import java.util.List;

class KeyPadCombinations
{
	
	public static void findCombinations(List<List<Character>> keypad,
										int[] input, String res, int index)
	{
		
		if (index < 0) {
            System.out.println(res);
            return;
        }

        // Get the list of characters corresponding to the current digit
        List<Character> chars = keypad.get(input[index]);

        // For each character in the list, append it to the current combination and recursively call the function
        for (char c : chars) {
            findCombinations(keypad, input, c + res, index - 1);
        } 
	}

	public static void main(String[] args)
	{
		List<List<Character>> keypad = Arrays.asList(
				
				Arrays.asList(),
				Arrays.asList(),
				Arrays.asList( 'A', 'B', 'C' ),
				Arrays.asList( 'D', 'E', 'F' ),
				Arrays.asList( 'G', 'H', 'I' ),
				Arrays.asList( 'J', 'K', 'L' ),
				Arrays.asList( 'M', 'N', 'O' ),
				Arrays.asList( 'P', 'Q', 'R', 'S'),
				Arrays.asList( 'T', 'U', 'V' ),
				Arrays.asList( 'W', 'X', 'Y', 'Z')
		);

		
		int[] input = { 2, 3, 4 ,5 };

		
		findCombinations(keypad, input, "", input.length - 1);
	}
}
