package com.example.ask.util



import com.example.ask.controlador.Controller
import okhttp3.Interceptor
import okhttp3.Response

class ServiceInterceptor : Interceptor {

    var token : String = "";

    fun Token(token: String ) {
        this.token = token;
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if(request.header("No-Authentication")==null){
            //val token = getTokenFromSharedPreference();
            //or use Token Function
            if(!token.isNullOrEmpty())
            {
                val finalToken =  "Bearer "+token
                request = request.newBuilder()
                    .addHeader("Authorization",String.format("Bearer %s","eyJhbGciOiJSUzI1NiIsImtpZCI6IjUwYTdhYTlkNzg5MmI1MmE4YzgxMzkwMzIzYzVjMjJlMTkwMzI1ZDgiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL3NlY3VyZXRva2VuLmdvb2dsZS5jb20vcXVlc3Rpb25zLWI5ODgzIiwiYXVkIjoicXVlc3Rpb25zLWI5ODgzIiwiYXV0aF90aW1lIjoxNjU2OTY1ODgyLCJ1c2VyX2lkIjoiZ1JacnhkVEZZbFZLY0tLVnJqbkQ1NU5XWGd3MSIsInN1YiI6ImdSWnJ4ZFRGWWxWS2NLS1Zyam5ENTVOV1hndzEiLCJpYXQiOjE2NTY5NjU4ODIsImV4cCI6MTY1Njk2OTQ4MiwiZW1haWwiOiJwZWRyb0Bob3RtYWlsLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiZmlyZWJhc2UiOnsiaWRlbnRpdGllcyI6eyJlbWFpbCI6WyJwZWRyb0Bob3RtYWlsLmNvbSJdfSwic2lnbl9pbl9wcm92aWRlciI6InBhc3N3b3JkIn19.coPBjRtKGYykAg6t_3mrVNXXmfvXxnU3MR2jJq_DOJUyicNnHkEp0cMxkhQ2mZgUKiZ9lheipJqocxqXVvHzA-FBkzLa1vK310ohks86k9tXqfHwsvO0sq_dm7dprJR0ksdeuzuwwjYg6oUdEtRQ1w7Ldo12B338lTdFAS7HfRrPmfcm1eZkWfHoZ5HGjSG1h8MICz9UAcIgYr97jFqeL0w-khgEPY8Ch7dPdq2O6vlgzAWwckwXWlkp68Odie-hEINO6eP7XURmGzWORg9Rc5pZwhPvjjEHUUNeJkBNK6SnovfkThXzhBx0latrv7GdmKnrgrydnweRGJvaFk6UNA"))
                        .build()
            }

        }

        return chain.proceed(request)
    }

}