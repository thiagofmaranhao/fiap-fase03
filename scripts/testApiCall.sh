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
  --header 'Authorization: Bearer  eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmYWJpb0BmaWFwLmNvbSIsImV4cCI6MTY0ODU5ODQ2OSwiaWF0IjoxNjQ4NTk4MTY5fQ.YWzk0Q33dl2J0QVW1Tc-uoUjLmsi-lDsDdYkXz14i12K8UnRPwMbAMLLq1tlPFb98GDEv5qaSqwl8aiF9aZvvw' \


##Crinado um Order
echo "Criando uma ordem... AINDA FALTA COLOCAR UM JSON VALIDO"
curl --request POST \
  --url http://localhost/order \
  --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmYWJpb0BmaWFwLmNvbSIsImV4cCI6MTY0ODU5ODYzMCwiaWF0IjoxNjQ4NTk4MzMwfQ.mt66cYKdYsqo47BQOE66QvM6W0q2smHabZRKqVw55WJLhSmo1p1owS-vAIFo2CBHz_i3ZlitYgtkDTkT6ev7dg' \
  --header 'Content-Type: application/json' \
  --data '{}'