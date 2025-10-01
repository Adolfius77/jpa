/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Modelo.Empleado;
import java.util.List;

/**
 *
 * @author USER
 */
public interface IEmpleadoDAO {
  void insertar(Empleado empleado);
  
  void actualzar(Empleado empleado);
  
  void eliminar(long id);
  
  Empleado buscar(Long id);
  
  List<Empleado> listar();
  
  void aumentarSalario(Long id, Double porcentaje);
}
