import java.util.Scanner;

class Naitonokotae {
     public static void main(String args[]) {
        Scanner size = new Scanner(System.in);

        //入力
        int sizeX = size.nextInt() - 1;
        int sizeY = size.nextInt() - 1;

        int squareSize = (sizeX + 1) * (sizeY + 1);

        //答えの座標
        /*
        int answerX[] = new int [squareSize];
        int answerY[] = new int [squareSize];
        answerX[0] = 1;
        answerY[0] = 1;
        */
        int ansX = 0;
        int ansY = 0;

        //開始地点
        int X = 0;
        int Y = 0;

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
        int j = 0;
        String state = "judged";
        int judgeX = X + aX[i[j]];
        int judgeY = Y + aY[i[j]];

        i[0] = 0;

        //行き先検索

        while (state != "finish"){

            for ( ; i[j] <= 7; i[j] ++) {
                judgeX = X + aX[i[j]];
                judgeY = Y + aY[i[j]];
                
                if (judgeX >= 0 && judgeX <= sizeX && judgeY >= 0 && judgeY <= sizeY) {
                    if (table[judgeY][judgeX] == 0) {
                        table[judgeY][judgeX] = 1;
                        /*
                        answerX[j] = X;
                        answerY[j] = Y;
                        */

                        X = judgeX;
                        Y = judgeY;

                        //デバッグ用部分ここから
                        
                        System.out.print(X + " ");
                        System.out.print(Y + " ");
                        System.out.print(j + " ");
                        System.out.println(i[j]);

                        //デバッグ用部分ここまで

                        state = "judged";

                        break;
                    }
                }
                else {
                    state = "back";
                }
            }

            if (j == squareSize - 1) {
                /*
                answerX[j] = X;
                answerY[j] = Y;
                */

                state = "finish";
            }

            if (state == "back") {
                table[Y][X] = 0;

                j --;

                if (j < 0) {
                    System.out.println("この形は解けません");
                    System.exit(0);
                }
                /*
                X = answerX[j];
                Y = answerY[j];
                */
                X = X - aX[i[j]];
                Y = Y - aY[i[j]];
                i[j] ++;
            }
            else if (state == "judged") {
                j ++;
                i[j] = 0;
            }

            //デバッグ用部分ここから
            
            System.out.print(state + " ");
            System.out.print(j + " ");
            System.out.println(i[j]);

            for (int l = 0; l <= sizeY; l ++) {
                String display = new String();
                for (int m = 0; m <= sizeX; m ++) {
                    display += table[l][m];
                }
                System.out.println(display);
            }
            
            //デバッグ用部分ここまで
        
        }

        System.out.println();

        for (int k = 0; k < squareSize - 1; k ++) {

            ansX += aX[i[k]];
            ansY += aY[i[k]];

            System.out.print(ansX + 1);
            System.out.print(",");
            System.out.println(ansY + 1);
        }

        size.close();
    }
}