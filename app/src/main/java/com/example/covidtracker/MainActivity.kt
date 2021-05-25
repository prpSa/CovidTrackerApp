@file:Suppress("Annotator", "Annotator", "Annotator")

package com.example.covidtracker

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Request.*
import com.android.volley.Request.Method
import com.android.volley.toolbox.Volley
import com.android.volley.toolbox.JsonObjectRequest as JsonObjectRequest


class MainActivity : AppCompatActivity() {
    lateinit var worldCaseTV:TextView
    lateinit var worldRecoveredTV:TextView
    lateinit var worldDeathTV:TextView
    lateinit var countryCasesTV:TextView
    lateinit var countryRecoveredTV:TextView
    lateinit var countryDeathsTV:TextView
    lateinit var stateRV:RecyclerView
    lateinit var stateRVAdapter: StateRVAdapter
    lateinit var stateList: List<StateModal>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        worldCaseTV = findViewById(R.id.idTVWorldCases)
        worldRecoveredTV = findViewById(R.id.idTVWorldRecoverd)
        worldDeathTV = findViewById(R.id.idTVWorldDeaths)
        countryCasesTV = findViewById(R.id.idTVIndiaCases)
        countryRecoveredTV = findViewById(R.id.idTVIndiaRecoverd)
        countryDeathsTV = findViewById(R.id.idTVIndiaDeaths)
        stateRV = findViewById(R.id.idRVStates)
        stateList = ArrayList<StateModal>()
        getStateInfo()
        getWorldInfo()

    }
    private fun getStateInfo(){
        val url = "https://api.rootnet.in/covid19-in/stats/latest"
        val queue = Volley.newRequestQueue(this@MainActivity)
        val request =
            JsonObjectRequest(Request.Method.GET, url,null, {response ->
}