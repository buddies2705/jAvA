package com.company;

/**
 * Created by root on 16/4/16.
 */
public class MyString {

    String string;

    MyString (String string)
    {
        this.string = string ;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyString myString = (MyString) o;

        return getString().equals(myString.getString());

    }

    @Override
    public int hashCode() {
        return getString().hashCode();
    }
}
