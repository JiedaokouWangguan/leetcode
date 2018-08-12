public class Question479{
    public int largestPalindrome(int n) {
        long upperBound = (long)Math.pow(10, n) - 1;
        long lowerBound = (long)Math.pow(10, n - 1);
        long maxNum = upperBound * upperBound;
        long firstHalf = maxNum / (long)Math.pow(10, n);
        while (firstHalf >= lowerBound) {
            long palindrome = getPal(firstHalf);
            for (long i = upperBound; i >= lowerBound; i--) {
                if (palindrome / i > upperBound || i * i < palindrome) {
                    break;
                }
                if (palindrome % i == 0) {
                    return (int)(palindrome % 1337);
                }
            }
            firstHalf--;
        }
        return (int)upperBound;
    }
    public long getPal(long i) {
        StringBuilder sb = new StringBuilder();
        return Long.parseLong(i + "" + sb.append(i).reverse().toString());
    }
}
