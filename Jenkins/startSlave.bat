@echo off
for /f "tokens=2 delims=:" %%i in ('ipconfig^|findstr "IPv4"') do (
	set ip=%%i 
	echo %%i
	if ip NEQ "" (
		GOTO :END
	)	
)
:END

java -jar swarm-client-2.0-jar-with-dependencies.jar -labels QBTest -username 123 -password 1234 -master http://172.16.8.93:30180 -executors 1 -name %ip%