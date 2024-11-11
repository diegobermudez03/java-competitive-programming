import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int rockNumber = cin.nextInt();
        int rangeNumber = cin.nextInt();

        List<Double> rocks = new ArrayList<>();
        for(int i = 0;  i < rockNumber; i++){
            rocks.add(cin.nextDouble());
        }

        List<List<Double>> ranges = new ArrayList<>();

        for(int i = 0; i < rangeNumber; i++){
            ranges.add(Arrays.asList(cin.nextDouble(), cin.nextDouble()));
        }

        List<Integer> count = new ArrayList<>();
        for(int i = 0; i < rangeNumber; i++) count.add(0);

        for(double rock: rocks){
            for(int i = 0; i < rangeNumber; i++){
                if(rock >= ranges.get(i).get(0) && rock <= ranges.get(i).get(1)){
                    count.set(i, count.get(i)+1);
                }
            }
        }
        for(int i = 0; i < rangeNumber; i++){
            System.out.print(count.get(i) + " ");
        }
        cin.close();
    }
}