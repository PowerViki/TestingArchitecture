@echo off
for /f "tokens=1,2,3 delims=," %%a in (slave.ini) do (
	echo %%a
    net use \\%%a\Qb_new %%c /user:%%b
	xcopy ..\report \\%%a\Qb_new\report\ /s /d
	xcopy ..\script \\%%a\Qb_new\script\ /s /d
	xcopy ..\generateHtmlReport \\%%a\Qb_new\generateHtmlReport\ /s /d
	net use \\%%a\Qb_new /del
)
::pause