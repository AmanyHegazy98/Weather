
package com.example.weather.data.models;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListModel implements Parcelable {

    @SerializedName("dt")
    @Expose
    private Integer dt;
    @SerializedName("main")
    @Expose
    private Main main;
    @SerializedName("weather")
    @Expose
    private java.util.List<Weather> weather = null;
    @SerializedName("clouds")
    @Expose
    private Clouds clouds;
    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("visibility")
    @Expose
    private Integer visibility;
    @SerializedName("pop")
    @Expose
    private Integer pop;
    @SerializedName("sys")
    @Expose
    private Sys sys;
    @SerializedName("dt_txt")
    @Expose
    private String dtTxt;

    protected ListModel(Parcel in) {
        if (in.readByte() == 0) {
            dt = null;
        } else {
            dt = in.readInt();
        }
        main = in.readParcelable(Main.class.getClassLoader());
        weather = in.createTypedArrayList(Weather.CREATOR);
        wind = in.readParcelable(Wind.class.getClassLoader());
        if (in.readByte() == 0) {
            visibility = null;
        } else {
            visibility = in.readInt();
        }
        if (in.readByte() == 0) {
            pop = null;
        } else {
            pop = in.readInt();
        }
        dtTxt = in.readString();
    }

    public static final Creator<ListModel> CREATOR = new Creator<ListModel>() {
        @Override
        public ListModel createFromParcel(Parcel in) {
            return new ListModel(in);
        }

        @Override
        public ListModel[] newArray(int size) {
            return new ListModel[size];
        }
    };

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public java.util.List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Integer getPop() {
        return pop;
    }

    public void setPop(Integer pop) {
        this.pop = pop;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (dt == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(dt);
        }
        dest.writeParcelable(main, flags);
        dest.writeTypedList(weather);
        dest.writeParcelable(wind, flags);
        if (visibility == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(visibility);
        }
        if (pop == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(pop);
        }
        dest.writeString(dtTxt);
    }
}
