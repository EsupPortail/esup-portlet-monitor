package org.esupportail.monitor.web.tools;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.digester3.Digester;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;


/**
 * Config<br>
 * <br>
 * Description<br>
 * <br>
 * (c)Copyright <a href="http://www.esup-portail.org">ESup-Portail 2004</a><br>
 * @author <a href="mailto:mathieu.larchet@univ-nancy2.fr">Mathieu Larchet</a>
 * @version $Revision: 1.0$
 * 
 */

public class Config {
    
    private final Logger logger = new LoggerImpl(getClass());

    private static String configFile = "/listeServers.xml";
    
    private static Config singleton = null;
    
    private List servers = null;
    
    public static synchronized Config getInstance() {
        if(singleton == null) {
            singleton = new Config();
            singleton.parseConfigFile();
        }
        return singleton;
    }
    
    /**
     * Constructeur
     */
    private Config() {
        servers = new ArrayList();
    }
    
    /**
     * Lit le fichier de configuration
     */
    private void parseConfigFile() {
        Digester dig = new Digester();
        dig.push(this);
        
        dig.addCallMethod("config/server", "addServer", 2);
        dig.addCallParam("config/server", 0, "name");
        dig.addCallParam("config/server", 1, "url");
        
        URL resourceURL = Config.class.getResource(configFile);
		if(resourceURL != null) {
		    try {
		        // On parse le fichier dont le chemin est passé en paramètre
				dig.parse(new InputSource(resourceURL.toExternalForm()));
			}
			catch(IOException e) {
				logger.error("Config::parseConfig() : Impossible d'ouvrir le fichier de config \n" + e);
			}
			catch(SAXException e) {
				logger.error("Config::parseConfig() : SAXException :\n" + e);
			} 
			catch(Exception e) {
				logger.error("Config::parseConfig() : Exception :\n" + e);
			}
		}
		else{
		    logger.error("Config::parseConfig() : Le fichier de configuration est introuvable");
		}
    }

    /**
     * Ajoute un nouveau serveur
     * @param name Le nom
     * @param url L'URL
     */
    public void addServer(String name, String url) {
        ServerInfo s = new ServerInfo();
        s.setName(name);
        s.setUrl(url);
        servers.add(s);
    }
    
    /**
     * Retourne la liste des serveurs
     * @return servers
     */
    public List getServers() {
        return servers;
    }
}
