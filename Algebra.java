// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    //System.out.println(plus(2,-3));   // 2 + 3
	    //System.out.println(minus(-7,-1));  // 7 - 2
   		//System.out.println(minus(2,7));  // 2 - 7
 		//System.out.println(times(-5,-7));  // 3 * 4
   		//System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		//System.out.println(pow(0,3));      // 5^3
   		//System.out.println(pow(3,5));      // 3^5
   		//System.out.println(div(21,-7));   // 12 / 3    
   		//System.out.println(div(5,5));    // 5 / 5  
   		//System.out.println(div(25,7));   // 25 / 7
   		//System.out.println(mod(-24,-25));   // 25 % 7
		//System.out.println(-24%-25);
   		//System.out.println(mod(120,6));  // 120 % 6    
   		//System.out.println(sqrt(5));
		/*System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));*/
		//System.out.println(2/7);
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if(x2<0){
			for(int i=x2; i<0 ; i++){
				x1 = --x1;
			}
		}

		for(int i=0; i<x2 ; i++){
			x1 = ++x1;
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {

        if(x2<0){
			for(int i=x2; i<0 ; i++){
				x1 = ++x1;
			}
		}

		for(int i=0; i<x2 ; i++){
			x1 = --x1;
		}
		return x1;	
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int add1 =x1;
		int add2 =x2;

		if(x1 ==0 || x2 ==0)
		return 0;

		if(x2<0 && x1>0){
			for(int i=0; i<x1-1 ; i++){
				x2 = plus(add2,x2);
			}
			return x2;
		}

		if(x2<0 && x1<0){
			for(int i=x2; i<1 ; i++){
				x1 = minus(x1,add1);
			}
			return x1;
		}

		for(int i=0; i<x2-1 ; i++){
			x1 = plus(add1,x1);
		}

		return x1;
	}
	

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if(n == 0)
		return 1;

		int original =x;

		for(int i=0; i<n-1 ;i++){
			x = times(original,x);

		}
		return x;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
           if(x1 ==0)
             return 0;

			 int numerator = x1;
			 int denominator =x2;
			 int denominatorFirstVal =x2;
			 int times =0;

			 if(numerator<0){
				numerator = times(numerator,-1);
			 }

			 if(denominator<0){
				denominator = times(denominator,-1);
				denominatorFirstVal = times(denominatorFirstVal,-1);
			 }
		
			 while(numerator>=denominator){
				denominator = plus(denominator,denominatorFirstVal);
				times++;
			 }
			 if((x1<0 && x2<0) || (x1>0 && x2>0))
			 return times;

			 return times(times,-1);
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int div =div(x1,x2);
		return x1 - times(div,x2);
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if(x==0)
		return 0;
	
		for(int i=0; i<=x ; i++){
			if(times( i,i) > x ){
				return i-1;
			}

		}
		return 0;
		
	}	  	  
}