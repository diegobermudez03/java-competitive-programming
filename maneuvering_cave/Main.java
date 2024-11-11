import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner cin = new Scanner(System.in)){
            int num = cin.nextInt();
            int[] results = new int[num];
            for(int i = 0; i < num; i++){
                int rows = cin.nextInt();
                int columns = cin.nextInt();
                results[i] = checkMatrix(columns, rows);
            }
            for(int i: results){
                System.out.println(i);
            }
        }
    }

    private static int checkMatrix(int columns, int rows){
        return recursive(columns-1, rows-1);
    }

    private static int recursive(int columnIndex, int rowIndex){
        if(columnIndex == 0 || rowIndex == 0) return 1;
        return recursive(columnIndex-1, rowIndex) + recursive(columnIndex, rowIndex-1) ;
    }
}
