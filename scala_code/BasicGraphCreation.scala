//~ package graphCreation
//~ 
//~ import java.awt.Dimension
//~ import javax.swing.JFrame
//~ import edu.uci.ics.jung.algorithms.layout._
//~ import edu.uci.ics.jung.graph._
//~ import edu.uci.ics.jung.visualization._
//~ import edu.uci.ics.jung.visualization.renderers._
//~ import java.awt.BasicStroke
//~ import java.awt.Color
//~ import java.awt.Dimension
//~ import java.awt.Paint
//~ import java.awt.Stroke
//~ import org.apache.commons.collections15._
//~ import edu.uci.ics.jung.visualization._
//~ import edu.uci.ics.jung.visualization._
//~ import edu.uci.ics.jung.visualization.decorators._
//~ import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel._
//~ 
//~ import kruskal.Kruskal._
//~ 
//~ object Network 
//~ {        
    //~ def networkCreation(graph : List[Edge[Symbol]]) 
    //~ {	
		//~ var g = new UndirectedSparseGraph[Symbol, String]()
		//~ graph.foreach
		//~ { 
			//~ edge =>
			//~ g.addVertex(edge.v1)
			//~ g.addVertex(edge.v2)
			//~ g.addEdge("From " + edge.v1.toString + " to " + edge.v2.toString + " : " + math.BigDecimal(edge.weight).setScale(4, BigDecimal.RoundingMode.HALF_UP).toString, edge.v1, edge.v2)
		//~ }
		//~ 
		//~ 
		//~ var vv =
		  //~ new BasicVisualizationServer[Symbol, String](
			//~ new CircleLayout[Symbol, String](g), new Dimension(1024, 720));
	//~ 
	//~ 
		//~ var vertexPaint = new Transformer[Symbol,Paint]() 
		//~ {
			//~ def transform(i : Symbol) : Paint = 
			//~ {
				//~ return Color.GREEN
			//~ }
		//~ }
		//~ 
		//~ // Set up a new stroke Transformer for the edges
		//~ var dash = Array(10.toFloat)
		//~ var edgeStroke = new BasicStroke(1.toFloat, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.toFloat, dash, 0.toFloat)
		//~ var edgeStrokeTransformer = new Transformer[String, Stroke]() 
		//~ {
			//~ def transform(s : String ): Stroke = 
			//~ {
				//~ return edgeStroke
			//~ }
		//~ }
		//~ 
		//~ vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint)
		//~ vv.getRenderContext().setEdgeStrokeTransformer(edgeStrokeTransformer)
		//~ vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller())
		//~ vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller())
		//~ vv.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR)
	 //~ 
		//~ var frame = new JFrame()
		//~ frame.getContentPane().add(vv)
		//~ frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
		//~ frame.pack()
		//~ frame.setVisible(true)
		//~ 
    //~ }
//~ }
//~ 
