@echo off
:: build everything
cd C:\Users\pitagoras\git\CCO2ANPI\Tools\
call mvn clean install generate-sources
cd C:\Users\pitagoras\git\CCO2ANPI\Models\
call mvn clean install generate-sources
cd C:\Users\pitagoras\git\CCO2ANPI\Database\
call mvn clean install generate-sources
cd C:\Users\pitagoras\git\CCO2ANPI\Repository\
call mvn clean install generate-sources
cd C:\Users\pitagoras\git\CCO2ANPI\Services\
call mvn clean install generate-sources
cd C:\Users\pitagoras\git\CCO2ANPI\Services.Client\
call mvn clean install generate-sources
cd C:\Users\pitagoras\git\CCO2ANPI\SystemBuildingControl\
call mvn clean install generate-sources
cd C:\Users\pitagoras\Desktop


:: run some java file
::cd \workspace\project3
::java -jar somefile.jar