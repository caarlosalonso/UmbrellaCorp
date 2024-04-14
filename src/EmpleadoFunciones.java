import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EmpleadoFunciones {

    public static void anadirDatos(ArrayList<Empleado> listaEmpleados) {

        Empleado empleado1 = new Empleado(11111111, "Aitor", "Tilla", "Informática", 60000, LocalDate.of(2002, 6, 30), LocalDate.of(2023, 9, 1));
        Empleado empleado2 = new Empleado(22222222, "Ester", "Colero", "Logistica", 34000, LocalDate.of(2000, 4, 12), LocalDate.of(1980, 12, 25));
        listaEmpleados.add(empleado1);
        listaEmpleados.add(empleado2);

    }

    public static void mostrarLista(ArrayList<Empleado> listaEmpleados) {
        for (Empleado empleado : listaEmpleados) {
            empleado.mostrarTodo();
        }
    }

    public static void menu() {
        System.out.println("UMBRELLA CORP\n" +
                "1. MOSTRAR TODOS LOS EMPLEADOS\n" +
                "2. DAR DE ALTA UN NUEVO EMPLEADO\n" +
                "3. BUSCAR UN EMPLEADO\n" +
                "4. BUSCAR TODOS LOS EMPLEADOS DE UN DEPARTAMENTO\n" +
                "5. BORRAR UN EMPLEADO\n" +
                "6. SUBIR EL SUELDO A UN EMPLEADO\n" +
                "7. MOSTRAR EL SALARIO DEL MES ACTUAL DE UN EMPLEADO");
    }

    public static void altaEmpleado(ArrayList<Empleado> listaEmpleados) {
        Scanner teclado = new Scanner(System.in);
        int dni = 0;
        double sueldo=0;
        LocalDate fechaNacimiento=LocalDate.now();

        DateTimeFormatter esDateFormat=
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        boolean dniValido=false;
        boolean sueldoValido=false;
        boolean fechaNacimientoValido=false;

        //Bucle que se repite en caso de que el formato de dni sea incorrecto
        while(!dniValido) {
            try {
                System.out.println("Introduce el DNI de la persona(sin letra): ");
                dni = teclado.nextInt();
                dniValido = true; //Se marca como true si no se lanza ninguna excepcion
            } catch (InputMismatchException e) {
                System.out.println("DNI Incorrecto!");
                teclado.nextLine();
            }
        }
        //Creamos un empleado auxiliar con ese dni.
        Empleado empleadoAux = new Empleado(dni);

        //Comprobamos si el usuario existe.
        int posicion = listaEmpleados.indexOf(empleadoAux);

        //Si la posición es distinta de -1 significa que ya existe
        if (posicion != -1) {
            System.out.println("El usuario ya existe");
        } else {
            System.out.println("Introduce el nombre del empleado: ");
            String nombre = solicitarDatos();
            System.out.println("Introduce el apellido del empleado: ");
            String apellido = solicitarDatos();
            System.out.println("Introduce el departamento del empleado: ");
            String departamento = solicitarDatos();

            while (!sueldoValido || sueldo>60000) {
                try {
                    System.out.println("Introduce el sueldo del empleado: ");
                    sueldo = teclado.nextInt();
                    sueldoValido=true; //Se marca como true si el formato de sueldo es valido
                } catch (InputMismatchException e) {
                    System.out.println("Formato incorrecto!");
                    teclado.nextLine();
                }
                teclado.nextLine();
            }

            while (!fechaNacimientoValido) {
                try {
                    System.out.println("Introduce la fecha de nacimiento del empleado: ");
                    fechaNacimiento = LocalDate.parse(teclado.nextLine(),
                            DateTimeFormatter.ofPattern("d/M/yyyy"));

                    //fechaNacimiento.format(esDateFormat);

                    fechaNacimientoValido =true; //Se marca como true si el formato de la fecha es correcto
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de fecha incorrecto!");
                }

            }
            //Creamos un nuevo empleado con los datos introducidos.
            Empleado nuevoEmpleado = new Empleado(dni, nombre, apellido, departamento, sueldo, fechaNacimiento, LocalDate.now());
            listaEmpleados.add(nuevoEmpleado);
            System.out.println("Se ha añadido el empleado con dni: " + dni);

            empleadoAux.mostrarTodo();
        }
    }

    public static String solicitarDatos() {
        Scanner teclado = new Scanner(System.in);

        String introducirDatosRegex = "[A-Z]{1,15}";
        String datos;
        do {
            datos = teclado.nextLine().toUpperCase();
        } while (!Pattern.matches(introducirDatosRegex, datos));
        return datos;
    }

    public static void buscarEmpleado(ArrayList<Empleado> listaEmpleados){
        Scanner teclado = new Scanner(System.in);

        String codigoEmpleado="UMBRE01";
        boolean codigoEmpleadoValido=false;

        //Bucle que se repite en caso de que el formato de dni sea incorrecto
        while(!codigoEmpleadoValido) {
            try {
                System.out.println("Introduce el codigo de empleado de la persona: ");
                codigoEmpleado = teclado.nextLine();
                codigoEmpleadoValido = true; //Se marca como true si no se lanza ninguna excepcion
            } catch (InputMismatchException e) {
                System.out.println("Codigo de empleado Incorrecto!");
                teclado.nextLine();
            }
            //Creamos un empleado auxiliar solo con el dni
            Empleado empleadoAux = new Empleado(codigoEmpleado);

            //Obtenemos la posicion en la que se encuentra el empleado original
            int posicion = listaEmpleados.indexOf(empleadoAux);

            if(posicion!=-1) {
                //Creamos otro objeto Empleado que obtiene la posicion del real (dado por el auxiliar)
                //y lo mostramos utilizando el metodo 'mostrarTodo'
                Empleado empleadoEncontrado = listaEmpleados.get(posicion);
                empleadoEncontrado.mostrarTodo();
            }else {
                System.out.println("El usuario no existe");
            }
        }
    }

}
