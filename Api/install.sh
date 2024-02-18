#!/bin/bash
curl https://raw.githubusercontent.com/creationix/nvm/master/install.sh | bash
      export NVM_DIR="$HOME/.nvm"
      [ -s "$NVM_DIR/nvm.sh" ] && . "$NVM_DIR/nvm.sh"  # This loads nvm
      [ -s "$NVM_DIR/bash_completion" ] && . "$NVM_DIR/bash_completion"  # This loads nvm bash_completion
      nvm use system
      nvm install 20

echo "[mongodb-org-6.0]" | sudo tee /etc/yum.repos.d/mongodb-org-6.0.repo > /dev/null
echo "name=MongoDB Repository" | sudo tee -a /etc/yum.repos.d/mongodb-org-6.0.repo > /dev/null
echo "baseurl=https://repo.mongodb.org/yum/redhat/\$releasever/mongodb-org/6.0/x86_64/" | sudo tee -a /etc/yum.repos.d/mongodb-org-6.0.repo > /dev/null
echo "gpgcheck=1" | sudo tee -a /etc/yum.repos.d/mongodb-org-6.0.repo > /dev/null
echo "enabled=1" | sudo tee -a /etc/yum.repos.d/mongodb-org-6.0.repo > /dev/null
echo "gpgkey=https://www.mongodb.org/static/pgp/server-6.0.asc" | sudo tee -a /etc/yum.repos.d/mongodb-org-6.0.repo > /dev/null

yum install -y mongodb-org