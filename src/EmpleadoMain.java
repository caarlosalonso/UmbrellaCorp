import paqueteDNI.Dni;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmpleadoMain {
    public static void main(String[] args) {

        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        EmpleadoFunciones.anadirDatos(listaEmpleados);

        Empleado empleado1 = new Empleado(11111111,"Aitor","Tilla","Informática",60000, LocalDate.of(2002,4,30),LocalDate.of(2018,9,1));

        empleado1.VigenciaEmpresa();
        empleado1.cumpleMes();
        empleado1.sueldoMensual();
        empleado1.mostrarTodo();

    }
}