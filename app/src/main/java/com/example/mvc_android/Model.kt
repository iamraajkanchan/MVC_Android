package com.example.mvc_android

import java.lang.IndexOutOfBoundsException
import java.util.*
import kotlin.collections.ArrayList

class Model : Observable()
{
    private val list : MutableList<Int>

    init
    {
        list = ArrayList(3)
        list.add(0)
        list.add(0)
        list.add(0)
    }

    @Throws(IndexOutOfBoundsException::class)
    fun getValue(theIndex : Int) : Int
    {
        return list[theIndex]
    }

    @Throws(IndexOutOfBoundsException::class)
    fun setValueAtIndex(theIndex : Int)
    {
        list[theIndex] = list[theIndex] + 1
        setChanged()
        notifyObservers()
    }
}