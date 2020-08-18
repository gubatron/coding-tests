/*package whatever //do not write package name here */
/** https://practice.geeksforgeeks.org/problems/palindrome-string/0 
Given a string S, check if it is palindrome or not.

Input:
The first line contains 'T' denoting the number of test cases. T testcases follow. Each testcase contains two lines of input. The first line contains the length of the string and the second line contains the string S.

Output:
For each testcase, in a new line, print "Yes" if it is a palindrome else "No". (Without the double quotes)

Constraints:
1 <= T <= 30
1 <= N <= 100

Example:
Input:
1
4
abba
Output:
Yes

*/

import java.util.*;
import java.lang.*;
import java.io.*;

class PalindromeString {
    
    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        if (input.length() == 0) {
            return true;
        }
        char[] arr = input.replaceAll(" ","").toCharArray();
        int i = 0;
        int j = arr.length - 1;
        int center = arr.length / 2;
        while (i < center) {
            if (arr[i] != arr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    static boolean processTestCase(Scanner cin) {
        try {
          int N = Integer.parseInt(cin.nextLine().trim());
          String input = cin.nextLine().trim();
          if (input.length() != N) {
              return false;
          }
          if (1 <= N && N <= 100) {
             if (isPalindrome(input)) {
                 return true;
             }
          }
        } catch (Throwable t) {
        }
        return false;
    }
    
	public static void main (String[] args) {
          Scanner cin = new Scanner(System.in);
	  int test_cases = Integer.parseInt(cin.nextLine().trim());
	  for (int i=0; i < test_cases && i < 30; i++) {
	    System.out.println(processTestCase(cin) ? "Yes" : "No");
	}
   }
}
