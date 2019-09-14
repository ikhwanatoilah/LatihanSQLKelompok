package com.example.latihansqlkelompok;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {
    String nama,jeniskelamin,alamat,tanggal;
    int no;

    public Data() {
        this.nama = nama;
        this.jeniskelamin = jeniskelamin;
        this.alamat = alamat;
        this.no = no;
        this.tanggal = tanggal;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString (this.nama);
        dest.writeString (this.jeniskelamin);
        dest.writeString (this.alamat);
        dest.writeString (this.tanggal);
        dest.writeInt (this.no);
    }

    protected Data(Parcel in) {
        this.nama = in.readString ();
        this.jeniskelamin = in.readString ();
        this.alamat = in.readString ();
        this.tanggal = in.readString ();
        this.no = in.readInt ();
    }

    public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data> () {
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
