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
 * Description : Les informations sur les memoires <br/>
 * 
 * @version Id : MemoryInfo.java, V2.0, mars 2013<br/>
 *          Copyright (c) 2002-2013 Esup Portail (www.esup-portail.org)<br/>
 *          Classe(s) : MemoryInfo <br/>
 * @author : Mathieu Larchet - Eric Doual - Doriane Duvivier 
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
    	this.free = ToMegaOctet(free);
    }
    
    /**
     * Insère des espaces dans une chaine numérique
     * @param s La chaine à modifier
     * @return s La chaine modifiée
     */
    private String ToMegaOctet(String s) {
    	Float test = Float.valueOf(s);
    	Float res = test / 1024;
    	res = res / 1024 ;
    	Integer result = new Integer(res.intValue());
    	return result.toString();
    }
 
}
