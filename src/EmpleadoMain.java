import paqueteDNI.Dni;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class EmpleadoMain {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        EmpleadoFunciones.anadirDatos(listaEmpleados);
/*
        Empleado empleado1 = new Empleado(11111111,"Aitor","Tilla","Informática",60000, LocalDate.of(2002,4,30),LocalDate.of(2018,9,1));

        empleado1.VigenciaEmpresa();
        empleado1.cumpleMes();
        empleado1.sueldoMensual();
        empleado1.mostrarTodo();
*/

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

                    break;

                case 6:

                    break;
            }
        }while (opcion!=6);
    }
}