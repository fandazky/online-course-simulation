# Online Course Simulation

## Assumption
1. There are 2 kind of account. The first one is Admin. The second one is User.
2. Account with role Admin have capability to create course & search course
3. Account with role User have capability to search course

## How to Run Locally
1. Clone this project
2. Adjust the config value on `application.properties` especially for a database & redis properties
3. Run DML of Master Data
4. Go to root directory of this project and type `mvn clean install -DskipTests`
5. Run the application using command `mvn spring-boot:run`

## API Endpoint
1. API Register User (POST /api/auth/)
2. API Signin (POST /api/auth/)
3. API Create course (POST /api/courses)
4. API Search course (GET /api/course?keyword=$keyword)

## DML Master Data
`
INSERT INTO categories (icon, name)
VALUES ('https://fandazky.xyz/categories/icon/software.png', 'IT & Software'),
('https://fandazky.xyz/categories/icon/finance.png', 'Finance & Accounting');
`

`
INSERT INTO roles (name)
VALUES ('ROLE_USER'),('ROLE_ADMIN')
`