FROM alpine:3.10 as builder

ARG VERSION=7.12.0
ARG DISTRO=tomcat
ARG SNAPSHOT=true

ARG EE=false
ARG USER
ARG PASSWORD

RUN apk add --no-cache \
        ca-certificates \
        maven \
        tar \
        wget \
        xmlstarlet

COPY /camunda_workflow/settings.xml /camunda_workflow/download.sh /camunda_workflow/camunda-tomcat.sh /camunda_workflow/camunda-wildfly.sh  /tmp/

RUN /tmp/download.sh

#### Workflow App ###
FROM maven:3.5.2-jdk-8-alpine as build
COPY /camunda_workflow/workflow /tmp/
WORKDIR /tmp
RUN mvn clean package

##### FINAL IMAGE #####

FROM alpine:3.10

ARG VERSION=7.12.0

ENV CAMUNDA_VERSION=${VERSION}
ENV DB_DRIVER=org.h2.Driver
ENV DB_URL=jdbc:h2:./camunda-h2-dbs/process-engine;MVCC=TRUE;TRACE_LEVEL_FILE=0;DB_CLOSE_ON_EXIT=FALSE
ENV DB_USERNAME=sa
ENV DB_PASSWORD=
ENV DB_CONN_MAXACTIVE=20
ENV DB_CONN_MINIDLE=5
ENV DB_CONN_MAXIDLE=20
ENV DB_VALIDATE_ON_BORROW=false
ENV DB_VALIDATION_QUERY="SELECT 1"
ENV SKIP_DB_CONFIG=
ENV WAIT_FOR=
ENV WAIT_FOR_TIMEOUT=30
ENV TZ=UTC
ENV DEBUG=false
ENV JAVA_OPTS="-Xmx768m -XX:MaxMetaspaceSize=256m"

EXPOSE 8080 8000

# Downgrading wait-for-it is necessary until this PR is merged
# https://github.com/vishnubob/wait-for-it/pull/68
RUN apk add --no-cache \
        bash \
        ca-certificates \
        openjdk11-jre-headless \
        tzdata \
        tini \
        xmlstarlet \
    && wget -O /usr/local/bin/wait-for-it.sh \
      "https://raw.githubusercontent.com/vishnubob/wait-for-it/a454892f3c2ebbc22bd15e446415b8fcb7c1cfa4/wait-for-it.sh" \
    && chmod +x /usr/local/bin/wait-for-it.sh

RUN addgroup -g 1000 -S camunda && \
    adduser -u 1000 -S camunda -G camunda -h /camunda -s /bin/bash -D camunda
WORKDIR /camunda
USER camunda

ENTRYPOINT ["/sbin/tini", "--"]
CMD ["./camunda.sh"]

COPY --chown=camunda:camunda --from=builder /camunda .
COPY --from=build /tmp/target/workflow-0.0.1-SNAPSHOT.war /camunda/webapps/workflow-0.0.1-SNAPSHOT.war
RUN cd /camunda/webapps && rm -rf camunda-invoice
