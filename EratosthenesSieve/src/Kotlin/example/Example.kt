package Kotlin.example

import Kotlin.Sieve.Eratosfen

fun main(args :Array<String>){
    val eratosfen = Eratosfen(120)
    val primenumbers = eratosfen.searchSimpleWords()
    System.out.print(primenumbers)
}