import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner cin = new Scanner(System.in)){
            double loanAmount = cin.nextDouble();
            int totalTenure = cin.nextInt();
            int bankAnSlabs = cin.nextInt();

            Interest[] bankA = new Interest[bankAnSlabs];
            for(int i = 0; i < bankAnSlabs; i++){
                bankA[i] = new Interest(cin.nextInt(), cin.nextDouble());
            }

            int bankBnSlabs = cin.nextInt();

            Interest[] bankB = new Interest[bankBnSlabs];
            for(int i = 0; i < bankBnSlabs; i++){
                bankB[i] = new Interest(cin.nextInt(), cin.nextDouble());
            }

            if(calculateTotal(bankA, bankAnSlabs, loanAmount, totalTenure) < calculateTotal(bankB, bankBnSlabs, loanAmount, totalTenure)){
                System.out.println("Bank A");
            }else{
                System.out.println("Bank B");
            }
        }
    }

    private static double calculateTotal(Interest[] bank, int amount, double loan, int nYears){
        double yearlyNetPayment = loan/amount;
        double totalPayment = 0;

        for(int i = 0; i < amount; i++){
            double divider = Math.pow((1+bank[i].intr), bank[i].nYears *12);
            double emi = loan * (bank[i].intr/(1-(1/divider)));
            totalPayment += emi* bank[i].nYears * 12;
            loan -= yearlyNetPayment*bank[i].nYears;
        }

        return totalPayment;
    }
    

    private static class Interest{
        public int nYears;
        public double intr;

        public Interest(int nYears, double intr) {
            this.nYears = nYears;
            this.intr = intr;
        }
    }
}
