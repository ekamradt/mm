# Interview Code Request

### Build Jar
mvn clean package

### Run Jar
java -jar ${HOME}/git/movemedical/target/movemedical-0.0.1-SNAPSHOT.jar

### Small super simple test script
./scripts/test.sh

### Application requirements:

* Provide basic input validation and return meaningful errors
    Stole ApiError to throw meaning fule errors
    
* Write to a log file as appropriate
    In controller logger logs only errors/exceptions at this time.

* Create records in a hierarchy:
  - Create N records for any given level of the hierarchy, for a given parent node.

**Have State/County/City**
  
* Root level nodes are created by providing no parent node in the request.

**Sorry, I wrote it so you pass in the parent ID, no orphans.**

* Allow duplicate records in the same request but only store one copy [remove duplicates]

**Input is based on a Set, so this is automatic.** 
        
* Return an error if the node name already exists from a prior service call that created it._

**Database is set for a unique index on stateName, stateCode, countryName, and cityName.** 

* List records in a hierarchy: List records within a level of the hierarchy, for a given parent node.

**Will list requested object, plus children.**

* Delete records in a hierarchy: ◦ Delete a given node and any child nodes (and their child nodes and so on), if it has any.

**Delete children built into JPA Entiies as written.**