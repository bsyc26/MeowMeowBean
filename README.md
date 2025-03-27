# Final Project - Choose your own adventure

### Due Dates
- *Proposal:* Friday, April 4, 2025
- *Design Document:* Thursday, April 10, 2025
- *Release 1:* Tuesday, April 15, 2025
- *Final Submission:* Thursday, April 24, 2025

Assignment Link: []()

For this project, you will propose and implement a project of your choosing. You may implement an extension of a previous project or a new project related to something we have discussed during the semester.

## Requirements

Your final project is an opportunity for you to explore a project that aligns with your interests and  demonstrates everything you have learned this semester about good design practices, development of large software in Java, and learning new things. 

Your final submission will be a working program with *at least three significant features* in addition to any basic functionality. Several examples are described below. It is very likely that you will need to teach yourself new things in order to complete this project! You can always seek help during office hours.

Your final project grade will be based on the following:

- Proposal: an oral proposal of the project you will implement.
- Design Document: a UML design document with your initial design.
- Release 1: at least *one* well-designed and completely functional feature. 
- Final Submission: a complete solution and project presentation. 

The coding portions of your project will be evaluated on both correctness ***and design***. If you do not apply the design principles you've learned this semester you will not earn full credit.

## Proposal - Due Friday, April 4, 2025

Your proposal will have two components: a written component and an oral presentation component.

**Written Component:** The written component will be submitted in the document [PROPOSAL.md](PROPOSAL.md). The document template describes the following four elements you must complete: Project Description; Basic Functionality; Three Significant Features; Anticipated Challenges.

To earn full credit, each element must be thoroughly described in one or more paragraphs of complete sentences.

**Oral Component:** On Friday, April 4 during the class period, each student will present a five-minute overview of their project. You are not required to present slides. An overview of the elements of your proposal is sufficient for this element; however, you may use slides or other materials if you wish.

## Design Document - Due Thursday, April 10, 2025

Your design document will be submitted in the document [DESIGN.md](DESIGN.md). It will include a UML diagram describing the design of your solution and a description of any other relevant elements of your design.

Your design may change; however, full credit will be awarded to designs that are complete and demonstrate that you have thought carefully about all of the components needed for your solution.

## Release 1 - Due Tuesday, April 15, 2025

During the class period on April 15 you will be responsible for demonstrating complete functionality for one of your features. You must implement enough of the basic functionality required to support this feature. Your grade will depend upon the design of your solution as well as the correctness of the functionality.

Your design score will be based on your program decomposition and code structure. Code smells will result in a deduction. Criteria include the following: 
- Classes follow the single responsible principle
- Methods do one thing 
- Methods are an appropriate length
- Classes, methods, and variables are named appropriately
- Inheritance is used appropriately
- Interfaces are used in appropriate cases and follow the interface segregation principle
- The dependency inversion principle is followed

*Note, you will not be graded on TDD at release 1; however, you will be graded on TDD for the final submission.*

## Final Submission - Thursday, April 24, 2025

Your final submission will be a complete program implementing all three features specified in your proposal. Your solution is required to include the following components:

**Three Implemented Features:** Your solution will have three complete features that will be graded on correctness of the functionality and overall design. 

**TDD:** Your GitHub commit history will demonstrate that you used TDD during the implementation of your solution. 

**Design Patterns:** You will use at least two different design patterns in your solution. You do not need to use the patterns we discuss in class. 

**Use of Collections:** You will use at least one data structure from the Collections framework, for example a List or Map.

**Jar File:** You will create a "fat jar" file. This will be stored in your top-level FinalProject directory and will be named `finalproject.jar`. Your program must be executable with the following command: `java -jar finalproject.jar`. If your design requires that your project take command line parameters or use other configuration, you will create a document called REQUIREMENTS.md and describe those requirements there. 

**Final Demonstration:** You will complete a 30-minute meeting with the instructor during which you will demonstrate your solution and orally answer reflection questions. A written reflection is not required; however, your final demonstration grade will be based on how well you answer the reflection questions asked during your final demo. 

You will also be graded on the level of difficulty of the project you have completed.

## Team Option

You may work in teams of two for this project, but it is not required. If you choose to work as a team you must complete ***five*** features rather than three. Consider designing your project so that each team member is responsible for a component of the system. In order to work as a team, send Sami a DM with the names of your team members. Specify which person's repository you want to use, and Sami will grant the other student access.

## Project Ideas

*Please be creative!* These are a few ideas you can consider, but you are not restricted to this list. 

### Music Player
Implement a music player client. Basic functionality would include the ability to load a music library and play songs. Additional features could include creating playlists; implementing a graphical user interface; and viewing available songs sorted by song title, album, and artist.

### Fitness Tracker Extension
Extend your Fitness Tracker application to include three substantial new features. Features could include a graphical user interface; additional data analysis to determine trends; user management; additional fitness/nutrition goal options. You could also integrate an external API or real dataset as your food database.

### Todo List Application
Implement an application to maintain a todo list. Basic functionality would include adding new items, viewing items, and marking items as completed. Additional features could include implementing the application as a web application; tagging/categorizing items; and assigning deadlines.

### Tic Tac Toe Game
Implement a tic tac toe game. Basic functionality would include allow two human players to play the game. Additional features could include a graphical user interface; a computer player option that would use an algorithm of your choosing to determine computer plays; and a leaderboard to track user wins.    

## Grading Rubric

The assignment is worth 25 points in total. For criteria worth two points,
partial credit may be awarded. For criteria worth one point, the solution must
be completely correct to earn credit.

| Criterion                                  | Points | 
|--------------------------------------------|--------|
| Proposal - Written Component               | 2      |
| Proposal - Oral Component                  | 1      |
| Design - UML                               | 1      |
| Design - Description                       | 1      |
| Release 1 - Feature 1 Functionality        | 1      |
| Release 1 - Feature 1 Design               | 2      |
| Final Submission - Program Difficulty      | 2      |
| Final Submission - Feature 2 Functionality | 1      |
| Final Submission - Feature 2 Design        | 2      |
| Final Submission - Feature 3 Functionality | 1      |
| Final Submission - Feature 3 Design        | 2      |
| Final Submission - TDD used                | 1      |
| Final Submission - Design Patterns Used    | 2      |
| Final Submission - Collections Used        | 1      |
| Final Submission - Jar File Provided       | 1      |
| Final Submission - Demonstration           | 1      |
| Final Submission - Javadoc                 | 1      |
| Final Submission - Reflection              | 2      |