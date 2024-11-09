# student-app
  Pull & Run sonarqube từ docker image

  docker pull sonarqube:lts-community

  docker run -p 9000:9000 sonarqube:lts-community

  mvn clean verify sonar:sonar \
    -Dsonar.projectKey=studentservice \
    -Dsonar.host.url=http://localhost:9000 \
    -Dsonar.login=sqp_cf06268c67817bf3425af795d180ffe899335f51

# Code quality test results

![Code quality test results](https://github.com/thoidaianhhung/student-app/blob/main/Ki%E1%BB%83m%20tra%20ch%E1%BA%A5t%20l%C6%B0%E1%BB%A3ng%20code.png?raw=true)


# Project folder structure

![Project folder structure](https://github.com/thoidaianhhung/student-app/blob/main/C%E1%BA%A5u%20tr%C3%BAc%20th%C6%B0%20m%E1%BB%A5c%20d%E1%BB%B1%20%C3%A1n.png?raw=true)




