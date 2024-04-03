import paqueteDNI.Dni;

import java.time.LocalDate;

public class Empleado {
    //Atributos
    private String codigoEmpleado;
    private Dni dni;
    private String nombre;
    private String apellido;
    private String departamento;
    private double sueldo;
    private LocalDate fechaNacimiento;
    private LocalDate fechaContrato;
    private static final String NOMBRE_EMPRESA = "UmbrellaCorp";
    private static final LocalDate CREACION_EMPRESA = LocalDate.of(2016,05,02);
    public static double ayudaComida;
    public static double vigencia;
    public static int contadorEmpleado = 0000;

    //Constructores

    public Empleado(String codigoEmpleado, Dni dni, String nombre, String apellido, String departamento, double sueldo, LocalDate fechaNacimiento, LocalDate fechaContrato) {
        this.codigoEmpleado = "UMBRE" + contadorEmpleado++;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = departamento;
        this.sueldo = sueldo;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaContrato = fechaContrato;
    }

    public Empleado (Dni dni){
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "codigoEmpleado= " + codigoEmpleado + "," +
                "dni= " + dni.getNIF() + "," +
                "nombre= " + nombre + "," +
                "apellido= " + apellido + "," +
                "departamento= " + departamento + "," +
                "sueldo= " + sueldo + "," +
                "fechaNacimiento= " + fechaNacimiento + "," +
                "fechaContrato= " + fechaContrato
                ;
    }

    
}
