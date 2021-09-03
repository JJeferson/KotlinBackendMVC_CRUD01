package com.kotlinmvcbackend.Controllers

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.lang.Exception

@SpringBootTest
@AutoConfigureMockMvc
class TestListaPorId {

    @Autowired
    var mockMvc: MockMvc? = null

    @Autowired
    private val objectMapper: ObjectMapper? = null

    var idValido:String = "61324eb820f01c7eb292d097"//Antes de rodar os testes ter certeza que o id existe
    @Test
    @Throws(Exception::class)
    fun Caso01() {
        mockMvc!!.perform(MockMvcRequestBuilders.get("/api/lista_cliente_por_id").
        contentType("application/json")).andExpect(MockMvcResultMatchers.status().`is`(412))
    }

    @Test
    @Throws(Exception::class)
    fun Caso02() {
        mockMvc!!.perform(MockMvcRequestBuilders.get("/api/lista_cliente_por_id?id="+idValido).
        contentType("application/json")).andExpect(MockMvcResultMatchers.status().isOk)
    }
}