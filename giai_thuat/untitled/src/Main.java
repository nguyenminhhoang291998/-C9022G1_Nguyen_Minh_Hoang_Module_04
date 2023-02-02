public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");


    }

    static int solution(int l, int r) {
        int count = 0;
        for (int i = l; i <= r ; i++) {
                String k = String.valueOf(i);
                if(k.charAt(0)==k.charAt(k.length()-1)){
                    count++;
                }
        }
        return count;
    }
}