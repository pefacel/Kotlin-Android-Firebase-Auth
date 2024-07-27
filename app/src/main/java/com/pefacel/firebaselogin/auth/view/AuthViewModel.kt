package com.pefacel.firebaselogin.auth.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.pefacel.firebaselogin.auth.network.AuthService
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val authService = AuthService()

    val user = MutableLiveData<FirebaseUser?>()

    val isLoading = MutableLiveData<Boolean>(false)


    fun loginWithEmailAndPassword(email: String, password: String) {

        viewModelScope.launch {

            isLoading.postValue(true)

            val result = authService.loginWithEmailAndPassword(email, password)

            if (result != null) {
                user.postValue(result)
            }

            isLoading.postValue(false)

        }
    }


    fun registerWithEmailAndPassword(email: String, password: String) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val result = authService.registerWithEmailAndPassword(email, password)
            if (result != null) {
                user.postValue(result)
            }
            isLoading.postValue(true)

        }


    }


}