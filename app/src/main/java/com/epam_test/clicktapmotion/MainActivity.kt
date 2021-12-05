package com.epam_test.clicktapmotion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {




    companion object {
        const val COUNT_KEY  = "COUNT_KEY"
    }
    private var count = 0
        set(value) {
            field = value
            val TCounter =  findViewById<TextView>(R.id.TabsCounter)
            val BeginTextTC = getResources().getString(R.string.TCount)
            TCounter.text =   "$BeginTextTC - $value"
        }

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RefreshCharacterCounter()



        val TCounter =  findViewById<TextView>(R.id.TabsCounter)
        val BeginTextTC = getResources().getString(R.string.TCount)
        TCounter.text =   "$BeginTextTC - $count"

        var Button1 =  findViewById<Button>(R.id.Button1)
        val Button2 =  findViewById<Button>(R.id.Button2)
        val Button3 =  findViewById<Button>(R.id.Button3)

        Button1.setOnClickListener(this)
        Button2.setOnClickListener(this)
        Button3.setOnClickListener(this)

        val InputTextView1 =  findViewById<TextView>(R.id.TextView1)
        InputTextView1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { RefreshCharacterCounter() }
        })

        val InputTextView2 =  findViewById<TextView>(R.id.TextView2)
        InputTextView2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { RefreshCharacterCounter() }
        })



    }

    override fun onSaveInstanceState(outState: Bundle) { // Here You have to save count value
        super.onSaveInstanceState(outState)
        outState.putInt(COUNT_KEY, count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) { // Here You have to restore count value
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt(COUNT_KEY)
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.Button1 -> {count += 1;RefreshTabsCounter()}
            R.id.Button2 -> {count += 1;RefreshTabsCounter()}
            R.id.Button3 -> {count += 1;RefreshTabsCounter()}
            else -> {
            }
        }
    }

    fun RefreshTabsCounter(){
        val TCounter =  findViewById<TextView>(R.id.TabsCounter)
        val BeginTextTC = getResources().getString(R.string.TCount)
        TCounter.text =  "$BeginTextTC - $count"
    }

    fun RefreshCharacterCounter(){
        val TextView1 =  findViewById<TextView>(R.id.TextView1)
        val TextView2 =  findViewById<TextView>(R.id.TextView2)
        val CharacterCounter =  findViewById<TextView>(R.id.CharacterCounter)
        val CharacterCount = TextView1.text.length +  TextView2.text.length

        val BeginTextCC = getResources().getString(R.string.СhCount)
        CharacterCounter.text = "$BeginTextCC - $CharacterCount"
    }
}
