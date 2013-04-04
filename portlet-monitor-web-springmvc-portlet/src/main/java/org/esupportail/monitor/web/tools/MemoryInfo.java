package org.esupportail.monitor.web.tools;

/**
 * MemoryInfo<br>
 * <br>
 * Description<br>
 * <br>
 * (c)Copyright <a href="http://www.esup-portail.org">ESup-Portail 2004</a><br>
 * @author <a href="mailto:mathieu.larchet@univ-nancy2.fr">Mathieu Larchet</a>
 * @version $Revision: 1.0$
 * 
 */

public class MemoryInfo implements XMLSerializable {


    private String max = null;
    private String total = null;
    private String free = null;
    
    /**
     * Constructeur
     */
    public MemoryInfo() {
    }
    
    /**
     * Retourne le maximum
     * @return max
     */
    public String getMax() {
        return max;
    }
    
    /**
     * Positionne le maximum 
     * @param max
     */
    public void setMax(String max) {
        this.max = max;
    }
    
    /**
     * Retourne la valeur courante
     * @return total
     */
    public String getTotal() {
        return total;
    }
    
    /**
     * Positionne la valeur courante
     * @param total
     */
    public void setTotal(String total) {
        this.total = total;
    }
    
    /**
     * Retourne la valeur libre
     * @return free
     */
    public String getFree() {
        return free;
    }
    
    /**
     * Positionne la valeur libre 
     * @param free
     */
    public void setFree(String free) {
        this.free = free;
    }
    
    /**
     * Insère des espaces dans une chaine numérique
     * @param s La chaine à modifier
     * @return s La chaine modifiée
     */
    private String wrapNumericValue(String s) {
        StringBuffer res = new StringBuffer();
        for(int i=7;i<=s.length();i++) {
            res.append(s.charAt(s.length() - i));
        }
        res = res.reverse();
        return res.toString();
    }
    
    /**
     *
     */
    public String toXMLString() {
        StringBuffer xml = new StringBuffer();
        xml.append("<memory max=\"");
        xml.append(wrapNumericValue(getMax()));
        xml.append("\" total=\"");
        xml.append(wrapNumericValue(getTotal()));
        xml.append("\" free=\"");
        xml.append(wrapNumericValue(getFree()));
        xml.append("\" />\n");
        return xml.toString();
    }
}
