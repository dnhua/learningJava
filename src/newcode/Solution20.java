package newcode;

/**
 * true
 *
 * "+100"
 * "5e2"
 * "-123"
 * "3.1416"
 * "-1E-16"
 *
 * false
 *
 * "12e"
 * "1a3.14"
 * "1.2.3"
 * "+-5"
 * "12e+4.3"
 */

public class Solution20 {
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0)
            return false;
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
