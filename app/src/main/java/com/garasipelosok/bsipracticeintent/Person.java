package com.garasipelosok.bsipracticeintent;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {

    /* to generate getter-setter automatically, do this step
     * type private String name, email, city;
     * type private int age;
     * right click on this workspace
     * select generate... [alt+insert]
     * select getter and setter
     * select all [ctrl+A]
     * click OK, setter and getter will automatically created
     *
     * makesure you already install 'android parcelable code generator in file->setting->plugin.
     * to implement parcelable generator right click generate... and select parcelable
     * your person class already add to parcelable
     */

    private String name;
    private String email;
    private String city;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.email);
        dest.writeString(this.city);
        dest.writeInt(this.age);
    }

    public void readFromParcel(Parcel source) {
        this.name = source.readString();
        this.email = source.readString();
        this.city = source.readString();
        this.age = source.readInt();
    }

    public Person() {
    }

    protected Person(Parcel in) {
        this.name = in.readString();
        this.email = in.readString();
        this.city = in.readString();
        this.age = in.readInt();
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
