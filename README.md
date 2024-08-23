# deforestation-data-feeder

This repository provides a way to read data from the Postgres database with the Deforestation Data Model and write it to the local directory in JSON format, ready for use in the Deforestation Dashboard.

# About feeder

## Build

See instruction in ./data-feeder/README.md for learn about how to build the feeder service.

## Use

To read about how to export data from Postgres database to JSON files for publishing on the server. See [EXPORT-DATA.md](./EXPORT-DATA.md).

# About GeoJSONs

GeoJSONs is a collection of geographic data to display the LOIs on dashboard embeded map.

To prepare the GeoJSON data, see instructions in ./data-lois/geojson_for_map/README.md
