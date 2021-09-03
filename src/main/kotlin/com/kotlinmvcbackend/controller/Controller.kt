package com.kotlinmvcbackend.controller

import com.kotlinmvcbackend.model.Cliente
import com.kotlinmvcbackend.repository.Repository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api"])
class Controller {

    @Autowired
    var repository: Repository? = null


    @GetMapping("/clientes")
    fun listaClientes(): ResponseEntity<List<Cliente?>> {
        return ResponseEntity.ok<List<Cliente?>>(repository?.findAll())
    }


    @Transactional
    @CacheEvict(value = ["/novo_cliente"], allEntries = true)
    @PostMapping("/novo_cliente")
    fun novaCliente(@RequestBody cliente: Cliente?): ResponseEntity<Cliente> {
        return ResponseEntity.ok<Cliente?>(repository?.save(cliente))
    }


}