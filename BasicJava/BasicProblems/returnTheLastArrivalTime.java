
public class returnTheLastArrivalTime {
    public static int returnTheArrivalTime(int N,int X){
        int totalPrintTime = 0;
        int arrivalTime = 0;
        for (int i = 1;i<N;i++){
             totalPrintTime += 10;
             arrivalTime += X;

        }
        return Math.max(0,totalPrintTime-arrivalTime);
    }
    public static void main(String[] args) {
        int N = 3;
        int X = 10;
        System.out.println(returnTheArrivalTime(N,X));
    }
}
