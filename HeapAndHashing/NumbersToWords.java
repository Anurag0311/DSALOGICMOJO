package com.anurag.HeapAndHashing;


public class NumbersToWords { 

    // Method to convert a number represented as a character array to words
    static void NumberToWords(char[] array) { 
        int length = array.length;  

        // Check for empty string
        if (length == 0) { 
            System.out.println("empty string"); 
            return; 
        } 

        // Check if the length is more than 4
        if (length > 4) { 
            System.out.println("length more than 4 is not supported"); 
            return; 
        } 

        // Arrays for storing words for single digits, two digits, 10-multiples, and 100-multiples
        String[] singleDigits = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}; 
        String[] twoDigits = new String[]{"", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"}; 
        String[] digits10Multiples = new String[]{"", "", "twenty", "thirty", "forty", "fifty","sixty", "seventy", "eighty", "ninety"}; 
        String[] digits100Multiples = new String[]{"hundred", "thousand"}; 

        // Print the original number
        System.out.print(String.valueOf(array) + ": "); 

        // Logic to convert the number to words
        if (length == 1) { 
            // For single digit numbers, directly print the word representation
            System.out.println(singleDigits[array[0] - '0']); 
            return; 
        } 

        int x = 0; 
        while (x < array.length) { 
            if (length >= 3) { 
                // For numbers with 3 or more digits
                if (array[x] - '0' != 0) { 
                    // Print the digit at current position and its corresponding multiple of 100
                    System.out.print(singleDigits[array[x] - '0'] + " "); 
                    System.out.print(digits100Multiples[length - 3] + " ");  
                } 
                --length; // Decrement length to move to the next digit position
            } else { 
                // For numbers with less than 3 digits
                if (array[x] - '0' == 1)  { 
                    // If the number forms a two-digit number between 10 to 19, print corresponding word
                    int sum = array[x] - '0' + array[x] - '0'; 
                    System.out.println(twoDigits[sum]); 
                    return; 
                } else if (array[x] - '0' == 2 && array[x + 1] - '0' == 0) { 
                    // For multiples of 10, print the corresponding word
                    System.out.println("twenty"); 
                    return; 
                } else { 
                    int i = (array[x] - '0'); 
                    if (i > 0) 
                        // For other two-digit numbers, print the corresponding multiple of 10
                        System.out.print(digits10Multiples[i] + " "); 
                    else
                        System.out.print(""); 
                    ++x; // Move to the next digit position
                    if (array[x] - '0' != 0) 
                        // If the next digit is non-zero, print its corresponding word
                        System.out.println(singleDigits[array[x] - '0']); 
                } 
            } 
            ++x; // Move to the next digit position
        } 
    } 

    // Main method to test the conversion
    public static void main(String[] args) { 
        NumberToWords("1234".toCharArray()); 
    } 
}

/* Try more Inputs
Case 1:
 NumberToWords("1".toCharArray());
 expected = [one]

Case 2:
NumberToWords("1200".toCharArray());
 expected = [one thousand two hundred]
*/
