package com.example.lab6;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.yandex.mapkit.MapKit;
import com.yandex.mapkit.geometry.Point;

import java.io.Serializable;

public class Site implements Parcelable {
    private String name;
    private String description;
    private String time;
    private int PicResourse;
    private Point coords;
    private boolean flag;





    public Site(String name, String description, double latitude, double longtitude) {
        this.name = name;
        this.description = description;
        this.PicResourse = R.drawable.nopic;
        this.coords = new Point(latitude, longtitude);
        flag = false;
    }

    public Site(String name, String description, int PicResource, double latitude, double longtitude) {
        this.name = name;
        this.description = description;
        this.time = "";
        this.PicResourse = PicResource;
        this.coords = new Point(latitude, longtitude);
        flag = false;
    }



    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPicResourse() {
        return PicResourse;
    }
    public void setCheck(boolean check){
        flag = check;
    }

    public boolean isFlag() {
        return flag;
    }

    public String getTime() {
        return time;
    }

    public Point getCoords() {
        return coords;
    }

    public Site(Parcel in){
        String[] data = new String[5];
        in.readStringArray(data);
        this.name = data[0];
        this.description = data[1];
        this.PicResourse = Integer.parseInt(data[2]);
        this.coords = new Point(Double.parseDouble(data[3]), Double.parseDouble(data[4]));
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeStringArray(new String[] {this.name,
        this.description, String.valueOf(this.PicResourse),
        String.valueOf(coords.getLatitude()), String.valueOf(coords.getLongitude())});

    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {


        public Site createFromParcel(Parcel in) {
            return new Site(in);
        }


        public Site[] newArray(int size) {
            return new Site[size];
        }
    };
}
