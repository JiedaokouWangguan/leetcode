class StringIterator {
    char[] s = null;
    int index = 0;
    int count = 0;
    char cur;
    public StringIterator(String compressedString) {
        s = compressedString.toCharArray();
    }

    public char next() {
        if(!hasNext())
            return ' ';
        if(count > 0){
            count -= 1;
            return cur;
        }
        else{
            cur = s[index++];
            int num = 0;
            while(index < s.length && s[index] >= '0' && s[index] <= '9'){
                num = num * 10 + (s[index] - '0');
                index += 1;
            }
            count = num - 1;
            return cur;
        }
    }

    public boolean hasNext() {
        return !(index == s.length && count == 0);
    }
}
