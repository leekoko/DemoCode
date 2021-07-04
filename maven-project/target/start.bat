@echo off
set name=maven-project
set version=1.2.3-SNAPSHOT
title %name%
set path=%JAVA_HOME%
"%path%\bin\java" -jar -Dloader.path=. -Xmn128m -Xms512m -Xmx512m "%name%"-"%version%".jar
pause