class TicTacToe {
    int n;
    Integer[] hori;
    Integer[] verti;
    Integer[] slash;
    Integer[] backSlash;
    public TicTacToe(int n) {
        this.n = n;
        hori = new Integer[n];
        verti = new Integer[n];
        slash = new Integer[2*n-1];
        backSlash = new Integer[2*n-1];
    }
    public int move(int row, int col, int player) {
        int incre = player == 1?1:-1;
        int indexHori = row;
        int indexVerti = col;
        int indexSlash = row + col;
        int indexBackSlash = col - row + n - 1;
        if(hori[indexHori] == null) hori[indexHori] = incre;
        else if(hori[indexHori] * incre <= 0) hori[indexHori] = 0;
        else hori[indexHori] += incre;
        if(hori[indexHori] == n || hori[indexHori] == -n) return player;
 
        if(verti[indexVerti] == null) verti[indexVerti] = incre;
        else if(verti[indexVerti] * incre <= 0) verti[indexVerti] = 0;
        else verti[indexVerti] += incre;
        if(verti[indexVerti] == n || verti[indexVerti] == -n) return player;
   
        if(slash[indexSlash] == null) slash[indexSlash] = incre;
        else if(slash[indexSlash] * incre <= 0) slash[indexSlash] = 0;
        else slash[indexSlash] += incre;
        if(slash[indexSlash] == n || slash[indexSlash] == -n) return player;
    
        if(backSlash[indexBackSlash] == null) backSlash[indexBackSlash] = incre;
        else if(backSlash[indexBackSlash] * incre <= 0) backSlash[indexBackSlash] = 0;
        else backSlash[indexBackSlash] += incre;
        if(backSlash[indexBackSlash] == n || backSlash[indexBackSlash] == -n) return player;
        
        return 0;
    }
}
