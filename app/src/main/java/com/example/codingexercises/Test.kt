package com.example.codingexercises

import kotlin.math.pow
import kotlin.math.roundToInt

private var resultFactorial = 1

fun main() {
    println(vowelCount("approximately"))
    println(combineTwoArrayAndDistinctAndSort(arrayListOf(1,3,2,4), arrayListOf(1,7,4,2)))
    println(swapCase("ComPuTeR"))
    println(factorial(5))
    println(palindrome("toot"))
    println(findBiggestNumber(arrayListOf(5,3,7,9,6)))
    println(extractDifferentWordsInASentence("This is a sentence but not a weird sentence"))
    println(fibonacci(7))
    sumAvgMaxMin(arrayListOf(1,13,8,10,5))
    println(geometricAvg(arrayListOf(2,4,8)))
    println(findMostRecurringNumber(arrayListOf(3,4,5,5,6,3,5,7,5,3,7)))
}

fun findMostRecurringNumber(list: ArrayList<Int>): Int {
    var resultSize = list.size
    var result = 0
    for (i in 0..< list.size) {
        val newList = arrayListOf<Int>()
        newList.addAll(list)
        for (j in list) {
            if (j == list[i]) {
                newList.remove(j)
            }
        }
        if(newList.size < resultSize) {
            resultSize = newList.size
            result = list[i]
        }
    }
    return result
}

fun geometricAvg(list: ArrayList<Int>): Int {
    var result = 1
    for (i in 0..< list.size) {
        result *= list[i]
    }
    return result.toDouble().pow(1/list.size.toDouble()).roundToInt()
}

fun sumAvgMaxMin(list: ArrayList<Int>) {
    val max = list.max()
    val min = list.min()
    val avg = list.average()
    val sum = list.sum()
    println("max: $max , min: $min , avg: $avg , sum: $sum")
}


fun fibonacci(count: Int): ArrayList<Int> {
    val fibonacciArray = arrayListOf(0,1)
    if (count > 1) {
        for (i in 1..count - 2) {
            fibonacciArray.add(
                fibonacciArray[fibonacciArray.size - 1] +
                        fibonacciArray[fibonacciArray.size - 2]
            )
        }
    }
    return fibonacciArray
}

fun extractDifferentWordsInASentence(sentence: String): String {
    val wordsArray = sentence.split(" ")
    var words = ""
    for (i in wordsArray.distinct()) {
        words += " $i"
    }
    return words
}

fun findBiggestNumber(array: ArrayList<Int>): Int {
    var biggest = array[0]
    for (i in 1..< array.size) {
        if (biggest < array[i]) {
            biggest = array[i]
        }
    }
    return biggest
}

fun palindrome(word: String): Boolean {
    return word == word.reversed()
}

fun factorial(number: Int): Int {
    resultFactorial = if (number == 0 || number == 1) {
        1
    } else {
        number * factorial(number - 1)
    }
    return resultFactorial
}

fun vowelCount(word: String): Int {
    val vowels = "aeiou"
    var count = 0
    for (i in word) {
        for (j in vowels) {
            if (i == j) {
                count++
            }
        }
    }
    return count
}

fun swapCase(word: String): String {
    var newWord = ""
    for (i in word) {
        newWord += if (i.isUpperCase()) {
            i.lowercaseChar()
        } else {
            i.uppercaseChar()
        }
    }
    return newWord
}

fun combineTwoArrayAndDistinctAndSort(
    first: ArrayList<Int>,
    second: ArrayList<Int>
): ArrayList<Int> {
    first.addAll(second)
    val result = first.distinct() as ArrayList<Int>
    result.sort()
    return result
}