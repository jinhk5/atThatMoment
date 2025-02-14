# atThatMoment
JWT 기반 회원가입 및 로그인 시스템

📌 프로젝트 개요

Java Spring Boot와 React를 사용하여 JWT 기반 회원가입 및 로그인 시스템을 구현한 프로젝트입니다.
MySQL을 데이터베이스로 사용하며, JWT를 활용하여 사용자 인증 및 보안을 관리합니다.

🚀 기술 스택

백엔드 (Spring Boot)

Java 17

Spring Boot 3.x

Spring Security & JWT (Json Web Token)

JPA (Java Persistence API) & Hibernate

MySQL

Gradle

프론트엔드 (React)

React.js (create-react-app 기반)

Axios (API 요청)

React Router (페이지 라우팅)

⚙️ 환경 설정

1️⃣ MySQL 데이터베이스 설정

MySQL에서 새로운 데이터베이스를 생성:

CREATE DATABASE jwt_auth_db;

Spring Boot application.properties (또는 application.yml) 설정:

spring.datasource.url=jdbc:mysql://localhost:3306/jwt_auth_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

2️⃣ JWT 설정

application.properties에 JWT 비밀 키 추가:

jwt.secret=your-secret-key
jwt.expiration=86400000  # 토큰 만료 시간 (1일)

🛠️ API 명세

1️⃣ 회원가입

[POST] /auth/register

요청:

{
  "username": "user1",
  "password": "password123"
}

응답:

{
  "message": "User registered successfully"
}

2️⃣ 로그인

[POST] /auth/login

요청:

{
  "username": "user1",
  "password": "password123"
}

응답:

{
  "token": "jwt_token_here"
}

3️⃣ 사용자 정보 조회 (보호된 API)

[GET] /user/me (JWT 필요)

요청 헤더:

Authorization: Bearer jwt_token_here

응답:

{
  "id": 1,
  "username": "user1"
}

🏃 실행 방법

백엔드 (Spring Boot) 실행

./gradlew bootRun

또는

mvn spring-boot:run

프론트엔드 (React) 실행

cd frontend
npm start

