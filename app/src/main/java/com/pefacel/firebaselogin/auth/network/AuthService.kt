package com.pefacel.firebaselogin.auth.network

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class AuthService {

    private lateinit var auth: FirebaseAuth


    suspend fun loginWithEmailAndPassword(email: String, password: String): FirebaseUser? {
        auth = Firebase.auth
        return withContext(Dispatchers.IO) {
            auth.signInWithEmailAndPassword(email, password).await().user
        }
    }

    suspend fun registerWithEmailAndPassword(email: String, password: String): FirebaseUser? {
        auth = Firebase.auth
        return withContext(Dispatchers.IO) {
            auth.createUserWithEmailAndPassword(email, password).await().user
        }
    }


}