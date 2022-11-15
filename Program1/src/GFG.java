
public class GFG {
		 
	    // Function to find the sum of
	    // two integers of base B
	    static String sumBaseB(String a, String b, int base)
	    {
	        int len_a, len_b;
	     
	        len_a = a.length();
	        len_b = b.length();
	     
	        String sum, s;
	        s = "";
	        sum = "";
	     
	        int diff;
	        diff = Math.abs(len_a - len_b);
	         
	        // Padding 0 in front of the
	        // number to make both numbers equal
	        for (int i = 1; i <= diff; i++)
	            s += "0";
	         
	        // Condition to check if the strings
	        // have lengths mis-match
	        if (len_a < len_b)
	            a = s + a;
	        else
	            b = s + b;
	     
	        int curr, carry = 0;
	         
	        // Loop to find the find the sum
	        // of two integers of base B
	        for (int i = Math.max(len_a, len_b) - 1;
	                            i > -1; i--) {
	             
	            // Current Place value for
	            // the resultant sum
	            curr = carry + (a.charAt(i) - '0') +
	                        (b.charAt(i) - '0');
	     
	            // Update carry
	            carry = curr / base;
	     
	            // Find current digit
	            curr = curr % base;
	     
	            // Update sum result
	            sum = (char)(curr + '0') + sum;
	        }
	        if (carry > 0)
	            sum = (char)(carry + '0') + sum;
	        return sum;
	    }
}
