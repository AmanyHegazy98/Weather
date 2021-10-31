
package com.example.weather.data.models;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main implements Parcelable {

    @SerializedName("temp")
    @Expose
    private Float temp;
    @SerializedName("feels_like")
    @Expose
    private Float feelsLike;
    @SerializedName("temp_min")
    @Expose
    private Float tempMin;
    @SerializedName("temp_max")
    @Expose
    private Float tempMax;
    @SerializedName("pressure")
    @Expose
    private Integer pressure;
    @SerializedName("sea_level")
    @Expose
    private Integer seaLevel;
    @SerializedName("grnd_level")
    @Expose
    private Integer grndLevel;
    @SerializedName("humidity")
    @Expose
    private Integer humidity;
    @SerializedName("temp_kf")
    @Expose
    private Float tempKf;

    protected Main(Parcel in) {
        if (in.readByte() == 0) {
            temp = null;
        } else {
            temp = in.readFloat();
        }
        if (in.readByte() == 0) {
            feelsLike = null;
        } else {
            feelsLike = in.readFloat();
        }
        if (in.readByte() == 0) {
            tempMin = null;
        } else {
            tempMin = in.readFloat();
        }
        if (in.readByte() == 0) {
            tempMax = null;
        } else {
            tempMax = in.readFloat();
        }
        if (in.readByte() == 0) {
            pressure = null;
        } else {
            pressure = in.readInt();
        }
        if (in.readByte() == 0) {
            seaLevel = null;
        } else {
            seaLevel = in.readInt();
        }
        if (in.readByte() == 0) {
            grndLevel = null;
        } else {
            grndLevel = in.readInt();
        }
        if (in.readByte() == 0) {
            humidity = null;
        } else {
            humidity = in.readInt();
        }
        if (in.readByte() == 0) {
            tempKf = null;
        } else {
            tempKf = in.readFloat();
        }
    }

    public static final Creator<Main> CREATOR = new Creator<Main>() {
        @Override
        public Main createFromParcel(Parcel in) {
            return new Main(in);
        }

        @Override
        public Main[] newArray(int size) {
            return new Main[size];
        }
    };

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public Float getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(Float feelsLike) {
        this.feelsLike = feelsLike;
    }

    public Float getTempMin() {
        return tempMin;
    }

    public void setTempMin(Float tempMin) {
        this.tempMin = tempMin;
    }

    public Float getTempMax() {
        return tempMax;
    }

    public void setTempMax(Float tempMax) {
        this.tempMax = tempMax;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(Integer seaLevel) {
        this.seaLevel = seaLevel;
    }

    public Integer getGrndLevel() {
        return grndLevel;
    }

    public void setGrndLevel(Integer grndLevel) {
        this.grndLevel = grndLevel;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Float getTempKf() {
        return tempKf;
    }

    public void setTempKf(Float tempKf) {
        this.tempKf = tempKf;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (temp == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(temp);
        }
        if (feelsLike == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(feelsLike);
        }
        if (tempMin == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(tempMin);
        }
        if (tempMax == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(tempMax);
        }
        if (pressure == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(pressure);
        }
        if (seaLevel == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(seaLevel);
        }
        if (grndLevel == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(grndLevel);
        }
        if (humidity == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(humidity);
        }
        if (tempKf == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(tempKf);
        }
    }
}
