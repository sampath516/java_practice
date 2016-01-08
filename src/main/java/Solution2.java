import java.util.Scanner;


public class Solution2 {


    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
         int count = sc.nextInt();
     while(sc.hasNext())
         {
         int input = sc.nextInt(),i=0;
         boolean outerbreakloop = true;
         if(input<=4)
         {
           System.out.println(2);
         }
         else
         {
            while (outerbreakloop)
                {
                int n=i,countfour=1;
                double value=0;
                boolean breakloop = true;
                while( breakloop)
                    {
                    value =value+(Math.pow(10, n));
//                    System.out.println(4*value+" "+countfour+" "+n);
                    
                    if((input<4*value && (4*value)%input == 0))
                        {
                     
                         System.out.println(2*countfour+n);
                        breakloop = false;
                        outerbreakloop=false;
                    }
                   
                     if(n<=0)
                     {
                       breakloop = false;
                     }
                     
                     n--;
                     countfour++;
                        
                    
                }
               
            
                i++;
        }
         }}
         sc.close();
        }
}
