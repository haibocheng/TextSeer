package textSeer.Model;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Vertex {

  public long marker = 1;	// used for xor splits in breath first search
  public TreeMap<Integer, String> visited;	// Graph ID 
  public static int totalVertices = 0;

  public int id = totalVertices++;;
  
  public String name = "";

  public TreeMap<String, Effect> CE;

  public Effect IE;

  public std.type.Node nodeType;

  public Object subNodeType;

  public List<Vertex> inNodes;

  public List<Vertex> outNodes;

  public List<SequenceEdge> inEdges;

  public List<SequenceEdge> outEdges;

  public Graph  parent;

  public void markVisited(Graph pGraph){
	  if(pGraph != null){
		  visited.remove(pGraph.ID);
		  visited.put(pGraph.ID, std.string.visted);
	  }
  }
  
  public boolean isVisited(Graph pGraph){
	  if(pGraph != null){
		  String result = visited.get(pGraph.ID);
		  
		  if(result.equals(std.string.visted))
			  return true;
		  else
			  return false;
	  }
	  return true;
  }
  
  public void init(){
	  visited = new TreeMap<Integer, String >();
	  if(parent != null)
		  visited.put(parent.ID, std.string.not_visited);
	  id = ++totalVertices;
	  inNodes = new LinkedList<Vertex>();
	  outNodes = new LinkedList<Vertex>();

	  inEdges = new LinkedList<SequenceEdge>();
	  outEdges = new LinkedList<SequenceEdge>();
	  IE = null;
	  

  }
  
  public Vertex(Graph myParent){
	  init();
	  parent = myParent;
	  name = generateName();
 }
 
  public Vertex(Graph myParent, String newName){
	  init();
	  parent = myParent;
	  name = newName;
  }
  
  public void addEffect(Effect e){
	  IE = e;
  }
 
  
  public String generateName() {
	  return "Vertex" + id; 
  }

  

  public void getCE() {
  }

  public void getIE() {
  }

  public String toString() {
	  String returnString = "";
	  returnString += "Vertex name: " + name + "(" +id + ")" + std.string.endl;
	  if(IE != null){
		  returnString += "\tEffects: " + IE.toString() +  std.string.endl;
	  }
	  
	  if(inNodes != null){
		  returnString += "\tInNodes: ";
		  for(Vertex in:inNodes){
			returnString += in.name + "(" + in.id + "), ";  
		  }
		// Cut final comma ;) and add a new line
		  returnString = returnString.substring(0, returnString.length()-2) + std.string.endl; 
	  }
	  if(outNodes != null){
		  returnString += "\tOutNodes: ";
		  for(Vertex in:outNodes){
			returnString += in.name + "(" + in.id + "), ";  
		  }
		  // Cut final comma ;) and add a new line
		  returnString = returnString.substring(0, returnString.length()-2) + std.string.endl; 
	  }
	  
	  
	  return returnString;
  }

}