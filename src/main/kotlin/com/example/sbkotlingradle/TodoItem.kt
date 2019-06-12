package com.example.sbkotlingradle

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import org.hibernate.annotations.Type
import org.hibernate.type.StandardBasicTypes
import java.sql.Types
import javax.persistence.Column
import javax.persistence.Entity

@Entity
data class TodoItem(
        @Type(type = "text") @JacksonXmlProperty var label: String,
        var text: String
) : AbstractIdPersistable<Long?>() {

    constructor(id: Long?, label: String, text: String) : this(label, text) {
        super.setId(id)
    }

    operator fun component3(): Long? = super.getId()
}