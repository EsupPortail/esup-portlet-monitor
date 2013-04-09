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



/**
 * 
 * Description : Les informations sur les sessions <br/>
 * 
 * @version Id : SessionInfo.java, V2.0, mars 2013<br/>
 *          Copyright (c) 2002-2013 Esup Portail (www.esup-portail.org)<br/>
 *          Classe(s) : SessionInfo <br/>
 * @author : Mathieu Larchet - Eric Doual - Doriane Duvivier 
 */


public class SessionInfo  {

    
    private String connected = null;
    private String guest = null;
    private String total = null;
    
    /**
     * Constructeur
     */
    public SessionInfo() {
    }
    
    /**
     * Retourne le nombre d'utilisateurs connectés
     * @return connected
     */
    public String getConnected() {
        return connected;
    }
    
    /**
     * Positionne le nombre d'utilisateurs connectés
     * @param connected
     */
    public void setConnected(String connected) {
        this.connected = connected;
    }
    
    /**
     * Retourne le nombre d'anonymes
     * @return guest
     */
    public String getGuest() {
        return guest;
    }
    
    /**
     * Positionne le nombre d'anonymes
     * @param guest
     */
    public void setGuest(String guest) {
        this.guest = guest;
    }
    
    /**
     * Retourne le nombre total
     * @return total
     */
    public String getTotal() {
        return total;
    }
    
    /**
     * Positionne le total 
     * @param total
     */
    public void setTotal(String total) {
        this.total = total;
    }

}
