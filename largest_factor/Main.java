import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner cin =  new Scanner(System.in)){
            String[] numbers = cin.nextLine().split(",");
            int number = Integer.parseInt(numbers[0]);
            int k = Integer.parseInt(numbers[1]);
            
            PriorityQueue<Integer> factors = new PriorityQueue<>();

            for(int i = number; i > 0; i--){
                if(number%i == 0) factors.add(i);
            }

            if(k > factors.size()){
                System.out.println(1);
                return;
            }
            for(int i = 0; i < k; i++){
                factors.poll();
            }
            System.out.println(factors.poll());
        }
    }
}
