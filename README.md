# student-app
Pull & Run sonarqube từ docker image
docker pull sonarqube:lts-community
docker run –p 9000:9000 sonarqube:lts-community

mvn clean verify sonar:sonar \
  -Dsonar.projectKey=studentservice \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=sqp_cf06268c67817bf3425af795d180ffe899335f51