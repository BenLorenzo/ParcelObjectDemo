package com.android3project.dev.parcelobjectdemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dev on 7/17/2015.
 */
public class Student implements Parcelable {
    String mSName;
    int mSAge;
    String mSAddress;
    String mSCourse;


    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * A constructor that initializes the Student object
     **/
    public Student(String sName, int sAge, String sAddress, String sCourse){
        this.mSName = sName;
        this.mSAge = sAge;
        this.mSAddress = sAddress;
        this.mSCourse = sCourse;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mSName);
        dest.writeInt(this.mSAge);
        dest.writeString(this.mSAddress);
        dest.writeString(this.mSCourse);
    }

    public Student() {
    }

    /**
     * Retrieving Student data from Parcel object
     * This constructor is invoked by the method createFromParcel(Parcel source) of
     * the object CREATOR
     **/
    protected Student(Parcel in) {
        this.mSName = in.readString();
        this.mSAge = in.readInt();
        this.mSAddress = in.readString();
        this.mSCourse = in.readString();
    }

    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
