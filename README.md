## INSURANCE COMPANY PROJECT
## In this project different REST methods are implemented for policy
You can use GET, PUT, POST, DELTE method for fetching, updating, creation and deletion of record.

## GET METHOD
http://localhost:2020/api/v1/policy
Fetch all the policies

http://localhost:2020/api/v1/policy/12313
fetch a perticular policy with id 12313

## POST METHOD
http://localhost:2020/api/v1/addupdatepolicy
{"id":"13", "name":"123", "description":"Policy description here", "validFrom":"2018-01-01", "validTo":"2050-01-01"}


## PUT METHOD
http://localhost:2020/api/v1/addupdatepolicy
{"id":"13", "name":"123", "description":"Policy description here", "validFrom":"2018-01-01", "validTo":"2050-01-01"}

## DELETE METHOD
http://localhost:2020/api/v1/deletepolicy/123
123 is the id of the policy
