
package com.example.weather.data.models;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Wind implements Parcelable {

    @SerializedName("speed")
    @Expose
    private Float speed;
    @SerializedName("deg")
    @Expose
    private Integer deg;
    @SerializedName("gust")
    @Expose
    private Float gust;

    protected Wind(Parcel in) {
        if (in.readByte() == 0) {
            speed = null;
        } else {
            speed = in.readFloat();
        }
        if (in.readByte() == 0) {
            deg = null;
        } else {
            deg = in.readInt();
        }
        if (in.readByte() == 0) {
            gust = null;
        } else {
            gust = in.readFloat();
        }
    }

    public static final Creator<Wind> CREATOR = new Creator<Wind>() {
        @Override
        public Wind createFromParcel(Parcel in) {
            return new Wind(in);
        }

        @Override
        public Wind[] newArray(int size) {
            return new Wind[size];
        }
    };

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    public Float getGust() {
        return gust;
    }

    public void setGust(Float gust) {
        this.gust = gust;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (speed == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(speed);
        }
        if (deg == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(deg);
        }
        if (gust == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(gust);
        }
    }
}
