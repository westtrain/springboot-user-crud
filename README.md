# Spring Boot User & Payment API

## 프로젝트 소개
- Java 17 + Spring Boot 3.4.5
- 메모리 기반 User CRUD 및 Payment 기능 구현
- 통일된 JSON 응답 포맷 적용
- Validation 및 Global Exception Handling 구현

## 개발 환경 세팅
1. JDK 17 설치 (SDKMAN! 이용)
2. IntelliJ 설치 (또는 다른 IDE 가능)
3. Maven Wrapper (`./mvnw clean compile`)로 프로젝트 빌드
4. 서버 실행 (`./mvnw spring-boot:run`)

## 주요 기능

### 1. 사용자 등록 (POST /users)
- 이름(name)과 나이(age)를 입력하여 사용자 등록
- 이름은 비어있을 수 없음, 나이는 0 이상

### 2. 사용자 조회 (GET /users)
- 등록된 사용자 목록 반환

### 3. 사용자 수정 (PUT /users/{index})
- 특정 인덱스 사용자의 이름과 나이 수정

### 4. 사용자 삭제 (DELETE /users/{index})
- 특정 인덱스 사용자 삭제

### 5. 결제 생성 (POST /payments)
- 결제 금액(amount)과 결제 수단(paymentMethod)을 입력하여 결제 등록
- 생성 시 고유한 UUID 기반 paymentId 자동 발급
- 기본 상태(status)는 "CREATED"

### 6. 결제 단건 조회 (GET /payments/{paymentId})
- 특정 paymentId에 해당하는 결제 정보 반환

### 7. 결제 전체 조회 (GET /payments)
- 등록된 모든 결제 내역 반환

### 8. 결제 취소 (PUT /payments/{paymentId}/cancel)
- 특정 paymentId에 해당하는 결제 상태를 "CANCELED"로 변경

## 테스트 작성 범위

### 사용자 API
- POST /users
- GET /users
- PUT /users/{index}
- DELETE /users/{index}

### 결제 API
- POST /payments
- GET /payments/{paymentId}
- GET /payments
- PUT /payments/{paymentId}/cancel

## 테스트 작성 범위
- POST /users
- GET /users
- PUT /users/{index}
- DELETE /users/{index}

## 테스트 특징
- @WebMvcTest를 이용해 Controller만 빠르게 테스트
- Service는 @MockBean을 이용해 가짜 객체로 주입
- HTTP Status Code 검증
- Request/Response 구조 확인

## 실행 방법
```bash
./mvnw spring-boot:run
```

## 주의사항
- 데이터는 서버 메모리에 저장되므로 서버 재시작 시 초기화됩니다.
- Validation 실패 시 일관된 에러 포맷(JSON)으로 400 Bad Request를 반환합니다.

## 배운 점
- Spring Boot Controller-Service-Domain 구조 이해
- RESTful API 설계 및 구현
- 메모리 기반 데이터 저장 흐름 이해
- Java 기본 예외처리 및 Validation 학습
- DTO 폴더 구조 분리 및 관리 방법 이해
- Java Stream API (filter, findFirst) 기초 사용법 학습
- Node.js Express와 Java Spring Boot 구조 차이 비교
- 터미널 curl 명령어를 통한 API 테스트 실습
- Spring Boot 테스트 환경(@SpringBootTest)과 Bean 관리 이해
