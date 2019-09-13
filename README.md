# Software-Engineering-RNG-Project Instructions

# Tomcat with Java on virtual machine
## Setting up the Virtual Machine
1. Create a new instance on GCP with the following settings
2. Choose the machine type of your choice (I reccomend choosing the cheapest one)
3. Choose Ubuntu 19.04 as the boot disk
4. Under firewall, select Allow HTTP traffic.
5. Click create to finish the VM setup.

## Virtual Machine Environment setup
1. Once you have successfull created the virtual machine, start it up.
2. Update package indexes using sudo apt-get update.
3. Install the java sdk using sudo apt-get install default-jdk.
4. Go to Tomcat's website on your local machine and click on Tomcat 9.
5. Scroll down a bit until you see a tar.gz download link.
6. Right click the link and copy it.
7. Go back to your virtual machine instance and use the command curl -O Link that you copied
8. Curl will download the file to your virtual machine.
9. Once the download finishes, create a new dir using the command sudo mkdir /opt/tomcat
10. Extract the tar file to the dir you just created using the command sudo tar xzvf "name of the tar.gz file" -C /opt/tomcat --strip-components=1
11. Use the command sudo update-java-alternatives -l to get your java jdk location
12. Create a new system md using the command sudo nano /etc/systemd/system/tomcat.service
13. Paste the following into the file

[Unit]
Description=Apache Tomcat Web Application Container
After=network.target

[Service]
Type=forking

Environment=JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64/jre
Environment=CATALINA_PID=/opt/tomcat/temp/tomcat.pid
Environment=CATALINA_HOME=/opt/tomcat
Environment=CATALINA_BASE=/opt/tomcat
Environment='CATALINA_OPTS=-Xms512M -Xmx1024M -server -XX:+UseParallelGC'
Environment='JAVA_OPTS=-Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom'

ExecStart=/opt/tomcat/bin/startup.sh
ExecStop=/opt/tomcat/bin/shutdown.sh

User=tomcat
Group=tomcat
UMask=0007
RestartSec=10
Restart=always

[Install]
WantedBy=multi-user.target

Make sure the JAVA_HOME path correctly reflects the java jdk location from sudo update-java-alternatives -l 

14. Run the command sudo systemctl daemon-reload to notify the system of our new file.
15. Use the command sudo systemctl start tomcat to start Tomcat.
