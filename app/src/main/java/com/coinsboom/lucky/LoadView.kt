package com.coinsboom.lucky

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.coinsboom.lucky.utils.Timer
import com.facebook.FacebookSdk
import com.facebook.applinks.AppLinkData
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.get
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

class LoadView:AppCompatActivity() {
    var remoteConfig = Firebase.remoteConfig
    val configSettings = remoteConfigSettings {
        minimumFetchIntervalInSeconds = 500
    }
    var checkTimer = 0

    var timer = Timer(object:Runnable{
        override fun run() {
            remoteConfig.setConfigSettingsAsync(configSettings)
            remoteConfig.setDefaultsAsync(R.xml.default_value)
            remoteConfig.fetchAndActivate()
                .addOnCompleteListener(this@LoadView) { task ->

                }
            checkTimer++

            if(checkTimer == 50){
                stopTimer()
            }

        }
    },300,true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.load_activity)

        FacebookSdk.setAutoInitEnabled(true)
        FacebookSdk.fullyInitialize()
        AppLinkData.fetchDeferredAppLinkData(this) { appLinkData ->
            Log.i("Deep","${appLinkData?.targetUri}")
            Log.i("Deep","${appLinkData?.targetUri}")
            var appLink = appLinkData?.targetUri

        }

        var url = remoteConfig[LOADING_PHASE].asString()

        if(url =="Fetching config…" || url =="null" || url == null){
            startTimer()
        }else{

        }
    }

    fun replaceToActivity(){
        var intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
    fun replaceToWebView(){

    }
    fun startTimer(){ timer.startTimer() }
    fun stopTimer(){ timer.stopTimer() }


    override fun onStop() {
        super.onStop()
        stopTimer()
    }
    companion object{
        private const val LOADING_PHASE = "web_url"
    }
}