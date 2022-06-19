package com.company;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private Client() {}
    public static void main(String[] args) throws NotBoundException, RemoteException, ContattoGiàPresente {
        int numero=5569;
        String nome="Mario";


        Registry reg= LocateRegistry.getRegistry("localhost",9000);
        Client fun=new Client();
        Funzioni f=(Funzioni) reg.lookup("server");
        Contatto contatto=f.creaNumero(numero,nome);
        System.out.println(contatto.getNome()+" "+contatto.getNumero());
    }
}
