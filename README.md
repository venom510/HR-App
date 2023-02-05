# HR-App
A basic HR app with features to add, list, search, update and delete employees.
You can add employee details (Id, Name and Salary), list all the existing employees, search an employee by id, update name or salary of an existing employee, or delete an existing employee.

An in-memory database (H2 database) has been used to persist the data.

There are separate HTML pages linked together to serve the information.
Rest APIs are written in Java. Used spring boot framework. Also, used some javascript in the HTML pages to use the fetch API for calling the REST endpoints.

Started this to learn java and spring boot. Will try to work more on this, to keep applying new things as I keep learning them.


---------------------

## Screenshots


| <img width="675" alt="image" src="https://user-images.githubusercontent.com/39994281/207153291-c697e3fc-cb8b-427d-8cbf-404d5f44167c.png"> |
|:--:|
| *Home Page* |

| <img width="386" alt="image" src="https://user-images.githubusercontent.com/39994281/207153427-95caa223-088a-4296-abc4-5312ce74b548.png"> |
|:--:|
| *List All Employees* |

| <img width="367" alt="image" src="https://user-images.githubusercontent.com/39994281/207153526-30f306cd-311c-4ea5-95b0-cdb25b00eba3.png"> |
|:--:|
| *Add New Employee* |


| <img width="327" height="250" alt="image" src="https://user-images.githubusercontent.com/39994281/207153952-34dde893-9d46-4959-b134-85adaa48d68d.png">   <img width="327" height="250" alt="image" src="https://user-images.githubusercontent.com/39994281/207154026-867a8dd7-fa35-48ea-855d-0d9b6daeee80.png">|
|:--:|
| *Search Employee By ID* |


--------------------------------




### To-Do (Not an exhaustive list. Will keep on updating this as well)
1. Add proper exception handling
2. Instead of creating own HTML templates and handling everything, use plugins or dependencies in spring boot, such as thymeleaf
3. Add more features such as search on the basis of different filters, etc
4. Add department info as well, and corresponding connections between department and employees
5. Add login feature
6. Improve the frontend



