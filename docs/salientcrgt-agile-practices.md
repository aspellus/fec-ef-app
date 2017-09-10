Agile Practices
===============

## Software Development Practices

Our [**Agile Software Development Methodology**](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/SalientAgileScrumProcess.png) is based on empowering  people to incrementally develop software using Behavior Driven Development (BDD) and User Centered Design (UCD) approach. User Stories and Scenarios are created making sure we understand the needs of the users, and incorporate business behavior upfront.  We use quality techniques of Test Driven Development (TDD), Pair Progrmaming and Test Automation for maintaining high code quality and demonstrating software behaviors being delivered to requirements.

Our **Agile Scrum Process** uses Sprint 0 to get the team ready for delivering working software, and then use multiple Sprints to incrementatlly deliver working code with test automation. We start each Sprint with **Sprint Planning** meeting (working with product owner the team accesses the work in sprint backlog), Scrum boards are displayed on TV monitors to manage work and visually track the progress of each Sprint. Further our Scrum process includes daily **stand-ups** (short team meetings again to keep team on track and take corrective action), each Sprint ends with [sprint-review](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/jira/test) (meeting to demonstrate working code), followed by [sprint-retrospective](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/jira/test) where the team discusses what went right, what did not go well, and what actions to take in next sprint to improve.

We further use our [Secured DevOps CI/CD platform](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/SalientCRGT%20SecDevOps.png) implemented on AWS to develop software. We use the efficiences of Continuous Integration/Continous Delivery and Quality Automation that is provided by our [Jenkins CI/CD Pipeline](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/SalientCRGT%20Jenkins%20Pipeline.png). By moving quality and security inspection of software as far as possible to the left, from day 1 we monitor for software quality and security vulnerabilities. Security is not an after thought, its baked into our Agile Software Development Methodology.


Further detail about some of our development strategies and methods can be found below:

### Version/Source Control
pramod to write

### Behavior-Driven Development / Test-driven Development (unit testing)
pramod to write

### CLOUD Strategy 
Cris to write

### Docker Containerization, Deployment, Management and Orchestration (Using OpenShift Kubernetes)
Cris to write

Quality Assurance Practices
===========================

The quality assurance practices employed for this project (as well as all our project engagements) are designed to prevent bugs, not just find and fix them. Our developers practice "pair programming" to catch errors at the keyboard and ensure  a uniform, maintainable approach to architecture and software coding standards. We embed QA personnel, whom we call "quality advocates" (because their job is to advocate for quality throughout the life-cycle of the project, not just as "assurance" at the end), into each of our development teams so that they can help facilitate quality throughout the project. For this project, one of the Writers/Content Designers/Content Strategists help serve in the QA role.

Further detail about some of our QA strategies and methods can be found below:

### Automated Testing

We employed automated tests to confirm immediately that any new code did not adversely impact features already completed. The tests were written around specific areas of functionality to ensure that they both met the acceptance criteria for user stories as well as function as a whole. 

### Continuous Integration 

Continuous integration, when combined with automated testing, ensures that a system works exactly as it’s designed to work after each and every change. Customer acceptance tests not only guarantee the code works properly, but also verify that the individual business functions of the system work correctly. By continuously performing integration testing and continuously building the applications, we were able to both ensure quality as well as provide our pseudo-users with live, working software (i.e., current-working-state versions) at virtually any time during the project.

### Static Code Analysis
pramod to write

### Static Application Security Testing (SAST)
[OWASP](pramod to write)

### Dynamic Application Security Testing (DAST)
[Zed Attack Proxy](pramod to write)

### Performance Testing
pramod to write
Cris/Dan can we get results

## User Experience/Design Practices

Our success with delivering the best possible functional design and user experience (UX) stems from two primary areas: skilled designers and environment. Each member of our design/user experience team (including the Visual Designer who worked on this project) goes through a stringent certification program for usability analysis and interaction design. Each designer is responsible for introducing elements of the user experience process such as card sorting, task flow analysis, prototyping, and usability testing to every project. 

The Visual Designer for this project was embedded into the project team, which ensured that good design and user experience were woven into the fabric of the application from start to finish. We generally employ any number of UX strategies and methods, such as the [user-interviews]() and [usability testing](), [wireframes](), the [flow diagram](), and application [style guide]() for this project, to ensure that our designs are not only functional and easy to use, but also meet customer and user expectations and needs.
