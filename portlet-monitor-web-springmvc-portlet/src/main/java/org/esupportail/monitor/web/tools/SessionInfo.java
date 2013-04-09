package org.esupportail.monitor.web.tools;



/**
 * SessionInfo<br>
 * <br>
 * Description<br>
 * <br>
 * (c)Copyright <a href="http://www.esup-portail.org">ESup-Portail 2004</a><br>
 * @author <a href="mailto:mathieu.larchet@univ-nancy2.fr">Mathieu Larchet</a>
 * @version $Revision: 1.0$
 * 
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
