# employee-management-app
 
Çalışan Yönetimi uygulaması Uygulaması

## Kullandığım dependency'ler ve teknolojiler

- Spring Boot 3
- Spring Data JPA
- Spring Web
- H2 Veritabanı
- Lombok
- Java 17

### Açıklama

- Employee ve Company entity'lerini aralarında one to many ilişki kurarak oluşturdum. 
- Veritabanı işlemlerinin sağlanacağı interface olan repository'yi EmployeeRepo ve CompanyRepo olarak iki entity için ayrı ayrı oluşturdum. JPARepo'yu her iki interface için extend ettim. Spring Data'nın sağladığı özellikle bu sınıfla sorgu işlemi yapabiliyorum.
- Servis katmanını oluşturdum. Buranın amacı veritabanında bulunan employee ve company tabloları üzerinde ekleme, silme, düzenleme, listeleme gibi işlemleri yapmaktır. Servis sınıfındaki methodların çalışabilmesi için Controllar'dan istek gelmesi gerekmektedir.
- Controller sınıfını Rest API ile oluşturdum. Uygulamayı web üzerinde HTTP protokolü üzerinden gelecek olan isteklerle çalışmaktadır. GetMapping üzerinden örnek vermek gerekirse buradan gelen istek servisteki findAllCompany methodunu çalıştırmaktadır.


- Bu Spring uygulaması EmployeeManagementAppApplication classındaki main methotda bulunan run methodu sayesinde ayağa kalkar.




