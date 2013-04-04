package org.esupportail.monitor.web.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * ServerInfo<br>
 * <br>
 * Description<br>
 * <br>
 * (c)Copyright <a href="http://www.esup-portail.org">ESup-Portail 2004</a><br>
 * @author <a href="mailto:mathieu.larchet@univ-nancy2.fr">Mathieu Larchet</a>
 * @version $Revision: 1.0$
 * 
 */

public class ServerInfo implements XMLSerializable {


    private String name = null;
    private String url = null;
    private MemoryInfo memory = null;
    private SessionInfo session = null;
    private List users = null;
    
    /**
     * Constructeur
     */
    public ServerInfo() {
        users = new ArrayList();
    }
    
    /**
     * Retourne le nom
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Positionne le nom 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Retourne l'URL
     * @return url
     */
    public String getUrl() {
        return url;
    }
    
    /**
     * Positionne l'URL 
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
    /**
     * Retourne l'état mémoire
     * @return memory
     */
    public MemoryInfo getMemory() {
        return memory;
    }
    
    /**
     * Positionne l'état mémoire 
     * @param memory
     */
    public void setMemory(MemoryInfo memory) {
        this.memory = memory;
    }
    
    /**
     * Retourne les infos de session
     * @return session
     */
    public SessionInfo getSession() {
        return session;
    }
    
    /**
     * Positionne les infos de session
     * @param session
     */
    public void setSession(SessionInfo session) {
        this.session = session;
    }
   
    /**
     * Retourne la liste des utilisateurs
     * @return users
     */
    public List getUsers() {
        Collections.sort(users);
        return users;
    }
    
    /**
     * Positionne la liste des utilisateurs 
     * @param users
     */
    public void addUser(String user) {
        if(!users.contains(user)) {
            users.add(user);
        }
    }
    
    /**
     *
     */
    public String toXMLString() {
        StringBuffer xml = new StringBuffer();
        xml.append("<server name=\"");
        xml.append(getName());
        xml.append("\" url=\"");
        xml.append(getUrl());
        xml.append("\" >\n");
        xml.append(getSession().toXMLString());
        xml.append(getMemory().toXMLString());
        xml.append("<users>\n");
        for(Iterator i = getUsers().iterator();i.hasNext();) {
            String user = (String)i.next();
            xml.append("<user id=\"");
            xml.append(user);
            xml.append("\" />\n");
        }
        xml.append("</users>\n");
        xml.append("</server>\n");
        return xml.toString();
    }
}
