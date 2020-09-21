import java.util.regex.Pattern;

public class DatosNoCorrectosException extends Exception{
    public DatosNoCorrectosException(String message) {
        super(message);
    }

    public static int categoriaIncorrecta(int categoria) throws DatosNoCorrectosException{
        if(categoria<1 ||categoria>10){
            throw new DatosNoCorrectosException("Categoria inexistente");
        }else{
            return categoria;
        }

    }
    public static String dniIncorrecto(String dni) throws DatosNoCorrectosException{
        if(Pattern.matches("(\\d{8})([-]?)([A-Z]{1})",dni)){
            throw new DatosNoCorrectosException("Formato DNI incorrecto");
        }
        return dni;
    }
    public static char sexoIncorrecto(String sexo){
        if(Pattern.matches())
    }
}
