# Описание 
**Была использована база postgres, для запуска проектна необходимо запустить docker-compose командой
из заданной директории _docker-compose -f docker-compose.yaml up -d postgres_**
##Описание Api:
1) Добавление пользователя
POST http://localhost:8080/api/add-customer/
Тело
   `{
   "name":"fill"
   }`
2) Получение списка пользователя
GET http://localhost:8080/api/
3) Получение пользователя по id   
   GET http://localhost:8080/api/get-customer/{id} - где id ключ в бд
4) Получение всех контактов пользователя
   http://localhost:8080/api/get-all-contacts/{name} - где name имя пользователя
5) Получение списка телефонов пользователя GET http://localhost:8080/api/get-phone-contacts-customer/{name} - где name имя пользователя
6) Получение списка почты пользователя GET http://localhost:8080/api/get-email-contacts-customer/{name} - где name имя пользователя
7) Добавление почты пользователю POST http://localhost:8080/api/add-email-customer/
    Тело запроса
   `{
   "name":"fill",
   "emails":[
   {"type":"home","email":"i@mail.ru"}
   ]
   }`
   
8)Добавление телефона пользователю POST http://localhost:8080/api/add-phone-customer/
   Тело запроса
   `{
   "name":"fill",
   "phones":[
   {"type":"home","phone":"3902111"}
   ]
   }`
   