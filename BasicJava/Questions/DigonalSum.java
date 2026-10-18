
public class DigonalSum {
    public static int diagonalSum(int[][] mat) {
        int i=0;
        int sum=0;
        while(i<mat.length){
            int j=0;
            while(j<mat.length)
            {
                if(mat.length%2==0){
                    if(i==j || i+j==mat.length+1){
                        sum=mat[i][j]+sum;
                    }
                }
                else{
                    if(i==j || i+j==mat.length+1&&i!=j)
                    {
                        sum=mat[i][j]+sum;
                    }
                }
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        int num=diagonalSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 },{1,2,3} });
        System.out.println(num);
    }
    }
