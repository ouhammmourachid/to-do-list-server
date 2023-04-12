# To do list server :
### this repo contain a simple Api to perform a **CRUD** operation on Item.
this API made specially to be use in a mobile app the code is here : [to do list app](https://github.com/ouhammmourachid/to-do-list.git)

### this api perform CRUD operation for Item object :
the java code for the Item class is the following :

```
public class Item {
    
    private Long id;
    private String text;
    private int category;
    private boolean selected;
}
```


### to use this api :

- first clone this repo using `git clone https://github.com/ouhammmourachid/to-do-list-server.git`.
- make sure you have installed **xampp** and you created a database with name _android_ .
- run the api with your favorite IDE (IntelliJ/eclipse).
- to start using the api :
  - **GET** for retrieving all the list of the item:
  ```HTTP
  GET /api/v1/item HTTP/1.1
    Host: localhost:8080
  ```
  - **POST**  to add a new item :
  ```HTTP
  POST /api/v1/item/ HTTP/1.1
    Host: localhost:8080
    Content-Type: application/json
    Content-Length: 82
    
    {
    "text" :"do the first item",
    "category": 2,
    "isSelected":false
    }
  ```
  - **PUT** to update an existing item: 
  ```HTTP
  PUT /api/v1/item/1/ HTTP/1.1
    Host: localhost:8080
    Content-Type: application/json
    Content-Length: 79
    
    {
    "text" :"do the first item",
    "category": 2,
    "selected":true
    }
  ```
  - **DELETE** to delete an item:
  ```HTTP
  DELETE /api/v1/item/1/ HTTP/1.1
    Host: localhost:8080
  ```

