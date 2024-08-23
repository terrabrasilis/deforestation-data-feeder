#!/bin/bash
#
DATA_DIR=`pwd`
# Same dir used in feeder process. See docker-compose stack to use the same basedir.
DIR_OUT="${DATA_DIR}/../../docker-compose/output"
#
# the base directories
BASE_DIRS=("data" "config/classes" "config/periods" "config/lois" "config/loinames" "config/filters")

length=${#BASE_DIRS[@]}
for ((i=0; i<$length; ++i));
do
    if [[ ! -d "${DIR_OUT}/${BASE_DIRS[$i]}" ]]; then
        mkdir -p ${DIR_OUT}/${BASE_DIRS[$i]}
    fi;
done

#
# list of locations for each JSON LOIs
BASE_LOIS=("cerrado" "amazonia_legal" "amazonia" "caatinga" "pampa" "pantanal" "mata_atlantica" "amazonia_nf")
# list of App Identifier for each LOI as Header
APP_ID_LOIS=("cerrado" "legal_amazon" "amazon" "caatinga" "pampa" "pantanal" "mata_atlantica" "amazon_nf")

length_j=${#BASE_LOIS[@]}
for ((j=0; j<$length_j; ++j));
do
    # The name for each LOI in config API
    CONFIG_LOIS=("uf" "mun" "consunit" "indi")
    # The name for each JSON file LOI
    JSON_LOIS=("state" "municipality" "uc" "ti")

    length=${#CONFIG_LOIS[@]}
    for ((i=0; i<$length; ++i));
    do
        if [[ ! -d "${DIR_OUT}/config/${CONFIG_LOIS[$i]}" ]]; then
            mkdir ${DIR_OUT}/config/${CONFIG_LOIS[$i]}
        fi;
        cp ${BASE_LOIS[$j]}/${JSON_LOIS[$i]}.json ${DIR_OUT}/config/${CONFIG_LOIS[$i]}/prodes_${APP_ID_LOIS[$j]}.json

    done


done
