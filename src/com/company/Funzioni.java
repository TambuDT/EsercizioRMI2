package com.company;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Funzioni extends Remote {
    Contatto creaNumero(int numero, String nome) throws RemoteException, ContattoGiàPresente;

    Boolean trovaNumero(int numero) throws RemoteException;

    Boolean cancllaNumero(int numero) throws RemoteException;
}
