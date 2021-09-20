class Solution {
    
    public int[][] initBoard(int[][] board){
        for(int i =0; i< 3 ; i++)
                for(int j = 0; j<3;j++)
                    board[i][j] = -1;
        return board;
    }
    
    public int[][] fillBoard(int[][] moves, int[][] board){
        
        for(int i =0;i < moves.length; i++){
                if(i %2 == 0)
                    board[moves[i][0]][moves[i][1]] = 1;    
                else
                    board[moves[i][0]][moves[i][1]] = 0;    
            }
        return board;
    }
    
    public int checkRow(int[][] board){
        for(int i =0; i< 3; i++){
            int rowA = 0, rowB = 0;
            for(int j =0 ; j< 3 ;j++){
                if(board[i][j] == 1 ) rowA++;
                if(board[i][j] == 0 ) rowB++;
            }
            if(rowA == 3) return 1;
            if(rowB == 3) return 0; 
        }
        return -1;
    }

    public int checkColumns(int[][] board){
        for(int i =0; i< 3; i++){
            int rowA = 0, rowB = 0;
            for(int j =0 ; j< 3 ;j++){
                if(board[j][i] == 1 ) rowA++;
                if(board[j][i] == 0 ) rowB++;
            }
            if(rowA == 3) return 1;
            if(rowB == 3) return 0; 
        }
        return -1;
    }

    public int checkDiag(int[][] board){
        int diagA = 0, diagB = 0;
        for(int i =0; i< 3; i++){
            if(board[i][i] == 1 ) diagA++;
            if(board[i][i] == 0 ) diagB++;
        }
        if(diagA == 3) return 1; else diagA = 0;
        if(diagB == 3) return 0; else diagB = 0; 
        
        for(int i =0; i< 3; i++){
            if(board[i][2-i] == 1 ) diagA++;
            if(board[i][2-i] == 0 ) diagB++;
        }
           
        if(diagA == 3) return 1;
        if(diagB == 3) return 0; 
        return -1;

    }
    
    public String gotoCleanUp(int res){
        if(res == 1) return new String("A");
        else return new String("B");
    }



    public String tictactoe(int[][] moves) {
        
        //A B Pending
        int[][] board = new int[3][3];
        
        board = initBoard(board);
        board = fillBoard(moves , board);
        
        int res = checkRow(board);
        if(res <0){
            res = checkColumns(board);
            if(res < 0){
                res = checkDiag(board);
                if(res < 0){
                    if(moves.length == 9) return new String("Draw");
                    else return new String("Pending");
                }else return gotoCleanUp(res);
            }else return gotoCleanUp(res);
        }else{
            return gotoCleanUp(res);
        }
    }

    public static void main(String[] args) {
        int[][] m  = {{0,0},{2,0},{1,1},{2,1},{2,2}};
        int[][] m1 = {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
        int[][] m2 = {{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}};
        int[][] m3 = {{0,0},{1,1}};

        Solution s = new Solution();
        System.out.println(s.tictactoe(m));
        System.out.println(s.tictactoe(m1));
        System.out.println(s.tictactoe(m2));
        System.out.println(s.tictactoe(m3));
        
    }
}

