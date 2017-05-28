@echo off
java -jar "%~dp0..\jar\Runner.jar %*" -cp "%~dp0..\lib%*;%~dp0..\jar%*"