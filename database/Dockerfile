FROM postgres
ENV POSTGRES_DB postgres
COPY /database/psql_dump.sql /docker-entrypoint-initdb.d/
EXPOSE 8080