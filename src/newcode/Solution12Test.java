package newcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution12Test {

    @Test
    void hasPath() {
        char[] array = new char[]{'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str = new char[]{'b', 'c', 'c', 'e', 'd'};
        Solution12 solution12 = new Solution12();
        System.out.println(solution12.hasPath(array, 3, 4, str));
    }
}