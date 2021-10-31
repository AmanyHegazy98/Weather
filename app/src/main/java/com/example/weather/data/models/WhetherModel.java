
package com.example.weather.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class WhetherModel implements Parcelable {

    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private Integer message;
    @SerializedName("cnt")
    @Expose
    private Integer cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<ListModel> listModel = null;
    @SerializedName("city")
    @Expose
    private City city;

    protected WhetherModel(Parcel in) {
        cod = in.readString();
        if (in.readByte() == 0) {
            message = null;
        } else {
            message = in.readInt();
        }
        if (in.readByte() == 0) {
            cnt = null;
        } else {
            cnt = in.readInt();
        }
    }

    public static final Creator<WhetherModel> CREATOR = new Creator<WhetherModel>() {
        @Override
        public WhetherModel createFromParcel(Parcel in) {
            return new WhetherModel(in);
        }

        @Override
        public WhetherModel[] newArray(int size) {
            return new WhetherModel[size];
        }
    };

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public java.util.List<ListModel> getList() {
        return listModel;
    }

    public void setList(java.util.List<ListModel> listModel) {
        this.listModel = listModel;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cod);
        if (message == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(message);
        }
        if (cnt == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(cnt);
        }
    }
}
