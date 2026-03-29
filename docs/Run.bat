@echo off

REM delete old sources list if exists
if exist sources.txt del sources.txt

REM find all java files
for /r src %%f in (*.java) do echo %%f >> sources.txt

REM compile (no -d, so .class stays in same folders)
javac @sources.txt

if %errorlevel% neq 0 (
    echo Compilation failed
    pause
    exit /b
)

REM run main class
java -cp src Main.MainClass

pause