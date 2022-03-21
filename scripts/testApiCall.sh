#!/bin/bash

## Usuário admin tem acesso!
echo "Acessando com usuário Administrador"
curl -X GET -v --user admin:xuxuzinho http://localhost/livros?titulo=A

echo "----"
echo "----"
echo "----"
echo "----"
echo "----"

## Usuário User não terá acesso
echo "Acessando com usuário User"
curl -X GET -v --user user:user http://localhost/livros?titulo=A


curl --location --request POST 'http://localhost:8088/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username" : "fabio@fiap.com",
    "password" : "senha123"
}'