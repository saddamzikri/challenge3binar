package com.saddam.challenge3binar

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Atribute(
    val name: String? = null,
    val umur: Int? = null,
    val alamat: String? = null,
    val pekerjaan: String? = null
) : Parcelable