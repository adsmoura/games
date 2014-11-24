/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mouralacerda.dao;

import com.edu.mouralacerda.modelo.Jogo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author BadluckNote
 */
public class JogoDao {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory("CadastroJogos");
    final EntityManager em = factory.createEntityManager();
    
    public void salvar(Jogo p){
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
    
    public List<Jogo> consultarLista(){
        
        TypedQuery<Jogo> query = em.createQuery("select a from Jogo a", Jogo.class);
        List<Jogo> jogos = query.getResultList();
        return jogos;
    }
}
