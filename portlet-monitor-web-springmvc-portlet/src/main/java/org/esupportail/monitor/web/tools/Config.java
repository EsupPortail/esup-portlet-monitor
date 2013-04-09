/**
 * Copyright  2002-2013 ESUP-portail consortium
 * This program is free software; you can redistribute 
 * it and/or modify it under the terms of the GNU 
 * General Public License as published by the Free 
 * Software Foundation augmented according to the
 * possibility of using it with programs developped under 
 * the Apache licence published by the Apache Software Foundation.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 *  IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY 
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, 
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * See the license terms site for more details : 
 * http://www.esup-portail.org/license.html
 */
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
 * 
 * Description : Recuperation des informations du
 * fichier de configuration <br/>
 * 
 * @version Id : Config.java, V2.0, mars 2013<br/>
 *          Copyright (c) 2002-2013 Esup Portail (www.esup-portail.org)<br/>
 *          Classe(s) : Config <br/>
 * @author : Mathieu Larchet - Eric Doual - Doriane Duvivier 
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
