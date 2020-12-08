/*Bibliografía utilizada:
 * Material didactico de la asignatura
 * https://www.udemy.com/course/fundamentos-de-java-aprende-a-programar-java-desde-cero-sin-misterios/?ranMID=39197&ranEAID=hL3Qp0zRBOc&ranSiteID=hL3Qp0zRBOc-BCezaPKFa1oDDdvKNK38qQ&LSNPUBID=hL3Qp0zRBOc&awc=6554_1603217600_822f2f391a496d1154a3e7018166b8eb&utm_source=Growth-Affiliate&utm_medium=Affiliate-Window&utm_campaign=Campaign-Name&utm_term=375095&utm_content=Placement&ranMID=39197&ranEAID=hL3Qp0zRBOc&ranSiteID=hL3Qp0zRBOc-P8VLOZ7rLpz4WhSiuEBaFg&LSNPUBID=hL3Qp0zRBOc&utm_source=aff-campaign&utm_medium=udemyads
 * http://prof.mfbarcell.es/programacion-orientada-objetos/
 * https://www.udemy.com/course/aprende-programacion-en-java-desde-cero/
 * Pildoras Informáticas https://www.youtube.com/watch?v=coK4jM5wvko
*/

public abstract class Dinero {

	// Atributos
	protected double dinero;
    protected String description;

    //Getters y setters
    public void setDescription(String description) {
        this.description = description;
    }
 
    public double getDinero() {
        return dinero;
    }
 
    public String getDescription() {
        return description;
        }
    
    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
}