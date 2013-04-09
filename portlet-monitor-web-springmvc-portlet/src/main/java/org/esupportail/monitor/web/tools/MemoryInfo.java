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

public class MemoryInfo {


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
    //	System.out.println("max avant traitement::"+max);
    	this.max = ToMegaOctet(max);
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
    //	System.out.println("total avant traitement::"+total);
        this.total = ToMegaOctet(total);
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
    //	System.out.println("free avant traitement::"+free);
    	this.free = ToMegaOctet(free);
    }
    
    /**
     * Insère des espaces dans une chaine numérique
     * @param s La chaine à modifier
     * @return s La chaine modifiée
     */
    private String ToMegaOctet(String s) {
    	Float test = Float.valueOf(s);
    	//System.out.println("test de transformation en Float :: "+test);
    	Float res = test / 1024;
    	//System.out.println("test de division:: "+res);
    	res = res / 1024 ;
    //	System.out.println("2eme test de division:: "+res);
    	Integer result = new Integer(res.intValue());
    //	System.out.println("en entier:: "+result);
    //	System.out.println("en String:: "+result.toString());
    	return result.toString();
    }
 
}
