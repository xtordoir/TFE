package graphicalLearning

import java.awt.Dimension
import javax.swing.JFrame
import edu.uci.ics.jung.algorithms.layout._
import edu.uci.ics.jung.graph._
import edu.uci.ics.jung.visualization._

import graphicalLearning.Kruskal._

object Graph 
{        
    def graph(graph : List[Edge[Symbol]]) 
    {	
		var g = new UndirectedSparseGraph[Symbol, Double]();
		graph.foreach
		{ 
			edge =>
			g.addVertex(edge.v1)
			g.addVertex(edge.v2)
			g.addEdge(edge.weight, edge.v1, edge.v2)
		}
		var vs =
		  new VisualizationImageServer[Symbol, Double](
			new CircleLayout[Symbol, Double](g), new Dimension(200, 200));
	 
		var frame = new JFrame();
		frame.getContentPane().add(vs);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
    }
}

