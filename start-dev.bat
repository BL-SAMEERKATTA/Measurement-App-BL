@echo off
echo ===================================================
echo Starting QMA Full Stack Local Development Environment
echo ===================================================

echo [1/5] Cleaning up old ports...
call kill-ports.bat

echo [2/5] Starting Eureka Server...
start "Eureka Server" cmd /k "cd eureka-server && mvn spring-boot:run -Dspring-boot.run.jvmArguments=-Xmx256m"
timeout /t 20 /nobreak

echo [3/5] Starting API Gateway...
start "API Gateway" cmd /k "cd api-gateway && mvn spring-boot:run -Dspring-boot.run.jvmArguments=-Xmx256m"
timeout /t 15 /nobreak

echo [4/5] Starting Auth Service...
start "Auth Service" cmd /k "cd auth-service && mvn spring-boot:run -Dspring-boot.run.jvmArguments=-Xmx256m"
timeout /t 10 /nobreak

echo [5/5] Starting Conversion Service...
start "Conversion Service" cmd /k "cd conversion-service && mvn spring-boot:run -Dspring-boot.run.jvmArguments=-Xmx256m"
timeout /t 10 /nobreak

echo Starting React Frontend...
cd quantity-measurement-react
if not exist "node_modules\" (
    echo node_modules folder missing. Installing dependencies...
    call npm install
)
start "React Frontend" cmd /k "npm start"
cd ..

echo ===================================================
echo All services are launching in separate windows!
echo It may take a minute for Eureka to register everyone.
echo ===================================================
pause
