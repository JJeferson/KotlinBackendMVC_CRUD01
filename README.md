# KotlinBackendMVC_CRUD01
KotlinBackendMVC_CRUD01
</br>
Requisitos </br>
-Java11  </br>
-MongoDB </br>
</br>
Endpoints disponveis </br>
[Post] </br>
curl --location --request POST 'localhost:8080/api/novo_cliente' \
--header 'Content-Type: application/json' \
--data-raw '{

    "nome":"teste"
}'

</br>
[Get] </br>
curl --location --request GET 'localhost:8080/api/clientes' \
--header 'Content-Type: application/json' \
--data-raw ' '

