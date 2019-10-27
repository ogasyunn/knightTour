import java.util.Scanner;

class Helloworld {
    public static void main(String args[]) {
      System.out.println("enter number");
      Scanner sc = new Scanner(System.in);
      int scan = sc.nextInt();
      
      String number1 = args[0];
      String number2 = args[1];
      
      System.out.println(number1 + "," + number2 + ":" + scan);
      sc.close();
    }
  }