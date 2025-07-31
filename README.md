# SpringbootMikroservisMimarisi
Spring boot tabanlı mikroservis projesi 
Bu projede Spring Boot ve çeşitli açık kaynak teknolojiler kullanılarak bir mikroservis mimarisi örneği geliştirilmiştir. Uygulama, servisler arası iletişimi yönetmek ve sistemin ölçeklenebilirliğini artırmak amacıyla mikroservis prensiplerine uygun olarak tasarlanmıştır.

⚙️ Kullanılan Teknolojiler

🧪 Spring Boot
📦 Docker
🔁 Kafka
🧭 Spring Cloud Eureka Server
🔐 Spring Cloud Config Server
📡 Spring Cloud Gateway (API Gateway)
🔍 Zipkin (Dağıtık izleme için)
🧪 Postman (API testleri için)
🧩 Mikroservis Yapısı

Proje toplamda 5 ana mikroservisten oluşmaktadır:

Servis Adı	Açıklama
api-gateway	Gelen istekleri ilgili servislere yönlendirir
lesson-service	Dersler ile ilgili işlemleri yönetir
student-service	Öğrenci bilgileri ile ilgili işlemler
config-server	Tüm servislerin konfigürasyonlarını merkezi olarak yönetir
service-registry	Eureka server olarak görev alır, servislerin kaydını tutar
🌐 Örnek API Endpointleri

Aşağıda bazı örnek endpoint'ler bulunmaktadır. Bu endpoint'ler, Postman gibi araçlarla test edilebilir:

Lesson Service
GET http://localhost:8081/lesson
Student Service
GET http://localhost:8082/student
API Gateway üzerinden erişim
GET http://localhost:8060/lesson
GET http://localhost:8060/student
🔁 Not: Tüm servisler Docker konteynerlerinde çalıştırılmakta ve servisler arası iletişim Eureka üzerinden sağlanmaktadır.
