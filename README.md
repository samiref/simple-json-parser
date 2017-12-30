# simple-json-parser for JAVA
Simple JSON Parser For JAVA &amp; Android

this class is for parse json string in java without any exception or need to try/catch.

very simple. only create new object from SimpleJsonParser() and go to end.

for example:

select full_name 

![Example](http://majazestan.com/static/SimpleJsonParser.jpg "Simple Json Parser Example")


```new SimpleJsonParser(jsonString)
        .Object("data")
        .Array("config")
        .Index(1)
        .Array("viewer")
        .Index(0)
        .getString("full_name");
// return "Seyyed Amir"
```


```new SimpleJsonParser(jsonString)
        .Object("data")
        **.Array("options")**
        .Index(1)
        .Array("viewer")
        .Index(0)
        .getString("full_name");
// return "" without exception
```
 


Object for parse item as JSONObject
Array for parse item as JSONArray
Index for get JSONObject or JSONArray from Array by index
getString get string value (return "" if not found)


```JSONArray jsonArray = new SimpleJsonParser(jsonString)
                          .Object("data")
                          .Array("config")
                          .getJSONArray();
```
------

```JSONObject jsonObject = new SimpleJsonParser(jsonString)
                          .Object("data")
                          .getJSONObject();
 ```                         
------




