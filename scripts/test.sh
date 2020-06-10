echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo "-- ========================================================="
echo "-- "
echo "-- ========================================================="
curl http://localhost:8080/api/findAllStates

echo ""
echo "-- ========================================================="
echo "-- Add State"
echo "-- ========================================================="
curl -d '{ "stateCode":"AZ", "stateName":"Arizona" }' \
      -H "Content-Type: application/json" \
      -X POST http://localhost:8080/api/createState

echo ""
echo ""
curl -d '{ "stateCode":"AZ", "stateName":"Arizona" }' \
      -H "Content-Type: application/json" \
      -X POST http://localhost:8080/api/createState

echo ""
echo ""
curl http://localhost:8080/api/findAllStates

echo ""
echo "-- ========================================================="
echo "-- Add County "
echo "-- ========================================================="
curl -d '{ "usState":{"stateId":4}, "countyName":"Pima County" }' \
      -H "Content-Type: application/json" \
      -X POST http://localhost:8080/api/createCounty

echo ""
echo ""
curl http://localhost:8080/api/findAllCounties

echo ""
echo "-- ========================================================="
echo "-- Add City "
echo "-- ========================================================="
curl -d '{ "usCounty":{"countyId":3}, "cityName":"Catalina" }' \
      -H "Content-Type: application/json" \
      -X POST http://localhost:8080/api/createCity

echo ""
echo ""
curl http://localhost:8080/api/findAllCities


echo ""
echo "-- ========================================================="
echo "-- Delete State "
echo "-- ========================================================="
curl -X DELETE http://localhost:8080/api/state/4
echo ""
curl -X DELETE http://localhost:8080/api/state/3
echo ""
curl -X DELETE http://localhost:8080/api/state/2

echo ""
echo ""
curl http://localhost:8080/api/findAllStates
echo ""
echo ""
curl http://localhost:8080/api/findAllCounties
echo ""
echo ""
curl http://localhost:8080/api/findAllCities

echo ""
