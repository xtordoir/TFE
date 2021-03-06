package graphicalLearning

import javax.swing.JFrame
import javax.swing.JMenu
import javax.swing.JMenuBar
import edu.uci.ics.jung.algorithms.layout._
import edu.uci.ics.jung.graph._
import edu.uci.ics.jung.visualization._
import edu.uci.ics.jung.visualization.renderers._
import java.awt.BasicStroke
import java.awt.Color
import java.awt.Dimension
import java.awt.Paint
import java.awt.Stroke
import org.apache.commons.collections15._
import edu.uci.ics.jung.visualization._
import edu.uci.ics.jung.visualization._
import edu.uci.ics.jung.visualization.decorators._
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel._
import edu.uci.ics.jung.visualization.VisualizationViewer
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse
import edu.uci.ics.jung.visualization.control._
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller
import org.apache.commons.collections15.Factory

import graphicalLearning.Kruskal._

object Network 
{        
    def networkCreation(graph : List[Edge[Symbol]]) 
    {	
		var g = new UndirectedSparseGraph[Symbol, String]()
		graph.foreach
		{ 
			edge =>
			g.addVertex(edge.v1)
			g.addVertex(edge.v2)
			g.addEdge("From " + edge.v1.toString + " to " + edge.v2.toString + " : " + math.BigDecimal(edge.weight).setScale(4, BigDecimal.RoundingMode.HALF_UP).toString, edge.v1, edge.v2)
		}
		
		var layout = new CircleLayout(g)
		
		layout.setSize(new Dimension(800,600));
		var vv = new VisualizationViewer[Symbol,String](layout)
		
		vv.setPreferredSize(new Dimension(800,600))
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller())
		vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller())
		var gm = new DefaultModalGraphMouse()
		gm.setMode(ModalGraphMouse.Mode.TRANSFORMING)
		vv.setGraphMouse(gm)

	
		var vertexPaint = new Transformer[Symbol,Paint]() 
		{
			def transform(i : Symbol) : Paint = 
			{
				return Color.GREEN
			}
		}
		
		// Set up a new stroke Transformer for the edges
		var dash = Array(10.toFloat)
		var edgeStroke = new BasicStroke(1.toFloat, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.toFloat, dash, 0.toFloat)
		var edgeStrokeTransformer = new Transformer[String, Stroke]() 
		{
			def transform(s : String ): Stroke = 
			{
				return edgeStroke
			}
		}
		
		vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint)
		vv.getRenderContext().setEdgeStrokeTransformer(edgeStrokeTransformer)
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller())
		vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller())
		vv.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR)
	 
	 
        var frame = new JFrame("Editing and interactive Graph Viewer 1")
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        frame.getContentPane().add(vv)
        
        // It adds a menu for changing mouse modes
        var menuBar = new JMenuBar()
        var modeMenu = gm.getModeMenu()
        modeMenu.setText("Mouse Mode")
        modeMenu.setIcon(null)
        modeMenu.setPreferredSize(new Dimension(150,30)); // Change the size so I can see the text
        
        menuBar.add(modeMenu)
        frame.setJMenuBar(menuBar)
        gm.setMode(ModalGraphMouse.Mode.EDITING) // Start off in editing mode
        frame.pack()
        frame.setVisible(true)
    }
}

