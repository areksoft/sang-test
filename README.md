# publicapi
Integrate Public api and do operation

Need to create 3 apis : 
1. get Users
2. get Posts
3. get Comments 

All three source are available in https://gorest.co.in/
Source api to get Users : https://gorest.co.in/public/v1/users
Source api to get Posts : https://gorest.co.in/public/v1/posts
Source api to get Comments : https://gorest.co.in/public/v1/comments

Developer needs to create 3 apis which calls the source apis and returns the DTOs
3 Api should be authenticated either by basic or JWT token based or any static secret key. JWT is prefered.
Bonus points to filter the posts and comments with some user key filter. Right now the source fetches all.


DO NOT PUSH IN THE MAIN BRANCH


Steps to code and commit
Current branch is main branch
Clone the project in your system
mvn clean install
mvn spring-boot:run
create a new branch named by firstname-feature . Example aditi-feature
Commit your changes and inform the team




