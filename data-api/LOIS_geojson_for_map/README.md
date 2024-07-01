## Current mode

To update the auxiliary data JSON files, we have a more automatic approach, implemented in the following repository.

https://github.com/terrabrasilis/prodes-release-tasks.git

See instructions at lois-to-json-file/README.md

## Deprecate mode

This way of simplifying and generating GeoJson files is done manually and is no longer used.

Para gerar os GeoJSONs a partir dos shapefiles de LOIs.

- Usar o serviço online: https://mapshaper.org/
- Importar os 4 arquivos minimos de um shape valido;
- Selecionar a opção "Symplify" e manter os parametros default - Method: "Visvalingam/weighted area";
- No proximo passo, configurar para 5% a simplificação;
- Em seguida usar o "Repair" para reparar eventuais erros após a simplificação;
- Por fim, exportar para GeoJSON;

Todos os shapesfiles devem possuir apenas a coluna "name" com o nome da feição representada. Deve ser o mesmo nome do dado auxiliar utilizado no processo de preparação do banco DashboardDataModel, mas sem a concatenação com o nome de Estado, no caso do dado de município.
