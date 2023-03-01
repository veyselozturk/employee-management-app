# employee-management-app
 
Şirketler ve Çalışanları Uygulaması

## Kullandığım dependency'ler ve teknolojiler

- Spring Boot 3
- Spring Data JPA
- H2 Veritabanı
- Lombok
- Java 17

### Açıklama

Employee ve Company entity'lerini aralarında one to many ilişki kurarak oluşturdum.
Veritabanı işlemlerinin sağlanacağı interface olan repository'yi EmployeeRepo ve CompanyRepo olarak iki entity için ayrı ayrı oluşturdum. JPARepo'yu her iki interface için extend ettim. 




