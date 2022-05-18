package Basic;

public class Bai8 {
    private static boolean sothuannghich(int n){
        int a = n%1000;
        int tn = 0;
        while(a>0){
            tn = tn*10 +a%10;
            a/=10;
        }
        n/=1000;
        if (n == tn) return true;
        return false;
    }
    private static int tongcs(int n){
        int sum = 0;
        while(n>0){
            sum = sum +n%10;
            n/=10;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println("Phan a: ");
        for(int i = 100000 ; i<=Math.pow(10,6)-1; i++){
            if (sothuannghich(i)){
                System.out.println(i);
            }
        }
        System.out.println("Phan b: ");
        for (int i = 100000; i<Math.pow(10,6)-1; i++){
            if(sothuannghich(i) && tongcs(i) % 10 == 0){
                System.out.println(i);
            }
        }
    }
}
