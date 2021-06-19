package com.base.myapplication.aidl

import android.os.Parcel
import android.os.Parcelable

class Book : Parcelable {
    var bookId = 0
    var bookName: String? = null

    constructor(bookId: Int, bookName: String?) {
        this.bookId = bookId
        this.bookName = bookName
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(bookId)
        dest.writeString(bookName)
    }

    constructor() {}
    protected constructor(`in`: Parcel) {
        bookId = `in`.readInt()
        bookName = `in`.readString()
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Book?> = object : Parcelable.Creator<Book?> {
            override fun createFromParcel(source: Parcel): Book? {
                return Book(source)
            }

            override fun newArray(size: Int): Array<Book?> {
                return arrayOfNulls(size)
            }
        }
    }
}