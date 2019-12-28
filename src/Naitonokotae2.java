import java.util.Scanner;

class Naitonokotae2 {
     public static void main(String args[]) {
        Scanner size = new Scanner(System.in);

        //入力
        String args1 = args[0];
        String args2 = args[1];

        int sizeX = Integer.parseInt(args1) - 1;
        int sizeY = Integer.parseInt(args2) - 1;

        int squareSize = (sizeX + 1) * (sizeY + 1);
        
        //開始地点
        System.out.println("開始位置を入れてください");
        int X = size.nextInt() - 1;
        int Y = size.nextInt() - 1;
        
        //答えの座標
        int ansX = X;
        int ansY = Y;

        

        //盤面登録
        int table[][] = new int[sizeY + 1][sizeX + 1];
        for (int p = 0; p <= sizeY; p ++) {
            for (int q = 0; q <= sizeX; q ++) {
                table[p][q] = 0;
            }
        }
        table[Y][X] = 1;

//処理部分
        
        //行き先検索用変数
        int aX[] = {1, 2, 2, 1, -1, -2, -2, -1};
        int aY[] = {-2, -1, 1, 2, 2, 1, -1, -2};

        //変化量指定
        int i[] = new int [squareSize];
        int j = 1;
        int judgeX = X + aX[i[j]];
        int judgeY = Y + aY[i[j]];

        i[0] = 0;

        //行き先検索

        while (true){

            for ( ; i[j] <= 7; i[j] ++) {
                judgeX = X + aX[i[j]];
                judgeY = Y + aY[i[j]];
                
                if (judgeX >= 0 && judgeX <= sizeX && judgeY >= 0 && judgeY <= sizeY) {
                    if (table[judgeY][judgeX] == 0) {
                        table[judgeY][judgeX] = 1;

                        X = judgeX;
                        Y = judgeY;

                        //デバッグ用部分ここから
/*
                        System.out.println("");
                        
                        System.out.print(X + " ");
                        System.out.print(Y + " ");
                        System.out.print(j + " ");
                        System.out.println(i[j]);

                        for (int l = 0; l <= sizeY; l ++) {
                            String display = new String();
                            for (int m = 0; m <= sizeX; m ++) {
                                display += table[l][m];
                            }
                            System.out.println(display);
                        }
*/
                        //デバッグ用部分ここまで

                        j ++;

                        if (j == squareSize) {
                            break;
                        }

                        i[j] = -1;
                    }
                }
            }

            if (j == squareSize) {
                break;
            }
            else if (j == 1) {
                System.out.println("この型は解けません");
                System.exit(0);
            }
            else {
                j --;
                table[Y][X] = 0;
                X = X - aX[i[j]];
                Y = Y - aY[i[j]];
                i[j] ++;
            }
        }

        System.out.println();

        for (int k = 1; k < squareSize; k ++) {

            ansX += aX[i[k]];
            ansY += aY[i[k]];

            System.out.print(ansX + 1);
            System.out.print(",");
            System.out.println(ansY + 1);
        }
        size.close();
    }
}