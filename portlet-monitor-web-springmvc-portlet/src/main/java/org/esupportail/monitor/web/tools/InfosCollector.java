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
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.digester3.Digester;
import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


/**
 * 
 * Description : Recuperation des informations du
 * fichier de configuration <br/>
 * 
 * @version Id : InfosCollector.java, V2.0, mars 2013<br/>
 *          Copyright (c) 2002-2013 Esup Portail (www.esup-portail.org)<br/>
 *          Classe(s) : InfosCollector <br/>
 * @author : Mathieu Larchet - Eric Doual - Doriane Duvivier 
 */


public class InfosCollector {
    
	private final Logger logger = new LoggerImpl(getClass());
    
    /**
     * Récupère les informations d'un serveur distant
     * @param s L'objet à remplit
     * @return status vrai si tout se passe bien, faux sinon
     */
	
	
    public static boolean fetch(ServerInfo s, boolean users) {
    	//Ajout pour uPortal 4.3
    	CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
    	
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
