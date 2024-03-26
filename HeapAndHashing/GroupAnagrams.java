package com.anurag.HeapAndHashing;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams
{
	public static void groupAnagramsFunc(String[] words)
	{
		List<String> list = Arrays.stream(words)
				.map(s -> s.toCharArray())
				.map(chars -> { Arrays.sort(chars); return new String(chars); })
				.collect(Collectors.toList());

		Map<String, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < list.size(); i++)
		{
			map.putIfAbsent(list.get(i), new ArrayList<>());
			map.get(list.get(i)).add(i);
		}
		for (var entry: map.entrySet()) {
			System.out.println(entry.getValue().stream()
							.map(index -> words[index])
							.collect(Collectors.toList()));
		}
	}
	
	 // Method to group anagrams in the given array of words
    public static void groupAnagrams(String[] words) {
        // Step 1: Convert each word to its sorted form and collect them into a list
        List<String> sortedWordsList = new ArrayList<>();
        for (String word : words) {
            char[] chars = word.toCharArray(); // Convert word to char array
            Arrays.sort(chars); // Sort the characters of the word
            String sortedWord = new String(chars); // Convert sorted char array back to string
            sortedWordsList.add(sortedWord); // Add sorted word to list
        }
        
        // Step 2: Create a map to store indices of words with the same sorted form
        Map<String, List<Integer>> anagramGroupsMap = new HashMap<>();
        for (int i = 0; i < sortedWordsList.size(); i++) {
            String sortedWord = sortedWordsList.get(i);
            if (!anagramGroupsMap.containsKey(sortedWord)) {
                anagramGroupsMap.put(sortedWord, new ArrayList<>()); // Initialize list for sorted word
            }
            anagramGroupsMap.get(sortedWord).add(i); // Add index of word to list
        }
        
        // Step 3: Print groups of anagrams
        for (List<Integer> indices : anagramGroupsMap.values()) {
            List<String> anagramGroup = new ArrayList<>();
            for (int index : indices) {
                anagramGroup.add(words[index]); // Add original word to group
            }
            System.out.println(anagramGroup); // Print group of anagrams
        }
    }
	
	public static void main(String[] args)
	{
		
		String[] words = {
				"cat", "dog", "tac", "got", "act"
		};

		groupAnagrams(words);
	}
}

/* Try more Inputs
Case 1:
        String[] words = {
				"eat","tea","tan","ate","nat","bat"
		};

		groupAnagrams(words);
        expected = [["bat"],["nat","tan"],["ate","eat","tea"]]

Case2: 
        String[] words = {
				"no","on","is"
		};

		groupAnagrams(words);
        expected = [["no","on"] ["is"]]

*/
