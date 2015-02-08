package vuesclient;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public final class Constante {

	public static Dimension normalsize = new Dimension(200,20);
	
	//-------------------------------------------------------------------
	public static GridBagConstraints getGBC(){
		GridBagConstraints gbc = new GridBagConstraints();
		//case ( gridx , gridy )
		gbc.gridx = 0;
		gbc.gridy = 0;
		//caseoccupé( gridwith , gridheight )
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		//facteur de demande d'espace (0.0 = pas de redimenssion)
		gbc.weightx = 0;
		gbc.weighty = 0;
		//margin ipadx ipady (INTERNE)
		gbc.ipadx = 0;
		gbc.ipady = 0;
		//padding Insets(top, left, bottom, right); (EXTERNE)
		gbc.insets=new Insets(2, 2, 2, 2);
		//anchor = position : CENTER / NORTH / SOUTH / EAST / WEST / NORTHEAST / NORTHWEST / SOUTHEAST / SOUTHWEST
		gbc.anchor = GridBagConstraints.NORTHWEST;
		//fill = remplissage : NONE / HORIZONTAL / VERTICAL / BOTH
		gbc.fill = GridBagConstraints.NONE;
		
		return gbc;
	}
	
	public static String wrapBigLabel(String txt){
		return "<html><div style=\"width:200px;\">"+txt+"</div></html>";
	}
	public static String wrapNormalLabel(String txt){
		return "<html><div style=\"width:100px;\">"+txt+"</div></html>";
	}
	public static String wrapSmallLabel(String txt){
		return "<html><div style=\"width:50px;\">"+txt+"</div></html>";
	}
}
