import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner cin = new Scanner(System.in)){
            int nTests = cin.nextInt();
            int[] resultTests = new int[nTests];
            for(int i = 0; i < nTests; i++){
                int n = cin.nextInt();
                PriorityQueue<Integer> boxes = new PriorityQueue<>();
                for(int j = 0; j < n; j++){
                    boxes.add(cin.nextInt());
                }
                resultTests[i] = checkTest(boxes, n);
            }

            for(int i: resultTests){
                System.out.println(i);
            }
        }
    }

    private static int checkTest(PriorityQueue<Integer> boxes, int nBoxes){
        int newBox = boxes.poll();
        int counter = 0;
        while(!boxes.isEmpty()){
            int minBox = boxes.poll();
            counter += newBox + minBox;
            newBox += minBox;
        }
        return counter;
    }
}
