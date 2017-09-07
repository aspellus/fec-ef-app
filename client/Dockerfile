FROM salientcrgt/fec-ef-app-ngrunner:latest

MAINTAINER Cris Daniluk <cris.daniluk@ctr.salientcrgt.com>

#RUN npm install -g angular-cli@1.0.0-beta.28.3 && npm cache clean

COPY . .
RUN npm install && ng build

# work around perms on OpenShift
RUN chmod -R a+rwx /opt/app
CMD ["ng", "serve", "--host", "0.0.0.0"]

EXPOSE 4200
