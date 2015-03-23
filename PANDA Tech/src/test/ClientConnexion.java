package test;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.UIManager;

import frames.MainFrame;


public class ClientConnexion {

	public static IServerRequest iserverrequest;
	
	public static void main(String[] args) {
		try{
			String codebase="file:///C:/workSpaceLuna/GestionProjet/src/";
			System.setProperty("java.security.policy","sec.policy");
			System.setProperty("java.rmi.server.codebase",codebase); 
			System.setSecurityManager(new RMISecurityManager());
			iserverrequest=(IServerRequest) Naming.lookup("rmi://localhost:1099/book");
			
//			ArrayList<HashMap<String, Object>> result=iserverrequest.executeQueryRusult("select * from role");
//			for( java.util.Map.Entry<String, Object> map :result.get(0).entrySet()){
//			System.out.println(map.getKey().toString()+"            "+map.getValue().toString());
//			}
//		    System.out.println(result.get(1).get("rlname"));
		    
		   // iserverrequest.uploadFichier("C:/Users/partenair_info/Desktop/MDP.docx", "MDP.docx");
		   //iserverrequest.DownloadFile("MDP.docx", "C:/Users/partenair_info/Desktop/MDPPP.docx");
		   //iserverrequest.createFolder("", "folder1");
		   //iserverrequest.DownloadFile("Section1.docx", "C:/Users/partenair_info/Desktop/Chapitre1.docx");
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			MainFrame f=new MainFrame();
			f.setVisible(true);
			
			
			
		}catch(Exception e)
		{System.out.println(e);}
		
	}


	}


