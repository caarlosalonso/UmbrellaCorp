import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Carlos Alonso, David Rodrigues
 */
public class EmpleadoMain {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        EmpleadoFunciones.anadirDatos(listaEmpleados);

        int opcion;
        do {
            EmpleadoFunciones.menu();
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    EmpleadoFunciones.mostrarLista(listaEmpleados);
                    break;
                case 2:
                    EmpleadoFunciones.altaEmpleado(listaEmpleados);
                    break;
                case 3:
                    EmpleadoFunciones.buscarEmpleado(listaEmpleados);
                    break;
                case 4:
                    EmpleadoFunciones.buscarDepartamento(listaEmpleados);
                    break;

                case 5:
                    EmpleadoFunciones.borrarEmpleado(listaEmpleados);
                    break;

                case 6:
                    EmpleadoFunciones.subirSueldo(listaEmpleados);
                    break;

                case 7:
                    EmpleadoFunciones.mostrarSalarioMesActual(listaEmpleados);
                    break;
            }
        }while (opcion!=8);
    }
}