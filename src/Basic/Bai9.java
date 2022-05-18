package Basic;

public class Bai9 {
    private static boolean stn(int n){
        int a = n;
        int stn = 0;
        while(n>0){
            stn = stn*10+ n%10;
            n/=10;
        }
        if(a == stn) return true;
        return false;
    }
    private static boolean cs(int n){
        int cs = 0;
        boolean check = true;
        while(n>0){
            cs = n%10;
            if(cs == 0|| cs == 6||cs == 8){
                check = true;
            }else{
                check = false;
                break;
            }
            n/=10;
        }
        if(check == false) return false;
        return true;
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
        for(int i = 1000000; i<=Math.pow(10,9)-1; i++){
            if(cs(i)&&tongcs(i)%10==0&&stn(i)){
                System.out.println(i);
            }
        }
    }
}
