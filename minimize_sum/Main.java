import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner cin = new Scanner(System.in)){
            int n = cin.nextInt();
            int k = cin.nextInt();
            PriorityQueue<Integer> numbers = new PriorityQueue<>(Comparator.reverseOrder());
            for(int i = 0; i < n; i++){
                numbers.add(cin.nextInt());
            }

            int minSum = 0;
            for(int i = 0; i < k; i++){
                int num = numbers.poll();
                numbers.add((int)Math.floor(num/2));
            }
            while(!numbers.isEmpty()){
                minSum += numbers.poll();
            }
            System.out.println(minSum);
        }
    }
}
