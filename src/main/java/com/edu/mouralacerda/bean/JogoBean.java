/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mouralacerda.bean;

import com.edu.mouralacerda.dao.JogoDao;
import com.edu.mouralacerda.modelo.Jogo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author BadluckNote
 */
@ManagedBean
public class JogoBean {
    private Jogo game = new Jogo();        
    private JogoDao gameDao = new JogoDao();
    private List<Jogo> lista = new ArrayList<Jogo>();
    
    
    public void salvarJogo() {
        gameDao.salvar(game);
        game = new Jogo();
        carregaLista();  
    }

    public Jogo getGame() {
        return game;
    }

    public void setGame(Jogo game) {
        this.game = game;
    }

    public JogoDao getGameDao() {
        return gameDao;
    }

    public void setGameDao(JogoDao gameDao) {
        this.gameDao = gameDao;
    }

    public List<Jogo> getLista() {
        return lista;
    }

    public void setLista(List<Jogo> lista) {
        this.lista = lista;
    }

    
    public JogoBean() {
        carregaLista();  
    }
    
    @PostConstruct
    public void carregaLista(){
        lista = gameDao.consultarLista();
    }
    
}
