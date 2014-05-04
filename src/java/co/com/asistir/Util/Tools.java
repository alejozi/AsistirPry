/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.asistir.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hectoridarraga
 */
public class Tools {
 public static String generateMD5Signature(String input) {
        try {
            System.out.println("input = " + input);
                    
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] huella = md.digest(input.getBytes());
            return transformaAHexadecimal(huella);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE,
                    "No se ha encontrado el algoritmo MD5", ex);
            return "-1";
        }
    }

    private static String transformaAHexadecimal(byte buf[]) {
        StringBuilder strbuf = new StringBuilder(buf.length * 2);
        for (int i = 0; i < buf.length; i++) {
            if (((int) buf[i] & 0xff) < 0x10) {
                strbuf.append("0");
            }
            strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
        }
        return strbuf.toString();
    }    
}
