# WebRequestCaller

*Use For Hit web request.*

Dependency
==========
```groovy
compile 'com.pratik.gondaliya:webrequestcaller:0.0.1'
```

### ConnectionClass Listener to get current network quality and bandwidth
```java
/*Request params
param 1 - url 
param 2 - Request type WebRequest.REQUEST_GET ,WebRequest.REQUEST_POST , WebRequest.REQUEST_PUT, WebRequest.REQUEST_DELETE
param 3 - Response type WebRequest.STRING ,WebRequest.JSON_OBJECT , WebRequesT.JSON_ARRAY (outputed value)
*/
WebRequest webRequest = new WebRequest(url,WebRequest.REQUEST_GET,WebRequest.JSON_OBJECT){
    @Override
    public void onWebResponse(String response) {
        Log.d(TAG,response);
    }

    @Override
    public void onWebErrorResponse(String reponse) {
        Log.d(TAG,"error : " + reponse);
    }
};

webRequest.execute();
```

Developed By
============

* Pratik Gondaliya - <gondaliya.p001@gmail.com>
 - Look me up on **StackOverflow**: [**Pratik Gondaliya**](http://stackoverflow.com/users/5944999/pratik-gondaliya)


References
==========
* Volley library

License
=======

    Copyright 2016 Pratik Gondaliya

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
