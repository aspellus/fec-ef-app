FROM salientcrgt/fec-ef-app-ngrunner:latest

MAINTAINER Cris Daniluk <cris.daniluk@ctr.salientcrgt.com>

ARG env

COPY . .
RUN npm install && ng build --environment=$env

# work around perms on OpenShift
RUN chmod -R a+rwx /opt/app
CMD ["ng", "serve", "--host", "0.0.0.0", "--disableHostCheck", "--env", "$env"]


EXPOSE 4200
