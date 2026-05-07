package es.usj.jjhernandez.mobileapps

interface IDao<T> {

    fun find(id: String): T?

    fun findAll(): List<T>

    fun insert(t: T): T

    fun update(t: T): T

    fun delete(t: T): Int
}