

# MoneyLion Java Technical Assessment
### by Teo Sheng Kai

This is a Spring Boot application developed for MoneyLion's technical assesssment as part of the hiring process. It is bootstrapped using Spring Initializr and uses the H2 database.

---
### Database initialization

Upon starting the application, the database will be preloaded with data, shown in the table below in terms of features that each email has access to.
| Email | donation | backup | restore |
|--|:--:|:--:|:--:|
| amy@email.com     | ❌ | ❌ | ✔ |
| brandon@email.com | ✔ | ❌ | ❌ |
| charlie@email.com | ✔ | ✔ | ❌ |

---

### Endpoints

#### `GET` /feature?email=XXX&featureName=XXX
Takes two query parameters, email and featureName, and returns a response as such, depending on whether the said feature is enabled for the specified email,

Response format:
```
{
    "canAccess": true|false <boolean>
}
```

#### `POST` /feature
Expects a request with JSON body and will return an empty response with either HTTP status 200 or 304 depending on if a change is made to the database. E.g.: If a request is made to enable a feature that is already enabled, a 304 response will be returned.

Request format:
```
{
    "featureName": "xxx", <string>
    "email": "xxx", <string>
    "enable": true|false <boolean>
}
```
