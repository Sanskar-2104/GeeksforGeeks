//http://geeksforgeeks.org/problems/minimum-sum4058/1

class Solution {
    String minSum(int[] arr) {
        Arrays.sort(arr);
        
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0)
                num1.append(arr[i]);
            else
                num2.append(arr[i]);
        }
        return addStrings(num1.toString(), num2.toString());
    }

    private String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            res.append(sum % 10);
            carry = sum / 10;
        }
        return res.reverse().toString().replaceFirst("^0+(?!$)", "");
    }
}
