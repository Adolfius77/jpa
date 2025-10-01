/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import DAO.empleadoDAO;
import Modelo.Empleado;
import Modelo.Estatus;
import interfaces.IEmpleadoDAO;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author USER
 */
public class JPAEmpresa {
    public static void main(String[] args) {
        IEmpleadoDAO empleadoDAO = new empleadoDAO();
        
        System.out.println("1. insertando nuevos empleados");
        
        Empleado emp1 = new Empleado("carlos","carlos@gmail.com",4200.0,Estatus.ACTIVO,LocalDate.now());
    }
}
