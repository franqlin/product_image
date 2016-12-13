# spring-resteasy-hibernate-example

## ER Diagram:

* We have a Product Entity with One to Many relationship with Image entity.
* Product also has a Many to One relationship with itself (Many Products to one Parent Product).

```
+-----------------------+
| Product               |
+-----------------------+
| PK id                 |
+-----------------------+
| FK name               |
|    description        |
|    parent_product_id  |
+-----------------------+

+-----------------------+
| Image                 |
+-----------------------+
| PK id                 |
+-----------------------+
| FK  type              |
|     location          |
|     product_id        |
+-----------------------+
```

## What to build ?

1. Build a Restful service using JAX-RS to perform CRUD operations on a Product resource using Image as  a sub resource of Product.

 
2. Build API classes to perform these operations

  1. Get all products excluding relationships (child products, images)

  2. Get all products including specified relationships (child product and/or images)

  3. Same as 1 using specific product identity

  4. Same as 2

  5. Get set of child products for specific product

  6. Get set of images for specific product

 
3. Build JPA/Hibernate classes using annotations to persist these objects in the database

