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