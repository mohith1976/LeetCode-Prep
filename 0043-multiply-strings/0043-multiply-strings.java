class Solution {
    public String multiply(String num1, String num2) {
        // Edge case: if either number is 0, the result is 0
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        // The maximum length of the product is m + n
        int[] pos = new int[m + n];

        // Traverse both strings from right to left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // Multiply the current digits
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                
                // Determine the positions in the result array
                int p1 = i + j;     // Position for carry
                int p2 = i + j + 1; // Position for current digit
                
                // Add the product to the existing value at p2
                int sum = mul + pos[p2];

                // Update the carry at p1
                pos[p1] += sum / 10;
                // Store the remainder at p2
                pos[p2] = sum % 10;
            }
        }

        // Build the final string
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            // Skip leading zeros
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}