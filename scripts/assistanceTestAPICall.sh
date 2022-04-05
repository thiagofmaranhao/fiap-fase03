#!/bin/bash

##Crinado um Order
echo "Criando uma ordem... "
curl --request POST \
  --url http://localhost/order \
  --header 'Content-Type: application/json' \
  --data '{
               "operatorId" : 123,
               "assistances" : [1, 2],
               "startOrderLocation" : {
                "latitude" : -23.555420,
                "longitude" : -46.601060,
                "date" : "2022-03-31T19:30:00"
              },
              "endOrderLocation" : {
                "latitude" : -23.555420,
                "longitude" : -46.601060,
                "date" : "2022-03-31T20:21:00"
            }
          }'


echo "Criando uma ordem sem nenhum Assistance... "
curl --request POST \
  --url http://localhost/order \
  --header 'Content-Type: application/json' \
  --data '{
               "operatorId" : 123,
               "assistances" : [],
               "startOrderLocation" : {
                "latitude" : -23.555420,
                "longitude" : -46.601060,
                "date" : "2022-03-31T19:30:00"
              },
              "endOrderLocation" : {
                "latitude" : -23.555420,
                "longitude" : -46.601060,
                "date" : "2022-03-31T20:21:00"
            }
          }'

echo ""
echo "Criando uma ordem scom mais de 15 assistences Assistance... "
curl --request POST \
  --url http://localhost/order \
  --header 'Content-Type: application/json' \
  --data '{
               "operatorId" : 123,
               "assistances" : [1, 2, 3, 4, 5, 6, 2, 3, 4, 5, 6, 2, 3, 4, 5, 6, 2, 3, 4, 5, 6],
               "startOrderLocation" : {
                "latitude" : -23.555420,
                "longitude" : -46.601060,
                "date" : "2022-03-31T19:30:00"
              },
              "endOrderLocation" : {
                "latitude" : -23.555420,
                "longitude" : -46.601060,
                "date" : "2022-03-31T20:21:00"
            }
          }'