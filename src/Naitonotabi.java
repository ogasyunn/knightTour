import java.util.Scanner;

class Naitonotabi {
    public static void main(String args[]){
        System.out.println("・があなたです。あなたはナイトの動きをすることができます。\n通ったマスが口から国に変わります。\n一度通ったマスは通れません。\nすべてのマスを国に変えましょう。");
        
        Scanner size = new Scanner(System.in);
        //size.close();

        int size1 = 0;
        int size2 = 0;

        try {
            size1 = size.nextInt();
            size2 = size.nextInt();

            //System.out.println(size1 + "+" + size2);

            if (size1 <= 0 || size2 <= 0) {
                System.out.println("指定できるのは正の値のみです");
                size.close();
                System.exit(0);
            }
        }
        catch (java.util.InputMismatchException e) {
            System.out.println("数字を入力してください");
            System.exit(0);
        }

        String table[][] = new String[size2][size1];

        for (int i = 0; i <= size2 - 1; i ++) {
            for (int j = 0; j <= size1 - 1; j ++) {
                table[i][j] = "口";
            }
        }

        table[0][0] = "・";
        
        for (int i = 0; i <= size2 - 1; i ++) {
            String display = new String();
            for (int j = 0; j <= size1 - 1; j ++) {
                display += table[i][j];
            }
            System.out.println(display);
        }

        table[0][0] = "国";
        int plased1 = 0;  //初期値
        int plased2 = 0;  //初期値        
        int counter = 1;

        //以下ループ部分
        while (counter != size1 * size2) {
            Scanner plase = new Scanner(System.in);

            int plase1 = 0;
            int plase2 = 0;
            
            try {
                plase1 = plase.nextInt() - 1;
                plase2 = plase.nextInt() - 1;
            }
            catch (java.util.InputMismatchException e) {
                System.out.println("数字を入力してください。");
                plase1 = -2;
                plase2 = -2;                
            }

            if (plase1 == -1 && plase2 == -1) {
                System.out.println("リタイアします。");
                //plase.close();
                break;
            }
            
            if (plase1 >= 0 && plase1<= size1 - 1 && plase2 >= 0 && plase2<= size2 - 1) {
                    
                if (table[plase2][plase1] == "口" && Math.abs(plased1 - plase1) + Math.abs(plased2 - plase2) == 3 && Math.abs(plased1 - plase1) != 0 && Math.abs(plased2 - plase2) != 0) {
                    table[plase2][plase1] = "・";

                    for (int i = 0; i <= size2 - 1; i ++) {
                        String display = new String();
                        for (int j = 0; j <= size1 - 1; j ++) {
                            display += table[i][j];
                        }
                    System.out.println(display);
                    }                

                    table[plase2][plase1] = "国";
                    plased1 = plase1;
                    plased2 = plase2;
                    counter ++ ;
                }

                else {
                    System.out.println("そこは通れません");
                }

                int a1[] = {-2, -2, -1, -1, 1, 1, 2, 2};
                int a2[] = {-1, 1, -2, 2, -2, 2, -1, 1};
                for (int k = 0; ; k ++) {
                    int judge1 = plased1 + a1[k];
                    int judge2 = plased2 + a2[k];
                    if (judge1 >=0 && judge1 <= size1 - 1 && judge2 >=0 && judge2 <= size2 - 1 ) {
                        if (table[judge2][judge1] != "口") {
                            if (counter == size1 * size2) {
                                System.out.println("成功です！！");
                                plase.close();
                                break;
                            }
                        }
                        else {
                            break;
                        }
                    }
                    if (k == 7) {
                        System.out.println("手詰まりです。");
                        plase.close();
                        System.exit(0);
                    }
                }
            }
            else if (plase1 != -2 || plase2 != -2) {
                System.out.println("そこは盤面の外です。");
            }
            else {
            }
        }
    }
}