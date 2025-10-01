/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author USER
 */
public class JPAUTIL {
    private static final String PERSISTENCE_UNIT ="myPU";
    private static EntityManagerFactory emf;

    public JPAUTIL() {}
        
        public static EntityManager getEntityManager(){
           if(emf == null) {
               emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
               
           }
           return  emf.createEntityManager();
        }
    }
    
    

