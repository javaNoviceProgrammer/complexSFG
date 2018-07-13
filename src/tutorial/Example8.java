package tutorial;

import static complexSFG.math.Complex.*;

import complexSFG.math.Complex;

/**
 * This is just a demonstration of operator overloading for complex numbers
 * Use "import static" for complex constants
 * @author meisam
 *
 */

public class Example8 {
	public static void main(String[] args) {
		// first creating a complex number
		Complex u = 1+2*j ;
		// then printing it to the consol
		System.out.println("u = " + u);
		// now performing mathematical tasks
		Complex w = u*u -1 ;
		System.out.println("w = " + w);
	}
}
