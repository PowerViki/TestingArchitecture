rd /s/q F:\QM
mkdir F:\QM
net share QM /delete
net share QM=F:\QM /grant:everyone,full
exit