package com.example.cmvvm3.modelo;

import java.util.ArrayList;

public class ClienteDao {
    private ArrayList<Cliente> lista = new ArrayList<>();

    public void insertar(Cliente cliente){
        lista.add(cliente);
    }

    public Cliente buscar(long dni){
        Cliente c = null;
        for(Cliente it:lista){
            if(it.getDni()==dni){
                c = it;
            }
        }
        return c;
    }
}