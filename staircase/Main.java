import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner cin = new Scanner(System.in)){
           int number = cin.nextInt();
           System.out.println(recursiveTree(number));
        }
    }

    private static int recursiveTree(int n){
       if(n == 0 || n == 1) return 1;
       return recursiveTree(n-1) + recursiveTree(n-2);
    }
}
