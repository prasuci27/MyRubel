package com.boss.myrubelapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class User (
        var uid : String? = "",
        var nama : String? = "",
        var username: String? = "",
        var photoUrl : String? = ""
            ) : Parcelable {
                constructor() : this ("", "", "","")
            }