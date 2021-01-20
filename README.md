# MadLibsProject2BackEnd
## Project Description

Madlibs is a fun learning tool for people who want to improve their English skills.  Once registered and logged in, 
you can select an age appropriate passage and be prompted for missing words.  After completing all the prompts 
you will be able to read the full passage with your unique additions.  You can then decide to keep your completed 
version for later, or just discard it.  Once played, you can compare your text to those from other users.  
 
## Requirements: 
- User registration. 
- User login / logout. 
- Users can update their personal information. 
- Link to the API for help with words. 
- Select incomplete passages by genre. 
- Have a chance to review and react to other players’ completed passages. 
- Validate the user’s input grammar, and check for appropriateness with the API . 
- Easy, mid-level, and advanced options to further enhance playing levels. 
 
## Technologies Used
 Java - Version 8
 Maven
 Spring Tools Suite
 Spring ORM w/ Hibernate
 Spring WebMVC
 AWS EC2 w/ Jenkins pipeline
 AWS RDS hosted DB

## Features
List of features ready and TODOs for future development

Features:
 - Core requirements met.
 - Users can choose and complete stories with input words checked by the API
 - User stories saved in the database

To-do list:
- Share completed madlibs on social media.  
- Vote on other user’s results to provide a ranking for which is most amusing. 
- Beginner level will allow for randomized suggestions from the API. 
- Statistics available on words selected. 
- Password recovery via email. 

## Getting the Backend Started
 git clone <repo>
 maven build <project>
 copy <.war file> <web container web-apps>
 tomcat run
 The DB is on an AWS RDS with limited access
 The frontend Angular file also needs to be started (see separate repo)

## Usage
 View of login page:
 https://github.com/khake96/MadLibsProject2FrontEnd/blob/3167104e976aba41588e0ed3e85e08d9da99c2ac/Login.jpg?raw=true

## Contributors
 O. Kulikov
 C. Svensson 
 A. Palaparthi
 K. Hake
