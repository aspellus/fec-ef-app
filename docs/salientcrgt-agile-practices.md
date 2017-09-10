Agile Practices
===============

## Software Development Practices

Our **Agile Software Development Methodology** (as shown in below graphics) is based on empowering  people to incrementally develop software using Behavior Driven Development (BDD) and User Centered Design (UCD) approach. User Stories and Scenarios are created making sure we understand the needs of the users, and incorporate business behavior upfront.  We use quality techniques of Test Driven Development (TDD), Pair Progrmaming and Test Automation for maintaining high code quality and demonstrating software behaviors being delivered to requirements.

![https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/SalientAgileScrumProcess.png](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/SalientAgileScrumProcess.png)

Our **Agile Scrum Process** uses Sprint 0 to get the team ready for delivering working software, and then use multiple Sprints to incrementatlly deliver working code with test automation. We start each Sprint with **Sprint Planning** meeting (working with product owner the team accesses the work in sprint backlog), Scrum boards are displayed on TV monitors to manage work and visually track the progress of each Sprint. Further our Scrum process includes daily **stand-ups** (short team meetings again to keep team on track and take corrective action), each Sprint ends with [sprint-review](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/jira/test) (meeting to demonstrate working code), followed by [sprint-retrospective](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/jira/test) where the team discusses what went right, what did not go well, and what actions to take in next sprint to improve.

We further use our [Secured DevOps CI/CD platform](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/SalientCRGT%20SecDevOps.png) implemented on AWS to develop software. We use the efficiences of Continuous Integration/Continous Delivery and Quality Automation that is provided by our [Jenkins CI/CD Pipeline](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/SalientCRGT%20Jenkins%20Pipeline.png). By moving quality and security inspection of software as far as possible to the left, from day 1 we monitor for software quality and security vulnerabilities. Security is not an after thought, its baked into our Agile Software Development Methodology.


Further detail about some of our development strategies and methods can be found below:

### Version/Source Control
pramod to write

### Behavior-Driven Development / Test-driven Development (unit testing)
We use Behavior Driven Development (BDD), which is an extension of Test Driven Development(TDD), to gather and develop requirements. With the BDD approach, application development focuses on the behavior of the system and brings the development team closer to the business team. Requirements are captured as scenarios written in easy-to-understand English (e.g., Gherkin) that describe the application behavior from the user perspective.

These same requirements become test scenarios for TDD development using Cucumber and Selenium to drive test automation in each Sprint. BDD achieves common understanding and consensus on requirements much faster, results in ready-to-use test cases for the development team to implement during test automation, and ensures that the requirement documentation is readily available and is kept current as changes get implemented with each Sprint. Above all, BDD scenario documentation facilitates an analytical validation of requirements from all stakeholders before they are transformed into executable test cases by the development team.

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

## User Experience and User-Centered Design (UCD) Practices
We believe that an application cannot be successful without an engaging user interface (UI) that is built on a foundation of high usability and customer satisfaction. Using a UCD approach to research, design, and validate, our UI/user experience (UX) Engineers and BA work iteratively with the product owner and users to address the business process flow, messaging, and functions. They design the overall usability of the application to meet business goals, use various artifacts (e.g., wireframes, mockups, templates, and navigational flow) to iteratively work with business and end-users to design the best user experience. Each member of our design/user experience team includes a Visual Designer to ensure good design and user expereince is the foundation of the application from start to finish.

Our Visual Designers and UX Engineers engage with users and—using research tools in the Team’s UX toolkit—identify challenges and design needs. We use wireframes and sketches to rapidly express the complete business workflow, which facilitates constructive feedback from customers and business users. With the goal of a working prototype, our design engineers collaborate with the BA to draft wireframes that capture the application workflow and requirements, while continuously working with Business to enhance and modify the wireframes. Mockups and UI layouts with workflows are drafted and reviewed regularly, which enables business to experience the complete business workflow (application) up front. This approach also provides a platform to provide early feedback.

Our process is data driven and focuses on measurable outcomes, while embracing users and their perspective as an essential part of what it means to develop a system. We conduct user testing against each design to validate that our design achieves the goals set by the user and the client. If the design is successful, the development team, working with the UX Designer, commits it to final coding in the application. The picture below shows how our four-step UCD process which incorporates a feedback loop and establishes goals for UX design

![https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/UCD%20Approach%20pic1.jpg](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/pictures/UCD%20Approach%20pic1.jpg)


For the prototype application the  Visual Designer/UX was 1person and was embedded into the project team. For this project we used  UX strategies, such as the [user-interviews](Frank interview User Mahi) and [personas](https://github.com/SalientCRGT/fec-ef-app/blob/master/docs/ux/personas/Personas.pdf) [wireframes](https://github.com/SalientCRGT/fec-ef-app/tree/master/docs/ux/wireframes), [usability testing](), and application [style guide](). These methods ensure that our designs are not only functional and easy to use, but also meet customer and user expectations and needs.
