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
                if (Controller.token != "") {
                    request = request.newBuilder()
                        .addHeader("Authorization",String.format("Bearer %s", Controller.token))
                        .build()
                }




        return chain.proceed(request)
    }

}