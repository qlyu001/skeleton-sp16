public class Ex1b{
    
    public static void drawTriangle() {
        for(int a = 1; a < 6; ++a)
        {
            for(int j = 0; j < a; ++j)
            {
                System.out.print ("*");
            }
            System.out.println ();
            
        }
    }
    
    public static void main(String[] args)
    {
        drawTriangle();
    }
}
