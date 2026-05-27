@echo off
echo ===================================================
echo Killing existing processes on project ports...
echo ===================================================

FOR %%p IN (8761 8080 8081 8082 3000) DO (
    FOR /F "tokens=5" %%a IN ('netstat -aon ^| findstr :%%p') DO (
        if "%%a" NEQ "0" (
            echo Killing PID %%a (Port %%p^)
            taskkill /F /PID %%a >nul 2>&1
        )
    )
)

echo Port cleanup complete!
