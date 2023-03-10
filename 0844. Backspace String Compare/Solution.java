public class Solution {

    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int sBksp = 0, tBksp = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') { sBksp++; i--; }
                else if (sBksp > 0) { sBksp--; i--; }
                else break;
            } 

            while (j >= 0) {
                if (t.charAt(j) == '#') { tBksp++; j--; }
                else if (tBksp > 0) { tBksp--; j--; }
                else break;
            }

            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) 
                return false;
            if ((i < 0 && j >= 0) || (j < 0 && i >= 0))
                return false;
            i--; j--;
        }

        return i < 0 && j < 0;
    }

}
