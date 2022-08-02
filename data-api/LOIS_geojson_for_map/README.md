Para gerar os GeoJSONs a partir dos shapefiles de LOIs.

- Usar o serviço online: https://mapshaper.org/
- Importar os 4 arquivos minimos de um shape valido;
- Selecionar a opção "Symplify" e manter os parametros default - Method: "Visvalingam/weighted area";
- No proximo passo, configurar para 5% a simplificação;
- Em seguida usar o "Repair" para reparar eventuais erros após a simplificação;
- Por fim, exportar para GeoJSON;

Todos os shapesfiles devem possuir apenas a coluna "name" com o nome da feição representada. Deve ser o mesmo nome do dado auxiliar utilizado no processo de preparação do banco DashboardDataModel, mas sem a concatenação com o nome de Estado, no caso do dado de município.

