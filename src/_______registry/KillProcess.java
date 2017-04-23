/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _______registry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SinPermisos
 */
public class KillProcess {
private static final String TASKLIST = "tasklist";
private static final String KILL = "taskkill /F /IM ";

    public static boolean isProcessRunning(String serviceName) throws Exception {

     Process p = Runtime.getRuntime().exec(TASKLIST);
     BufferedReader reader = new BufferedReader(new InputStreamReader(
       p.getInputStream()));
     String line;
     while ((line = reader.readLine()) != null) {

      System.out.println(line);
      if (line.contains(serviceName)) {
       return true;
      }
     }

     return false;

    }

    public static void killProcess(String serviceName) throws Exception {

      Runtime.getRuntime().exec(KILL + serviceName);

     }   
    
    public static void main(String args[]) throws Exception {
        new Thread(){
            @Override
            public void run(){
                try {
                    while(true){
                        String processName = "wordpad.exe";

                        //System.out.print(isProcessRunning(processName));

                        if (isProcessRunning(processName)) {
                            System.out.println("SÍ ESTÁ EJECUTÁNDOSE");

                            killProcess(processName);
                        }            
                        Thread.sleep(300);                            
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }.start();

    }    
    
}
