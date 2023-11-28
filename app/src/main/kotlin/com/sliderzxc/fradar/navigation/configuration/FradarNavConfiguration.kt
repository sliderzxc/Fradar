package com.sliderzxc.fradar.navigation.configuration

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class FradarNavConfiguration : Parcelable {
    @Parcelize
    data object Auth : FradarNavConfiguration()
}