EZ-Amendment Application
========================

Link to prototype at http://dev-fecportal-fec-ef-app.b9ad.pro-us-east-1.openshiftapps.com/.

## Description

[EZ-Amendment](http://dev-fecportal-fec-ef-app.b9ad.pro-us-east-1.openshiftapps.com/.) application will allow FEC E-filing committee members to connect to EZ-Amendment portal and search/amend existing filing (transactions). This is a prototype to show SalientCRGT skills in agile software development, using open source, secured DevOps practices and Cloud. 

## Project Approach

SalientCRGT quickly gathered an experience DevOps team consist a puesdo Product Owner (DG), Back-end Web Developer (SP), a Front-End Web Developer (JS), a DevOps Engineer (David), a Scrum Master/Agile Coach (PM), UX/Visual Designer (FZ), a Business Analyst/SME (Mahi), a Technical Architect/Lead (CD). The team was lead by experience Product Owner (NS) who was responsible for quality and delivery of "working code" for this application using our [Agile methodology](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/salientcrgt-agile-practices.md), which is in line with [U.S. Digital Services Playbook](https://playbook.cio.gov/).

We performed an "iteration zero" [Kick-off Ideation Session](), where we identified our target users and a primary [use case](), planned an initial feature set, and did some preliminary wireframing. From there, we wrote out stories, set up our development and testing environment, and began development. 

Throughout the course of the project, our team used human-centered design techniques and tools to create a usable, simple, and intuitive system. This included performing [user interviews]() and [usability testing](), as well as creating [wireframes](), a [persona](), a [flow diagram](), and an application [style guide]().


Throughout our development process, we used [iterative software development techniques](), and both a [physical]() and [electronic Scrum Board](). We did use [unit testing](), test-driven development, automated testing, and CI/CD along with every quality and security testing provided by our [DevOps CI/CD pipeline](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/SalientCRGT%20Jenkins%20Pipeline.png). 

## Technical Details

Our prototype application is written in **Angular 4** (client-side), **Spring Boot** (server-side) and **ProgreSQL** (database). We choose Angular 4 and Sprint Boot because [...add Pramod/Cris](). Our technology stack is completely open source and is built on top of SalientCRGT DevOps platform which is built using open source technologies such as JIRA, Jenkins, SonarQube, Artifactory, Jenkins-Plug-ins, Docker, OpenShift and AWS Cloud. Further, the application was designed using a responsive layout so that it works on multiple devices and form-factors (we tested it on PCs, tablets, and phones). 

Our application prototype is deployed using OpenShift container management platform (PaaS). Our deployment process uses [Docker]() for containers, [Jenkins]() for Continuous Integration and [OpenShift]() for managing and deploying containers with orchestration and scaling provided by Kubernetes. We also used FEC 18F [open api](https://18f.gsa.gov/2015/07/08/openfec-api/) for retrieving FEC filings.


## Installation and Local Deployment

Instructions on running the app locally on your box can be found in [install_app.txt add Cris](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/install_app.txt) 
