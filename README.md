FEC E-filing Application - EZ Amendment Portal
==============================================
Link to prototype application [EZ Amendment Portal](http://prod-fecportal-fec-ef-app.b9ad.pro-us-east-1.openshiftapps.com)

## Description

The [EZ-Amendment](http://dev-fecportal-fec-ef-app.b9ad.pro-us-east-1.openshiftapps.com/) application allows FEC E-filing committee members to connect to a sample EF Committee Portal, browse existing filings and amend those filings by directly adding, editing and updating transactions within the portal. This prototype leverages both internal APIs we built as well as OpeFEC APIs to demonstrate how various APIs can contribute to a finished product. 

This project demonstrates SalientCRGT's ability to execute an Agile Scrum project, employing UCD, BDD and TDD to rapidly iterate and deliver a high quality product in a short period of time. The team heavily leveraged open source technology, existing APIs and DevOps techniques to quickly spin up the needed infrastructure and scaffolding, then start iterating--this prototype was developed in a series of five 1-day sprints. While the team was able aided by a deep understanding of the eFiling process at FEC its primary strength was the ability to iterate designs. By incorporating mock end users as well as subject matter experts, a team with little understanding of the complex filing process was able to zero in on and ultimately produce a user design consistent with the FEC/18f Style Guide, filing rules and workflow, and User Centered Design objectives. We were surprised at how far our design evolved from the initial wire frames and believe this reflects the effectiveness our unique team can bring to modernize this vital FEC system and improve the filer experience.

## Agile Software Development Approach

SalientCRGT quickly gathered an experienced DevOps team consisting of a Product Owner (Drew G), Back-end Web Developer (Satheesh P), Front-End Web Developer (James S), DevOps Engineer (David G), Scrum Master/Agile Coach (Pramod M), UX/Visual Designer (Frank Z), Business Analyst/SME (Mahi B), Technical Architect/Lead (Cris D). Further, the team was lead by an experienced Product Owner (Neal S) who was responsible for quality and delivery of "working code" using our [Agile methodology](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/salientcrgt-agile-practices.md), which is in line with the [U.S. Digital Services Playbook](https://playbook.cio.gov/).

We started off by having a quick [Discovery phase](https://trello.com/b/pnKkdO92/fec-application-board) to understand the needs of the RFP, review the eFiling Study, and select a problem that will be developed to be shared as working code with the RFP, and be able to showcase our Agile, open source, APIs, DevOps and Cloud skills. We started with brainstorming on a number of ideas and after down-select, narrowed it to 1 selected a problem to build a prototype application for. We also discussed and decided to use Amazon Web Services (AWS) and Kubernetes [SalientCRGT DevOps](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/SalientCRGT%20SecDevOps.png) which provides us with a DevOps oriented suite of tools that we can use to orchestrate Dev, Test, Pre-Prod and Production environment on demand with monitoring capabilities. We also incorporated automated build and deployment with a [Jenkins CI/CD Pipeline](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/SalientCRGT%20Jenkins%20Pipeline.png), which greatly aided the team as we worked in such a compressed schedule. To speed up scaffolding, we agreed to use the SalientCRGT **Angular-4/Spring-Boot** [bootstrap-app](https://github.com/SalientCRGT/app-bootstrap) project to get the team jump start and hit the ground running with starter Angular 4, Spring Boot and Selenium projects.

For every feature, our team used human-centered design techniques and tools to create a usable, simple, and intuitive system. This included creating [wireframes](https://github.com/SalientCRGT/fec-ef-app/tree/master/docs/ux/wireframes), a [persona](https://github.com/SalientCRGT/fec-ef-app/tree/master/docs/ux/personas), an application [style guide]() and [usability testing]().

Throughout our development process, we used electronic [Scrum Board](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/jira/Sprint4-Scrum-Board.png) to manage sprint commitments, track our backlog and faciliate sprint grooming/planning. Using behavior-driven development (BDD) we produced [scenarios](https://github.com/SalientCRGT/fec-ef-app/tree/master/selenium/src/test/resources/features) that are used by Selenium/Cucumber code for test automation, an approach that goes beyond code coverage and ensures feature coverage. Our development process used API-based design, with APIs being agreed upon in advance of implementation. Though mock APIs were not leveraged due to the compressed time schedule, SalientCRGT anticipates heavily using such techniques to ensure front-end and back-end teams can iterate on their respective areas independently of each other. The Selenium tests proved especially valuable as wire frames and UI continued to evolve from sprint to sprint, ensuring that features and scenarios aligned with their implementation in user design.

We were also able to demonstrate a number of valuable capabilities through our [DevOps CI/CD pipeline](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/SalientCRGT%20Jenkins%20Pipeline.png), performing static code analaysis (SonarQube) and security vulnerability checks (OWASP, Zed Attack Tool), and even Section 508 Compliance (Axe). These pipeline stages, along with unit/functional, regression and smoke tests all produce a clear pipeline that can be drilled into to see detailed results. 

In addition to these automated tools, our team relied on a daily branching strategy and daily Pull Requests to ensure peer-based review. Our process empowers everyone on the team to review independently and directly annotate code. In a Scrum project with longer sprints, we rely on a Git-flow style branching model that includes feature branching, with minor features using a "+1" PR model and major features using a "+2" or better model. We believe this model is essential in a truly agile project as traditional code reviews scope in more code than can be adequately reviewed in one session.

## Technical Details

We used an open source stack comprising of **Angular 4** (client-side), **Spring Boot** (server-side) and **PostgreSQL** (database). We choose thie stack as we believe it is appropriate for most aspects of the FEC EF System. The entire stack, including all dependencies, is completely open source and is complemented by the SalientCRGT DevOps platform which includes tools such as JIRA, Jenkins, SonarQube, Artifactory, Docker, Kubernetes, AWS and a variety of pre-configured pipelines, plugins and other tools. The application was designed using a responsive layout so that it works on multiple devices and form-factors (we tested it on PCs, tablets, and phones). 

## Installation and Usage 
See [Installation Instructions](https://github.com/SalientCRGT/fec-ef-app/blob/master/INSTALL.md)

## References:

|Prototype URL|http://prod-fecportal-fec-ef-app.b9ad.pro-us-east-1.openshiftapps.com|
| --- | ---  |
| Installation Document | https://github.com/SalientCRGT/fec-ef-app/blob/master/INSTALL.md |
| Trello Board | [https://trello.com/b/pnKkdO92/fec-application-board](https://trello.com/b/pnKkdO92/fec-application-board) |
| GitHub Issue Log | [https://github.com/SalientCRGT/fec-ef-app/issues](https://github.com/SalientCRGT/fec-ef-app/issues) |
| Jenkins Pipeline | http://jenkins.salientcrgt-devops.com/job/FEC/job/fec-ef-app/view/FEC-EF-Delivery/  |
| Wireframes | [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe_board_1.jpg](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe_board_1.jpg), [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe1.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe1.png), [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe2.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe2.png), [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe_board_2.jpg](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe_board_2.jpg), [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe4.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe4.png),[https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe5.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/wireframe5.png) |
| Personas | [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/Personas.pdf](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/Personas.pdf) |
| Usability Testing | [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/usability-testing.pdf](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/usability-testing.pdf) |
| Style Guide | [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/style-guide.html](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/style-guide.html) |
| User Acceptance Test | [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/user-acceptance-test.pdf](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/user-acceptance-test.pdf) |
| Continuous Monitoring OpenShift| [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/OpenShift_monitor_fe_pod.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/OpenShift_monitor_fe_pod.png), [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/OpenShift_monitor_be_pod.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/OpenShift_monitor_be_pod.png), [https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/OpenShift_monitor_db_pod.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/OpenShift_monitor_db_pod.png)  |

