#!/bin/bash

## Usuário admin tem acesso!
#echo "Acessando com usuário Administrador"
#curl -X GET -I --user admin:xuxuzinho http://localhost/livros?titulo=A

## Usuário User não terá acesso
#echo "Acessando com usuário User"
#curl -X GET -I --user user:user http://localhost/livros?titulo=A

curl -X GET -I  http://localhost/users/ffint/?username=fabio@fiap.com

exit 0

#echo "" # TODO VALIDAR SE USR JA EXISTE!
#echo "Criando Usuário..."
#curl --location --request POST 'http://localhost/users' \
#--header 'Content-Type: application/json' \
#--data-raw '{
#    "username" : "fabio@fiap.com",
#    "password" : "senha123"
#}'

echo ""
echo "Fazendo Login..."
TOKEN=$( \
  curl --location --request POST 'http://localhost/users/login' \
  --header 'Content-Type: application/json' \
  --data-raw '{
      "username" : "fabio@fiap.com",
      "password" : "senha123"
  }' | jq -r '.token' \
)

echo "----TOKEN $TOKEN"

## Deve-se copiar o token gerado acima.
#echo "Listando Livros..."
#curl --request GET \
#  --url 'http://localhost/livros?titulo=A' \
#  --header 'Authorization: Bearer $TOKEN' \

echo "Authorization: Bearer $TOKEN"

##Crinado um Order
echo "Criando uma ordem..."
curl --request POST \
  --url http://localhost/order \
  --header "Authorization: Bearer $TOKEN" \
  --header 'Content-Type: application/json' \
  --data '{
            "operatorId" : 2,
            "assistances" : [ {
              "id" : "1",
              "name" : "Mock Name",
              "description" : "Mock Description"
            }, {
              "id" : "2",
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

exit 0

curl --request POST \
  --url http://localhost/order/1/ \
  --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmYWJpb0BmaWFwLmNvbSIsImV4cCI6MTY1NTg4NzI0NywiaWF0IjoxNjQ4Njg3MjQ3fQ.hBIq8crm0hLnLEJBaakH0_XgmY1707s3dTP1PWba-6WROim02uz9mvNGblPvTM4sABT1AReRc_rw6gYpGq-E_g' \
  --header 'Content-Type: application/json' \
  --data '{
              "latitude" : 25,
              "longitude" : 25,
              "date" : 1648599964784
          }'