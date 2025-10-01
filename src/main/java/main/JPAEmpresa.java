package main;


import DAO.empleadoDAO;
import Modelo.Empleado;
import Modelo.Estatus;
import interfaces.IEmpleadoDAO;
import java.time.LocalDate;
import java.util.List;
import util.JPAUTIL;

public class JPAEmpresa {

    public static void main(String[] args) {
        IEmpleadoDAO empleadoDAO = new empleadoDAO();

        System.out.println("--- 1. Insertando nuevos empleados ---");
        empleadoDAO.insertar(new Empleado("Ana Solis", "ana.s@example.com", 3200.0, Estatus.ACTIVO, LocalDate.now()));
        empleadoDAO.insertar(new Empleado("Juan Perez", "juan.p@example.com", 3500.0, Estatus.ACTIVO, LocalDate.of(2022, 5, 10)));
        empleadoDAO.insertar(new Empleado("Maria Lopez", "maria.l@example.com", 2800.0, Estatus.INACTIVO, LocalDate.of(2021, 11, 20)));
        System.out.println(">>> Empleados insertados.");

        System.out.println("\n--- 2. Listando todos los empleados ---");
        List<Empleado> empleados = empleadoDAO.listar();
        empleados.forEach(System.out::println);

        System.out.println("\n--- 3. Actualizando un empleado (ID: 1) ---");
        Empleado empleadoAActualizar = empleadoDAO.buscar(1L);
        if (empleadoAActualizar != null) {
            empleadoAActualizar.setNombre("Ana Solis Rojas");
            empleadoDAO.actualzar(empleadoAActualizar);
            System.out.println(">>> Empleado actualizado: " + empleadoDAO.buscar(1L));
        }

        System.out.println("\n--- 4. Aumentando salario del empleado con ID 2 (un 15%) ---");
        Empleado empleadoSalario = empleadoDAO.buscar(2L);
        if (empleadoSalario != null) {
            System.out.println("Salario antes: " + empleadoSalario.getSalario());
            empleadoDAO.aumentarSalario(2L, 15.0);
            System.out.println("Salario después: " + empleadoDAO.buscar(2L).getSalario());
        }

        System.out.println("\n--- 5. Eliminando al empleado con ID 3 ---");
        empleadoDAO.eliminar(3L);
        System.out.println(">>> Empleado eliminado.");

        System.out.println("\n--- 6. Listando empleados restantes ---");
        empleados = empleadoDAO.listar();
        empleados.forEach(System.out::println);

      
        JPAUTIL.shutdown();
        System.out.println("\n--- Aplicación finalizada ---");
    }
}