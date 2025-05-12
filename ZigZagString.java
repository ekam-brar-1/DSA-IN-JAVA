public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        
        // Initialize a StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        int curRow = 0;
        boolean goingDown = false;
        
        // Place each character in the appropriate row
        for (char c : s.toCharArray()) {
            rows[curRow].append(c);
            
            // Flip direction at top or bottom row
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            
            curRow += goingDown ? 1 : -1;
        }
        
        // Combine all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder rowSb : rows) {
            result.append(rowSb);
        }
        return result.toString();
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.convert("PAYPALISHIRING", 3)); // PAHNAPLSIIGYIR
        System.out.println(sol.convert("PAYPALISHIRING", 4)); // PINALSIGYAHRPI
        System.out.println(sol.convert("A", 1));             // A
    }
}
