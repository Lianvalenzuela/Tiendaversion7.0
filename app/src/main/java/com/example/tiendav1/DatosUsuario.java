package com.example.tiendav1;

public class DatosUsuario {
    private String Correo;
    private String Contraseña;
    private String Id;
    public DatosUsuario(){
        this.Correo = "correo";
        this.Contraseña = "contraseña";
        this.Id = "0";
    }
    public void setCorreo(String correo){
        Correo = correo;
    }
    public void setContraseña(String contraseña){
        Contraseña = contraseña;
    }
    public void setUId(String id){
        Id = id;
    }
    public String getCorreo(){
        return Correo;
    }
    public String getContraseña(){
        return Contraseña;
    }
    public String getUId(){
        return Id;
    }

}
