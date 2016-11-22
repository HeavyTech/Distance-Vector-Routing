import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
public class RouterListener extends Thread{
	
	ServerSocket ss;
	Router router;
	
	
	public RouterListener(Router router){
		
		this.router = router;  //Our Computer  is a out router 
		
		try{
			ss = new ServerSocket(5555);   // trying to connect a Socket using port 5555
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	public void run(){
		
		while(true){
			
			
			try{
				Socket s = ss.accept();  //Listening to socket and waiting to accept. 
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				Object data = ois.readObject();
			//	router.update(data,s.getInetAddress().getHostAddress());

				
			}catch(IOException | ClassNotFoundException e){
				e.printStackTrace();
			}
			
			
			
			
			
		}
		
		
		
		
		
	}

}
