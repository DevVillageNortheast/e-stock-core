package com.dvn.estock.core.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="conta", schema="private")
public class Conta implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name="conta_id")
    private Long id;

    @Column(name="tipo_conta", nullable=false)
    @Enumerated(EnumType.ORDINAL)
    private TipoConta tipoConta;

    @Column(name="username", nullable=false, unique=true)
    private String username;

    @Column(name="email", nullable=false, unique=true)
    private String email;

    @Column(name="senha", nullable=false)
    private String senha;

    @Column(name="nome", nullable=false)
    private String nome;
    
    @Column(name="sobrenome", nullable=false)
    private String sobrenome;
    
    @Column(name="criado_em", nullable=false)
    private LocalDateTime criadoEm;
    
    @Column(name="ultimo_login", nullable=true)
    private LocalDateTime ultimoLogin;

    public Conta(){

    }

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public TipoConta getTipoConta(){return tipoConta;}
    public void setTipoConta(TipoConta tipoConta){this.tipoConta = tipoConta;}

    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    public String getSenha(){return senha;}
    public void setSenha(String senha){this.senha = senha;}

    public String getNome(){return nome;}
    public void setNome(String nome){this.nome = nome;}

    public String getSobrenome(){return sobrenome;}
    public void setSobrenome(String sobrenome){this.sobrenome = sobrenome;}

    public LocalDateTime getCriadoEm(){return criadoEm;}
    public void setCriadoEm(LocalDateTime criadoEm){this.criadoEm = criadoEm;}

    public LocalDateTime getUltimoLogin(){return ultimoLogin;}
    public void setUltimoLogin(LocalDateTime ultimoLogin){this.ultimoLogin = ultimoLogin;}

    public static long getSerialVersionUID(){return serialVersionUID;}
    
}