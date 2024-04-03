import paqueteDNI.Dni;

public class EmpleadoMain {
    public static void main(String[] args) {

        Dni dni = new Dni(53814305);

        Empleado empleado1 = new Empleado(dni);

        System.out.println(empleado1);
    }
}