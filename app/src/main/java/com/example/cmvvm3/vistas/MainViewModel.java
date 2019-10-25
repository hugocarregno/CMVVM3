package com.example.cmvvm3.vistas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cmvvm3.modelo.Cliente;
import com.example.cmvvm3.modelo.ClienteDao;

public class MainViewModel extends ViewModel {
    private MutableLiveData<Cliente> mldCliente;
    private ClienteDao clienteDao = new ClienteDao();
    private MutableLiveData<String> mldResultado;

    public LiveData<Cliente> getMLDCliente(){
        if(mldCliente == null){
            mldCliente = new MutableLiveData<>();
        }
        return mldCliente;
    }
    public LiveData<String> getMLDResultado(){
        if(mldResultado == null){
            mldResultado = new MutableLiveData<>();
        }
        return mldResultado;
    }
    public void buscarCliente(long dni){
        mldResultado.postValue("Iniciando...");
        Cliente c = clienteDao.buscar(dni);
        mldCliente.setValue(c);
        new Thread(){
            public void run(){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mldResultado.postValue("Listo");
            }
        }.start();
    }

    public void cargarDatos(){
        clienteDao.insertar(new Cliente(23,"Perez","Maria","colon 11"));
        clienteDao.insertar(new Cliente(24,"Castro","Martin","las heras 22"));
    }
}
