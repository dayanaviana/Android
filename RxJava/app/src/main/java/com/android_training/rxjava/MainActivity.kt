package com.android_training.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android_training.rxjava.models.User
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

//Observables: Emits data when there is a change
//Observer: It receives the data by the observable
//Schedulers: It is used to provide thread to the observable and observer
//Subscriptions: Its a bond between Observable and Observer
//Disposable: It is used to dispose the bonding between Observable and Observer
class MainActivity : AppCompatActivity() {
    lateinit var user: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        user = User(email = "dayana@gmail.com", password = "password")

        getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(getObserver())
    }

    fun getObservable(): Observable<User>{
        return Observable.just(user)
    }

    fun getObserver(): Observer<User>{
        return object: Observer<User>{
            //Setup the bonding between Observable and Observer
            //Disposable: It is used to dispose the bonding between Observable and Observer
            override fun onSubscribe(d: Disposable) {
                Log.d("myApp", "Login Observer Subscribed")
            }

            //Receives string one by one
            override fun onNext(u: User) {
                Log.d("myApp", "User received:, ${u.email}")
            }

            override fun onComplete() {
                Log.d("myApp", "Receiving data complete.")
            }

            override fun onError(e: Throwable) {
                Log.d("myAp", "Error receiving Data. ${e.message}")
            }

        }
    }
}