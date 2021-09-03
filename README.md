# KotlinBackendMVC_CRUD01
KotlinBackendMVC_CRUD01
</br>
Requisitos </br>
-Java11  </br>
-MongoDB </br>
</br>
Endpoints disponveis </br>
[Post]-Grava novo </br>
curl --location --request POST 'localhost:8080/api/novo_cliente' \
--header 'Content-Type: application/json' \
--data-raw '{

    "nome":"teste"
}'

</br>
[Get]-Lista todos </br>
curl --location --request GET 'localhost:8080/api/clientes' \
--header 'Content-Type: application/json' \
--data-raw ' '

</br> </br> </br>
-[Get]-Lista por nome </br>
curl --location --request GET 'localhost:8080/api/lista_clientes_por_nome?nome=t' \
--header 'Content-Type: application/json' \
--data-raw ' '
</br>
</br> </br>
-[Get]-Lista por id </br>
curl --location --request GET 'localhost:8080/api/lista_cliente_por_id?id=61317fb6bc041a206fb93bc9' \
--header 'Content-Type: application/json' \
--data-raw ' '

