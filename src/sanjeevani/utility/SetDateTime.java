/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevani.utility;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.Timer;

/**
 *
 * @author pradu
 */
public class SetDateTime {
    public static void setTime(javax.swing.JLabel label){
        
         Timer timer=new Timer(0,new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Date today=new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-YYY  hh:mm:ss");
                String time=sdf.format(today);
                label.setText(time);
            }
          
        }); 
        timer.start();
        
    }
}
