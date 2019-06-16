package com.example.sbkotlingradle

import org.springframework.data.util.ProxyUtils
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class GenericIdTable<T> {

    @Id
    @GeneratedValue
    private var id: T? = null

    fun getId(): T? {
        return id
    }

    fun setId(id: T?): Unit {
        this.id = id
    }

    override fun equals(other: Any?): Boolean {
        other ?: return false

        if (this === other) return true

        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as GenericIdTable<*>

        return if (null == this.getId()) false else this.getId() == other.getId()
    }

    override fun hashCode(): Int {
        return 31
    }

    override fun toString() = "Entity of type ${this.javaClass.name} with id: $id"

}
