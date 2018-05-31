public class Question717{
    public boolean isOneBitCharacter(int[] bits){
        int result = isOBC(bits, 0);
        if(result == 1)
            return true;
        else
            return false;
    }

    private int isOBC(int[] bits, int begin){
        if(begin == bits.length-1)
            return 1;
        if(begin == bits.length-2){
            if(bits[begin] == 0)
                return 1;
            else
                return 0;
        }

        if(bits[begin] == 1){
            return isOBC(bits, begin+2);
        }
        else{
            return isOBC(bits, begin+1);
        }
    }
}
