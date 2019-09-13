package com.example.latihansqlkelompok;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {
    int nomor;
    String nama,tgl,jenkel,alamat;

    public int getNo(){return nomor;}
    public void setNo(int no){this.nomor = nomor;}

    public String getNama(){return nama;}
    public void setNama(String nama){this.nama = nama;}

    public String getTgl(){return tgl;}
    public void setTgl(String tgl){this.tgl = tgl;}

    public String getJenkel(){return jenkel;}
    public void setJenkel(String jenkel){this.jenkel = jenkel;}

    public String getAlamat(){return alamat;}
    public void setAlamat(String alamat){this.alamat = alamat;}


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.nomor);
        dest.writeString(this.tgl);
        dest.writeString(this.nama);
        dest.writeString(this.jenkel);
        dest.writeString(this.alamat);
    }
    public Data() {
    }

    protected Data(Parcel in) {
        this.nomor = in.readInt();
        this.tgl = in.readString();
        this.nama = in.readString();
        this.jenkel = in.readString();
        this.alamat = in.readString();
    }

    public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel source) {
            return new Data(source);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };
}
