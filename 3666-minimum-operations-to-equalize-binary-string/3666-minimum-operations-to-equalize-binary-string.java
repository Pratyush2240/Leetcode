import java.util.*;

public class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        int startZeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') startZeros++;
        }

        if (startZeros == 0) return 0;

        // Separate unvisited counts by parity because (currZeros + k - 2x)
        // always maintains the same parity for a fixed currZeros and k.
        TreeSet<Integer> evenUnvisited = new TreeSet<>();
        TreeSet<Integer> oddUnvisited = new TreeSet<>();

        for (int i = 0; i <= n; i++) {
            if (i == startZeros) continue;
            if (i % 2 == 0) evenUnvisited.add(i);
            else oddUnvisited.add(i);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startZeros, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currZeros = current[0];
            int steps = current[1];

            int lowX = Math.max(0, k - (n - currZeros));
            int highX = Math.min(currZeros, k);

            // The range of next zero counts:
            // minNext = currZeros + k - 2 * highX
            // maxNext = currZeros + k - 2 * lowX
            int minNext = currZeros + k - 2 * highX;
            int maxNext = currZeros + k - 2 * lowX;

            // Target the correct parity set
            TreeSet<Integer> targetSet = (minNext % 2 == 0) ? evenUnvisited : oddUnvisited;

            // Find all unvisited states in [minNext, maxNext] and process them
            Integer next = targetSet.ceiling(minNext);
            while (next != null && next <= maxNext) {
                if (next == 0) return steps + 1;
                
                queue.add(new int[]{next, steps + 1});
                targetSet.remove(next); // O(log n) removal
                next = targetSet.ceiling(minNext);
            }
        }

        return -1;
    }
}