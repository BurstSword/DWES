/*Bibliografía utilizada:
 * Material didactico de la asignatura
 * https://www.udemy.com/course/fundamentos-de-java-aprende-a-programar-java-desde-cero-sin-misterios/?ranMID=39197&ranEAID=hL3Qp0zRBOc&ranSiteID=hL3Qp0zRBOc-BCezaPKFa1oDDdvKNK38qQ&LSNPUBID=hL3Qp0zRBOc&awc=6554_1603217600_822f2f391a496d1154a3e7018166b8eb&utm_source=Growth-Affiliate&utm_medium=Affiliate-Window&utm_campaign=Campaign-Name&utm_term=375095&utm_content=Placement&ranMID=39197&ranEAID=hL3Qp0zRBOc&ranSiteID=hL3Qp0zRBOc-P8VLOZ7rLpz4WhSiuEBaFg&LSNPUBID=hL3Qp0zRBOc&utm_source=aff-campaign&utm_medium=udemyads
 * http://prof.mfbarcell.es/programacion-orientada-objetos/
 * https://www.udemy.com/course/aprende-programacion-en-java-desde-cero/
 * Pildoras Informáticas https://www.youtube.com/watch?v=coK4jM5wvko
*/


public class GastoException extends Exception {
 
    // Variable con mensaje de error 
    private String error="";
    public GastoException() {
        this.error="No se puede agregar el gasto debido a que su saldo es insuficiente o cero, compruebe el saldo del que dispone.";
    }
     
    @Override
    public String getMessage(){
        return error;
    }    
}

