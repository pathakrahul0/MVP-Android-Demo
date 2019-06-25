
package com.mvpandroidsample.login;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShippingAddress implements Parcelable
{

    @SerializedName("shipping_address")
    @Expose
    private String shippingAddress;
    @SerializedName("shipping_city")
    @Expose
    private String shippingCity;
    @SerializedName("shipping_zip")
    @Expose
    private String shippingZip;
    public final static Creator<ShippingAddress> CREATOR = new Creator<ShippingAddress>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ShippingAddress createFromParcel(Parcel in) {
            return new ShippingAddress(in);
        }

        public ShippingAddress[] newArray(int size) {
            return (new ShippingAddress[size]);
        }

    }
    ;

    protected ShippingAddress(Parcel in) {
        this.shippingAddress = ((String) in.readValue((String.class.getClassLoader())));
        this.shippingCity = ((String) in.readValue((String.class.getClassLoader())));
        this.shippingZip = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ShippingAddress() {
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public String getShippingZip() {
        return shippingZip;
    }

    public void setShippingZip(String shippingZip) {
        this.shippingZip = shippingZip;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(shippingAddress);
        dest.writeValue(shippingCity);
        dest.writeValue(shippingZip);
    }

    public int describeContents() {
        return  0;
    }

}
