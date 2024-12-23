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

# Tạo dự án Spring Boot
   Tạo project Spring Boot: Sử dụng https://start.spring.io/ để khởi tạo project Spring Boot với các dependencies: Spring Web, Spring Data JPA, MySQL Driver,
   Lombok, Validation, Spring Boot DevTools.

   Cấu hình application.yml:
   # yml
   ![yaml](https://github.com/thoidaianhhung/student-app/blob/main/yml.png?raw=true) 

# Xây dựng cấu trúc dữ liệu
   Thiết kế bảng student: Xác định các thuộc tính của student như id, fullName, birthDate, email, gender, pwd, role,
   createDt, authorities, personalInformation.

   Thiết kế bảng personal: Xác định các thuộc tính của personal như id, fullName, relationship, birthDate, gender, student.

   Thiết kế bảng authority: Xác định các thuộc tính của authority như id, authorityName, student.

   Tạo Entity: Tạo các lớp Entity đại diện cho bảng trong cơ sở dữ liệu, như student, personal, authority.
# Xây dựng dto, form, mapper
# Viết Repository Layer
   Tạo các repository interface kế thừa JpaRepository cho các entity như StudentRepository, PersonalRepository, AuthorityRepository
# Viết Service Layer
   Tạo các lớp service để xử lý logic nghiệp vụ, ví dụ: StudentService với các phương thức như getAllStudents(), findByEmail(), updateStudent(),
   registerUser(), loginUser().

   PersonalService với các phương thức như findAll(), findByStudentId(), findById(), create(), update(), deleteById().
# Tạo Controller
   Tạo các controller REST như StudentController để quản lý API cho CRUD operations. Ví dụ:

   POST /api/v1/register - Thêm sinh viên.

   POST /api/v1/login - Đăng nhập bằng email và pwd

   GET /api/v1/students - Lấy danh sách sinh viên.

   GET /api/v1/findByEmail - Tìm sinh viên bằng email

   PUT /api/students/{id} - Cập nhật sinh viên.

   PersonalController để quản lý API CRUD operations. Ví dụ:

   POST /api/v1/students/{studentId}/personals - Thêm người thân.

   GET /api/v1/personals - Lấy danh sách người thân.

   GET /api/v1/students/{studentId}/personals - Tìm danh sách người thân bởi id sinh viên.

   GET /api/v1/personals/{id} - Tim người thân bằng id.

   PUT /api/v1/personals/{id} - Cập nhật người thân.

   DELETE /api/v1/personals/{id} - Xóa người thân.

# Viết exception, validation
# Token based Authentication using JSON Web Token

   


