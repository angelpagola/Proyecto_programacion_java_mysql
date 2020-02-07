/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author ANGEL
 */
public class ControlDate {

    public String fecha_AMD(Date fecha) {
        SimpleDateFormat formatoAMD = new SimpleDateFormat("YYYY/MM/dd");
        return formatoAMD.format(fecha);
    }
}
