package com.kotlinmvcbackend.controller

import com.kotlinmvcbackend.model.Cliente
import com.kotlinmvcbackend.repository.Repository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(value = ["/api"])
class Controller {

    @Autowired
    var repository: Repository? = null



    @GetMapping("/lista_tudo_paginado")
    fun listaTudoPaginado
            (@RequestParam(value = "qtde"  , required = false, defaultValue = "0")qtde: String,
             @RequestParam(value = "pagina", required = false, defaultValue = "0")page: String)
             : ResponseEntity<Page<Cliente?>>
    {
        var quantidade = qtde
        var pagina     = page

        if(quantidade.equals("0")){
            var listClientes = repository?.findAll()
            var numero = listClientes?.size
            quantidade = numero.toString()
        }


        var paginacao: Pageable = PageRequest.of(pagina.toInt(), quantidade.toInt())
        var listaClientePaginado = repository?.findAll(paginacao)
        return ResponseEntity.ok<Page<Cliente?>>(listaClientePaginado)

    }


    @GetMapping("/lista_cliente_por_id")
    fun listaPorId
    (@RequestParam(value = "id", required = false, defaultValue = "0")
     id: String): ResponseEntity<Cliente?> { if(id.equals("0")){
            val erroCliente = Cliente()
            erroCliente.nome="Erro: Informe um id."

            return ResponseEntity.status(412).body<Cliente?>(erroCliente)
        }
        var recebeCliente = repository?.findById(id)
        var exibe = recebeCliente?.get()
        return ResponseEntity.ok<Cliente?>(exibe)

    }


    @GetMapping("/lista_clientes_por_nome")
    fun listaPorNome(
        @RequestParam(value = "nome", required = false, defaultValue = "0")
        nome: String): ResponseEntity<List<Cliente?>> {
        if(nome.equals("0")){
              val erroCliente = Cliente()
              erroCliente.nome="Erro: Informe um nome."
              val listNotas: MutableList<Cliente> = ArrayList<Cliente>()
              listNotas.add(erroCliente)

              return ResponseEntity.status(412).body<List<Cliente?>>(listNotas)
        }
        var listClientes = repository?.findAllByNomeContains(nome)
        return ResponseEntity.ok<List<Cliente?>>(listClientes)

    }

    @GetMapping("/clientes")
    fun listaClientes(): ResponseEntity<List<Cliente?>> {
        var listClientes = repository?.findAll()
        return ResponseEntity.ok<List<Cliente?>>(listClientes)
    }


    @Transactional
    @CacheEvict(value = ["/novo_cliente"], allEntries = true)
    @PostMapping("/novo_cliente")
    fun novaCliente(@RequestBody cliente: Cliente?): ResponseEntity<Cliente> {
        var salva:Cliente? = repository?.save(cliente)
        return ResponseEntity.ok<Cliente?>(salva)
    }


}