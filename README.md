# Todo Application

- This is an application for SITE's capstone project. As a part of our training, we need to build a simple application using any programming languages and tools.

- I built a simple Todo application. The system allows the user to enter details of the task she/he is planning to do, and the finish date of that task. To sum up, the system is built to perform all CRUD operations. REST services have been also implemented for this project.


- The application built to be light, friendly, and appealing to use.
So I would like to thank FreeFrontend.com for the great html/css template which I used in this project and edited it. You can find thier website in the References section and explore their amazing templates.

### Use Case Diagram 
![usecasepic](https://user-images.githubusercontent.com/61372625/83962760-baca1780-a8a8-11ea-8966-f9600d5ef330.png)

** To run the project:
Run on maven and do * clean spring-boot:run * then go to http://localhost:8080/todo/home.

** For REST
All tasks : http://localhost:8080/api/todo/tasksList
Get task : http://localhost:8080/api/todo/task/1
** Note Task with ID 1 has already created on the database once you run the project. **
Add :http://localhost:8080/api/todo/add/{id}
Update :http://localhost:8080/api/todo/update/{id}
Delete :http://localhost:8080/api/todo/delete/{id}
* You can test it on Postman
---

## Technologies Used

```diff
- Java 11
- SpringBoot
- Thymeleaf
- Maven
- H2 database
- Postman
```
---

## Screenshots

![Picture1](https://user-images.githubusercontent.com/61372625/83655006-88799b00-a5c6-11ea-818b-85ac860d5c44.png)

![Picture2](https://user-images.githubusercontent.com/61372625/83655394-0b025a80-a5c7-11ea-998e-8320055395b0.png)

---

## References 

[Free Frontend Website](https://freefrontend.com/css-forms/)

---

## Acknowledgments

- Saudi Information Technology Company (**SITE**)
- KnowledgeHut
