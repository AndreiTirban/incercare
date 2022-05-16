FROM node:14.17.6-alpine AS build

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . /app

RUN npm run build --prod

FROM nginx:alpine

COPY --from=build /app/dist/* /usr/share/nginx/html/

COPY --from=build /app/nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 4200:80
