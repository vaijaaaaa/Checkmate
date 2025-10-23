@echo off
echo Compiling Chess Game...
javac -d bin src/chess/*.java src/chess/pieces/*.java
if %errorlevel% == 0 (
    echo Compilation successful!
) else (
    echo Compilation failed!
    pause
)
