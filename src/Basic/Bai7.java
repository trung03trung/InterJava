package Basic;

public class Bai7 {
    private static boolean nto(int n){
        if (n<=1) return false;
        for(int i = 2; i<=Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        return true;
    }
    private static boolean csle(int n){
        int cs = 0;
        while(n>0){
            cs = n%10;
            if(cs%2 == 0) return false;
            n/=10;
        }
        return true;
    }
    public static void main(String[] args) {
        for(int i = 100000; i<=Math.pow(10,6)-1;i++){
            if(nto(i) && csle(i)) System.out.println(i);
        }
    }
}
