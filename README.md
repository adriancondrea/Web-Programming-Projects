# Quiz
Web application which implements a quiz test.

Develop a web application based on JSP (Java Server Pages) or Java Servlets. 

All web pages should be accessible only if the user logs in using a username and a password (create a session each time a user logs in, and destroy the session when the user logs out). Have in mind the user experience when you implement the problem:

* add different validation logic for input fields
* do not force the user to input an ID for an item if he wants to delete/edit/insert it; this should happen automatically (e.g. the user clicks an item from a list, and a page/modal prepopulated with the data for that particular item is opened, where the user can edit it)
* add confirmation when the user deletes/cancels an item
* do a bare minimum CSS that at least aligns the various input fields
* State information (between web requests) is always stored in a database; you may store some state information in cookies/session objects.

Solve the following problem using the JSP/Servlet technology. Write a web application which implements a quiz test. The application displays several questions together with their possible answers on a web page and the use must choose an appropriate answer. The number of questions per page should be configured by the user. Also the number of questions in a test should be configured (chosen) by the user. The questions and possible answers are stored in the database. In the end, the application displays the number of questions correctly answered by the user and the number of questions wrongly answered by the user, together with the all time best result of the user.
