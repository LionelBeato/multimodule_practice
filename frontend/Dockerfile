# Use official Node.js image for build
FROM node:22-alpine AS build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# Use official Nginx image to serve the built app
FROM nginx:alpine
## Replace default nginx site content and config with Angular build
RUN rm -rf /usr/share/nginx/html/*
# Copy only the browser build artifacts (Angular CLI places them under dist/<project>/browser)
COPY --from=build /app/dist/frontend/browser/ /usr/share/nginx/html/
# Provide custom nginx config to enable SPA routing (fallback to index.html)
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
