#!/bin/bash

echo "Criando Usuário..."
curl --location --request POST 'http://abctechserviceapi-env.eba-r54kbutn.us-east-1.elasticbeanstalk.com/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username" : "fabio@fiap.com",
    "password" : "senha123"
}'

echo "Fazendo Login"
curl --location --request POST 'http://abctechserviceapi-env.eba-r54kbutn.us-east-1.elasticbeanstalk.com/users/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username" : "fabio@fiap.com",
    "password" : "senha123"
}'

## Deve-se copiar o token gerado acima.
echo "Listando Livros..."
curl --request GET \
  --url 'http://abctechserviceapi-env.eba-r54kbutn.us-east-1.elasticbeanstalk.com/livros?titulo=A' \
  --header 'Authorization: Bearer  eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmYWJpb0BmaWFwLmNvbSIsImV4cCI6MTY1Njg4NTE3MSwiaWF0IjoxNjQ5Njg1MTcxfQ.1VpZd7dwJq6pO2GstBpKwfkX0qR1cpbY6Q4fUqXoKD74Z18A71WbTMlxYzoQfF-vmNaIS23_NtJM2nuBH6i_WA' \


##Listando Get Version
echo "Verificando a versão.... "
curl --request GET --url http://abctechserviceapi-env.eba-r54kbutn.us-east-1.elasticbeanstalk.com/version \
     --header 'Authorization: Bearer  eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmYWJpb0BmaWFwLmNvbSIsImV4cCI6MTY1Nzg0MjQwMiwiaWF0IjoxNjUwNjQyNDAyfQ.Z8zE1Lnr-TwmIgVliKSb9hwFAYmEIUKdLMpX3tWFwKq7pNhaig9S5dOcrVd6cpQK5sGsg43bjM2PhKDPDECitQ'


