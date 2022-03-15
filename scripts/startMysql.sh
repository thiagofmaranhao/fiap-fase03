#!/bin/bash

# docker run --name mysql-dev -p 3306:3306 -e MYSQL_ROOT_PASSWORD=Fiap1234 -d mysql:8.0

###  For Mac M1
docker run --name mysql-dev -p 3306:3306 -e MYSQL_ROOT_PASSWORD=Fiap1234 -d mysql:8.0-oracle