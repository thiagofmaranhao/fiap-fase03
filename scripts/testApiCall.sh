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
  --header 'Authorization: Bearer  eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmYWJpb0BmaWFwLmNvbSIsImV4cCI6MTY0ODU5OTM0MiwiaWF0IjoxNjQ4NTk5MDQyfQ.xyW2_koAOGqXastz9sKnFmj8j0cvaR3hYTAibBWZJ0DaaS5FYiOwSjUZ2RAOQQNBeCklsyhLYqKFUZDHdlkANw"' \


##Crinado um Order
echo "Criando uma ordem... AINDA FALTA COLOCAR UM JSON VALIDO"
curl --request POST \
  --url http://localhost/order \
  --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmYWJpb0BmaWFwLmNvbSIsImV4cCI6MTY0ODU5OTM0MiwiaWF0IjoxNjQ4NTk5MDQyfQ.xyW2_koAOGqXastz9sKnFmj8j0cvaR3hYTAibBWZJ0DaaS5FYiOwSjUZ2RAOQQNBeCklsyhLYqKFUZDHdlkANw"' \
  --header 'Content-Type: application/json' \
  --data '{
            "operatorId" : 2,
            "assistances" : [ {
              "name" : "Mock Name",
              "description" : "Mock Description"
            }, {
              "name" : "Mock Name 2",
              "description" : "Mock Description 2"
            } ],
            "startOrderLocation" : {
              "latitude" : 2,
              "longitude" : 2,
              "date" : 1648599964784
            },
            "endOrderLocation" : {
              "latitude" : 2,
              "longitude" : 2,
              "date" : 1648599964784
            }
          }'