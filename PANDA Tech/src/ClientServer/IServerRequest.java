package ClientServer;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;


public interface IServerRequest extends Remote {

	public boolean DownloadFile(String remotefile,String downloadfile) throws RemoteException;
	public  boolean uploadFichier(String localfile, String remotefile) throws RemoteException;
	public boolean createFolder(String pathfoder,String foldername) throws RemoteException;
	public boolean executeQuery(String query)throws RemoteException;
	public ArrayList<HashMap<String, Object>> executeQueryRusult(String query)throws RemoteException;
}
