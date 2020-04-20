package com.gmail.neirdag.calculetteouf

import android.util.Log

class Calculator{

    fun compute(calcString:String):Double{
        //string de type : 5+2*3+18/9
        var calcStr = calcString

        if (calcString.contains("-")){
            calcStr = calcString.replace("-","+-1*")
        }

        var sums = calcStr.split('+').toMutableList()
        var minus:MutableList<MutableList<String>> = mutableListOf()
        var times:MutableList<MutableList<String>> = mutableListOf()
        var divisons:MutableList<MutableList<String>> = mutableListOf()


        var result:Double = 0.0

        for (j in sums.indices)
        {
            times.add(sums[j].split('*').toMutableList())

        }
        for (i in sums.indices)
        {
            divisons.add(sums[i].split('/').toMutableList())
        }



        for (i in times.indices)
        {
            for (j in times[i].indices){

                if (times[i][j].contains("/")){
                    var divided = times[i][j].split("/")
                    var divisonsSum:Double = divided[0].toDouble()
                    for (k in 1 until  divided.size ){
                        divisonsSum *= 1.0 / divided[k].toDouble()
                    }
                    times[i][j] ="$divisonsSum"
                }

                }

        }
        for (i in times.indices)
        {
            if (times[i].size > 1){
                var timesSum:Double = times[i][0].toDouble()
                for (j in 1 until times[i].size)
                {
                    timesSum *= times[i][j].toDouble()
                }
                sums.set(i,"$timesSum")
            }

        }

        for (i in sums.indices)
        {
            if (sums[i].contains("/")){
                var divided = sums[i].split("/")
                var divisonsSum:Double = divided[0].toDouble()
                for (k in 1 until  divided.size ){
                    divisonsSum *= 1.0 / divided[k].toDouble()
                }
                sums[i] ="$divisonsSum"
            }
        }

        if (sums.size >= 1){
            var sumSum:Double = 0.0
            for (i in 0 until sums.size)
            {
                sumSum += sums[i].toDouble()
            }
            result = sumSum
        }


        Log.d("sumsCalc", "$sums")
        Log.d("minusCalc", "$minus")
        Log.d("timesCalc", "$times")
        Log.d("divisions", "$divisons")
        Log.d("result", "$result")
        // => 5 + 6 + 2
        //doit obtenir : 13
       return result
    }
}