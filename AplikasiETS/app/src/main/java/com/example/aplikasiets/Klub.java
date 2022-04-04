package com.example.aplikasiets;

import android.os.Parcel;
import android.os.Parcelable;

public class Klub implements Parcelable {
    String nama;
    int peringkat;
    int totalPoin;
    int totalMain;
    int totalMenang;
    int seri;
    int kalah;
    int golMasuk;
    int golKemasukan;
    int selisihGol;

    public int getSeri() {
        return seri;
    }

    public void setSeri(int seri) {
        this.seri = seri;
    }

    public int getKalah() {
        return kalah;
    }

    public void setKalah(int kalah) {
        this.kalah = kalah;
    }

    public Klub(String nama, int peringkat, int totalPoin, int totalMain, int totalMenang, int seri, int kalah, int golMasuk, int golKemasukan, int selisihGol) {
        this.nama = nama;
        this.peringkat = peringkat;
        this.totalPoin = totalPoin;
        this.totalMain = totalMain;
        this.totalMenang = totalMenang;
        this.seri = seri;
        this.kalah = kalah;
        this.golMasuk = golMasuk;
        this.golKemasukan = golKemasukan;
        this.selisihGol = selisihGol;
    }


//    public Klub(String nama, int peringkat, int totalPoin) {
//        this.nama = nama;
//        this.peringkat = peringkat;
//        this.totalPoin = totalPoin;
//    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getPeringkat() {
        return peringkat;
    }

    public void setPeringkat(int peringkat) {
        this.peringkat = peringkat;
    }

    public int getTotalPoin() {
        return totalPoin;
    }

    public void setTotalPoin(int totalPoin) {
        this.totalPoin = totalPoin;
    }

    public int getTotalMain() {
        return totalMain;
    }

    public void setTotalMain(int totalMain) {
        this.totalMain = totalMain;
    }

    public int getTotalMenang() {
        return totalMenang;
    }

    public void setTotalMenang(int totalMenang) {
        this.totalMenang = totalMenang;
    }

    public int getGolMasuk() {
        return golMasuk;
    }

    public void setGolMasuk(int golMasuk) {
        this.golMasuk = golMasuk;
    }

    public int getGolKemasukan() {
        return golKemasukan;
    }

    public void setGolKemasukan(int golKemasukan) {
        this.golKemasukan = golKemasukan;
    }

    public int getSelisihGol() {
        return selisihGol;
    }

    public void setSelisihGol(int selisihGol) {
        this.selisihGol = selisihGol;
    }

    protected Klub(Parcel in){
        nama = in.readString();
        peringkat = in.readInt();
        totalPoin = in.readInt();
        totalMain = in.readInt();
        totalMenang= in.readInt();
        seri= in.readInt();
        kalah = in.readInt();
        golMasuk= in.readInt();
        golKemasukan= in.readInt();
        selisihGol= in.readInt();


    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(nama);
        dest.writeInt(peringkat);
        dest.writeInt(totalMain);
        dest.writeInt(totalMenang);
        dest.writeInt(totalPoin);
        dest.writeInt(seri);
        dest.writeInt(kalah);
        dest.writeInt(golKemasukan);
        dest.writeInt(golMasuk);
        dest.writeInt(selisihGol);
    }

    public static final Creator<Klub> CREATOR = new Creator<Klub>() {
        @Override
        public Klub createFromParcel(Parcel in) {
            return new Klub(in);
        }

        @Override
        public Klub[] newArray(int i) {
            return new Klub[i];
        }
    };
}
