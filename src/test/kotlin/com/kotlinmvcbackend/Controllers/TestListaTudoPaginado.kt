package com.kotlinmvcbackend.Controllers

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.lang.Exception


@SpringBootTest
@AutoConfigureMockMvc
class TestListaTudoPaginado {
    @Autowired
    var mockMvc: MockMvc? = null

    @Autowired
    private val objectMapper: ObjectMapper? = null

    @Test
    @Throws(Exception::class)
    fun Caso01() {
        mockMvc!!.perform(MockMvcRequestBuilders.get("/api/lista_tudo_paginado").
        contentType("application/json")).andExpect(MockMvcResultMatchers.status().isOk)
    }
    @Test
    @Throws(Exception::class)
    fun Caso02() {
        mockMvc!!.perform(MockMvcRequestBuilders.get("/api/lista_tudo_paginado?qtde=2").
        contentType("application/json")).andExpect(MockMvcResultMatchers.status().isOk)
    }
}