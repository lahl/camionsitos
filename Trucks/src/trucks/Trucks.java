/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trucks;

import Presentacion.frmLogin;
import java.awt.Frame;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author lalon
 */
public class Trucks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        frmLogin frm = new frmLogin();
        frm.setVisible(true);
        
        
        TimeZone tz= TimeZone.getTimeZone("America/Mexico_City");
        Calendar cal = Calendar.getInstance(tz);
        
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        System.out.printf("Now is %4d/%02d/%02d %02d:%02d:%02d\n",  // Pad with zero
          year, month+1, day, hour, minute, second);
        
    }
    
}
