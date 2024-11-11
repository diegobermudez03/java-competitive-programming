import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try(Scanner cin = new Scanner(System.in)){
            int n = cin.nextInt();

            List<Integer> sumPrimes = new ArrayList<>();
            Set<Integer> prime = new HashSet<>();
            sumPrimes.add(2);
            for(int i = 3; i < n; i++){
                boolean notPrime = false;
                for(int j = i-1; j>1; j--){
                    if(i%j == 0){
                        notPrime = true;
                        break;
                    }
                }
                if(!notPrime){
                    prime.add(i);
                    sumPrimes.add(i + sumPrimes.get(sumPrimes.size()-1));
                }
            }
            int counter = 0;

            for(int i = 0; i < n; i++){
                if(sumPrimes.contains(i) && prime.contains(i)) counter++;
            }
            System.out.println(counter);
        }
    }
}
