package com.example.mvc_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() , Observer , View.OnClickListener
{
    private lateinit var myModel : Model
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myModel = Model()
        myModel.addObserver(this)

        btnFirstCount.setOnClickListener(this)
        btnSecondCount.setOnClickListener(this)
        btnThirdCount.setOnClickListener(this)
    }

    override fun update(observable : Observable? , argument : Any?)
    {
        btnFirstCount.text = "Count: ${myModel.getValue(0)}"
        btnSecondCount.text = "Count: ${myModel.getValue(1)}"
        btnThirdCount.text = "Count: ${myModel.getValue(2)}"
    }

    override fun onClick(view : View?)
    {
        when (view?.id)
        {
            R.id.btnFirstCount -> myModel?.setValueAtIndex(0)
            R.id.btnSecondCount -> myModel?.setValueAtIndex(1)
            R.id.btnThirdCount -> myModel?.setValueAtIndex(2)
        }
    }
}