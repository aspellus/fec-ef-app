FEC E-filing Application - EZ-Amendment 
=======================================

Link to application prototype http://dev-fecportal-fec-ef-app.b9ad.pro-us-east-1.openshiftapps.com/.

References:

| Prototype URL | [http://dev-fecportal-fec-ef-app.b9ad.pro-us-east-1.openshiftapps.com/] |
| --- | --- |
| GitHub Main Branch | master |
| Installation Document | [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/install_app.md](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/install_app.md)   |
| Dev Installation Document | [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/developer_inst.md](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/developer_inst.md) |
| Style Guide | [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/style-guide.html](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/style-guide.html) |
| Trello Board | [https://trello.com/b/pnKkdO92/fec-application-board](https://trello.com/b/pnKkdO92/fec-application-board) |
| GitHub Issue Log | [https://github.com/SalientCRGT/fec-ef-app/issues](https://github.com/SalientCRGT/fec-ef-app/issues) |
| Jenkins Pipeline | http://jenkins.salientcrgt-devops.com/job/FEC/job/fec-ef-app/view/FEC-EF-Delivery/  |
| Wireframes | [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe_board_1.jpg](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe_board_1.jpg), [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe1.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe1.png), [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe2.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe2.png), [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe_board_2.jpg](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe_board_2.jpg), [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe4.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe4.png),[https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe5.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe5.png) |
| Personas | [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/Personas.pdf](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/Personas.pdf) |
| Usability Testing | [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/usability-testing.pdf](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/usability-testing.pdf) |
| Style Guide | [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/style-guide.html](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/style-guide.html) |
| User Acceptance Test | [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/user-acceptance-test.pdf](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/user-acceptance-test.pdf) |
| Continuous Monitoring OpenShift| [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/OpenShift_monitor_fe_pod.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/OpenShift_monitor_fe_pod.png), [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/OpenShift_monitor_be_pod.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/OpenShift_monitor_be_pod.png), [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/OpenShift_monitor_db_pod.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/OpenShift_monitor_db_pod.png)  |
## Description

[EZ-Amendment](http://dev-fecportal-fec-ef-app.b9ad.pro-us-east-1.openshiftapps.com/.) application will allow FEC E-filing committee members to connect to EZ-Amendment portal and search/amend existing filing (transactions). This is a prototype to show SalientCRGT skills in agile software development, using open source, secured DevOps practices and incorporating Cloud. 

## Agile Software Development Approach

SalientCRGT quickly gathered an experience DevOps team consist puesdo Product Owner (DG), Back-end Web Developer (SP), Front-End Web Developer (JS), DevOps Engineer (David), Scrum Master/Agile Coach (PM), UX/Visual Designer (FZ), Business Analyst/SME (Mahi), Technical Architect/Lead (CD). Further, the team was lead by experience Product Owner (NS) who was responsible for quality and delivery of "working code" using our [Agile methodology](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/salientcrgt-agile-practices.md), which is in line with [U.S. Digital Services Playbook](https://playbook.cio.gov/).

We performed an "iteration zero" [Kick-off Ideation Session](), where we identified our target users and a primary [use case](), planned an initial feature set, and did some preliminary wireframing. From there, we wrote out stories, set up our development and testing environment, and began development. 

Throughout the course of the project, our team used human-centered design techniques and tools to create a usable, simple, and intuitive system. This included performing [user interviews]() and [usability testing](), as well as creating [wireframes](), a [persona](), a [flow diagram](), and an application [style guide]().


Throughout our development process, we used [iterative software development techniques](), and both a [physical]() and [electronic Scrum Board](). We did use [unit testing](), test-driven development, automated testing, and CI/CD along with every quality and security testing provided by our [DevOps CI/CD pipeline](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/SalientCRGT%20Jenkins%20Pipeline.png). 

## Understanding what people need

## Technical Details

Our prototype application is written in **Angular 4** (client-side), **Spring Boot** (server-side) and **ProgreSQL** (database). We choose Angular 4 and Sprint Boot because [...add Pramod/Cris](). Our technology stack is completely open source and is built on top of SalientCRGT DevOps platform which is built using open source technologies such as JIRA, Jenkins, SonarQube, Artifactory, Jenkins-Plug-ins, Docker, OpenShift and AWS Cloud. Further, the application was designed using a responsive layout so that it works on multiple devices and form-factors (we tested it on PCs, tablets, and phones). 

Our application prototype is deployed using OpenShift container management platform (PaaS). Our deployment process uses [Docker]() for containers, [Jenkins]() for Continuous Integration and [OpenShift]() for managing and deploying containers with orchestration and scaling provided by Kubernetes. We also used FEC 18F [open api](https://18f.gsa.gov/2015/07/08/openfec-api/) for retrieving FEC filings.

## Prerequisites 

## Installation and Local Deployment

Instructions on running the app locally on your box can be found in [install_app.txt add Cris](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/install_app.txt) 

## OpenShift configuration

## Usage 

