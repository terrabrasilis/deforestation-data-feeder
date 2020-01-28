curl -X POST -d @amazon_uf.json http://localhost:3000/dashboard/api/v1/redis-cli/config/uf -H "App-Identifier:prodes_amazon" -H "Content-Type: application/json"

curl -X POST -d @amazon_mun.json http://localhost:3000/dashboard/api/v1/redis-cli/config/mun -H "App-Identifier:prodes_amazon" -H "Content-Type: application/json"

curl -X POST -d @amazon_consunit.json http://localhost:3000/dashboard/api/v1/redis-cli/config/consunit -H "App-Identifier:prodes_amazon" -H "Content-Type: application/json"

curl -X POST -d @amazon_indi.json http://localhost:3000/dashboard/api/v1/redis-cli/config/indi -H "App-Identifier:prodes_amazon" -H "Content-Type: application/json"

#curl -X POST -d @amazon_pathrow.json http://localhost:3000/dashboard/api/v1/redis-cli/config/pathrow -H "App-Identifier:prodes_amazon" -H "Content-Type: application/json"


curl -X POST -d @cerrado_uf.json http://localhost:3000/dashboard/api/v1/redis-cli/config/uf -H "App-Identifier:prodes_cerrado" -H "Content-Type: application/json"

curl -X POST -d @cerrado_mun.json http://localhost:3000/dashboard/api/v1/redis-cli/config/mun -H "App-Identifier:prodes_cerrado" -H "Content-Type: application/json"

curl -X POST -d @cerrado_consunit.json http://localhost:3000/dashboard/api/v1/redis-cli/config/consunit -H "App-Identifier:prodes_cerrado" -H "Content-Type: application/json"

curl -X POST -d @cerrado_indi.json http://localhost:3000/dashboard/api/v1/redis-cli/config/indi -H "App-Identifier:prodes_cerrado" -H "Content-Type: application/json"

#curl -X POST -d @cerrado_pathrow.json http://localhost:3000/dashboard/api/v1/redis-cli/config/pathrow -H "App-Identifier:prodes_cerrado" -H "Content-Type: application/json"


curl -X POST -d @legal_amazon_uf.json http://localhost:3000/dashboard/api/v1/redis-cli/config/uf -H "App-Identifier:prodes_legal_amazon" -H "Content-Type: application/json"

curl -X POST -d @legal_amazon_mun.json http://localhost:3000/dashboard/api/v1/redis-cli/config/mun -H "App-Identifier:prodes_legal_amazon" -H "Content-Type: application/json"

curl -X POST -d @legal_amazon_consunit.json http://localhost:3000/dashboard/api/v1/redis-cli/config/consunit -H "App-Identifier:prodes_legal_amazon" -H "Content-Type: application/json"

curl -X POST -d @legal_amazon_indi.json http://localhost:3000/dashboard/api/v1/redis-cli/config/indi -H "App-Identifier:prodes_legal_amazon" -H "Content-Type: application/json"

#curl -X POST -d @legal_amazon_pathrow.json http://localhost:3000/dashboard/api/v1/redis-cli/config/pathrow -H "App-Identifier:prodes_legal_amazon" -H "Content-Type: application/json"
