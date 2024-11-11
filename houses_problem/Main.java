
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try(Scanner cin = new Scanner(System.in)){

            List<Integer> houses = new ArrayList<>();

            while (cin.hasNextInt()) { 
                houses.add(cin.nextInt());
            }

            Set<Integer> prohibitedIndexHouses = new HashSet<>();
            
            int total = 0;
            for(int i = 0;  i < houses.size(); i++){
                if(prohibitedIndexHouses.contains(i)) continue;
                int left = 0, right = 0;
                if(i > 0 ) left = houses.get(i-1);
                if(i < houses.size()-1) right = houses.get(i+1);

                if(houses.get(i) > left && houses.get(i) > right){
                    prohibitedIndexHouses.add(i-1);
                    prohibitedIndexHouses.add(i+1);
                    total += houses.get(i);
                }
            }
            System.out.println(total);
        }
    }
}
