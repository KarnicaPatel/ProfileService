# ProfileService

Database Console 
http://localhost:8009/h2/

Base URI - http://localhost:8009
1. Create User Profile
    Method- POST
    
    URI- /user/profile,    http://localhost:8009/user/profile
    {"userName":"KarnicaPatel","first_name":"Karnica","last_name":"Patel","age":"20"}

2. Update User Profile
    Method- PUT
    
    URI-/user/profile
    
    Request Body- 
    {"userName":"KarnicaPatel","first_name":"Karnica","last_name":"Patel","age":"20"}

3. Read USer profile 
    MEthod- GET
    
    a. By ID
    URI- /user/profile/{userId}, eg. /user/profile/10
    
    b. By First name and last name
    URI- /user/profile/{firstName}/{lastName}, eg. /user/profile/Karnica/Patel
    
4. Delete User Profile
    Method- DELETE
    URI- /user/profile/{userId}
