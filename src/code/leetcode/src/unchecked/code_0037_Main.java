package unchecked;

public class code_0037_Main {

    public static void main(String[] args) {
        code_0037 one = new code_0037();

//        char[][] board2 = new char[9][9];
//        int[][] board = new int[9][9];

        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
//        board[0][0] = 5; board[0][1] = 3; board[0][4] = 7;
//        board[1][0] = 6; board[1][3] = 1; board[1][4] = 9; board[1][5] = 5;
//        board[2][1] = 9; board[2][2] = 8; board[2][7] = 6;
//        board[3][0] = 8; board[3][4] = 6; board[3][8] = 3;
//        board[4][0] = 4; board[4][3] = 8; board[4][5] = 3; board[4][8] = 1;
//        board[5][0] = 7; board[5][4] = 2; board[5][8] = 6;
//        board[6][1] = 6; board[6][6] = 2; board[6][7] = 8;
//        board[7][3] = 4; board[7][4] = 1; board[7][5] = 9; board[7][8] = 5;
//        board[8][4] = 8; board[8][7] = 7; board[8][8] = 9;

//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (board[i][j] >= 1 && board[i][j] <= 9) {
//                    board2[i][j] = (char)(board[i][j]+48);
//                } else board2[i][j] = '.';
//            }
//        }


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        one.solveSudoku(board);
        System.out.println("---------res----------");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
