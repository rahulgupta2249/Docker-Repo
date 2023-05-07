FROM openjdk:8u191-jre-alpine3.8
# Workspace
WORKDIR /usr/share/udemy

# ADD .jar under target from host
# Into this image
ADD target/selenium-docker.jar  selenium-docker.jar
ADD target/selenium-docker-tests.jar  selenium-docker-tests.jar
ADD target/libs   libs

# In case of any other dependnacy, like .csv/.json/.xls
# Please add that as well

#ADD Suite Files
ADD book-flight-module.xml book-flight-module.xml
ADD searchModule.xml searchModule.xml

# BROWSER
# HUB_HOST
# MODULE


ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE