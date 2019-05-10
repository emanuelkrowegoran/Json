package emanuelkrowegoran.gmail.com


import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable


class PlayerItem : Parcelable {
    var no: String? = null
    var name: String? = null
    var position: String? = null
    var birth_date: String? = null
    var poster: String? = null

    constructor(no: String, name: String, Position: String, birth_date: String, Poster: String) {
        this.no = no
        this.name = name
        this.position = Position
        this.birth_date = birth_date
        this.poster = Poster
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(this.no)
        parcel.writeString(this.name)
        parcel.writeString(this.position)
        parcel.writeString(this.birth_date)
        parcel.writeString(this.poster)
    }

    constructor() {}

    protected constructor(`in`: Parcel) {
        this.no = `in`.readString()
        this.name = `in`.readString()
        this.position = `in`.readString()
        this.birth_date = `in`.readString()
        this.poster = `in`.readString()
    }

    companion object {

        @SuppressLint("ParcelCreator")
        val CREATOR: Parcelable.Creator<PlayerItem> = object : Parcelable.Creator<PlayerItem> {

            override fun createFromParcel(source: Parcel): PlayerItem {
                return PlayerItem(source)
            }

            override fun newArray(size: Int): Array<PlayerItem?> {
                return arrayOfNulls(size)
            }
        }
    }
}