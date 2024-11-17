# Redis 공식 이미지 사용
FROM redis:latest

# Redis 설정 파일 복사 (필요한 경우)
COPY redis.conf /usr/local/etc/redis/redis.conf

# Redis 포트 노출
EXPOSE 6379

# Redis 서버 시작 명령
CMD ["redis-server", "/usr/local/etc/redis/redis.conf"]

#docker build -t redis-server .

#docker run -d -p 6379:6379 --name redis-server redis-server
