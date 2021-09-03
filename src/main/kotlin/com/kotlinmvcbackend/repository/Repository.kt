package com.kotlinmvcbackend.repository

import com.kotlinmvcbackend.model.Cliente
import org.springframework.data.mongodb.repository.MongoRepository

interface Repository : MongoRepository<Cliente, String>{
    abstract fun save(cliente: Cliente?): Cliente?
}