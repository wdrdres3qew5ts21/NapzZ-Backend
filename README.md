# Backend Project

### App Stack
![alt](asset/app-stack.png)

SMTP Server: Mailgun Service

Authentication: JWT Token

Persistent API: JPA Hibernate

Database: MySQL Connector

Infrastructure: Docker Container Image

Container Platform: Openshift 4.6

![alt](asset/app-connect.png)

### Preview User Interface

![alt](asset/app/1login.png)
![alt](asset/app/2%20overview.png)
![alt](asset/app/3search.png)
![alt](asset/app/4.4.1view.png)
![alt](asset/app/4reserve.png)
![alt](asset/app/5manag.png)
![alt](asset/app/6edit.png)

### Class Diagram

กดที่รูปเพื่อดูรูปแบบ HD (ภาพขนาดใหญ่มาก สามารถซูมได้)

![alt](asset/class-diagram-finalbackend.umlcd.png)

### Backend Version ปัจจุบัน
Container Registry: Quay.io
https://quay.io/repository/linxianer12/napzz-backend?tab=tags

Image: quay.io/linxianer12/napzz-backend:1.19.0
![alt](asset/container-image.png)
### Developer Setup
ใช้ Postman Collection สำหรับการเรียกใช้ API ที่ไฟล์ "NapZz Init Project.postman_collection.json"

![alt](asset/postman.png)
```
docker-compose up -d

mvn quarkus:dev

openssl genrsa -out rsaPrivateKey.pem 2048
openssl rsa -pubout -in rsaPrivateKey.pem -out publicKey.pem
openssl pkcs8 -topk8 -nocrypt -inform pem -in rsaPrivateKey.pem -outform pem -out privateKey.pem

mvn quarkus:dev -D"mp.jwt.verify.publickey.location=publicKey.pem" -D"smallrye.jwt.sign.key-location=privateKey.pem"

mvn quarkus:dev -D"MAILGUN_KEY=place-mailgun-key-here" -D"MAILGUN_DOMAIN=place-mail-gun-domain-here"

oc create cm napzz-config --from-file=application.properties

oc create dc --image=docker.io/phpmyadmin/phpmyadmin:5.1.0 phpmyadmin

oc set env dc/phpmyadmin --env="PMA_HOST=mysql"

```
ไฟล์ที่อ่านจาก application.properties ถ้าจะใช้ relative path ก็ต้องวางใน directories resources ด้วยไม่อย่างนั้นจะมองไม่เห็น

### Configuraiton File
ตำแหน่งของไฟล์ที่วางไว้
`src/resources/application.propeties`
```
quarkus.datasource.db-kind=mysql
quarkus.datasource.username=supakorn
quarkus.datasource.password=lnwza007


quarkus.datasource.jdbc.url=jdbc:mysql://${DATABASE_URL:localhost}:${DATABASE_PORT:3306}/napzz?characterEncoding=utf-8&createDatabaseIfNotExist=true

#quarkus.hibernate-orm.database.generation=drop-and-create
quarkus.hibernate-orm.database.generation=update
quarkus.hibernate-orm.log.sql=${ENABLE_DEBUG_SQL:true}
com.napzz.service.MailGunEndpointInterface/mp-rest/url=https://api.mailgun.net/v3/${MAILGUN_DOMAIN:mailgun-domain-place-here}

mailgun.key=${MAILGUN_KEY:mailgun-key-place-here}
quarkus.swagger-ui.always-include=${ENABLE_SWAGGER:true}

mailgun.sender=NapZzSystem <mailgun@${MAILGUN_DOMAIN:mailgun-domain-place-here}>

# mp.jwt.verify.publickey.location=C:\\ProjectCode\\NapzZ-Backend\\publicKey.pem
# smallrye.jwt.sign.key-location=C:\\ProjectCode\\NapzZ-Backend\\privateKey.pem

mp.jwt.verify.publickey.location=publicKey.pem
smallrye.jwt.sign.key-location=privateKey.pem
quarkus.openshift.build-strategy=docker

quarkus.http.cors.origins=*
quarkus.http.cors=${ENABLE_CORS:true}
quarkus.http.cors.methods=*

quarkus.swagger-ui.title=Napzz Backend Host by Openshift 4.6

quarkus.http.port=9090

quarkus.log.file.enable=true
quarkus.log.file.path=C:\\ProjectCode\\NapzZ-Backend\\backend.log
quarkus.log.file.level=ALL
```



This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/backend-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Related guides

- RESTEasy JAX-RS ([guide](https://quarkus.io/guides/rest-json)): REST endpoint framework implementing JAX-RS and more

## Provided examples

### RESTEasy JAX-RS example

REST is easy peasy with this Hello World RESTEasy resource.

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)

### RESTEasy JSON serialisation using Jackson

This example demonstrate RESTEasy JSON serialisation by letting you list, add and remove quark types from a list. Quarked!

[Related guide section...](https://quarkus.io/guides/rest-json#creating-your-first-json-rest-service)
