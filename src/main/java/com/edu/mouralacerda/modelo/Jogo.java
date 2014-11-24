/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.mouralacerda.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BadluckNote
 */
@Entity
@Table(name = "JOGO",catalog = "",schema = "HR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jogo.findAll", query = "SELECT j FROM Jogo j"),
    @NamedQuery(name = "Jogo.findById", query = "SELECT j FROM Jogo j WHERE j.id = :id"),
    @NamedQuery(name = "Jogo.findByNome", query = "SELECT j FROM Jogo j WHERE j.nome = :nome"),
    @NamedQuery(name = "Jogo.findByTipo", query = "SELECT j FROM Jogo j WHERE j.tipo = :tipo")})
public class Jogo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 60)
    @Column(name = "NOME")
    private String nome;
    @Size(max = 20)
    @Column(name = "TIPO")
    private String tipo;

    public Jogo() {
    }

    public Jogo(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jogo)) {
            return false;
        }
        Jogo other = (Jogo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.mouralacerda.modelo.Jogo[ id=" + id + " ]";
    }
    
}
