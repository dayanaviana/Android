package com.example.android.tmo.test.viewmodel

import androidx.lifecycle.ViewModel
import org.openapitools.client.apis.PetApi
import org.openapitools.client.infrastructure.ClientException
import org.openapitools.client.infrastructure.ServerException
import org.openapitools.client.models.Pet

class AlphaViewModel : ViewModel() {
    fun addPet() {
        val apiInstance = PetApi()
    }
    // TODO: Implement the ViewModel
}