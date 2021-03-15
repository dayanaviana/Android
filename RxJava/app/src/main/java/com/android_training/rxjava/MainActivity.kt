package com.android_training.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(getObserver())


    }

    fun getObservable(): Observable<String>{
        return Observable.just("data1","data2","data3","data4")
    }

    fun getObserver(): Observer<String>{
        return object: Observer<String>{
            override fun onComplete() {
                Log.d("myAp", "onComplete")
            }

            //Setup the bonding between Observable and Observer
            //Disposable: It is used to dispose the bonding between Observable and Observer
            override fun onSubscribe(d: Disposable) {
                Log.d("myAp", "onSubscribed")
            }

            //Receives string one by one
            override fun onNext(t: String) {
                Log.d("myAp", "onNext, $t")
            }

            override fun onError(e: Throwable) {
                Log.d("myAp", "onError")
            }

        }
    }
}