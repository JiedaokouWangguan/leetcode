import java.util.ArrayDeque;

public class Question907{
    public int sumSubarrayMins(int[] A) {     
        int mod = 1000000007;
        int n = A.length; 
        int[][] con = new int[n][2];   
        ArrayDeque<Integer> stack = new ArrayDeque<>();                     
        stack.push(-1);   
        for(int i = 0;i<n;i++){        
            while(stack.peek() != -1 && A[stack.peek()] > A[i]) stack.pop(); 
            con[i][0] = stack.peek()+1;
            stack.push(i);
        }

        stack = new ArrayDeque<>();    
        stack.push(n);    
        for(int i = n-1;i>=0;i--){     
            while(stack.peek() != n && A[stack.peek()] >= A[i]) stack.pop();
            con[i][1] = stack.peek()-1;
            stack.push(i);
        }                                                                                                                                                                                                   
        int result = 0;   
        for(int i = 0;i<n;i++){        
            result += ((i - con[i][0] + 1)*(con[i][1] - i + 1) * A[i])%mod;
            result %= mod;
        }
        return result;    
    }
}
