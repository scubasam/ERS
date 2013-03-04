#!/bin/bash

mvn clean
mvn compile
mvn war:war

target_path="/var/lib/tomcat7/webapps"
app_name="ERS"
backup_path="build_backup"
war_name="ERS-1.0-SNAPSHOT.war"

timestamp=$( date +"%m-%d-%y-%T")
sudo mv "$target_path/$app_name.war" "$backup_path/$app_name-$timestamp.war"
sudo rm -r "$target_path/$app_name"

sudo cp "target/$war_name" "$target_path/$app_name.war"

sudo service tomcat7 restart

