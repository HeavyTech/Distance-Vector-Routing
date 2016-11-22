import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Router {

	private int size;
	private RouterListener listener;
	private ArrayList<Edge> neighbors;  //Will hold the connections 
	private String ip; 
	
	
	
	//
	public Router() throws UnknownHostException{
		size = 4; //Will hold 4 computers
		listener = new RouterListener(this);
		listener.start();
		neighbors = new ArrayList<Edge>();
		
		ip = Inet4Address.getLocalHost().getHostName(); // Retrieve the Ip address 
	}	

	
	

	public static void main(String[] args) {
		
		
		
		
	}

}
