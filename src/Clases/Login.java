/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author ANGEL
 */
public class Login {

    private String usuario;
    private String psw;
    private String cargo;
    private String nomTrab;

    Controlador control = new Controlador();

    public Login(String usuario, String psw) {
        this.usuario = usuario;
        this.psw = psw;
        this.cargo = DevolverDto("cargo");
        this.nomTrab = DevolverDto("concat(nombres,' ',apellidos)");
    }

    public String getUsuario() {
        return usuario;
    }

    public String getnomEmp() {
        return nomTrab;
    }

    public String getcargo() {
        return cargo;
    }

    public boolean VerificarUsuario() {
        return control.VerififcarConsulta("Select  * from vw_trabajadores where login='" + usuario + "';");
    }

    public boolean VerificarCredenciales() {
        return control.VerififcarConsulta("Select * from vw_trabajadores where login='" + usuario + "' and psw=md5('" + psw + "');");
    }

    public String DevolverDto(String dato) {
        return control.DevolverRegistroDto("Select " + dato + " from vw_trabajadores where login='" + usuario + "' and psw=md5('" + psw + "');", 1);
    }
}
