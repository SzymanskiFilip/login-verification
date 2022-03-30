# login-verification

## Spring Boot, Spring Security, Redis, MySQL

### Database:
users </br>
``id bigint auto_increment``</br>
``username varchar(60)``</br>
``password varchar(60)``</br>
``email varchar(50)``</br>
``active tinyint``</br>

verification_tokens</br>
``user_id bigint foreign key to users.id``</br>
``expiration_date datetime``</br>
``activation_token binary(16)``

The acitvation_token stores a UUID that is a 
verification code to activate the account.