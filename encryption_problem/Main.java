import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner cin = new Scanner(System.in)){
            String encrypted = cin.nextLine();
            String instructions = cin.nextLine();

            int currentPos = 0;
            for(int i = 0; i < instructions.length(); i++){
                if(instructions.charAt(i) == 'R'){
                    currentPos++;
                }else if(instructions.charAt(i) == 'L'){
                    currentPos--;
                }
                else if(instructions.charAt(i) == 'T'){
                    String left = encrypted.substring(0, currentPos);
                    String right = encrypted.substring(currentPos+1);
                    int newNumber =  encrypted.charAt(currentPos) - '0' + 1;
                    if(newNumber >9) newNumber = 9;
                    encrypted = left + newNumber + right;
                }
                else if(instructions.charAt(i) == 'D'){
                    String left = encrypted.substring(0, currentPos);
                    String right = encrypted.substring(currentPos+1);
                    int newNumber =  encrypted.charAt(currentPos) - '0' - 1;
                    if(newNumber <0) newNumber = 0;
                    encrypted = left + newNumber + right;
                }
                else if(instructions.charAt(i) == 'S'){
                    int secondIndex = instructions.charAt(i+1) - '0' -1 ;
                    int firstNumber = encrypted.charAt(currentPos) - '0';
                    int secondNumber = encrypted.charAt(secondIndex) - '0';
                    
                    int middleCut = 0;
                    int endCut = 0;
                    if(secondIndex < currentPos){
                        int aux = firstNumber;
                        firstNumber = secondNumber;
                        secondNumber = aux;
                        middleCut = secondIndex;
                        endCut = currentPos;
                    }else{
                        middleCut = currentPos;
                        endCut = secondIndex;
                    }
                    String left = encrypted.substring(0, middleCut);
                    String middle = encrypted.substring(middleCut+1, endCut);
                    String right = encrypted.substring(endCut+1);
                    encrypted = left + secondNumber + middle + firstNumber + right;
                }
            }
            System.out.println(encrypted);
        }
    }
}
