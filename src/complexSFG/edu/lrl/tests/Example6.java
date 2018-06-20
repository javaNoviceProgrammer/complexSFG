package complexSFG.edu.lrl.tests;

import java.util.ArrayList;

import complexSFG.edu.lrl.math.Complex;
import complexSFG.edu.lrl.solver.SFG;

public class Example6 {

	public static void main(String[] args){
		ArrayList<String> nodeNames = new ArrayList<>() ;
		nodeNames.add("A") ; // node 1
		nodeNames.add("B") ; // node 2
		nodeNames.add("C") ; // node 3
		nodeNames.add("D") ; // node 4
		SFG sfg = new SFG(nodeNames) ;
		sfg.addArrow("A", "B", new Complex(3, 1));
		sfg.addArrow("B", "C", new Complex(0, 2));
		sfg.addArrow("C", "A", new Complex(-2, 1));
		
		ArrayList<String> nodeNames1 = new ArrayList<>() ;
		nodeNames1.add("A1") ; // node 1
		nodeNames1.add("B1") ; // node 2
		nodeNames1.add("C1") ; // node 3
		nodeNames1.add("D1") ; // node 4
		SFG sfg1 = new SFG(nodeNames1) ;
		sfg1.addArrow("A1", "B1", new Complex(3, 1));
		sfg1.addArrow("B1", "C1", new Complex(0, 2));
		sfg1.addArrow("C1", "A1", new Complex(-2, 1));
		
		// combining two SFGs
		SFG sfg2 = new SFG(null) ;
		sfg2.append(sfg);
		sfg2.append(sfg1);
		sfg2.addArrow("A", "A1", Complex.ONE);
		sfg2.addArrow("A1", "C", Complex.ONE);
//		System.out.println(sfg2.printAllLoops_noGains());
		System.out.println(sfg2.printAllLoops_compactForm());

	}
}
