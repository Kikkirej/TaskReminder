@echo off
java -jar "%~dp0..\jar\Core*.jar %*" -cp "%~dp0..\lib%*;%~dp0..\jar%*"