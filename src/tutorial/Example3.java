package tutorial;

import java.util.ArrayList;

import complexSFG.math.Complex;
import complexSFG.solver.SFG;

public class Example3 {

	public static void main(String[] args){
		ArrayList<String> nodeNames = new ArrayList<>() ;
		nodeNames.add("A") ; // node 1
		nodeNames.add("B") ; // node 2
		nodeNames.add("C") ; // node 3
		nodeNames.add("D") ; // node 4
		SFG sfg = new SFG(4, nodeNames) ;
		sfg.addArrow("A", "B", new Complex(3, 1));
		sfg.addArrow("B", "C", new Complex(0, 2));
		sfg.addArrow("C", "D", Complex.ONE);
		sfg.addArrow("B", "D", new Complex(0, -3));
		sfg.addArrow("A", "D", new Complex(1, -5));
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
