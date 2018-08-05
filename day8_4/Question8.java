public class Question8{
    public int myAtoi(String str) {
        int sign = 1, base = 0, i = 0, INT_MAX = Integer.MAX_VALUE, INT_MIN = Integer.MIN_VALUE;
        while (i < str.length() && str.charAt(i) == ' ') i++;

        if (i >= str.length()) return 0;

        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            if (str.charAt(i) == '-') sign = -1;
            i++;
        }

        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > INT_MAX / 10 || (base == INT_MAX / 10 && str.charAt(i) - '0' > 7)) {
                if (sign == -1) return INT_MIN;
                else            return INT_MAX;    
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }

        return base * sign;

    }
}
