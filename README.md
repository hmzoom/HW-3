# HW-3
mysql needed.<br/>
first database name: course<br/>
second database name: student<br/>
mysql port:3306.<br/>
maven student port: 8082.<br/>
maven course port: 8081.<br/>
maven eureka server port: 8761.<br/>
you can:<br/>
post to student /student<br/>
get all students from: /student<br/>
get one student by id from: /student/{id}<br/>
get one student by name from: /student/byname/{name}<br/>
get students by course name from: /student/studentsbycoursename/{name}<br/>
get course name by student name from: /coursebystudentname/{name}<br/>

post to course /course<br/>
get all courses from: /course<br/>
get course by id from: /course/{id}<br/>
get course by student id from: course/coursebystudentid/{id}<br/>
get students ids by course name from: course/studentsids/{name}<br/>
