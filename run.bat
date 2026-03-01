@echo off
echo Cleaning and building project...
call mvnw.cmd clean package -DskipTests

if %errorlevel% neq 0 (
    echo Build failed.
    exit /b %errorlevel%
)

echo Running application...
java -jar target\taskflow-0.0.1-SNAPSHOT.jar