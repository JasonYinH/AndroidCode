package com.base.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author jia
 */
public class UserParcelable implements Parcelable{
    public String userName;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userName);
    }

    public UserParcelable() {
    }

    protected UserParcelable(Parcel in) {
        this.userName = in.readString();
    }

    public static final Parcelable.Creator<UserParcelable> CREATOR = new Creator<UserParcelable>() {
        @Override
        public UserParcelable createFromParcel(Parcel source) {
            return new UserParcelable(source);
        }

        @Override
        public UserParcelable[] newArray(int size) {
            return new UserParcelable[size];
        }
    };
}