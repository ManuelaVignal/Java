# Build
mvn clean package && docker build -t com.mycompany/bkmapp .

# RUN

docker rm -f bkmapp || true && docker run -d -p 8080:8080 -p 4848:4848 --name bkmapp com.mycompany/bkmapp 

# System Test

Switch to the "-st" module and perform:

mvn compile failsafe:integration-test