#!/bin/bash
#
DATA_DIR=`pwd`
#
# list of locations for each JSON LOIs
BASE_LOIS=("cerrado" "amazonia_legal" "amazonia" "caatinga" "pampa" "pantanal" "mata_atlantica" "amazonia_nf")
# list of App Identifier for each LOI as Header
APP_ID_LOIS=("cerrado" "legal_amazon" "amazon" "caatinga" "pampa" "pantanal" "mata_atlantica" "amazon_nf")

length_j=${#BASE_LOIS[@]}
for ((j=0; j<$length_j; ++j));
do

    docker-compose -f ${DATA_DIR}/../../docker-compose/docker-compose.yml up -d
    sleep 10

    # The name for each LOI in config API
    CONFIG_LOIS=("uf" "mun" "consunit" "indi")
    # The name for each JSON file LOI
    JSON_LOIS=("state" "municipality" "uc" "ti")

    length=${#CONFIG_LOIS[@]}
    for ((i=0; i<$length; ++i));
    do
        curl -X POST -d @${BASE_LOIS[$j]}/${JSON_LOIS[$i]}.json http://localhost:3000/dashboard/api/v1/redis-cli/config/${CONFIG_LOIS[$i]} \
        -H "App-Identifier:prodes_${APP_ID_LOIS[$j]}" -H "Content-Type: application/json"
        
        sleep 2
    done

    docker-compose -f ${DATA_DIR}/../../docker-compose/docker-compose.yml down

done
