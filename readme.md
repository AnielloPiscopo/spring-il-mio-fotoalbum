<div align="center">
<h1 align="center">
<img src="https://img.shields.io/badge/Spring-4FC08D.svg?style&logo=Spring&logoColor=white" width="100" />
<br>SPRING-IL-MIO-FOTOALBUM
</h1>
<h3>◦ Simple exercise that contains a webpage for the photos of a series of users for the back-end and a homepage with a generic list of photos for the front-end</h3>
<h3>◦ Developed during the course of Java Web Developer with Experis</h3>

<p align="center">
<img src="https://img.shields.io/badge/JavaScript-F7DF1E.svg?style&logo=JavaScript&logoColor=black" alt="JavaScript" />
<img src="https://img.shields.io/badge/HTML5-E34F26.svg?style&logo=HTML5&logoColor=white" alt="HTML5" />
<img src="https://img.shields.io/badge/CSS3-E34F26.svg?style&logo=CSS3&logoColor=white" alt="CSS3" />
<img src="https://img.shields.io/badge/Vite-646CFF.svg?style&logo=Vite&logoColor=white" alt="Vite" />
<img src="https://img.shields.io/badge/Axios-5A29E4.svg?style&logo=Axios&logoColor=white" alt="Axios" />

<img src="https://img.shields.io/badge/Vue.js-4FC08D.svg?style&logo=vuedotjs&logoColor=white" alt="Vue.js" />
<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style&logo=openjdk&logoColor=white" alt="java" />
<img src="https://img.shields.io/badge/Spring-4FC08D.svg?style&logo=Spring&logoColor=white" alt="Spring" />
<img src="https://img.shields.io/badge/JSON-000000.svg?style&logo=JSON&logoColor=white" alt="JSON" />
<img src="https://img.shields.io/badge/Markdown-000000.svg?style&logo=Markdown&logoColor=white" alt="Markdown" />
</p>
<img src="https://img.shields.io/github/languages/top/AnielloPiscopo/spring-il-mio-fotoalbum?style&color=5D6D7E" alt="GitHub top language" />
<img src="https://img.shields.io/github/languages/code-size/AnielloPiscopo/spring-il-mio-fotoalbum?style&color=5D6D7E" alt="GitHub code size in bytes" />
<img src="https://img.shields.io/github/commit-activity/m/AnielloPiscopo/spring-il-mio-fotoalbum?style&color=5D6D7E" alt="GitHub commit activity" />
<img src="https://img.shields.io/github/license/AnielloPiscopo/spring-il-mio-fotoalbum?style&color=5D6D7E" alt="GitHub license" />
</div>

---

## 📒 Table of Contents
- [📒 Table of Contents](#-table-of-contents)
- [🧩 Modules](#modules)
- [🚀 Getting Started](#-getting-started)

---

## 🧩 Modules

<details closed><summary>Root</summary>

| File                                                                                                                                                                                                                | Summary                   |
| ---                                                                                                                                                                                                                 | ---                       |
| [BackendIlMioFotoalbumApplication.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\java\org\java\spring\BackendIlMioFotoalbumApplication.java)           | This is the entry point of the application, containing the main method. This method starts the application, automatically configuring the Spring environment, handling dependencies, and launching the embedded web server. |
| [ApiContactMessage.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\java\org\java\spring\api\controllers\ApiContactMessage.java)                         | This is the file dedicated to the api for the messages send by the front-end with the form. |
| [ApiPhotoController.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\java\org\java\spring\api\controllers\ApiPhotoController.java)                       | HTTPStatus Exception: 429 |
| [AuthConfig.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\java\org\java\spring\auth\conf\AuthConfig.java)                                             | This is the file dedicated to the auth configuration |
| [Role.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\java\org\java\spring\auth\pojo\Role.java)                                                         |  	This is the Role pojo. |
| [User.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\java\org\java\spring\auth\pojo\User.java)                                                         |  	This is the User pojo. |
| [RoleRepo.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\java\org\java\spring\auth\repo\RoleRepo.java)                                                 | This is the repository for the Role pojo. |
| [UserRepo.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\java\org\java\spring\auth\repo\UserRepo.java)                                                 | This is the repository for the User pojo. |
| [RoleServ.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\java\org\java\spring\auth\services\RoleServ.java)                                             |  	This is the service for the Role pojo. |
| [UserServ.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\java\org\java\spring\auth\services\UserServ.java)                                             |  	This is the service for the User pojo. |
| [CategoryController.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\java\org\java\spring\controllers\CategoryController.java)                           |  	This is the controller for the Category pojo. |
| [PhotoController.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\java\org\java\spring\controllers\PhotoController.java)                                 |  	This is the controller for the Photo pojo. |
| [Helper.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\java\org\java\spring\helper\Helper.java)                                                        |  	This is the helper file containing the usefull functions. |
| [Category.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\java\org\java\spring\pojo\Category.java)                                                      |  	This is the Category pojo. |
| [ContactMessage.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\java\org\java\spring\pojo\ContactMessage.java)                                          |  	This is the ContactMessage pojo. |
| [Photo.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\java\org\java\spring\pojo\Photo.java)                                                            |  	This is the Photo pojo. |
| [CategoryRepo.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\java\org\java\spring\repo\CategoryRepo.java)                                              | This is the repository for the Category pojo. |
| [ContactMessageRepo.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\java\org\java\spring\repo\ContactMessageRepo.java)                                  | This is the repository for the ContactMessage pojo. |
| [PhotoRepo.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\java\org\java\spring\repo\PhotoRepo.java)                                                    | This is the repository for the Photo pojo. |
| [CategoryServ.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\java\org\java\spring\services\CategoryServ.java)                                          | This is the service for the Category pojo. |
| [ContactMessageServ.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\java\org\java\spring\services\ContactMessageServ.java)                              | This is the service for the ContactMessage pojo. |
| [PhotoServ.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\java\org\java\spring\services\PhotoServ.java)                                                | This is the service for the Photo pojo. |
| [header.html](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\resources\templates\frag\header.html)                                                           | This is the fragment in the back-end dedicated to the header. |
| [main-layout.html](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\resources\templates\frag\main-layout.html)                                                 | This is the fragment in the back-end which represents the main-layout with the generic info. |
| [index.html](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\resources\templates\view\admin\category\index.html)                                              | This is the index file for the Category pojo. |
| [trash.html](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\resources\templates\view\admin\category\trash.html)                                              | This is the trash file for the Category pojo. |
| [table-layout.html](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\resources\templates\view\admin\category\frag\table-layout.html)                           | This is the fragment with the layout of the table for the index and trash files of the Category pojo. |
| [create.html](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\resources\templates\view\admin\photo\create.html)                                               | This is the create file for the Photo pojo. |
| [edit.html](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\resources\templates\view\admin\photo\edit.html)                                                   | This is the edit file for the Photo pojo. |
| [index.html](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\resources\templates\view\admin\photo\index.html)                                                 | This is the index file for the Photo pojo. |
| [show.html](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\resources\templates\view\admin\photo\show.html)                                                   | This is the show file for the Photo pojo. |
| [trash.html](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\resources\templates\view\admin\photo\trash.html)                                                 | This is the trash file for the Photo pojo. |
| [form.html](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\resources\templates\view\admin\photo\frag\form.html)                                              | This is the fragment with the layout of the form for the create and edit files of the Photo pojo. |
| [table-layout.html](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\main\resources\templates\view\admin\photo\frag\table-layout.html)                              | This is the fragment with the layout of the table for the index and trash files of the Photo pojo. |
| [BackendIlMioFotoalbumApplicationTests.java](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/backend-il-mio-fotoalbum\src\test\java\org\java\spring\BackendIlMioFotoalbumApplicationTests.java) | This file is responsible for orchestrating the execution of tests, including unit tests, integration tests, and end-to-end tests, to ensure the application's functionality is validated under various scenarios. |
| [vite.config.js](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/frontend-il-mio-fotoalbum\vite.config.js)                                                                                      | This is a configuration file used with Vite, which is a build tool and development server designed for modern web development. |
| [App.vue](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/frontend-il-mio-fotoalbum\src\App.vue)                                                                                                | This is the base of the work and it serves as the root component of the Vue.js application and contains the overall layout, navigation, and the top-level structure of your app. |
| [main.js](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/frontend-il-mio-fotoalbum\src\main.js)                                                                                                | This file is the entry point of the application. It's where you create and configure the Vue instance, set up routing (if used), and specify which component to render in the root DOM element. |
| [store.js](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/frontend-il-mio-fotoalbum\src\store.js)                                                                                              | This file contains the global and general variables and functions of the work. |
| [AppHeader.vue](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/frontend-il-mio-fotoalbum\src\components\AppHeader.vue)                                                                         | This is the component that represents the header tag of the webpage. |
| [AppMain.vue](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/frontend-il-mio-fotoalbum\src\components\AppMain.vue)                                                                             | This is the component that represents the main tag of the webpage. |
| [LogoContainer.vue](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/frontend-il-mio-fotoalbum\src\components\LogoContainer.vue)                                                                 | This is the component for the logo. |
| [NavBar.vue](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/frontend-il-mio-fotoalbum\src\components\header\NavBar.vue)                                                                        | This is the component for the navbar. |
| [ContactSection.vue](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/frontend-il-mio-fotoalbum\src\components\main\ContactSection.vue)                                                          | This is the Contact section  in the front-end. |
| [PhotosSection.vue](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/frontend-il-mio-fotoalbum\src\components\main\PhotosSection.vue)                                                            | This is the section in the front-end dedicated photos list. |
| [ContactForm.vue](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/frontend-il-mio-fotoalbum\src\components\main\contact\ContactForm.vue)                                                        | This is the component in the front-end with a form where to send messages to the back-end. |
| [BtnContainer.vue](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/frontend-il-mio-fotoalbum\src\components\main\photos\BtnContainer.vue)                                                       | This is the component containing a btn. |
| [PhotosList.vue](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/frontend-il-mio-fotoalbum\src\components\main\photos\PhotosList.vue)                                                           | This is the component dedicated to the photos list. |
| [SinglePhoto.vue](https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum/blob/main/frontend-il-mio-fotoalbum\src\components\main\photos\SinglePhoto.vue)                                                         | This is the component dedicated to show a single photo. |

</details>

---

## 🚀 Getting Started

### ✔️ Prerequisites

Before you begin, ensure that you have the following prerequisites installed:
> - `ℹ️ Java Development Kit (JDK): Ensure you have the Java Development Kit (JDK) installed on your system. You can download the latest JDK from the official Oracle website or from alternative sources like OpenJDK. `
> - `ℹ️ Code Editor or IDE: To open and edit the Java source code, it's helpful to have a code editor or an Integrated Development Environment (IDE) like Eclipse, IntelliJ IDEA, or Visual Studio Code.`
> - `ℹ️ Dependency Management (optional): Depending on the project, you may need to manage the program's dependencies. Typically, this is done using a dependency management tool like Maven or Gradle. Check if the project uses one of these tools and make sure you have them installed if necessary.`

### 📦 Installation

1. Clone the repository:
```sh
git clone https://github.com/AnielloPiscopo/spring-il-mio-fotoalbum
```

2. Change to the project directory:
```sh
cd spring-il-mio-fotoalbum
```

---

