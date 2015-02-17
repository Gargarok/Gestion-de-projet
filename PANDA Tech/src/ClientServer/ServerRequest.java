package ClientServer;
import java.awt.List;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;


public class ServerRequest extends UnicastRemoteObject implements IServerRequest {

	protected ServerRequest() throws RemoteException {
		super();
		connectBdd();
	}


	private FTPClient ftpClient; 
	private String server = "127.0.0.1";
	private int port = 21;
	private String user = "adam";
	private String pass = "smith07";
	private static Connection connexion;


	private static boolean connectBdd(){

		try {

			Class.forName("org.postgresql.Driver");
			System.out.println("DRIVER OK ! ");
			String url = "jdbc:postgresql://localhost:5432/postgres";
			String user = "postgres";
			String passwd = "adamsmith";

			connexion = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connection effective !");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false; 
		}

	}



	private static void showServerReply(FTPClient ftpclient) {
		String[] replies = ftpclient.getReplyStrings();
		if (replies != null && replies.length > 0) {
			for (String aReply : replies) {
				System.out.println("SERVER: " + aReply);
			}
		}
	}


	private void connexionServerFtp() throws SocketException, IOException{

		ftpClient = new FTPClient();
		ftpClient.connect(server, port);
		ftpClient.login(user, pass);
		ftpClient.enterLocalPassiveMode();
		System.out.println("Connexion réussie");
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
	}

	////////telcharger un fichier, remotefile: chemin du fichier à telecharger
	/////////download file:ou mettre le fichier telecharger 
	public boolean DownloadFile(String remotefile,String downloadfile) throws  RemoteException{

		boolean result=false;
		try {
			connexionServerFtp();

			OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadfile));
			boolean success = ftpClient.retrieveFile(remotefile, outputStream1);
			outputStream1.close();

			if (success) {
				System.out.println("File has been downloaded successfully.");
				result=true;
			}else {
				result= false;
			}

			ftpClient.logout();
			ftpClient.disconnect();
			return result;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}



	}
	/////// uploader un fichier, localefile: chemin du fichier à uploader
	//////remotefile: chemin ou mettre le fichier dans le serveur	
	public boolean uploadFichier(String localfile, String remotefile) throws RemoteException{
		boolean result=false;
		try {
			connexionServerFtp();	
			File firstLocalFile = new File(localfile);
			InputStream inputStream = new FileInputStream(firstLocalFile);

			System.out.println("Start uploading first file");
			boolean done = ftpClient.storeFile(remotefile, inputStream);
			inputStream.close();
			if (done) {
				System.out.println("The first file is uploaded successfully.");
				result=true;
			}else{
				System.out.println("the file was not uploaded");
				result= false;
			}
			ftpClient.logout();
			ftpClient.disconnect();
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}    

	}


	///////creer un dossier dans le serveur ftp, 
	//////pathfolser: chemin du dossier, foldername: nom du dossier
	public boolean createFolder(String pathfoder,String foldername) throws RemoteException{
		try {
			connexionServerFtp();
			boolean result=false;
			String dirToCreate = pathfoder+foldername ;
			boolean success = ftpClient.makeDirectory(dirToCreate);
			showServerReply(ftpClient);
			if (success) {
				System.out.println("Successfully created directory: " + dirToCreate);
				result=true;
			} else {
				System.out.println("Failed to create directory. See server's reply.");
				result= false;
			}
			// logs out
			ftpClient.logout();
			ftpClient.disconnect();
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} 
	}

	///executer une requeste
	public boolean executeQuery(String query) throws RemoteException{
		boolean result=false;
		Statement stm;
		try {
			stm = connexion.createStatement();
			stm.execute(query);		
			result=true;
			connexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result= false;
		}

		return result;

	}

	////excuter une requete avec un resultat
	public ArrayList<HashMap<String, Object>> executeQueryRusult(String query) throws RemoteException{
		String[] columNames=null;
		ArrayList<HashMap<String, Object>> result=new ArrayList<HashMap<String,Object>>();
		try {
			Statement stm=connexion.createStatement();	
			ResultSet resultset=stm.executeQuery(query);
			/////obtenir les meta données
			int col=resultset.getMetaData().getColumnCount();
			columNames=new String[col];
			for(int i=1;i<=col;i++){
				columNames[i-1]=resultset.getMetaData().getColumnLabel(i);
			}
			/////remplir la list
			while(resultset.next()){
				HashMap<String, Object> ligne=new HashMap<String, Object>();
				for(int j=1;j<=col;j++){
					ligne.put(columNames[j-1], resultset.getObject(j)); 	
				}
				result.add(ligne);
			}
			connexion.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return result;
	}


}
