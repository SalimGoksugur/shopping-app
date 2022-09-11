# shopping-app

## Proje Hakkında
Shopping-app uygulaması online alışveriş sitesinin iskeleti niteliğinde demo bir uygulamadır. Kullanıcı, ürün ve yorum nesneleri üzerinden çalışmaktadır.

## Özet
Bu projede, 
- Bağımlılık yönetimi için Maven,
- ORM olarak Hibernate kullanıldı.
- Her istek için Spring validation ile geçerlilik kontrolü yapıldı.
- Entity'leri dışarı açmak yerine, DTO'lar üzerinden request ve responselar yönetildi.
- Entity-Dto maplemesi için MapStrunct'dan yararlanıldı.
- Swagger ile dökümante edildi. 
- Lombok kullanıldı.
- Her response'un aynı formatta olması sağlandı. Response içerisindeki isSucces alanında isteğin başarılı olarak işlenip işlenmediği görülebilir.

### Kullanılan Teknolojiler
- Java 17
- PostgreSQL
- Spring Boot
- Maven
- Swagger
- Lombok
- MapStruct
