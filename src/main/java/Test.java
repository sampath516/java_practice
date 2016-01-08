import java.util.Scanner;


public class Test {



    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int noOfTestCases = scanner.nextInt();
        scanner.nextLine();
        int i = 0;
        String[] strings = new String[10];
        while(scanner.hasNext() && i < noOfTestCases){
            strings[i++] = scanner.next();
            if(i < noOfTestCases){
                scanner.nextLine();
            }
            
        }
       
        for(int k=0; k<noOfTestCases; k++ ){
        	String str=strings[k];
        	String result = "Not Funny";
            if(isItFunny(str)){
                result = "Funny";
            }
            System.out.println(result);
        }
    }
    
    private static  boolean isItFunny(String str){
       char[] strArray =  str.toCharArray();
        boolean isFunny = true;
        for(int i = 1, j = str.length()-1; j>=i ; i++, j--   ){
            if(Math.abs(strArray[i] - strArray[i-1]) != Math.abs(strArray[j] - strArray[j-1])) {
                isFunny = false;
                break;
            }
        }
        return isFunny;
    }
}
