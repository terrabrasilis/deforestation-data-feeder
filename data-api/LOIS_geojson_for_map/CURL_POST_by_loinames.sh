#!/bin/bash
#
# list of LOIs
BASE_LOIS=("cerrado" "legal_amazon" "amazon" "caatinga" "pampa" "pantanal" "mata_atlantica" "amazon_nf")

for BASE_LOI in ${BASE_LOIS[@]}
do

LOIS=("uf" "mun" "consunit" "indi")

    for LOI in ${LOIS[@]}
    do

        curl -X POST -d @${BASE_LOI}_${LOI}.json http://localhost:3000/dashboard/api/v1/redis-cli/config/${LOI} \
        -H "App-Identifier:prodes_${BASE_LOI}" -H "Content-Type: application/json Charset=utf-8"

    done

done
