FEC E-filing Application - EZ Amendment Portal
==============================================
Link to prototype application [EZ Amendment Portal](http://dev-fecportal-fec-ef-app.b9ad.pro-us-east-1.openshiftapps.com)

## Description

[EZ-Amendment](http://dev-fecportal-fec-ef-app.b9ad.pro-us-east-1.openshiftapps.com/.) application will allow FEC E-filing committee members to connect to EZ-Amendment portal and search/amend existing filing (transactions). This is a prototype to show SalientCRGT skills in agile software development, using open source, secured DevOps practices using Cloud. 

## Agile Software Development Approach

SalientCRGT quickly gathered an experience DevOps team consist puesdo Product Owner (DG), Back-end Web Developer (SP), Front-End Web Developer (JS), DevOps Engineer (David), Scrum Master/Agile Coach (PM), UX/Visual Designer (FZ), Business Analyst/SME (Mahi), Technical Architect/Lead (CD). Further, the team was lead by experience Product Owner (NS) who was responsible for quality and delivery of "working code" using our [Agile methodology](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/salientcrgt-agile-practices.md), which is in line with [U.S. Digital Services Playbook](https://playbook.cio.gov/).

We started off by having a quick [Discovery phase](https://trello.com/b/pnKkdO92/fec-application-board) to understand the need of the RFP and select the application that will be developed to be shared as working code with the RFP, and be able to showcase our Agile, open source, APIs, DevOps and Cloud skills. We started with brainstorming on number of ideas and after down-select, narrowed it to 1 selected idea to build the application. We also discussed and decided to use AWS hosted [SalientCRGT DevOps](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/SalientCRGT%20SecDevOps.png) which provides us Dev, Test, Pre-Prod and Production environment with Cloud deployment and monitoring capabilities, a [Jenkins CI/CD Pipeline](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/SalientCRGT%20Jenkins%20Pipeline.png) that provides teams the necessary automated checks for quality, security and reliability. We further decided to use, SalientCRGT [bootstrap-app](https://github.com/SalientCRGT/app-bootstrap) project to get the team jump start and hit the ground running.

For every feature, our team used human-centered design techniques and tools to create a usable, simple, and intuitive system. This included creating [wireframes](https://github.com/SalientCRGT/fec-ef-app/tree/master/docs/ux/wireframes), a [persona](https://github.com/SalientCRGT/fec-ef-app/tree/master/docs/ux/personas), an application [style guide]() and [usability testing]().

Throughout our development process, we used electronic [Scrum Board](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/jira/Sprint4-Scrum-Board.png), to keep track of pending work. Usin behavior driven development we produces [scenarios](https://github.com/SalientCRGT/fec-ef-app/tree/master/selenium/src/test/resources/features) that are used by selenium/cucumber code for test automation. Our development process use behavir-driven development, writing selenium test to fail the scenario, developers then write unit test to fail their application code, followed by writing code to make sure all unit test run successfully, and in-turn the selenium test then run successfully simulating business-behavior and user interactions. 

Our[DevOps CI/CD pipeline](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/SalientCRGT%20Jenkins%20Pipeline.png) also focuses on static, code analaysis and security vulnerability check implemented via SonarQube. Engineers ensure high code quality by analyzing sonar reports. Further Static dependency security vulnerabilies are tested using OWASP tool, and dynamic security penetration testing is performed by Zed Attack Proxy (ZAP tool). In addition to automated tools, our agile process requires checklist-driven code reviews for security and code/design quality. All new code goes through the code-review process lead by technical team lead.

## Technical Details

We used an open source technical stack comprising of **Angular 4** (client-side), **Spring Boot** (server-side) and **ProgreSQL** (database). We choose Angular 4 and Sprint Boot (as it provides a radically faster and widely accessible 'getting starte' experience for all Spring development among other benefits). Our technology stack is completely open source and is built on top of SalientCRGT DevOps platform which is built using open source technologies such as JIRA, Jenkins, SonarQube, Artifactory, Jenkins-Plug-ins, Docker, OpenShift and AWS Cloud. Further, the application was designed using a responsive layout so that it works on multiple devices and form-factors (we tested it on PCs, tablets, and phones). 

Our application prototype is deployed using OpenShift container management platform (PaaS). Our deployment process uses [Docker]() for containers, [Jenkins](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/SalientCRGT%20Jenkins%20Pipeline.png) for Continuous Integration and [OpenShift](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/OpenShift_defined_PODS.png) for managing and deploying containers with orchestration and scaling provided by Kubernetes. We also used FEC 18F [open api](https://18f.gsa.gov/2015/07/08/openfec-api/) for retrieving FEC filings.

## Prerequisites 
[Cris](Cris can you write)

## Installation and Local Deployment
[Cris](Cris can you write)
Instructions on running the app locally on your box can be found in [install_app.txt](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/install_app.txt) 

## OpenShift configuration
[Cris](Cris can you write)

## Usage 
[Cris](Cris can you write)
References:

|Prototype URL|[http://dev-fecportal-fec-ef-app.b9ad.pro-us-east-1.openshiftapps.com](http://dev-fecportal-fec-ef-app.b9ad.pro-us-east-1.openshiftapps.com) |
| --- | ---  |
| Installation Document | [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/install_app.md](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/install_app.md)   |
| Dev Installation Document | [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/developer_inst.md](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/developer_inst.md) |
| Trello Board | [https://trello.com/b/pnKkdO92/fec-application-board](https://trello.com/b/pnKkdO92/fec-application-board) |
| GitHub Issue Log | [https://github.com/SalientCRGT/fec-ef-app/issues](https://github.com/SalientCRGT/fec-ef-app/issues) |
| Jenkins Pipeline | http://jenkins.salientcrgt-devops.com/job/FEC/job/fec-ef-app/view/FEC-EF-Delivery/  |
| Wireframes | [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe_board_1.jpg](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe_board_1.jpg), [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe1.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe1.png), [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe2.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe2.png), [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe_board_2.jpg](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe_board_2.jpg), [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe4.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe4.png),[https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe5.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe5.png) |
| Personas | [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/Personas.pdf](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/Personas.pdf) |
| Usability Testing | [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/usability-testing.pdf](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/usability-testing.pdf) |
| Style Guide | [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/style-guide.html](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/style-guide.html) |
| User Acceptance Test | [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/user-acceptance-test.pdf](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/user-acceptance-test.pdf) |
| Continuous Monitoring OpenShift| [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/OpenShift_monitor_fe_pod.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/OpenShift_monitor_fe_pod.png), [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/OpenShift_monitor_be_pod.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/OpenShift_monitor_be_pod.png), [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/OpenShift_monitor_db_pod.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/OpenShift_monitor_db_pod.png)  |

