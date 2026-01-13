class Solution {
    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;
        double totalArea = 0;

        // Find bounds and total area
        for (int[] s : squares) {
            double y = s[1];
            double l = s[2];
            low = Math.min(low, y);
            high = Math.max(high, y + l);
            totalArea += l * l;
        }

        double half = totalArea / 2.0;

        // Binary search
        while (high - low > 1e-6) {
            double mid = (low + high) / 2.0;
            double areaBelow = 0;

            for (int[] s : squares) {
                double y = s[1];
                double l = s[2];

                if (mid <= y) {
                    // fully above
                    continue;
                } else if (mid >= y + l) {
                    // fully below
                    areaBelow += l * l;
                } else {
                    // partially cut
                    areaBelow += l * (mid - y);
                }
            }

            if (areaBelow < half) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }
}