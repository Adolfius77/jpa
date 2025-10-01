/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Empleado;
import interfaces.IEmpleadoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;
import util.JPAUTIL;

/**
 *
 * @author USER
 */
public class empleadoDAO implements IEmpleadoDAO {

    private EntityManager em = JPAUTIL.getEntityManager();

    @Override
    public void insertar(Empleado empleado) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(empleado);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void actualzar(Empleado empleado) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(empleado);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(long id) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Empleado empleado = em.find(Empleado.class, id);
            if (empleado != null) {
                em.remove(empleado);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public Empleado buscar(Long id) {
        return em.find(Empleado.class, id);
    }

    @Override
    public List<Empleado> listar() {
        TypedQuery<Empleado> query = em.createQuery("SELECT e FROM Empleado e", Empleado.class);
        return query.getResultList();
    }

    @Override
    public void aumentarSalario(Long id, Double porcentaje) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            
            Empleado empleado = em.find(Empleado.class, id);
            
            if (empleado !=null) {
                double aumento = empleado.getSalario() * (porcentaje / 100);
                empleado.setSalario(empleado.getSalario() + aumento);
                em.merge(empleado);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

}
