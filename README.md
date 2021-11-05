
## implementaion
### APIS
	1. /users fethces  all the users and respective posts for each user  (and commnets to respective  posts )
	2. /posts fetches all the posts and commnets to individual posts
	3. /comments fetches all the comments
	4. /users/{id} fetches user details and  all the posts and comments of respective post posted by user_id id
	5. /posts/{id} fetches post and all comments of post (id)
	6. /comments/{id} fetches all the comments with id 

### for jwt implementaion 
	1./authenticate to login (user,password) pass as({"username":"user","password":"password"} in post body
	2. used constant username:user, password:password
	3. used bearer token for further communication

	had some help from internet on this
