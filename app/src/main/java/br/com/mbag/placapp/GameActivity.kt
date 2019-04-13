package br.com.mbag.placapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.content.Intent
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_main.*


class GameActivity : AppCompatActivity() {

    var goalHome=0
    var goalAway=0
    var home=""
    var away=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        home = intent.getStringExtra("HOME")
        away = intent.getStringExtra("AWAY")

        if(savedInstanceState!=null){
            goalHome=savedInstanceState.getInt("GOALHOME")
            goalAway=savedInstanceState.getInt("GOALAWAY")
        }

        tvGoalHome.text=goalHome.toString()
        tvGoalAway.text=goalAway.toString()

        tvHome.text=home
        tvAway.text=away


        btGoalHome.setOnClickListener{
            goalHome++;
            tvGoalHome.text=goalHome.toString()
        }

        btGoalAway.setOnClickListener{
            goalAway++;
            tvGoalAway.text=goalAway.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt("GOALHOME",goalHome)
        outState?.putInt("GOALAWAY",goalAway)
    }
}
