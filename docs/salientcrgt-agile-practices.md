Agile Practices
===============

## Software Development Practices

Our **Agile Software Development Methodology** (as shown in below graphics) is based on empowering  people to incrementally develop software using Behavior Driven Development (BDD) and User Centered Design (UCD) approach. User Stories and Scenarios are created making sure we understand the needs of the users, and incorporate business behavior upfront.  We use quality techniques of Test Driven Development (TDD), Pair Progrmaming and Test Automation for maintaining high code quality and demonstrating software behaviors being delivered to requirements.

![https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/SalientAgileScrumProcess2.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/SalientAgileScrumProcess2.png)

Our **Agile Scrum Process** uses Sprint 0 to get the team ready for delivering working software, and then use multiple Sprints to incrementatlly deliver working code with test automation. We start each Sprint with **Sprint Planning** meeting (working with product owner the team accesses the work in sprint backlog), Scrum boards are displayed on TV monitors to manage work and visually track the progress of each Sprint. Further our Scrum process includes daily **stand-ups** (short team meetings again to keep team on track and take corrective action), each Sprint ends with sprint-review (meeting to demonstrate working code), followed by sprint-retrospective where the team discusses what went right, what did not go well, and what actions to take in next sprint to improve.

We further use our **Secured DevOps CI/CD platform** implemented on AWS to develop software (as shown below):

![https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/devops/SalientCRGT%20SecDevOps2.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/devops/SalientCRGT%20SecDevOps2.png)

We use the efficiences of our **Jenkins CI/CD Pipeline** that provides us the capabilities of Continuous Integration/Continous Delivery and Test Automation, By moving quality and security inspection of software as far as possible to the left, from day 1 we monitor for software quality and security vulnerabilities. Security is not an after thought, its baked into our Agile Software Development Methodology. Shown Below:

![ttps://github.com/SalientCRGT/fec-ef-app/blob/master/docs/devops/SalientCRGT%20Jenkins%20Pipeline.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/devops/SalientCRGT%20Jenkins%20Pipeline.png)


Further detail about some of our development strategies and methods can be found below:

### Version/Source Control
For version control of source code our [repository](https://github.com/SalientCRGT/fec-ef-app) choice was GitHub with its strong merging features and online collaboration capabilities. A new branch was created for each sprint, which is then merged with master before branching again for a new sprint. Pull requests were used to ensure peer review of changes.

### Behavior-Driven Development / Test-driven Development (unit testing)
We use Behavior Driven Development (BDD), which is an extension of Test Driven Development(TDD), to gather and develop requirements. With the BDD approach, application development focuses on the behavior of the system and brings the development team closer to the business team. Requirements are captured as scenarios written in easy-to-understand English (e.g., Gherkin) that describe the application behavior from the user perspective.

These same requirements become test scenarios for TDD development using Cucumber and Selenium to drive test automation in each Sprint. BDD achieves common understanding and consensus on requirements much faster, results in ready-to-use test cases for the development team to implement during test automation, and ensures that the requirement documentation is readily available and is kept current as changes get implemented with each Sprint. Above all, BDD scenario documentation facilitates an analytical validation of requirements from all stakeholders before they are transformed into executable test cases by the development team.

Quality Assurance Practices
===========================

The quality assurance practices employed for this project (as well as all our project engagements) are designed to prevent bugs, not just find and fix them. We embed QA personnel, whom we call "quality advocates" (because their job is to advocate for quality throughout the life-cycle of the project, not just as "assurance" at the end), into each of our development teams so that they can help facilitate quality throughout the project. For this project, one of the Writers/Content Designers/Content Strategists help serve in the QA role.

Further detail about some of our QA strategies and methods can be found below:

### Automated Testing

Automated tests help in  confirming immediately that no new code has adversely impacted features already completed. Test are written to ensure that they both meet the acceptance criteria for user stories as well as functionality as a whole. 

### Continuous Integration 

Continuous integration, when combined with automated testing, ensures that a system works exactly as it’s designed to work after each and every change. Customer acceptance tests not only guarantee the code works properly, but also verify that the individual business functions of the system work correctly. By continuously performing integration testing and continuously building the applications, we were able to both ensure quality as well as provide our pseudo-users with live, working software (i.e., current-working-state versions) at virtually any time during the project.

### Static Code Analysis
Developers get [sonar reports](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/Sonar-Quality-Dashboard-1.png) on quality with every check-in via the continuous integration jenkins server, along with code quality the test coverage lets the developers know how much test-driven development they are doing. Providing these analysis upfront improves the quality at source, and peer code-review now reveal less and less code issues.

### Static Application Security Testing (SAST)
Automation is key to security testing, by embedding automated tools like SonarQube for code vulnerabilities and OWASP for dependency security vuilneratibilies, CI process lets the developer/team know of any issues upfront. Along with automated security testing, peer security-review further ensure security is baked in from the start in every project.

### Dynamic Application Security Testing (DAST)
Dynamic application security penetration testing is achieved via open source tool like [OWASP ZAP](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/devops/ZAP%20Scanning%20Report.pdf). The CI Pipeline makes this happen in the environment of choice, and lets the team know of security vulnerabilities early. 

### Performance Testing
We have incorporated Jmeter plug-in into our DevOps Pipeline, with every release we can perform multiple load/performance test and make sure new sprint has not degraded the overall performance and the system is still performing to the agreed SLA.

## User Experience and User-Centered Design (UCD) Practices
We believe that an application cannot be successful without an engaging user interface (UI) that is built on a foundation of high usability and customer satisfaction. Using a UCD approach to research, design, and validate, our UI/user experience (UX) Engineers and BA work iteratively with the product owner and users to address the business process flow, messaging, and functions. They design the overall usability of the application to meet business goals, use various artifacts (e.g., wireframes, mockups, templates, and navigational flow) to iteratively work with business and end-users to design the best user experience. Each member of our design/user experience team includes a Visual Designer to ensure good design and user expereince is the foundation of the application from start to finish.

Our Visual Designers and UX Engineers engage with users and—using research tools in the Team’s UX toolkit—identify challenges and design needs. We use wireframes and sketches to rapidly express the complete business workflow, which facilitates constructive feedback from customers and business users. With the goal of a working prototype, our design engineers collaborate with the BA to draft wireframes that capture the application workflow and requirements, while continuously working with Business to enhance and modify the wireframes. Mockups and UI layouts with workflows are drafted and reviewed regularly, which enables business to experience the complete business workflow (application) up front. This approach also provides a platform to provide early feedback.

Our process is data driven and focuses on measurable outcomes, while embracing users and their perspective as an essential part of what it means to develop a system. We conduct user testing against each design to validate that our design achieves the goals set by the user and the client. If the design is successful, the development team, working with the UX Designer, commits it to final coding in the application. The picture below shows how our four-step UCD process which incorporates a feedback loop and establishes goals for UX design

![https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/UCD%20Approach%20pic1.jpg](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/UCD%20Approach%20pic1.jpg)


For the prototype application the  Visual Designer/UX was 1person and was embedded into the project team. For this 5-day project we used  some of the UX strategies, such as the user-interviews, [personas](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/ux/personas/Personas.pdf) [wireframes](https://github.com/SalientCRGT/fec-ef-app/tree/master/docs/ux/wireframes) and [usability testing](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/ux/usability/Usability_testing.md). These methods ensure that our designs are not only functional and easy to use, but also meet customer and user expectations and needs.
