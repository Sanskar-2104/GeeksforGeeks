//https://www.geeksforgeeks.org/problems/case-specific-sorting-of-strings4845/1

import java.util.*;

class Solution {
    public static String caseSort(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        List<Character> lower = new ArrayList<>();
        List<Character> upper = new ArrayList<>();
        for (char c : chars) {
            if (Character.isLowerCase(c)) {
                lower.add(c);
            } else {
                upper.add(c);
            }
        }
        Collections.sort(lower);
        Collections.sort(upper);
        StringBuilder result = new StringBuilder();
        int li = 0, ui = 0;
        for (char c : chars) {
            if (Character.isLowerCase(c)) {
                result.append(lower.get(li++));
            } else {
                result.append(upper.get(ui++));
            }
        }

        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(caseSort("GEekS"));   
        System.out.println(caseSort("XWMSPQ"));  
    }
}
