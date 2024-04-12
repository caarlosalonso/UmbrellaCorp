package paqueteDNI;

public class Dni {
    private int dni;
    private static final String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

    public Dni(int dni) {
        this.dni = dni;
    }

    public int getDNI() {
        return dni;
    }
    public String getNIF() {
        int resto = dni % 23;

        return String.valueOf(dni) +
                letras.charAt(resto);
    }

    public void setDni(int dni) throws NifIntroducidoException, DniLongitudErroneaException {

        if (String.valueOf(dni).length() > 8){
            this.dni = dni;
        }else {
            throw new DniLongitudErroneaException("El DNI tiene que ser de 8 digitos o menos (12345678)");
        }
    }

    public static char calcularLetraNIF (int dni){
        return letras.charAt(dni%23);
    }
    public static boolean validarNIF (String nif){
        int dniNumeros = extraerNumerosNIF(nif);
        char dniLetra = extraerLetraNIF(nif);
        return dniLetra == calcularLetraNIF(dniLetra);
    }
    public static char extraerLetraNIF (String nif){
        return nif.charAt(nif.length()-1);
    }
    public static int extraerNumerosNIF (String nif){
        StringBuilder newNif = new StringBuilder(nif);
        newNif.deleteCharAt(nif.length());

        return Integer.parseInt(String.valueOf(newNif));
    }
}