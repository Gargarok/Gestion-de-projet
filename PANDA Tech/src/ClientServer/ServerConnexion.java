package ClientServer;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;


public class ServerConnexion {

	
	public static void main(String[] args) throws RemoteException{
		
		LocateRegistry.createRegistry(1099);
		
		System.setProperty("java.security.policy","sec.policy");
		System.setSecurityManager(new RMISecurityManager());
		try{
	    
        IServerRequest iservicerequest=new ServerRequest ();
		Naming.rebind("rmi://localhost:1099/book", iservicerequest);
		System.out.println("izan");
		}catch(Exception e){System.out.println(e);}
//		
//		IServerRequest servicerequest=new ServerRequest();
//		//servicerequest.uploadFichier("F:/CV_adam.rtf", "/vd.rtf");
//		//servicerequest.executeQuery("insert into role values ('adam','smith')");
//		
//		ArrayList<HashMap<String, Object>> result=servicerequest.executeQueryRusult("select * from role");
//		for( java.util.Map.Entry<String, Object> map :result.get(0).entrySet()){
//		System.out.println(map.getKey().toString()+"            "+map.getValue().toString());
//		}
//	    System.out.println(result.get(1).get("rlname"));
	}
	
	
}
