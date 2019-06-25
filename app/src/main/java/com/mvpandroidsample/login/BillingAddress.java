
package com.mvpandroidsample.login;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BillingAddress implements Parcelable
{

    @SerializedName("billing_address")
    @Expose
    private String billingAddress;
    @SerializedName("billing_city")
    @Expose
    private String billingCity;
    @SerializedName("billing_zip")
    @Expose
    private String billingZip;
    public final static Creator<BillingAddress> CREATOR = new Creator<BillingAddress>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BillingAddress createFromParcel(Parcel in) {
            return new BillingAddress(in);
        }

        public BillingAddress[] newArray(int size) {
            return (new BillingAddress[size]);
        }

    }
    ;

    protected BillingAddress(Parcel in) {
        this.billingAddress = ((String) in.readValue((String.class.getClassLoader())));
        this.billingCity = ((String) in.readValue((String.class.getClassLoader())));
        this.billingZip = ((String) in.readValue((String.class.getClassLoader())));
    }

    public BillingAddress() {
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingZip() {
        return billingZip;
    }

    public void setBillingZip(String billingZip) {
        this.billingZip = billingZip;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(billingAddress);
        dest.writeValue(billingCity);
        dest.writeValue(billingZip);
    }

    public int describeContents() {
        return  0;
    }

}
