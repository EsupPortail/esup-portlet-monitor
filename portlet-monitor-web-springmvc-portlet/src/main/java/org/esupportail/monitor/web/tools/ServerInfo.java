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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * Description : Les informations renvoyees pour un serveur
 * declare dans le fichier de configuration <br/>
 * 
 * @version Id : ServerInfo.java, V2.0, mars 2013<br/>
 *          Copyright (c) 2002-2013 Esup Portail (www.esup-portail.org)<br/>
 *          Classe(s) : ServerInfo <br/>
 * @author : Mathieu Larchet - Eric Doual - Doriane Duvivier 
 */

public class ServerInfo  {


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
}
