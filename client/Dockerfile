FROM salientcrgt/fec-ef-app-ngrunner:latest

MAINTAINER Cris Daniluk <cris.daniluk@ctr.salientcrgt.com>

COPY . .
RUN npm install && ng build

# work around perms on OpenShift
RUN chmod -R a+rwx /opt/app
CMD ["ng", "serve", "--host", "0.0.0.0", "--disableHostCheck"]


EXPOSE 4200
