# 베이스 이미지 설정
FROM postgres:12

# 환경 변수 설정
ENV POSTGRES_DB=springboot
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=pass

# 초기 SQL 스크립트 복사
#COPY init.sql /docker-entrypoint-initdb.d/

# PostgreSQL 기본 포트 노출
EXPOSE 5432

# 이미지 빌드
#docker build -t springboot-postgres .

# 컨테이너 실행
#docker run -d -p 5432:5432 --name springboot-db springboot-postgres
