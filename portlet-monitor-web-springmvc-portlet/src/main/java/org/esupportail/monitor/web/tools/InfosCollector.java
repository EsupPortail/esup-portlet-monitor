package org.esupportail.monitor.web.tools;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.digester3.Digester;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
/**
 * InfosCollector<br>
 * <br>
 * Description<br>
 * <br>
 * (c)Copyright <a href="http://www.esup-portail.org">ESup-Portail 2004</a><br>
 * @author <a href="mailto:mathieu.larchet@univ-nancy2.fr">Mathieu Larchet</a>
 * @version $Revision: 1.0$
 * 
 */

public class InfosCollector {
    
	private final Logger logger = new LoggerImpl(getClass());
    
    /**
     * Récupère les informations d'un serveur distant
     * @param s L'objet à remplit
     * @return status vrai si tout se passe bien, faux sinon
     */
    public static boolean fetch(ServerInfo s, boolean users) {
        
    	Digester dig = new Digester();
        dig.push(s);
        
        dig.addObjectCreate("runtimeinfo/memory", MemoryInfo.class);
        dig.addSetProperties("runtimeinfo/memory");
        dig.addSetNext("runtimeinfo/memory", "setMemory");
        
        dig.addObjectCreate("runtimeinfo/sessions", SessionInfo.class);
    	dig.addSetProperties("runtimeinfo/sessions");
    	dig.addSetNext("runtimeinfo/sessions", "setSession");
        
        dig.addCallMethod("runtimeinfo/users/user", "addUser", 1);
        dig.addCallParam("runtimeinfo/users/user", 0, "uid");
        
        URL ressourceUrl = null;
        try {
            if(users) {
                ressourceUrl = new URL(s.getUrl() + "?xml=full");
            }
            else {
                ressourceUrl = new URL(s.getUrl() + "?xml");
            }
        }
        catch(MalformedURLException e) {
          //  logger.error(e);
            System.out.print (e+"\n" );
            return false;
        }
        if(ressourceUrl != null) {
            try {
		        // On parse le fichier dont le chemin est passé en paramètre
				dig.parse(new InputSource(ressourceUrl.toExternalForm()));
				
			}
			catch(IOException e) {
				//logger.error("InfosCollector::fetch() : Impossible d'ouvrir l'URL \n" + e);
				System.out.print ("InfosCollector::fetch() : Impossible d'ouvrir l'URL \n" + e);
				return false;
			}
			catch(SAXException e) {
			    //logger.error("InfosCollector::fetch() : SAXException :\n" + e);
			    System.out.print ("InfosCollector::fetch() : SAXException :\n" + e);
			    return false;
			} 
			catch(Exception e) {
			    //logger.error("InfosCollector::fetch() : Exception :\n" + e);
			    System.out.print ("InfosCollector::fetch() : Exception :\n" + e);
			    return false;
			}
        }
        else {
            //logger.error("InfosCollector::fetch() : L'URL est introuvable");
            System.out.print ("InfosCollector::fetch() : L'URL est introuvable");
            return false;
        }
        return true;
    }
}
