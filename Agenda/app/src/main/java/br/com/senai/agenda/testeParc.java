package br.com.senai.agenda;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by adminLocal on 20/02/2018.
 */

public class testeParc implements Parcelable {
    private String nome;
    private String sobrenome;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nome);
        dest.writeString(this.sobrenome);
    }

    public testeParc() {
    }

    protected testeParc(Parcel in) {
        this.nome = in.readString();
        this.sobrenome = in.readString();
    }

    public static final Parcelable.Creator<testeParc> CREATOR = new Parcelable.Creator<testeParc>() {
        @Override
        public testeParc createFromParcel(Parcel source) {
            return new testeParc(source);
        }

        @Override
        public testeParc[] newArray(int size) {
            return new testeParc[size];
        }
    };
}
