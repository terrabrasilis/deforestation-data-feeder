#!/bin/bash
#
DATA_DIR=`pwd`
#
# list of LOIs
BASE_LOIS=("cerrado" "legal_amazon" "amazon" "caatinga" "pampa" "pantanal" "mata_atlantica" "amazon_nf")

for BASE_LOI in ${BASE_LOIS[@]}
do

    docker-compose -f ${DATA_DIR}/../../docker-compose/docker-compose.yml up -d
    sleep 10

    LOIS=("uf" "mun" "consunit" "indi")

    for LOI in ${LOIS[@]}
    do

        curl -X POST -d @${BASE_LOI}_${LOI}.json http://localhost:3000/dashboard/api/v1/redis-cli/config/${LOI} \
        -H "App-Identifier:prodes_${BASE_LOI}" -H "Content-Type: application/json"
        
        sleep 2
    done

    docker-compose -f ${DATA_DIR}/../../docker-compose/docker-compose.yml down

done
