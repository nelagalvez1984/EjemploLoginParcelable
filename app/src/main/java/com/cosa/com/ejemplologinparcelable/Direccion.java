package com.cosa.com.ejemplologinparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Nela on 19/09/2017.
 */

public class Direccion implements Parcelable{
    private String calle = null;
    private Integer cp = null;

    public Direccion(String calle, Integer cp) {
        this.calle = calle;
        this.cp = cp;
    }

    public Direccion(){

    }

    private Direccion(Parcel in){
        readFromParcel(in);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(calle);
        parcel.writeInt(cp);
    }

    public static final Parcelable.Creator<Direccion> CREATOR
            = new Parcelable.Creator<Direccion>() {
        public Direccion createFromParcel(Parcel in) {
            return new Direccion(in);
        }

        public Direccion[] newArray(int size) {
            return new Direccion[size];
        }
    };

    private void readFromParcel(Parcel in){
        calle = in.readString();
        cp = in.readInt();
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }
}
