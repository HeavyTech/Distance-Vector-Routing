import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Router {

	private int size;
	private RouterListener listener;
	private ArrayList<Edge> neighbors;  //Will hold the connections 
	private HashMap<String, HashMap<String,Integer>> routingTable; //This will hold values to display. hold Source, Destination plus Cost 
	private String ip; 
	
	
	
	//
	public Router(int size) throws UnknownHostException{
		this.size = size; // Will hold the amount enters 
		listener = new RouterListener(this);
		listener.start();
		neighbors = new ArrayList<Edge>();
		
		ip = Inet4Address.getLocalHost().getHostName(); // Retrieve the Ip address
	}	

	
	public void addNeighbors(String ip, int cost){
		//Testing
		System.out.println("Adding Neighbour : " + ip);
		
		Edge edge = new Edge(this.ip,ip,cost); //Creates a new Edge with source ip, destination ip and cost
		if(!neighbors.contains(edge)){
			neighbors.add(edge);
		}
		routingTable.put(ip, new HashMap<String,Integer>());
		routingTable.get(ip).put(ip, cost);
		
	}
	
	public void initialize(){
		
		System.out.println("Initializing Routing Tables : ");
		for(Edge edge : neighbors){
			System.out.println("Edge "  + edge.getDestination());
			if(!routingTable.containsKey(edge.getDestination())){
				routingTable.put(edge.getDestination(), new HashMap<String,Integer>());
				routingTable.get(edge.getDestination());
			}
		}
		
	}
	
	public void display(){
		
		System.out.println("Neighbors : ");
		for(Edge edge : neighbors){
			System.out.println(edge.getDestination()+ " ");	
		}
		System.out.println();
		System.out.println(routingTable);
		
	}
	
	public void send() throws UnknownHostException{
		
		while(true){
			for(Edge edge : neighbors){
				try{
					Socket s = new Socket(edge.getDestination(),5555);
					ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
					oos.writeObject(routingTable);
					oos.flush();
					oos.close();
					
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			
			try{
				Thread.sleep(5000);
			}catch(InterruptedException e){
				
			}
		}
	}
	

	public static void main(String[] args) throws UnknownHostException {
		Scanner input = new Scanner(System.in);
		
		
		
		System.out.println("Enter the amout of Routers : ");
		int amount = input.nextInt();
		Router router = new Router(amount);
		

		
		
		
		
	}

}
