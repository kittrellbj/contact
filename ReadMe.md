# Reflection Report and JUnit Test Examples
## Software Testing, Automation, and Quality Assurance

> How can I ensure that my code, program, or software is functional and secure?

Testing software is critical to the software development lifecycle, ensuring project requirements, and securing software against vulnerabilities. Technical excellence plays a role in functional and secure software&emdash;to have knowledge of potential risks and issues&emdash;but even seasoned software engineers do not produce perfect code without testing. Everyone, beginning to master, needs to make sure.

Many methods exist to test code, and I have found a mixture of automated and manual testing leads to the best results for my code. Testing packages like JUnit (Java), NCover or MSTest (C#), and many others may be used for unit testing the code. Alongside the unit testing&emdash;and often before unit testing begins&emdash;I use manual testing on parts of the code as I go to provide inputs and observe outputs, which allows me to spot fix areas of concern.

> How do I interpret user needs and incorporate them into a program?

Two primary methods for requirement gathering involve outlining and user stories. An outline gives a broad overview of the general idea of what the software should accomplish or what need it serves, and this represents the "big picture" of the project. This outline need not drill down into fine detail, but a general idea of where the project should be going can be helpful, and establishing major categories of work can help determine dependencies in the project and order in which tasks should be completed for the highest efficiency.

> How do I approach designing software?

My typical approach&emdash;which may vary somewhat between projects depending on their needs&emdash;involves outlining the overall goals and requirements of the project, the major modules, and the dependency relationships between modules. Once a basic sketch has been put forth, the foundational dependencies are identified, and work is prioritized to these portions first. A focus on simplicity and abstraction in the foundational layer defines the early development process so that later dependent modules can interact with the core, and these pieces can be extended later for more specific functionality.

Once the foundation is build, the framework for dependent modules can begin. At each module, the agile approach gives the development process structure. Designs are refined and user stories are generated to reflect the goal of each module. Iterative development and testing occur until the module is functionally complete and ready for widespread testing, using rigorous unit testing to uncover flaws in the source. After successful testing and eliminating any errors, the module can then be integrated into the project source. Some further testing is usually in order for the module to be fully integrated, but rarely is this a complicated process for thoroughly-tested code.

The iterative cycles continue until the project is finished. At key points in the process, progress is reported to the client (if I am handling the project as the only developer) or to the Product Owner so that we can receive additional feedback during the development process. This avoids late changes that can mean significant refactoring of the code that would be costly to perform.

Once the software has reached its release stage, the Product Owner, client, and the team are satisfied with the results, the product or service enters the production stage where it can be purchased and/or used by end users. Maintenance cycles which resemble development cycles may occur after production if new errors or vulnerabilities are discovered in the product post-launch, and some products undergo the whole process again to produce a sequential software version with new features, refinements, and functionality.
