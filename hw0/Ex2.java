public class Ex2 {
    public static int max(int[] m) {
        int a = 0;
        for(int i = 0; i < m.length; ++i){
            if(m[i]>a){
                a = m[i];
            }
        }
        return a;
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        int b = max(numbers);
        System.out.println(b);
    }
}