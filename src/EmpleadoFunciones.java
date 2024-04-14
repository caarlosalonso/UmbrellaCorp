import paqueteDNI.Dni;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EmpleadoFunciones {

    public static void anadirDatos(ArrayList<Empleado>listaEmpleados){

        Empleado empleado1 = new Empleado(11111111,"Aitor","Tilla","Informática",60000, LocalDate.of(2002,6,30),LocalDate.of(2023,9,1));
        Empleado empleado2 = new Empleado(22222222, "Ester", "Colero","Logistica",34000,LocalDate.of(2000,4,12),LocalDate.of(1980,12,25));
        listaEmpleados.add(empleado1);
        listaEmpleados.add(empleado2);

    }

    public static void mostrarLista(ArrayList<Empleado> listaEmpleados) {
        for (Empleado empleado : listaEmpleados){
            System.out.println(empleado);
        }
    }

    public static void menu(int opcion){
        Scanner teclado = new Scanner(System.in);
        System.out.println("UMBRELLA CORP\n" +
                "1. MOSTRAR TODOS LOS EMPLEADOS\n" +
                "2. DAR DE ALTA UN NUEVO EMPLEADO\n" +
                "3. BUSCAR UN EMPLEADO\n" +
                "4. BUSCAR TODOS LOS EMPLEADOS DE UN DEPARTAMENTO\n" +
                "5. BORRAR UN EMPLEADO\n" +
                "6. SUBIR EL SUELDO A UN EMPLEADO\n" +
                "7. MOSTRAR EL SALARIO DEL MES ACTUAL DE UN EMPLEADO");
    }

    public static void altaEmpleado (ArrayList<Empleado> listaEmpleados){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el DNI de la persona(sin letra): ");
        int dni = teclado.nextInt();

        //Creamos un empleado auxiliar con ese dni.
        Empleado empleadoAux = new Empleado(dni);

        //Comprovamos si el usuario existe.
        int posicion = listaEmpleados.indexOf(empleadoAux);

        if (posicion!=-1){
            System.out.println("El usuario ya existe");
        }else {
            System.out.println("Introduce el nombre del empleado: ");
            String nombre = solicitarDatos();
            System.out.println("Introduce el apellido del empleado: ");
            String apellido = solicitarDatos();
            System.out.println("Introduce el departamento del empleado: ");
            String departamento = solicitarDatos();
            System.out.println("Introduce el sueldo del empleado: ");
            double sueldo = teclado.nextInt();
            try {
                System.out.println("introduce la fecha de nacimiento del empleado: ");
                LocalDate fechaNacimiento = LocalDate.parse(teclado.nextLine());
            }catch (DateTimeParseException e){

            }


        }

    }
    public static String solicitarDatos (){
        Scanner teclado = new Scanner(System.in);

        String introducirDatosRegex = "[A-Z]{15}";
        String datos;
        do {
            datos = teclado.nextLine();
        }while (!Pattern.matches(introducirDatosRegex,datos));
        return datos;
    }

}
