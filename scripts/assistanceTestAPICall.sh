#!/bin/bash

##Listando Assistances
echo "Listando assitances... "
curl --request GET --url http://abctechserviceapi-env.eba-r54kbutn.us-east-1.elasticbeanstalk.com/assistance \
     --header 'Authorization: Bearer  eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmYWJpb0BmaWFwLmNvbSIsImV4cCI6MTY1Njg4NTE3MSwiaWF0IjoxNjQ5Njg1MTcxfQ.1VpZd7dwJq6pO2GstBpKwfkX0qR1cpbY6Q4fUqXoKD74Z18A71WbTMlxYzoQfF-vmNaIS23_NtJM2nuBH6i_WA'
