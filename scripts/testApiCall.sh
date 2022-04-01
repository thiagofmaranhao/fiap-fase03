#!/bin/bash

echo "Criando Usuário..."
curl --location --request POST 'http://localhost/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username" : "fabio@fiap.com",
    "password" : "senha123"
}'

echo "Fazendo Login"
curl --location --request POST 'http://localhost/users/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username" : "fabio@fiap.com",
    "password" : "senha123"
}'

## Deve-se copiar o token gerado acima.
echo "Listando Livros..."
curl --request GET \
  --url 'http://localhost/livros?titulo=A' \
  --header 'Authorization: Bearer  eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmYWJpb0BmaWFwLmNvbSIsImV4cCI6MTY1NTg4NjE1MSwiaWF0IjoxNjQ4Njg2MTUxfQ.di1j_qNCsZFv3k92ncacgJxCgk2oWwo1aWQWo2H96U19quGOmD6fLxpgvZdiNplJjLv8ByeqO0p2P38OH_tz4A' \


