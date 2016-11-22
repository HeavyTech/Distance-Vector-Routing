
public class Edge {
	
	
	private String source;
	private String destination;
	private int cost;

	public Edge(String source, String destination, int cost){
		this.source = source;
		this.destination = destination;
		this.cost = cost;

		
	}
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public String toString(){
		String edge = "";
		edge = "Incoming IP: " + getSource() + "\n" +
		       "Destination IP: " + getDestination() + "\n" + 
			   "Total Cost " + getCost();
		
		return edge;
	}

}
