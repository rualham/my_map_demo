package com.android.mp.activity

class ListDemo {


}

//https://mp.weixin.qq.com/s/gZ2dsbbrf0zT85JVAjAKbg  代码链接
fun main(args: Array<String>) {
    var a: List<Int> = listOf(1, 2, 3).filter {
        print("$it ")
        it >= 2
    }

    for (i in a) {
        print("filter +$i ")
    }
    print("- ")
    listOf(1, 3, 5 )
        .asSequence()
        .map {
            print("$it")
            it + 1
        }
        .filter {
            print("$it ")
            it >= 3
        }.toList()
}