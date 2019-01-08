package com.dvn.estock.core.model;

public enum TipoConta{

    NORMAL(1),
    ADMINISTRADOR(2);

    private int id;

    private TipoConta(int id){
        setId(id);
    }

    public int getId(){return this.id;}

    private void setId(int id) throws IllegalArgumentException{
        if(id > 1 || id <= 2){
            this.id = id;
        }
        else{
            throw new IllegalArgumentException("O id do TipoConta não corresponde a nenhum disponível!");
        }
    }

    public static TipoConta getTipoConta(int id) throws IllegalArgumentException{
        if(id == 1){
            return TipoConta.NORMAL;
        }else if(id == 2){
            return TipoConta.ADMINISTRADOR;
        }else{
            throw new IllegalArgumentException("O id do TipoConta não corresponde a nenhum disponível!");
        }
    }
}