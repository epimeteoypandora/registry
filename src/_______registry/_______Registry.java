/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _______registry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author SinPermisos
 */
public class _______Registry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
String line;
try {
    String processName="explorer.exe";
    Process proc = Runtime.getRuntime().exec("wmic.exe");
    BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));
    OutputStreamWriter oStream = new OutputStreamWriter(proc.getOutputStream());
    oStream .write("process where name='"+processName+"'");
    oStream .flush();
    oStream .close();
    while ((line = input.readLine()) != null) {
        System.out.println(line);
        String[] split = line.split("\\s+");  
//        if (split.length>=24 && line.contains(processName)){
        if (split.length>=24){
//            System.out.println(line);
            System.out.println("split.length="+split.length);
            System.out.println("split[9]="+split[24]);        
        } else {
//            System.out.println("##############"+line);
        }

    }
    input.close();
    

    
//    ///////////////////
//    proc = Runtime.getRuntime().exec("wmic.exe");
//    input = new BufferedReader(new InputStreamReader(proc.getInputStream()));
//    oStream = new OutputStreamWriter(proc.getOutputStream());
//    oStream .write("process");
//    oStream .flush();
//    oStream .close();
//    while ((line = input.readLine()) != null) {
//        if (line.contains(serviceName)) {
//         return true;
//        }
//    }
//    input.close();    
    
    
    
    
} catch (IOException ioe) {
    ioe.printStackTrace();
}
    }
    
}
