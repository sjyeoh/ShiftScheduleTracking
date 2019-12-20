# ShiftScheduleTracking
Week20 - Mini Project

|method | path | action|
|---|---|---|
|GET| /records |index(record)
|GET| /records/{id} |show
|GET| /records/{user_id} |show
|GET| /records/{type} |show
|POST| /records |create
|PUT |/records/{id} |update
|DELETE |records/{id} |delete


### GET /records

List all records, can be searched or sorted

**Query Params**

`id` - number, will match exactly <br/>
`user_id` - number, will match exactly <br/>
`type` - string, will fuzzy search using `LIKE '%leave_type%'`

**Sample Response** 

``
[
    {
        "id": 12,
        "user_id": 1,
        "apply_date": "2019-12-20",
        "leave_type": "AL"
        "created_at" : "2019-12-19 12:40PM",
        "created_by" : "Eddie",
        "updated_at" : "2019-12-19 12:40PM",
        "updated_by" : "Eddie",
        "update_frequency" : "1"
    }
]
``

---

### POST /records

Create new record

**Sample Response** 

``
[
    {
        "Record successfully created"
    }
]
``

---

### PUT /records/{id}

Update record based on record id

**Query Params**

`id` - number, will match exactly

**Sample Response** 

``
[
    {
        "Record successfully updated"
    }
]
``

---

### DELETE /records/{id}

Delete record based on record id

**Query Params**

`id` - number, will match exactly

**Sample Response** 

``
[
    {
        "Record successfully deleted"
    }
]
``



### GET /users
List all users, can be searched or sorted
**Query Params**
`name` - String, will fuzzy search using `Like '%name%'`
### GET /users{id}
List user based on ID
**Query Params**
`id` - number, exact match
### GET /users{group}
List user based upon group
**Query Params**
`group` - number, exact match
### GET /users{status}
List user based on status
**Query Params**
`status` - String, exact match
### GET /users{access}
List user based on access

**Query Params**
`access` - string, exact match
---
### POST /users
create new user

**Sample Response**
New user created
---
### PUT /users
Update user's details

**Query Params**
`ID` - number, exact match
---
### DELETE /users
Delete user

**Query Params**
`ID` - number, exact match
---
### GET /users/{id}/records
get records by user id

**Query Params**
`ID` - number, exact match