
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try(Scanner cin = new Scanner(System.in)){

            List<Integer> houses = new ArrayList<>();

            while (cin.hasNextInt()) { 
                houses.add(cin.nextInt());
            }

           int[] robValue = new int[houses.size()];
           robValue[0] = houses.get(0);
           robValue[1] = houses.get(1);

           for(int i = 2; i < houses.size(); i++){
                if(houses.get(i) + robValue[i-2] > robValue[i-1]){
                    robValue[i] = houses.get(i) + robValue[i-2];
                }else{
                    robValue[i] = robValue[i-1];
                }
           }
           System.out.println(robValue[houses.size()-1]);
        }
    }
}
