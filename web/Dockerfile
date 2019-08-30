# build stage
FROM node:lts-alpine as build-stage
WORKDIR /web
COPY /web/. /web/
RUN npm install
#COPY /web/. /web/
RUN npm run build

# production stage
FROM nginx:stable-alpine as production-stage
RUN rm -rf /usr/share/nginx/html/*
COPY --from=build-stage /web/dist/CodeChallenge /usr/share/nginx/html
COPY --from=build-stage /web/nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
