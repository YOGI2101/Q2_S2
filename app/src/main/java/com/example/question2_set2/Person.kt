package com.example.question2_set2

class Person (var p_name:String, var p_height:Double, var p_weight:Double) {
    var p_id:Int = 0

    constructor(p_id:Int, p_name: String,p_height: Double,p_weight: Double):this(p_name, p_height, p_weight)
    {
        this.p_id = p_id
    }
}