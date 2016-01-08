import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Regex {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("4+0*");
		Matcher matcher  = pattern.matcher("440");
		//matcher.reset();
		System.out.println("Result "+matcher.matches());
		
		BigInteger target = new BigInteger("444444444444444");
		BigInteger x = new BigInteger("62");
		System.out.println(target.divide(x));
		System.out.println("444444444444444000".split("0")[0]);

	}

}
