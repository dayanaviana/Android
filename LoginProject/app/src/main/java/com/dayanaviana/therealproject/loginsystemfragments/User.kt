package com.dayanaviana.therealproject.loginsystemfragments

import java.io.Serializable

data class User (
    var name: String,
    var email: String,
    var password: String
) : Serializable {
    companion object {
        const val USER_DATA = "USER_DATA"
    }
}