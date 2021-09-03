package com.kotlinmvcbackend.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Getter
import lombok.Setter
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Document(collection = "Notas")
class Cliente {

    @Id
    @JsonProperty("_id")
    var id: String? = null
    var nome: String? = null

    /*
        caso banco relacional
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
    */

}