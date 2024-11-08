USE students_db;
DROP PROCEDURE IF EXISTS find_by_email_and_password;
DELIMITER $$
CREATE PROCEDURE find_by_email_and_password (
	IN in_email     VARCHAR(50),
    IN in_password  VARCHAR(50)
)
BEGIN
	SELECT *
	FROM student
	WHERE email = in_email AND pwd = in_password;
END $$
DELIMITER ;
