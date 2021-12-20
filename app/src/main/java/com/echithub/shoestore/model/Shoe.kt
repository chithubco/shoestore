package com.echithub.shoestore.model

import android.os.Parcel
import android.os.Parcelable
import android.text.Editable

data class Shoe(
    val name: String?,
    val code: String?,
    val price: Int,
    val quantity: Int,
    val colour: String?,
    val size: Int,
    val imageUrl: String?,
    val company: String?,
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(code)
        parcel.writeInt(price)
        parcel.writeInt(quantity)
        parcel.writeString(colour)
        parcel.writeInt(size)
        parcel.writeString(imageUrl)
        parcel.writeString(company)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Shoe> {
        override fun createFromParcel(parcel: Parcel): Shoe {
            return Shoe(parcel)
        }

        override fun newArray(size: Int): Array<Shoe?> {
            return arrayOfNulls(size)
        }
    }
}
