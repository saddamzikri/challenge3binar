package com.saddam.challenge3binar

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Atribute(
    val name: String? = null,
    val gaji: Int,
    val iuranBulanan: Int,
    val belanja: Int,
) : Parcelable

// @Parcelize
// data class Atribute(val name: String? = null, val gaji: Int, val iuranBulanan: Int, val belanja: Int): Parcelable {
// }