// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;
class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Sol g=new Sol();
            System.out.println(g.multiply(a,b));
        }
    }
}// } Driver Code Ends

/**
https://practice.geeksforgeeks.org/problems/multiply-two-strings/1

Given two numbers as stings s1 and s2 your task is to multiply them.

Example 1:

Input:
s1 = 33
s2 = 2
Output: 66
Example 2:

Input:
s1 = 11
s2 = 23
Output: 253
Your Task:

You are required to complete the function multiplyStrings() which takes two strings s1 and s2 as its only argument and returns their product as strings.

Constraints:
1 <= length of s1 and s2 <= 103

Expected time complexity: O( n1 * n2 )
Expected auxiliary space: O( n1 + n2 ) ; where n1 and n2 are sizes of strings s1 and s2 respectively.

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.

What I'd do in real life:
*/


class Sol
{
    public String multiply(String a,String b)
    {
        if (a == null || a.length() == 0 || b == null || b.length() == 0) {
            return "";
        }
        BigInteger ba = new BigInteger(a);
        BigInteger bb = new BigInteger(b);
        return String.valueOf(ba.multiply(bb));
    }
}
