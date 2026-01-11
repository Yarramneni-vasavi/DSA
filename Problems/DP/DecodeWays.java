class DecodeWays {

    private int numDecodingsDP(String s) {
        int n = s.length();
        int[] ways = new int[n];

        //n -> 0
        ways[n-1] = s.charAt(n-1) == '0' ? 0 : 1;

        if (n > 1) {
            if (s.charAt(n-2) == '1' || ((s.charAt(n-2) == '2') && s.charAt(n-1) >= '0' && s.charAt(n-1) <= '6')) {
                ways[n-2] = ways[n-1] + 1;
            } else if (s.charAt(n-2) == '0') {
                ways[n-2] = 0;
            } else {
                ways[n-2] = ways[n-1];
            }

            for(int i=n-3; i>=0; i--) {
                if (s.charAt(i) == '1' || ((s.charAt(i) == '2') && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '6')) {
                    ways[i] = ways[i+1] + ways[i+2];
                } else if (s.charAt(i) == '0') {
                    ways[i] = 0;
                } else {
                    ways[i] = ways[i+1];
                }
            }
        }

        return ways[0];

    }

    private int numDecodingsRecurHelper(String s, int index) {

        if (index >= s.length()) {
            return 1;
        }

        if (s.charAt(index) >= '1' && s.charAt(index) <= '9') {
            if (s.charAt(index) == '1' && index + 1 < s.length() && s.charAt(index + 1) >= '0' && s.charAt(index + 1) <= '9') {
                return numDecodingsRecurHelper(s, index + 1) + numDecodingsRecurHelper(s, index + 2);
            } else if (s.charAt(index) <= '2' && index + 1 < s.length() && s.charAt(index + 1) >= '0' && s.charAt(index + 1) <= '6') {
                return numDecodingsRecurHelper(s, index + 1) + numDecodingsRecurHelper(s, index + 2);
            } else {
                return numDecodingsRecurHelper(s, index + 1);
            }
        }

        return 0; // for invalid case, 0 will be propogated recursively, So no need to any negatove value to differentiate.
    }

    public int numDecodingsRecur(String s) {
        return numDecodingsRecurHelper(s, 0);
    }

    public static void main(String args[]) {
        System.out.println(new DecodeWays().numDecodingsDP("12126"));
    }
}