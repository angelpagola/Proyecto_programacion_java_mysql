/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.*;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANGEL
 */
public class Controlador {
    
    Conexion Base = new Conexion();
    
    public ResultSet DevolverRegistro(String consulta) {
        try {
            Base.stat = Base.conec.createStatement();
            Base.resul = Base.stat.executeQuery(consulta);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return Base.resul;
    }
    
    public String DevolverRegistroDto(String consulta, int posicion) {
        String rs = "";
        try {
            Base.stat = Base.conec.createStatement();
            Base.resul = Base.stat.executeQuery(consulta);
            if (Base.resul.next()) {
                rs = Base.resul.getString(posicion);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return rs;
    }
    
    public boolean VerififcarConsulta(String consulta) {
        boolean b = false;
        try {
            Base.stat = Base.conec.createStatement();
            Base.resul = Base.stat.executeQuery(consulta);
            b = Base.resul.next();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return b;
    }
    
    public void LimpiarJtable(DefaultTableModel modelo) {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }
    
    public void LlenarJtable(DefaultTableModel modelo, String consulta, int longitud) {
        try {
            LimpiarJtable(modelo);
            String[] dt = new String[longitud];
            Base.resul = DevolverRegistro(consulta);
            while (Base.resul.next()) {
                for (int n = 0; n < longitud; n++) {
                    dt[n] = Base.resul.getString(n + 1);
                }
                modelo.addRow(dt);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void LlenarCombo(JComboBox combo, String consulta, int posicion) {
        combo.removeAllItems();
        
        try {
            Base.resul = DevolverRegistro(consulta);
            while (Base.resul.next()) {
                combo.addItem(Base.resul.getString(posicion));
            }
            combo.setSelectedIndex(-1);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void LlenarComboTit(JComboBox combo, String consulta, int posicion) {
        combo.removeAllItems();
        combo.addItem("--Seleccione--");
        try {
            Base.resul = DevolverRegistro(consulta);
            while (Base.resul.next()) {
                combo.addItem(Base.resul.getString(posicion));
            }
            combo.setSelectedIndex(-1);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void LlenarLista(DefaultListModel lista, String consulta, int posicion) {
        lista.removeAllElements();
        try {
            Base.resul = DevolverRegistro(consulta);
            while (Base.resul.next()) {
                lista.addElement(Base.resul.getString(posicion));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
}
