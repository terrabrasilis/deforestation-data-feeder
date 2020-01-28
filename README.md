# terrabrasilis-dashboard-api
This analytics API consists of a stack of services representing not only a data model abstraction but also a command query responsability segregation design pattern

# REDIS-Feeder

See instruction in ./redis-feeder/README.md for learn about how to build the feeder service.


# PUT GeoJSONs on REDIS

GeoJSONs is a collection of geographic data to display the LOIs on dashboard embeded map.

Goto the ./data-api/LOIS_geojson_for_map/ and run the ./CURL_POST_by_loinames.sh script.

To prepare the GeoJSON data, see instructions in ./data-api/LOIS_geojson_for_map/README.md
