package com.cosa.com.ejemplologinparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Nela on 18/09/2017.
 */

public class Persona implements Parcelable {

    String nombre = null;
    String apellidos = null;
    Integer edad = null;
    Direccion direccion = null;

    Persona(){

    }

    public Persona(String nombre, String apellidos, Integer edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        direccion = null;
    }

    public Persona(String nombre, String apellidos, Integer edad, Direccion direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.direccion = direccion;
    }

    public Persona(Persona p, Direccion direccion){
        this.nombre = p.getNombre();
        this.apellidos = p.getApellidos();
        this.edad = p.getEdad();
        this.direccion = direccion;
    }

    private Persona(Parcel in){
        readFromParcel(in);
    }

    //Metodos parcelables
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(nombre);
        out.writeString(apellidos);
        out.writeInt(edad);
        out.writeParcelable(direccion,0);
    }

    public static final Parcelable.Creator<Persona> CREATOR
            = new Parcelable.Creator<Persona>() {
                 public Persona createFromParcel(Parcel in) {
                    return new Persona(in);
                 }

                 public Persona[] newArray(int size) {
                     return new Persona[size];
                 }
             };

    private void readFromParcel(Parcel in){
        nombre = in.readString();
        apellidos = in.readString();
        edad = in.readInt();
        direccion = in.readParcelable(Direccion.class.getClassLoader());

    }

    //Getter and Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Direccion getDireccion() { return direccion; }

    public void setDireccion(Direccion direccion) { this.direccion = direccion; }

    public String getCalle(){
        return direccion.getCalle();
    }

    public Integer getCP(){
        return direccion.getCp();
    }


}
