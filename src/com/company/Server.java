package com.company;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements Funzioni{

    public ArrayList<String> listaContatti=new ArrayList<>();

    private Server() throws RemoteException {
        super();
    }

    @Override
    public synchronized Contatto creaNumero(int numero, String nome) throws RemoteException, ContattoGiàPresente {
        if(listaContatti==null){
            Contatto contatto=new Contatto(numero,nome);
            listaContatti.add(nome+","+numero);
            System.out.println("contatto aggiunto");
            System.out.println(nome+","+numero);
            System.out.println(listaContatti);
            return contatto;
        }
        if (listaContatti.contains(nome+","+numero)){
            System.out.println("contatto non aggiunto, già presente");
            System.out.println(listaContatti);
            throw new ContattoGiàPresente("CONTATTO GIA' PRESENTE");
        }
        Contatto contatto=new Contatto(numero,nome);
        listaContatti.add(nome+","+numero);
        System.out.println("contatto aggiunto");
        System.out.println(nome+","+numero);
        System.out.println(listaContatti);
        return contatto;
    }

    @Override
    public synchronized Boolean cancllaNumero(int numero) throws RemoteException {
        return null;
    }

    @Override
    public synchronized Boolean trovaNumero(int numero) throws RemoteException {
        return null;
    }

    public static void main(String[] args) throws RemoteException {
        Registry reg= LocateRegistry.createRegistry(9000);
        reg.rebind("server",new Server());
        System.out.println("Server ready");
    }
}
