import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    private static class CustomComp implements  Comparator<List<Integer>>{

        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            return o1.get(0) - o2.get(0);
        }

    }
    public static void main(String[] args) {
        try(Scanner cin = new Scanner(System.in)){
            int n = cin.nextInt();
            PriorityQueue<List<Integer>> trains = new PriorityQueue<>(new CustomComp());
            for(int i = 0; i < n; i++){
                int arriving = cin.nextInt();
                int stoppage = cin.nextInt();
                trains.add(Arrays.asList(arriving, arriving+stoppage));
            }

            int railwaysCounter = 1;
            int previousEnd = -1;

            PriorityQueue<List<Integer>> aux = new PriorityQueue<>(new CustomComp());

            while(!trains.isEmpty()){
                List<Integer> train = trains.poll();
                if(previousEnd < train.get(0)){
                    previousEnd = train.get(1);
                }
                else{
                    aux.add(train);
                }
                if(trains.isEmpty() && !aux.isEmpty()){
                    railwaysCounter++;
                    previousEnd = -1;
                    while(!aux.isEmpty()){
                        List<Integer> t = aux.poll();
                        trains.add(t);
                    }
                }
            }

            System.out.println(railwaysCounter);
        }   
    }
}
