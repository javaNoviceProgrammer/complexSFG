package tests;

import static complexSFG.math.Complex.*;

import java.util.ArrayList;

import complexSFG.math.Complex;
import complexSFG.solver.SFG;

/**
 * Example of SFG with operator overloading for Complex numbers
 * @author Meisam
 *
 */

public class Example7 {
	public static void main(String[] args) {
		ArrayList<String> nodeNames = new ArrayList<>() ;
		nodeNames.add("A") ; // node 1
		nodeNames.add("B") ; // node 2
		nodeNames.add("C") ; // node 3
		nodeNames.add("D") ; // node 4
		SFG sfg = new SFG(4, nodeNames) ;
		// defining gains using operator overloading of complex objects
		sfg.addArrow("A", "B", 3+j);
		sfg.addArrow("B", "C", 2*j);
		sfg.addArrow("C", "D", 1+0*j);
		sfg.addArrow("B", "D", -3*j);
		// building up the paths between two designated nodes
		String startNode = "A" ;
		String endNode = "D" ;
		sfg.buildForwardPaths(startNode, endNode);

		System.out.println(sfg.printForwardPaths());
		System.out.println(sfg.printAllLoops());
		System.out.println("\nTotal forward gain is: " + sfg.computeForwardGain());
		System.out.println("Graph determinant is: " + sfg.computeDelta());
		Complex gain = sfg.computeGain(1, 4).divides(sfg.computeDelta()) ;
		System.out.println();
		System.out.println("Total gain between node " + startNode +" and node "
							+ endNode + " is: ") ;
		System.out.println(gain);
	}
}
